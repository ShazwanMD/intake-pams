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
public class GivenIAmInternationalOfficer extends Stage<GivenIAmInternationalOfficer> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmInternationalOfficer.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    public void I_am_a_International_Officer_in_$_academic_session(String academicSessionCode){
        loginAsIO();
        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
    }

    public void I_am_a_International_Officer_in_current_intake_session(){
        loginAsIO();
        intakeSession = policyService.findCurrentIntakeSession();
    }

    private void loginAsIO() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("international-officer", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}

