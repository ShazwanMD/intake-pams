package my.edu.umk.pams.intake.workflow;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.identity.model.InActor;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author PAMS
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class IntakeApplicationTest {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeApplicationTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SecurityService securityService;

    @Before
    public void before() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("applicant1", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

    @Test
    @Rollback(false)
    public void testDraftWorkflow() {
        // find first intake
        List<InIntake> intakes = policyService.findIntakes();
        InIntake intake = intakes.get(0);

        // user & applicant
        InUser currentUser = securityService.getCurrentUser();
        InActor actor = currentUser.getActor();
        InApplicant applicant = null;
        if (actor instanceof InApplicant) applicant = (InApplicant) actor;

        InIntakeApplication application = new InIntakeApplicationImpl();
        application.setName(applicant.getName());
        application.setEmail(applicant.getEmail());
        try {
            applicationService.applyIntake(intake, application);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
