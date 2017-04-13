package my.edu.umk.pams.bdd.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;

@JGivenStage
public class GivenIAmCandidate extends Stage<GivenIAmCandidate>{
	private static final Logger LOG = LoggerFactory.getLogger(GivenIAmCandidate.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    private InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InIntake intake;
    
    @ProvidedScenarioState
    private InCandidate candidate;
    
    public GivenIAmCandidate I_am_a_candidate_in_$_intake_session(String academicSessionCode) {
        loginAsCandidate();
        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
        return self();
    }
    
    public GivenIAmCandidate I_am_candidate_in_current_intake_session() {
        loginAsCandidate();
        intakeSession = policyService.findCurrentIntakeSession();
        return self();
    }
    
    public GivenIAmCandidate I_applied_for_intake_$(String intakeReferenceNo){
        intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);
        return self();
    }
    
    private void loginAsCandidate() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("candidate1", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
        
        InUser currentUser = securityService.getCurrentUser();
        candidate = (InCandidate) currentUser.getActor();
    }

}
