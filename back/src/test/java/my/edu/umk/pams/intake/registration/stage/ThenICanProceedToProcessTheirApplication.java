package my.edu.umk.pams.intake.registration.stage;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenICanProceedToProcessTheirApplication extends Stage<ThenICanProceedToProcessTheirApplication> {

   	private static final Logger LOG = LoggerFactory.getLogger(ThenICanProceedToProcessTheirApplication.class);

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

    public ThenICanProceedToProcessTheirApplication I_can_proceed_to_process_their_application() {

    	applicationService.draftedIntakeApplication(intake, intakeApplication);
        Assert.notNull(InBidStatus.APPEAL, "withdraw application is null");
        LOG.debug("intake status {}", intakeApplication.getBidStatus());
        return self();
    }
}

