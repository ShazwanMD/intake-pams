
package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;


@JGivenStage
public class WhenIVerifySponsorshipStatus extends Stage<WhenIVerifySponsorshipStatus> {

    @Autowired
    private RegistrationService registrationService;

    @ProvidedScenarioState
    private InUser user;

    public WhenIVerifySponsorshipStatus I_verify_applicant_has_valid_sponsorship_status() {
   

        return self();
    }
}
