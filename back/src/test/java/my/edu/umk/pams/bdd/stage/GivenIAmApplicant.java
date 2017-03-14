
package my.edu.umk.pams.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@JGivenStage
public class GivenIAmApplicant extends Stage<GivenIAmApplicant> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIAmApplicant.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private SecurityService securityService;

    @ProvidedScenarioState
    private InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private InApplicant applicant;

    public GivenIAmApplicant I_am_a_applicant_in_$_intake_session(String academicSessionCode) {
        loginAsApplicant();
        intakeSession = policyService.findIntakeSessionByCode(academicSessionCode);
        return self();
    }

    public GivenIAmApplicant I_am_an_applicant_in_current_intake_session() {
        loginAsApplicant();
        intakeSession = policyService.findCurrentIntakeSession();
        return self();
    }

    public GivenIAmApplicant I_am_applying_for_intake_$(String intakeReferenceNo){
        intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);
        return self();
    }

    private void loginAsApplicant() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("applicant1", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);

        // retrieve applicant from user
        InUser currentUser = securityService.getCurrentUser();
        applicant = (InApplicant) currentUser.getActor();
    }
}
