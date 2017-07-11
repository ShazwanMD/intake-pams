package my.edu.umk.pams.intake.web.module.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InRefereeType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.identity.model.InActorType;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.web.module.application.controller.ApplicationController;
import my.edu.umk.pams.intake.web.module.application.controller.ApplicationTransformer;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.identity.vo.Applicant;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;

/**
 */
@RestController
@RequestMapping("/api/account")
public class ApplicantAccountController {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

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
    // DASHBOARD
    // ====================================================================================================

    @RequestMapping(value = "/intakes/flowState/{flowState}", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findIntakesByFlowState(@PathVariable String flowState) {
        List<InIntake> intakes = policyService.findIntakesByFlowState(InFlowState.valueOf(flowState));
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications}", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplications() {
        InUser user = securityService.getCurrentUser();
        InApplicant applicant = null;
        if (user.getActor() instanceof InApplicant) applicant = (InApplicant) user.getActor();
        List<InIntakeApplication> applications = applicationService.findIntakeApplications(applicant);
        return new ResponseEntity<List<IntakeApplication>>(applicationTransformer.toIntakeApplicationVos(applications),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/bidStatus/{bidStatus}", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplicationsByBidStatus(@PathVariable String bidStatus) {
        InUser user = securityService.getCurrentUser();
        InApplicant applicant = null;
        if (user.getActor() instanceof InApplicant) applicant = (InApplicant) user.getActor();
        List<InIntakeApplication> applications = applicationService.findIntakeApplications(applicant, InBidStatus.valueOf(bidStatus));
        return new ResponseEntity<List<IntakeApplication>>(applicationTransformer.toIntakeApplicationVos(applications),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/applicant", method = RequestMethod.POST)
    public ResponseEntity<String> updateApplicant(@RequestBody Applicant vo) {
        InApplicant applicant = identityService.findApplicantById(vo.getId());
        applicant.setEmail(vo.getEmail());
        applicant.setFax(vo.getFax());
        applicant.setMobile(vo.getMobile());
        applicant.setName(vo.getEmail());
        applicant.setIdentityNo(vo.getIdentityNo());
     //   applicant.setActorType(InActorType.get(vo.getActorType().ordinal()));
        identityService.updateApplicant(applicant);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
