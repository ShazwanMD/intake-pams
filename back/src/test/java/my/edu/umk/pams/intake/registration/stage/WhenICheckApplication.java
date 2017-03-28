
package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenICheckApplication extends Stage<WhenICheckApplication> {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SecurityService securityService;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ProvidedScenarioState
    private boolean exists;

    public WhenICheckApplication i_check_for_application() {

        //uda and max, tolong tgk jap betul dak buat mcm ni untuk check for registered user?
        exists = registrationService.isExists("applicant1");
        Assert.isTrue(exists, "registered user does not exists");

        return self();
    }


}

