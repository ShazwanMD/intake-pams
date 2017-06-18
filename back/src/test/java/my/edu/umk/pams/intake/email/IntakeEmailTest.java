package my.edu.umk.pams.intake.email;

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
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;
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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class IntakeEmailTest {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeEmailTest.class);

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
    private SystemService systemService;

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
        InEmailQueue emailQueue = new InEmailQueueImpl();
        emailQueue.setBody("This is a test");
        emailQueue.setCode(((Long)System.currentTimeMillis()).toString());
        emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
        emailQueue.setRetryCount(0);
        emailQueue.setSubject("Test");
        emailQueue.setTo("rafizan.baharum@gmail.com");
        systemService.saveEmailQueue(emailQueue);
     }
}
