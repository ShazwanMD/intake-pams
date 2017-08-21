package my.edu.umk.pams.intake.workflow;

import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.*;
import my.edu.umk.pams.intake.policy.service.PolicyService;
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

import java.util.Date;
import java.util.UUID;

/**
 * @author PAMS
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class IntakeDraftWorkflowTest {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeDraftWorkflowTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private IdentityService identityService;

    @Before
    public void before() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

    @Test
    @Rollback(false)
    public void testDraftWorkflow() {
        InProgramLevel level = policyService.findProgramLevelByCode("MASTER");
        InIntakeSession session = policyService.findIntakeSessionByCode("20171");
        InGraduateCenter center = commonService.findGraduateCenterByCode("MGSEB");

        // start a new intake
        InIntake intake = new InIntakeImpl();
        intake.setAuditNo(UUID.randomUUID().toString());
        intake.setSourceNo("MASTER/201720182" + System.currentTimeMillis());
        intake.setDescriptionEn("Intake for Program Master 201720181 "  + System.currentTimeMillis());
        intake.setProjection(100);
        intake.setStartDate(new Date());
        intake.setEndDate(new Date());
        intake.setProgramLevel(level);
        intake.setSession(session);
        intake.setGraduateCenter(center);
        String referenceNo = policyService.startIntakeTask(intake);

        // search again
        intake = policyService.findIntakeByReferenceNo(referenceNo);

        // preload program offering
        InProgramCode mck = commonService.findProgramCodeByCode("MCK");
        InProgramOffering mckOffering = new InProgramOfferingImpl();
        mckOffering.setProgramCode(mck);
        policyService.addProgramOffering(intake, mckOffering);

        InProgramCode mcn = commonService.findProgramCodeByCode("MCN");
        InProgramOffering mcnOffering = new InProgramOfferingImpl();
        mcnOffering.setProgramCode(mcn);
        policyService.addProgramOffering(intake, mcnOffering);

        // preload studymode offering
        InStudyMode fulltime = commonService.findStudyModeByCode("1");
        InStudyModeOffering fulltimeOffering = new InStudyModeOfferingImpl();
        fulltimeOffering.setStudyMode(fulltime);
        policyService.addStudyModeOffering(intake, fulltimeOffering);

        InStudyMode parttime = commonService.findStudyModeByCode("1");
        InStudyModeOffering parttimeOffering = new InStudyModeOfferingImpl();
        parttimeOffering.setStudyMode(parttime);
        policyService.addStudyModeOffering(intake, parttimeOffering);

    }
}
