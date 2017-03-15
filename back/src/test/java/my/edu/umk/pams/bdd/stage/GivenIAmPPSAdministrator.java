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
public class GivenIAmPPSAdministrator extends Stage<GivenIAmPPSAdministrator> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmPPSAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    public void I_am_a_PPS_administrator_in_$_academic_session(String academicSessionCode){
        loginAsPPS();
        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
    }

    public void I_am_a_PPS_administrator_in_current_intake_session(){
        loginAsPPS();
        intakeSession = policyService.findCurrentIntakeSession();
    }

    private void loginAsPPS() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("pps", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

}
