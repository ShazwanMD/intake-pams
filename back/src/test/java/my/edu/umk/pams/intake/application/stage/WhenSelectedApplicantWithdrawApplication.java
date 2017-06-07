package my.edu.umk.pams.intake.application.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenSelectedApplicantWithdrawApplication extends Stage<WhenSelectedApplicantWithdrawApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenSelectedApplicantWithdrawApplication.class);
	
	@Autowired
    private ApplicationService applicationService;
	
	@ExpectedScenarioState
    private InIntake intake;

	@ExpectedScenarioState
    private InIntakeSession intakeSession;
	
    @ExpectedScenarioState
    private InApplicant applicant;
	
    
    @ExpectedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState 
    List<InIntakeApplication> applicants;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
	public WhenSelectedApplicantWithdrawApplication Withdraw_Application_in_current_intake_session_$(String intakeSession) {

		 applicationService.withdrawIntakeApplication(intake, intakeApplication);
		 Assert.notNull(InBidStatus.WITHDRAW, "withdraw application is null");
		 LOG.debug("intake application status: {} ", intakeApplication.getBidStatus());
		
		 return self();
	 }

}
