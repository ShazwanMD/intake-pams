package my.edu.umk.pams.intake.admission.stage;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
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
		 

	   LOG.debug("reason : {}", intakeApplication.getReason());
	   Assert.notNull(intakeApplication, "reason is not set");
		 LOG.debug("reason : {}", intakeApplication.getReason());
		 return self();
   }
}
