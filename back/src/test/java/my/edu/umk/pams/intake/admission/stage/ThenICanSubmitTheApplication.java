package my.edu.umk.pams.intake.admission.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class ThenICanSubmitTheApplication extends Stage<ThenICanSubmitTheApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenICanSubmitTheApplication.class);
	
	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
        
    @Autowired
    private ApplicationService applicationService;

    public ThenICanSubmitTheApplication I_can_submit_the_application() {
		
        applicationService.submitIntakeApplication(intake, intakeApplication);
        Assert.notNull(InBidStatus.SUBMITTED, "withdraw application is null");
        LOG.debug("intake status {} :", intakeApplication.getBidStatus());
        return self();
		
	}

}
