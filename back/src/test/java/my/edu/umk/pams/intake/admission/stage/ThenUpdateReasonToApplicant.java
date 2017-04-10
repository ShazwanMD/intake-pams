package my.edu.umk.pams.intake.admission.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

public class ThenUpdateReasonToApplicant  extends Stage<ThenUpdateReasonToApplicant> {

	 private static final Logger LOG = LoggerFactory.getLogger(ThenUpdateReasonToApplicant.class);
	
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
	 
   public ThenUpdateReasonToApplicant unsuccessful_applicant_view_the_reason(){
		 
	   applicationService.updateIntakeApplication(intakeApplication);
	   //Assert.notNull(intakeApplication.getReason());
	  // Assert.notNull(InBidStatus.PROCESSING, "application is not updated");
		 LOG.debug("reason : {}", intakeApplication.getReason());
		 return self();
   }
}
