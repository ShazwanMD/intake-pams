package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenIntakeIsReadyForSetup extends Stage<ThenIntakeIsReadyForSetup> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenIntakeIsReadyForSetup.class);

    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InIntake intake;

    public ThenIntakeIsReadyForSetup intake_is_ready_for_setup(){
        InIntake found = policyService.findIntakeByReferenceNo(intake.getReferenceNo());
        Assert.assertEquals(InFlowState.DRAFTED, found.getFlowdata().getState());
        return self();
    }
}
