package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;



@JGivenStage
public class WhenViewApplicationWithInternationalAcademicQualification extends Stage<WhenViewApplicationWithInternationalAcademicQualification>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenViewApplicationWithInternationalAcademicQualification.class);
	
	
	@Autowired
	ApplicationService applicationService;

	@ProvidedScenarioState
	List<InIntakeApplication> UnverifiedApplications;

	@ExpectedScenarioState
	private InIntake intake;
	
	public WhenViewApplicationWithInternationalAcademicQualification I_view_application_with_international_academic_qualification() {

		UnverifiedApplications = applicationService
				.findIntakeApplicationsByVerificationStatus(intake, InBidStatus.SELECTED, false);
		Assert.notEmpty(UnverifiedApplications, "paidApplications cannot be empty");

		for (InIntakeApplication application : UnverifiedApplications) {

			LOG.debug("Current verification status for IO student {}, is : {}", application.getName(),
					application.isVerified());

		}
		
		return self();
	}
	

}
