package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InStaff;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmBursary extends Stage<GivenIAmBursary> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmBursary.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyServce;

    @ProvidedScenarioState
    private InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InStaff staff;

    public void I_am_a_bursary_in_$_academic_session(String academicSessionCode) {
        loginAsBursary();
        intakeSession = policyServce.findIntakeSessionByCode(academicSessionCode);
    }

    public void I_am_a_bursary_in_current_academic_session() {
        loginAsBursary();
        intakeSession = policyServce.findCurrentIntakeSession();
    }

    private void loginAsBursary() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("bursary", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        // retrieve staff from user
        InUser user = ((InUserDetails) authed.getPrincipal()).getUser();
        staff = (InStaff) user.getActor();
    }

}
