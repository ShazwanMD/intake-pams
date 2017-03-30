package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenWithdrawApplication extends Stage<WhenWithdrawApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenWithdrawApplication.class);
	
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
	
	 public WhenWithdrawApplication Withdraw_Application() {
		 
		applicationService.withdrawIntakeApplication(intake, intakeApplication);
		Assert.notNull(InBidStatus.WITHDRAWN, "withdraw application is null");
	    return self();
		  
	 }

}
