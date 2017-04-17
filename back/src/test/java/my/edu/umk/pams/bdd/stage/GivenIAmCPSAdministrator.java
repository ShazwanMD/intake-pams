package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
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
public class GivenIAmCPSAdministrator extends Stage<GivenIAmCPSAdministrator> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmCPSAdministrator.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private ApplicationService applicationService;

    @ProvidedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    InIntake intake;

    @ProvidedScenarioState
    private InIntakeApplication selectedApplication;
    
    @ProvidedScenarioState
    private InApplicant applicant;
    
    
    public GivenIAmCPSAdministrator I_am_a_CPS_administrator_in_$_academic_session(String academicSessionCode){
        loginAsCPS();
        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
        return self();
    }

    public GivenIAmCPSAdministrator I_am_a_CPS_administrator_in_current_intake_session(){
        loginAsCPS();
        intakeSession = policyService.findCurrentIntakeSession();
        return self();
    }

    public GivenIAmCPSAdministrator I_pick_an_intake_$(String intakeReferenceNo){
      LOG.debug("intakeReferenceNo {}",intakeReferenceNo);
      intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);
        return self();
    }
    
    private void loginAsCPS() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("cps", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

}