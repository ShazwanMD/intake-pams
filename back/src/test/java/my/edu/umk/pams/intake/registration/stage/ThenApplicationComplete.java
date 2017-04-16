package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenApplicationComplete extends Stage<ThenApplicationComplete> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenApplicationComplete.class);

    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;

    public ThenApplicationComplete the_application_is_complete() {

//      TODO:  Assert.isTrue(something.equals(application.getSomething()), "application is not completed");
        LOG.debug("TODO FIX ME");
        return self();
    }

    public ThenApplicationComplete the_application_is_submitted() {

        String message = "application is not submitted";
        Assert.isTrue(InBidStatus.SUBMITTED.equals(intakeApplication.getBidStatus()), message);

        return self();
    }

}