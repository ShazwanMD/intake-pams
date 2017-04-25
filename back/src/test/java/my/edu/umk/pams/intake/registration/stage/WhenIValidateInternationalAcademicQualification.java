package my.edu.umk.pams.intake.registration.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;

@JGivenStage
public class WhenIValidateInternationalAcademicQualification
		extends Stage<WhenIValidateInternationalAcademicQualification> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIValidateInternationalAcademicQualification.class);

	@Autowired
	ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntake intake;

	public WhenIValidateInternationalAcademicQualification I_validate_international_academic_qualification() {

		List<InIntakeApplication> verifiedApplications = applicationService
				.findIntakeApplicationsByVerificationStatus(intake, false);
		Assert.notEmpty(verifiedApplications, "paidApplications cannot be empty");

		for (InIntakeApplication application : verifiedApplications) {

			LOG.debug("Current verification status : {}", application.getVerification());
			applicationService.verifyInternationalApplications(intake, application);
			Assert.isTrue(application.getVerification(), "intakeApplication cannot be unverified");
			LOG.debug("Verification status after validation : {}", application.getVerification());

		}

		return self();
	}

}