package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmAdministrator extends Stage<GivenIAmAdministrator> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    public void I_am_a_administrator_in_$_intake_session(String academicSessionCode, String username, String password) {
        loginAsAdministrator(username, password);
        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
    }

    public void I_am_a_administrator_in_current_intake_session_as_$(String username, String password) {
        loginAsAdministrator(username, password);
        intakeSession = policyService.findCurrentIntakeSession();
    }

    private void loginAsAdministrator(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
