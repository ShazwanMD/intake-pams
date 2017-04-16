
package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenCompleteApplication extends Stage<WhenCompleteApplication> {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SecurityService securityService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;

    public WhenCompleteApplication i_complete_my_application() {

        //uda and max, tolong tgk jap betul dak buat mcm ni untuk check for registered user?
        // TODO: Instead of check for registered user, just 'complete' this application
        // TODO: application.setSomething() to complete this application;

        return self();
    }


}

