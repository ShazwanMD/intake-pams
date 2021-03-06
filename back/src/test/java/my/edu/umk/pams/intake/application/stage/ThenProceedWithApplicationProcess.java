package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;


@JGivenStage
public class ThenProceedWithApplicationProcess  extends Stage<ThenProceedWithApplicationProcess> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenProceedWithApplicationProcess.class);
		
	@Autowired
	private ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntake intake;

	@ExpectedScenarioState
	private InIntakeSession intakeSession;

	@ExpectedScenarioState
	private InApplicant applicant;

	@ExpectedScenarioState
	private InIntakeApplication application;
	    	
	 public ThenProceedWithApplicationProcess Proceed_Application_Process() {
		
		
		 applicationService.updateIntakeApplication(application);
	     //Assert.notNull(InBidStatus.DRAFTED, "new application is drafted");
	     LOG.debug("intake application: {}", application.getBidStatus());
		 
	     return self();
	 }

}
