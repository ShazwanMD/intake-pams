package my.edu.umk.pams.intake.web.module.account.controller;

import org.hibernate.SessionFactory;
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
import java.util.Locale;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InRefereeType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InBankCode;
import my.edu.umk.pams.intake.common.model.InBankCodeImpl;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.model.InStudyModeImpl;
import my.edu.umk.pams.intake.common.model.InSubjectCode;
import my.edu.umk.pams.intake.common.model.InSubjectCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.identity.model.InActorType;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.web.module.account.vo.EmailChange;
import my.edu.umk.pams.intake.web.module.account.vo.PasswordChange;
import my.edu.umk.pams.intake.web.module.application.controller.ApplicationController;
import my.edu.umk.pams.intake.web.module.application.controller.ApplicationTransformer;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.identity.controller.IdentityTransformer;
import my.edu.umk.pams.intake.web.module.identity.vo.Applicant;
import my.edu.umk.pams.intake.web.module.identity.vo.User;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;


import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.web.module.common.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


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
    private IdentityTransformer identityTransformer;

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

    @RequestMapping(value = "/intakeApplications", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplications() {
        InUser user = securityService.getCurrentUser();
        InApplicant applicant = null;
        if (user.getActor() instanceof InApplicant) applicant = (InApplicant) user.getActor();
        if (null == applicant) throw new IllegalArgumentException("Applicant does not exists");

        List<InIntakeApplication> applications = applicationService.findIntakeApplications(applicant);
        return new ResponseEntity<List<IntakeApplication>>(applicationTransformer.toIntakeApplicationVos(applications),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/bidStatus/{bidStatus}", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplicationsByBidStatus(@PathVariable String bidStatus) {
        InUser user = securityService.getCurrentUser();
        InApplicant applicant = null;
        if (user.getActor() instanceof InApplicant) applicant = (InApplicant) user.getActor();
        if (null == applicant) throw new IllegalArgumentException("Applicant does not exists");

        List<InIntakeApplication> applications = applicationService.findIntakeApplications(applicant, InBidStatus.valueOf(bidStatus));
        return new ResponseEntity<List<IntakeApplication>>(applicationTransformer.toIntakeApplicationVos(applications),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/applicant", method = RequestMethod.GET)
    public ResponseEntity<Applicant> findApplicant() {
        InUser user = securityService.getCurrentUser();
        InApplicant applicant = null;
        if (user.getActor() instanceof InApplicant) applicant = (InApplicant) user.getActor();
        if (null == applicant) throw new IllegalArgumentException("Applicant does not exists");

        return new ResponseEntity<Applicant>(identityTransformer.toApplicantVo(applicant), HttpStatus.OK);
    }

    @RequestMapping(value = "/applicant", method = RequestMethod.POST)
    public ResponseEntity<String> updateApplicant(@RequestBody Applicant vo) {
        InApplicant applicant = identityService.findApplicantById(vo.getId());
        applicant.setEmail(vo.getEmail());

        applicant.setFax(vo.getFax());
        applicant.setMobile(vo.getMobile());
        applicant.setName(vo.getEmail());
        applicant.setIdentityNo(vo.getIdentityNo());
        identityService.updateApplicant(applicant);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    // ==================================================================================================== //
    // USER
    // ==================================================================================================== //

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> findUser() {
        InUser user = securityService.getCurrentUser();
        InApplicant applicant = null;
        if (user.getActor() instanceof InApplicant) applicant = (InApplicant) user.getActor();
        if (null == applicant) throw new IllegalArgumentException("Applicant does not exists");

        return new ResponseEntity<User>(identityTransformer.toUserVo(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestBody User vo) {
        InUser user = identityService.findUserByUsername(securityService.getCurrentUser().getUsername());
        if (null == user) throw new IllegalArgumentException("User does not exists");

        user.setEmail(vo.getEmail());
        user.setRealName(vo.getRealName());
        user.setPassword(vo.getPassword());
        identityService.updateUser(user);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/passwordChange", method = RequestMethod.POST)
    public ResponseEntity<String> changeUserPassword(@RequestBody PasswordChange vo) {
        InUser user = identityService.findUserByUsername(securityService.getCurrentUser().getUsername());
        if (null == user)
            throw new IllegalArgumentException("User does not exists");
        if(user.getPassword().equals(vo.getNewPassword()))
            throw new IllegalArgumentException("Please use a different password");
        LOG.debug("changing user password");
        user.setPassword(vo.getNewPassword());
        identityService.updateUser(user);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
//    @RequestMapping(value = "/emailChange/{currentEmail:.+}", method = RequestMethod.POST)
//    public ResponseEntity<String> changeUserEmail(@PathVariable String currentEmail, @RequestBody EmailChange vo) {
//    	
//        InUser user = identityService.findUserByEmail(currentEmail);
//        if (null == user)
//            throw new IllegalArgumentException("User does not exists");
//        if(user.getEmail().equals(vo.getNewEmail()))
//            throw new IllegalArgumentException("Please use a different email");
//
//        LOG.debug("EmailChange from: " + vo.getCurrentEmail());
//        LOG.debug("EmailChange to: " + vo.getNewEmail());
//        user.setEmail(vo.getNewEmail());
//        identityService.updateUser(user);
       
	@RequestMapping(value = "/emailChange/{currentEmail:.+}", method = RequestMethod.POST)
	public ResponseEntity<String> changeApplicantEmail(@PathVariable String currentEmail, @RequestBody EmailChange vo) {

		InPrincipal principal = identityService.findPrincipalByName(currentEmail);
		if (null == principal)
			throw new IllegalArgumentException("Applicant does not exists");
		if (principal.getName().equals(vo.getNewEmail()))
			throw new IllegalArgumentException("Please use a different email");
		LOG.debug("EmailChange from: " + vo.getCurrentEmail());
		LOG.debug("EmailChange to: " + vo.getNewEmail());
		principal.setName(vo.getNewEmail());
		identityService.updatePrincipal(principal);
		InApplicant applicant = identityService.findApplicantByEmail(currentEmail);
		if (null == applicant)
			throw new IllegalArgumentException("Applicant does not exists");
		if (applicant.getName().equals(vo.getNewEmail()))
			throw new IllegalArgumentException("Please use a different email");
		applicant.setEmail(vo.getNewEmail());
		identityService.updateApplicant(applicant);

		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
