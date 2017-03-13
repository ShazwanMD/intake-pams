package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanLogIn extends Stage<ThenICanLogIn> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanLogIn.class);

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @ExpectedScenarioState
    InUser user;

    public ThenICanLogIn I_can_login() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticated = authenticationManager.authenticate(token);
        Assert.assertNotNull(authenticated);
        return self();
    }
}
