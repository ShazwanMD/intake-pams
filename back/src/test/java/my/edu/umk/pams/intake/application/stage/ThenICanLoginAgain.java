package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanLogIn;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanLoginAgain extends Stage<ThenICanLoginAgain> {

	  @Autowired
	    private RegistrationService registrationService;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @ExpectedScenarioState
	    InUser user;

	    public ThenICanLoginAgain I_can_login_again() 
	    {
	    	
	        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
	        Authentication authenticated = authenticationManager.authenticate(token);
	        Assert.assertNotNull(authenticated);
	        return self();
	    }
}

