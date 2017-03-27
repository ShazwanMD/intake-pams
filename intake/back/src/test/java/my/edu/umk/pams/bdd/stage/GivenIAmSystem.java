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
public class GivenIAmSystem extends Stage<GivenIAmSystem> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmSystem.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    public void I_am_a_system_in_$_academic_session(String academicSessionCode) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("system", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
    }

    public void I_am_a_system_in_current_academic_session() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("system", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        intakeSession = policyService.findCurrentIntakeSession();
    }
}
