package my.edu.umk.pams.intake.web.module.application.controller;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InActor;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private PolicyTransformer policyTransformer;

    @Autowired
    private ApplicationTransformer applicationTransformer;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // ====================================================================================================
    // INTAKE
    // ====================================================================================================

    @RequestMapping(value = "/intakes", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findIntakes() {
        List<InIntake> intakes = policyService.findIntakes();//(InFlowState.PUBLISHED);
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<Intake> findIntakeByReferenceNo(@PathVariable String referenceNo) {
        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        return new ResponseEntity<Intake>(policyTransformer.toIntakeVo(intake), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/apply", method = RequestMethod.POST)
    public ResponseEntity<String> applyIntake(@PathVariable String referenceNo) {
        dummyLogin();

        // user & applicant
        InUser currentUser = securityService.getCurrentUser();
        InActor actor = currentUser.getActor();
        InApplicant applicant = null;
        if (actor instanceof InApplicant) applicant = (InApplicant) actor;

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        InIntakeApplication application = new InIntakeApplicationImpl();
        application.setName(applicant.getName());
        application.setEmail(applicant.getEmail());

        // todo: applyIntake(intake);
        String refNo = applicationService.draftIntakeApplication(intake, application);
        return new ResponseEntity<String>(refNo, HttpStatus.OK);
    }

    // ====================================================================================================
    // INTAKE APPLICATION
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplications() {
        dummyLogin();

        // user & applicant
        InUser currentUser = securityService.getCurrentUser();
        InActor actor = currentUser.getActor();
        InApplicant applicant = null;
        if (actor instanceof InApplicant) applicant = (InApplicant) actor;

        List<InIntakeApplication> applications = applicationService.findIntakeApplications(applicant, InBidStatus.DRAFTED);
        return new ResponseEntity<List<IntakeApplication>>(applicationTransformer.toIntakeApplicationVos(applications), HttpStatus.OK);
    }

    // ====================================================================================================
    // INTAKE APPLICATION
    // ====================================================================================================

    @RequestMapping(value = "/intakeApplications/{referenceNo}", method = RequestMethod.POST)
    public ResponseEntity<String> updateIntakeApplication(@PathVariable String referenceNo, @RequestBody IntakeApplication vo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeById(vo.getIntake().getId());
        InIntakeApplication application = applicationService.findIntakeApplicationById(vo.getId());

        applicationService.submitIntakeApplication(intake, application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/submit", method = RequestMethod.POST)
    public ResponseEntity<String> submitIntakeApplication(@PathVariable String referenceNo, @RequestBody IntakeApplication vo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeById(vo.getIntake().getId());
        InIntakeApplication application = applicationService.findIntakeApplicationById(vo.getId());

        applicationService.submitIntakeApplication(intake, application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
        InAutoLoginToken token = new InAutoLoginToken("applicant1");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
