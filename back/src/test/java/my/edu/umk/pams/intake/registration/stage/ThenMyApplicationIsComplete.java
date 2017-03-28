package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenMyApplicationIsComplete extends Stage<ThenMyApplicationIsComplete> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenMyApplicationIsComplete.class);

    @Autowired
    private RegistrationService registrationService;

    @ExpectedScenarioState
    InUser user;

    @ExpectedScenarioState
    boolean exists;

    public ThenMyApplicationIsComplete my_application_is_complete() {

        Assert.isTrue(exists, "yes i have registered before");

        return self();
    }

}