
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

/**
 * @author PAMS
 */
@JGivenStage
public class CheckForRegistration extends Stage<CheckForRegistration> {

    @Autowired
    private RegistrationService registrationService;

    @ProvidedScenarioState
    private InUser user;

    @ProvidedScenarioState
    private boolean exists;

    public CheckForRegistration I_check_for_registeration_for_$(String username) {
		
		//exists = registrationService.isUserExists(username);	
		
		
		return self();
	}

		
 }

