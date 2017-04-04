package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class ThenMyApplicationIsUpdated extends Stage<ThenMyApplicationIsUpdated>{
	private static final Logger LOG = LoggerFactory.getLogger(ThenMyApplicationIsUpdated.class);
	
	 @Autowired
	 private ApplicationService applicationService;

	 @ExpectedScenarioState
	 private InIntake intake;

	 @ExpectedScenarioState
	 private InIntakeSession intakeSession;

	 @ExpectedScenarioState
	 private InApplicant applicant;

	 @ExpectedScenarioState
	 private InIntakeApplication intakeApplication;
	 
	 
	 public ThenMyApplicationIsUpdated my_application_is_updated(){
		 applicationService.updateIntakeApplication(intakeApplication);
		 Assert.notNull(InBidStatus.PROCESSING, "application is not updated");
		 LOG.debug("intake status {}", intakeApplication.getBidStatus());

		 return self();
		 
	 }

}
