package my.edu.umk.pams.intake.workflow;

import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeImpl;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Ignore;
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
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class IntakeWorkflowTest {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeWorkflowTest.class);

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

    @Ignore("This one throws a NPE")
    @Test
    @Rollback(false)
    public void testDraftWorkflow() {
        InProgramLevel level = policyService.findProgramLevelByCode("MASTER");
        InIntakeSession session = policyService.findIntakeSessionByCode("20171");

        // start a new intake
        InIntake intake = new InIntakeImpl();
        intake.setAuditNo(UUID.randomUUID().toString());
        intake.setDescription("Intake for Program Master 201720181");
        intake.setProgramLevel(level);
        intake.setSession(session);
        intake.setProjection(100);
        intake.setStartDate(new Date());
        intake.setEndDate(new Date());
        intake.setSourceNo("MASTER/201720182");
        String referenceNo = policyService.startIntakeTask(intake);

        // find and pick assigned drafted intake
        // assuming there is one
        List<Task> draftedTasks = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(draftedTasks, "Tasks should not be empty");
        Task draftedTask = draftedTasks.get(0);
        InIntake draftedIntake = policyService.findIntakeByTaskId(draftedTask.getId());

        // add program offering to intake
        // add supervisor offering to intake
        // add study mode offering to intake

        workflowService.completeTask(draftedTask);

        List<Task> pooledRegisteredIntakes = policyService.findPooledIntakeTasks(0, 100);
        Assert.notEmpty(pooledRegisteredIntakes, "Tasks should not be empty");
        workflowService.assignTask(pooledRegisteredIntakes.get(0));

        // find and complete assigned registered intake
        // assuming there is exactly one
        // transition to VERIFIED
        List<Task> assignedRegisteredIntakes = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(assignedRegisteredIntakes, "Tasks should not be empty");
        workflowService.completeTask(assignedRegisteredIntakes.get(0));

        // PEGAWAI
        // find and pick pooled verified intake
        // assuming there is exactly one
        List<Task> pooledVerifiedIntakes = policyService.findPooledIntakeTasks(0, 100);
        Assert.notEmpty(pooledVerifiedIntakes, "Tasks should not be empty");
        workflowService.assignTask(pooledVerifiedIntakes.get(0));

        // find and complete assigned verified intake
        // assuming there is exactly one
        // transition to PUBLISHED (COMPLETED)
        List<Task> assignedVerifiedIntakes = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(assignedVerifiedIntakes, "Tasks should not be empty");
        workflowService.completeTask(assignedVerifiedIntakes.get(0)); // TO APPROVE

        // apply here

        // find and pick pooled published intake
        // assuming there is exactly one
        List<Task> pooledPublishedIntakes = policyService.findPooledIntakeTasks(0, 100);
        Assert.notEmpty(pooledPublishedIntakes, "Tasks should not be empty");
        workflowService.assignTask(pooledPublishedIntakes.get(0));

        // find and complete assigned published intake
        // assuming there is exactly one
        // transition to EVALUATED (COMPLETED)
        List<Task> assignedPublishedIntakes = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(assignedPublishedIntakes, "Tasks should not be empty");
        workflowService.completeTask(assignedPublishedIntakes.get(0)); // TO APPROVE
        

        // find and pick pooled evaluated intake
        // assuming there is exactly one
        List<Task> pooledEvaluatedIntakes = policyService.findPooledIntakeTasks(0, 100);
        Assert.notEmpty(pooledEvaluatedIntakes, "Tasks should not be empty");
        workflowService.assignTask(pooledEvaluatedIntakes.get(0));

        // find and complete assigned evaluated intake
        // assuming there is exactly one
        // transition to SELECTED (COMPLETED)
        List<Task> assignedEvaluatedIntakes = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(assignedEvaluatedIntakes, "Tasks should not be empty");
        workflowService.completeTask(assignedEvaluatedIntakes.get(0)); // TO APPROVE

        // find and pick pooled selected intake
        // assuming there is exactly one
        List<Task> pooledSelectedIntakes = policyService.findPooledIntakeTasks(0, 100);
        Assert.notEmpty(pooledSelectedIntakes, "Tasks should not be empty");
        workflowService.assignTask(pooledSelectedIntakes.get(0));

        // find and complete assigned selected intake
        // assuming there is exactly one
        // transition to APPROVED (COMPLETED)
        List<Task> assignedSelectedIntakes = policyService.findAssignedIntakeTasks(0, 100);
        Assert.notEmpty(assignedSelectedIntakes, "Tasks should not be empty");
        workflowService.completeTask(assignedSelectedIntakes.get(0)); // TO APPROVE

    }
}
