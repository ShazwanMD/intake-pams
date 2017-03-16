package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.WhenIDraftMyApplication;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeLevel;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.security.service.SecurityService;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

@JGivenStage
public class GivenIHaveIncompleteApplication extends Stage<GivenIHaveIncompleteApplication> {

	private static final Logger LOG = LoggerFactory.getLogger(GivenIHaveIncompleteApplication.class);

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private PolicyService policyService;
	
	

	@ExpectedScenarioState
	private InUser user;

	public GivenIHaveIncompleteApplication i_drafted_an_application(){
		InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		Assert.notNull(intake, "intake is null");

		InApplicant applicant = null;

		Assert.isTrue((user.getActor() instanceof InApplicant), "actor is not an applicant");

		if (user.getActor() instanceof InApplicant) {
			applicant = (InApplicant) user.getActor();
			Assert.notNull(applicant, "applicant is null");
		}


		InIntakeApplication application = new InIntakeApplicationImpl();
		application.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); // auto
																		// numbered
		application.setIntake(intake);
		application.setName("Ahmad Kharizmi bin Khaldun");
		application.setCredentialNo("910607145581");
		application.setEmail("ibnu_khaldun@gmail.com");
		application.setAge(21);
		application.setGenderCode(commonService.findGenderCodeByCode("M"));
		application.setReligionCode(commonService.findReligionCodeByCode("ISLAM"));
		application.setNationalityCode(commonService.findNationalityCodeByCode("MALAYSIA"));
		application.setRaceCode(commonService.findRaceCodeByCode("MALAY"));
		application.setEthnicityCode(commonService.findEthnicityCodeByCode("JAVA"));
		application.setMaritalCode(commonService.findMaritalCodeByCode("MARRIED"));
		application.setDisabilityCode(commonService.findDisabilityCodeByCode("DISABLE"));
		application.setResidencyCode(commonService.findResidencyCodeByCode("RESIDENT"));
		application.setApplicant(applicant);
		
		applicationService.draftIntakeApplication(intake, application);
		return self();
		
	}
	public GivenIHaveIncompleteApplication i_have_an_incomplete_application() {
		InIntake intake = policyService.findIntakeByReferenceNo("MASTER/201720181");

		InApplicant applicant = null;

		Assert.isTrue((user.getActor() instanceof InApplicant), "actor is not an applicant");

		if (user.getActor() instanceof InApplicant) {
			applicant = (InApplicant) user.getActor();
			Assert.notNull(applicant, "applicant is null");
			LOG.debug("applicant ", applicant);
		}

		
		InIntakeApplication application = applicationService.findIntakeApplicationByIntakeAndApplicant(intake,
				applicant);
		Assert.notNull(application, "application should not be null");
		Assert.isTrue(!application.isAccepted(), "already accepted");
		
		
		return self();
	}	
}
