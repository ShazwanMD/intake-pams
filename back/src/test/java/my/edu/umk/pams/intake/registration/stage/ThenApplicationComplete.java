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
    private InIntakeApplication application;

    public ThenApplicationComplete the_application_is_complete() {

    	Assert.notNull(application, "application is not complete");
        return self();
    }

    public ThenApplicationComplete the_application_is_submitted() {

        String message = "application is not submitted";
        Assert.isTrue(InBidStatus.SUBMITTED.equals(application.getBidStatus()), message);
        LOG.debug("intake status : {} ", application.getBidStatus());

        return self();
    }

}