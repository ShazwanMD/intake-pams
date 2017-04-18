package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.policy.model.InIntake;
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
public class GivenIAmRegistrar extends Stage<GivenIAmRegistrar> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmRegistrar.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    InIntakeSession intakeSession;
    
    @ProvidedScenarioState
    InIntake intake;


    public void I_am_a_Registrar_in_$_academic_session(String academicSessionCode){
        loginAsRegistrar();
        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
    }

    public GivenIAmRegistrar I_am_a_Registrar_in_current_intake_session(){
        loginAsRegistrar();
        intakeSession = policyService.findCurrentIntakeSession();
        return self();
    }
    
    public GivenIAmRegistrar I_pick_an_intake_$(String intakeReferenceNo){
        intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);
        return self();
    }

    private void loginAsRegistrar() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("registrar", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}