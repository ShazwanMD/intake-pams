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
public class WhenIAddPromoCode extends Stage<WhenIAddPromoCode> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddPromoCode.class);

    @ProvidedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    public WhenIAddPromoCode i_add_promo_code() {

        return self();
    }
}
