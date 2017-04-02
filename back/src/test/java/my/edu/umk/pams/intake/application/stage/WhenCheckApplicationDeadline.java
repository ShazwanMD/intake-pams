package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.policy.model.InIntake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;


/**
 * @author PAMS
 */
@JGivenStage
public class WhenCheckApplicationDeadline extends Stage<WhenCheckApplicationDeadline> {
 
	private static final Logger LOG = LoggerFactory.getLogger(WhenCheckApplicationDeadline.class);

    @ExpectedScenarioState
    private InIntake intake;

    public WhenCheckApplicationDeadline i_check_intake_application_deadline() {
        Assert.notNull(intake, "intake cannot be null");

        return self();
    }

}
