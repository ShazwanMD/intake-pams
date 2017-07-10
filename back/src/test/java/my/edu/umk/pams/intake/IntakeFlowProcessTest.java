package my.edu.umk.pams.intake;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.*;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;

import org.activiti.engine.task.Task;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author PAMS
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class IntakeFlowProcessTest {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeFlowProcessTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private ApplicationService applicationService;

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
        InGraduateCenter center = commonService.findGraduateCenterByCode("CPS");

        // start a new intake
        InIntake intake = new InIntakeImpl();
        intake.setAuditNo(UUID.randomUUID().toString());
        intake.setSourceNo("MASTER/201720182" + System.currentTimeMillis());
        intake.setDescription("Intake for Program Master 201720181 " + System.currentTimeMillis());
        intake.setProjection(100);
        intake.setStartDate(new Date());
        intake.setEndDate(new Date());
        intake.setProgramLevel(level);
        intake.setSession(session);
        intake.setGraduateCenter(center);
        String referenceNo = policyService.startIntakeTask(intake);

        // verify intake

        List<Task> draftedTasks = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(draftedTasks, "Tasks should not be empty");
        Task draftedTask = draftedTasks.get(0);
        InIntake draftedIntake = policyService.findIntakeByTaskId(draftedTask.getId());

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

        InStudyMode parttime = commonService.findStudyModeByCode("2");
        InStudyModeOffering parttimeOffering = new InStudyModeOfferingImpl();
        parttimeOffering.setStudyMode(parttime);
        policyService.addStudyModeOffering(intake, parttimeOffering);

        // preload supervisor offering
        InSupervisorCode supervisor1 = commonService.findSupervisorCodeByCode("00001A");
        InSupervisorOffering supervisorOffering1 = new InSupervisorOfferingImpl();
        supervisorOffering1.setSupervisorCode(supervisor1);

        policyService.addSupervisorOffering(intake, supervisorOffering1);

        InSupervisorCode supervisor2 = commonService.findSupervisorCodeByCode("00019A");
        InSupervisorOffering supervisorOffering2 = new InSupervisorOfferingImpl();
        supervisorOffering2.setSupervisorCode(supervisor2);

        policyService.addSupervisorOffering(intake, supervisorOffering2);
        workflowService.completeTask(draftedTask);

        // publish intake
        List<Task> assignedVerifiedIntakes = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(assignedVerifiedIntakes, "Tasks should not be empty");
        workflowService.completeTask(assignedVerifiedIntakes.get(0)); // TO APPROVED

        //Create application samples for citizen and on citizen application

        InIntakeApplication application1 = new InIntakeApplicationImpl();
        application1.setIntake(intake);
        application1.setReferenceNo(referenceNo);
        application1.setStudyModeSelection(parttimeOffering);
        application1.setSupervisorSelection(supervisorOffering1);
        application1.setProgramSelection(mckOffering);
        application1.setCredentialNo("234234");
        application1.setResearchTitle("test1");
        application1.setName("testCitizen bin ting");
        application1.setEmail("testCitizen@email.com");
        application1.setPhone("01110202022");
        application1.setNationalityCode(commonService.findNationalityCodeByCode("1"));
        application1.setBidStatus(InBidStatus.NEW);
        application1.setApplicant((InApplicant) identityService.findUserByUsername("applicant1").getActor());
        applicationService.applyIntake(intake, application1);
        applicationService.submitIntakeApplication(draftedIntake, application1);

        InIntakeApplication application2 = new InIntakeApplicationImpl();
        application2.setIntake(intake);
        application2.setReferenceNo(referenceNo);
        application2.setStudyModeSelection(fulltimeOffering);
        application2.setSupervisorSelection(supervisorOffering2);
        application2.setProgramSelection(mcnOffering);
        application2.setCredentialNo("123123");
        application2.setResearchTitle("test2");
        application2.setName("testNonCitizen bin ting");
        application2.setEmail("testNonCitizen@email.com");
        application2.setPhone("011102021221");
        application2.setNationalityCode(commonService.findNationalityCodeByCode("2"));
        application2.setBidStatus(InBidStatus.NEW);
        application2.setApplicant((InApplicant) identityService.findUserByUsername("applicant1").getActor());
        applicationService.applyIntake(intake, application2);
        applicationService.submitIntakeApplication(draftedIntake, application2);

    }

}
