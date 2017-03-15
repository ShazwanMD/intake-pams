package my.edu.umk.pams.intake.registration.stage;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

public class ThenICanProcessTheirApplication extends Stage<ThenICanProcessTheirApplication>{
	
	public static final Logger LOG = LoggerFactory.getLogger(ThenICanProcessTheirApplication.class);
	
	@Autowired
	private RegistrationService registrationService;
	
	@ExpectedScenarioState
	InUser user;
	
	
    public ThenICanProcessTheirApplication I_can_process_their_application() {
        return self();
    }

}
