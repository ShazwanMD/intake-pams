package my.edu.umk.pams.intake.web.module.application.controller;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InActor;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.web.module.application.vo.Education;
import my.edu.umk.pams.intake.web.module.application.vo.Employment;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.application.vo.SpmResult;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
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
        InApplicant applicant = identityService.findApplicantById(actor.getId());
        if (actor instanceof InApplicant) applicant = (InApplicant) actor;

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        InIntakeApplication application = new InIntakeApplicationImpl();
        application.setName(applicant.getName());
        application.setEmail(applicant.getEmail());
        application.setApplicant(applicant);

        // todo: applyIntake(intake);
        String refNo = applicationService.draftIntakeApplication(intake, application);
        return new ResponseEntity<String>(refNo, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/intakeApplications", method = RequestMethod.POST)
    public ResponseEntity<List<IntakeApplication>> findIntakeApplicationsByIntake(@PathVariable String referenceNo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
       List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake);
        return new ResponseEntity<List<IntakeApplication>>(applicationTransformer.toIntakeApplicationVos(applications), HttpStatus.OK);
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
        InApplicant applicant = identityService.findApplicantById(actor.getId());
        if (actor instanceof InApplicant) applicant = (InApplicant) actor;
        List<InIntakeApplication> applications = applicationService.findIntakeApplications(applicant, InBidStatus.DRAFTED);
        List<IntakeApplication> applicationVos = applicationTransformer.toIntakeApplicationVos(applications);
        return new ResponseEntity<List<IntakeApplication>>(applicationVos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/intakeApplications/{referenceNo}", method = RequestMethod.POST)
    public ResponseEntity<String> updateIntakeApplication(@PathVariable String referenceNo, @RequestBody IntakeApplication vo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeById(vo.getIntake().getId());
        InIntakeApplication application = applicationService.findIntakeApplicationById(vo.getId());

        applicationService.submitIntakeApplication(intake, application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplication/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<IntakeApplication> findIntakeApplicationByReferenceNo(@PathVariable String referenceNo) {
        InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        return new ResponseEntity<IntakeApplication>(applicationTransformer.toIntakeApplicationVo(intakeApplication), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakeApplications/{referenceNo}/submit", method = RequestMethod.POST)
    public ResponseEntity<String> submitIntakeApplication(@PathVariable String referenceNo, @RequestBody IntakeApplication vo) {
        dummyLogin();

        InIntake intake = policyService.findIntakeById(vo.getIntake().getId());
        InIntakeApplication application = applicationService.findIntakeApplicationById(vo.getId());

        applicationService.submitIntakeApplication(intake, application);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    // PROGRAM OFFERINGS BY INTAKE APPLICATION
    @RequestMapping(value = "/intakeApplications/{referenceNo}/programOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramOffering>> findProgramOfferingsByIntakeApplication(@PathVariable String referenceNo) {
        InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        List<InProgramOffering>  offerings = applicationService.findProgramOfferings(application);
        return new ResponseEntity<List<ProgramOffering>>(policyTransformer.toProgramOfferingVos(offerings), HttpStatus.OK);
    }

    // ====================================================================================================
	// EMPLOYMENTS
	// ====================================================================================================

	@RequestMapping(value = "/intakeApplications/{referenceNo}/employments", method = RequestMethod.GET)
	public ResponseEntity<List<Employment>> findEmploymentsByIntakeApplication(@PathVariable String referenceNo) {
		InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);

		List<InEmployment> employments = applicationService.findEmployments(application);

		return new ResponseEntity<List<Employment>>(applicationTransformer.toEmploymentVos(employments), HttpStatus.OK);
	}

	@RequestMapping(value = "/intakeApplications/{referenceNo}/employments", method = RequestMethod.POST)
	public ResponseEntity<String> addEmployment(@PathVariable String referenceNo, @RequestBody Employment vo) {
		dummyLogin();

		InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InEmployment employment = new InEmploymentImpl();
		employment.setEmployer(vo.getEmployer());
        employment.setDesignation(vo.getDesignation());
		employment.setStartDate(vo.getStartDate());
		employment.setEndDate(vo.getEndDate());
		// employment.setFieldCode(commonService.findEmploymentFieldCodeById(vo.getFieldCode().getId()));
		// employment.setLevelCode(commonService.findEmploymentLevelCodeById(vo.getLevelCode().getId()));
		// employment.setSectorCode(commonService.findEmploymentSectorCodeById(vo.getSectorCode().getId()));
		employment.setCurrent(false);
		applicationService.addEmployment(application, employment);

		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// EDUCATIONS
	// ====================================================================================================

	@RequestMapping(value = "/intakeApplications/{referenceNo}/educations", method = RequestMethod.GET)
	public ResponseEntity<List<Education>> findEducationsByIntakeApplication(@PathVariable String referenceNo) {
		InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		List<InEducation> educations = applicationService.findEducations(application);
		return new ResponseEntity<List<Education>>(applicationTransformer.toEducationVos(educations), HttpStatus.OK);
	}

	@RequestMapping(value = "/intakeApplications/{referenceNo}/educations", method = RequestMethod.POST)
	public ResponseEntity<String> addEducation(@PathVariable String referenceNo, @RequestBody Education vo) {
		dummyLogin();

		InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InEducation education = new InEducationImpl();
		education.setProvider(vo.getProvider());
		education.setStartDate(vo.getStartDate());
		education.setEndDate(vo.getEndDate());
		education.setCurrent(false);
		applicationService.addEducation(application, education);

		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

    // ====================================================================================================
	// SPM RESULTS
	// ====================================================================================================

	@RequestMapping(value = "/intakeApplications/{referenceNo}/spmResults", method = RequestMethod.GET)
	public ResponseEntity<List<SpmResult>> findSpmResultsByIntakeApplication(@PathVariable String referenceNo) {
		InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);

		List<InSpmResult> spmResults = applicationService.findSpmResults(application);

		return new ResponseEntity<List<SpmResult>>(applicationTransformer.toSpmResultVos(spmResults), HttpStatus.OK);
	}

	@RequestMapping(value = "/intakeApplications/{referenceNo}/spmResults", method = RequestMethod.POST)
	public ResponseEntity<String> addSpmResult(@PathVariable String referenceNo, @RequestBody SpmResult vo) {
		dummyLogin();

		InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InSpmResult spmResult = new InSpmResultImpl();
		spmResult.SetMalay(vo.getMalay());
		spmResult.SetEnglish(vo.getEnglish());
		spmResult.setIslamEduc(vo.getIslamEduc());
		spmResult.setHistory(vo.getSejarah());
		spmResult.setMath(vo.getMath());
		spmResult.setYear(vo.getYear());
		spmResult.setAggregate(vo.getAggregate());

		applicationService.addSpmResult(application, spmResult);

		return new ResponseEntity<String>("Success", HttpStatus.OK);
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
