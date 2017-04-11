package my.edu.umk.pams.intake.admission.stage;

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
public class WhenAddReasonForUnSuccessfulApplication  extends Stage<WhenAddReasonForUnSuccessfulApplication> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenAddReasonForUnSuccessfulApplication.class);

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
	 
	 public WhenAddReasonForUnSuccessfulApplication I_add_reason_for_unsuccessful_application(){
		 
		 
	     applicationService.rejectIntakeApplication(intake, intakeApplication);
	     Assert.notNull(intakeApplication, "application is null");

	     InBidStatus bidStatus = intakeApplication.getBidStatus();
	     Assert.isTrue(InBidStatus.REJECTED.equals(bidStatus), "application is not submitted");
	     LOG.debug("intake status {} :", intakeApplication.getBidStatus());
	     
	     
		 intakeApplication.setReason("Your Application Is UnSuccessfull");
		 applicationService.updateIntakeApplication(intakeApplication);
		 
		 
		 
		 return self();
	 }
}
