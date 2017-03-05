package my.edu.umk.pams.intake.policy;

import my.edu.umk.pams.intake.TestSupport;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.identity.US_IN_ADM_0001;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeLevel;
import my.edu.umk.pams.intake.policy.model.InIntakeImpl;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.activiti.engine.task.Task;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_0001 extends TestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_ADM_0001.class);

    @Autowired
    private CommonService commonService;

    @Autowired
    private PolicyService policyService;

    private String referenceNo;

    @Before
    public void before() {
        super.before();
    }

    @After
    public void after(){
    }

    @Test
    @Rollback(true)
    public void testSomething(){
        Assert.assertNotNull(currentUser);
        InIntakeSession session = policyService.findIntakeSessionByCode("201720181");
        InIntakeLevel level = policyService.findIntakeLevelByCode("MASTER");

        InIntake newIntake = new InIntakeImpl();
        referenceNo = session.getCode() + "/" + level.getCode();
        newIntake.setReferenceNo(referenceNo);
        newIntake.setSourceNo(level.getCode() + "/" + session.getCode());
        newIntake.setDescription("Intake for Masters 201520161");
        newIntake.setLevel(level);
        newIntake.setSession(session);
        newIntake.setProjection(100);
        newIntake.setStartDate(new Date());
        newIntake.setEndDate(new Date());
        policyService.startIntakeTask(newIntake);

        // ====================================================================================================
        // DRAFTED
        // ====================================================================================================

        List<Task> draftedTasks = policyService.findAssignedIntakeTasks(0, 100);
        Task draftedTask = draftedTasks.get(0);
        InIntake draftedIntake = policyService.findIntakeByTaskId(draftedTask.getId());

        InProgramCode tpc09 = commonService.findProgramCodeByCode("TP09");
        addProgramOffering(draftedIntake, tpc09);

        InProgramCode tp16 = commonService.findProgramCodeByCode("TP16");
        addProgramOffering(draftedIntake, tp16);

        policyService.completeTask(draftedTask);

        // ====================================================================================================
        // VERIFIED
        // ====================================================================================================

        List<Task> verifiedTasks = policyService.findAssignedIntakeTasks(0, 100);
        Task verifiedTask = verifiedTasks.get(0);
        policyService.completeTask(verifiedTask);

        // ====================================================================================================
        // PUBLISHED
         // ====================================================================================================

        List<Task> publishedTasks = policyService.findAssignedIntakeTasks(0, 100);
        Task publishedTask = publishedTasks.get(0);
        policyService.completeTask(publishedTask);

        // ====================================================================================================
        // EVALUATED
        // ====================================================================================================

        List<Task> evaluatedTasks = policyService.findAssignedIntakeTasks(0, 100);
        Task evaluatedTask = evaluatedTasks.get(0);
        policyService.completeTask(evaluatedTask);

        // ====================================================================================================
        // SELECTED
        // ====================================================================================================

        List<Task> selectedTasks = policyService.findAssignedIntakeTasks(0, 100);
        Task selectedTask = selectedTasks.get(0);
        policyService.completeTask(selectedTask);

        // assert that our intake is processed
        InIntake processedIntake = policyService.findIntakeByReferenceNo(referenceNo);
        Assert.assertTrue(InFlowState.COMPLETED.equals(processedIntake.getFlowdata().getState()));
    }


    private void addProgramOffering(InIntake intake, InProgramCode programCode) {
        // todo
    }
}

