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
public class ThenValidateTheApplication extends Stage<ThenValidateTheApplication>{
	
	@Autowired
	ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntake intake;
	
	@ExpectedScenarioState
	List<InIntakeApplication> UnverifiedApplications;
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenValidateTheApplication.class);
	
	public ThenValidateTheApplication I_can_validate_the_application() {
		
		for (InIntakeApplication application : UnverifiedApplications) {
			
			applicationService.verifyInternationalApplications(intake, application);
			Assert.isTrue(application.getVerification(), "intakeApplication cannot be unverified");
			LOG.debug("Verification status for IO student {} after validation is : {}", application.getName() , application.getVerification());
			
		}

		
		return self();
	}
	

}
