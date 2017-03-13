package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIReceiveNotificationForSignUp  extends Stage<WhenIReceiveNotificationForSignUp> {

	@Autowired
    private RegistrationService registrationService;

    @ProvidedScenarioState
    private InUser user;
    
    public WhenIReceiveNotificationForSignUp I_receive_notification_for_sign_up() {
    	return self();
    }
}
