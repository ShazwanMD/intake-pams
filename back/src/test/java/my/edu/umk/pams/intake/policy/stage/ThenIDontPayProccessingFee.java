package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenIDontPayProccessingFee extends Stage<ThenIDontPayProccessingFee> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenIDontPayProccessingFee.class);

    @ProvidedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    public ThenIDontPayProccessingFee i_dont_pay_processing_fee() {

        return self();
    }
}

