
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
public class GivenIAmAnonymous extends Stage<GivenIAmAnonymous> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmAnonymous.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyServce;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    public void I_am_a_anonymous_in_$_intake_session(String academicSessionCode) {
        // do nothing
        intakeSession = policyServce.findIntakeSessionByCode(academicSessionCode);
    }

    public void I_am_an_anonymous_in_current_intake_session() {
        // do nothing
    	loginAsAnonymous();
        intakeSession = policyServce.findCurrentIntakeSession();
    }

	private void loginAsAnonymous() {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("anon", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
	}


}
