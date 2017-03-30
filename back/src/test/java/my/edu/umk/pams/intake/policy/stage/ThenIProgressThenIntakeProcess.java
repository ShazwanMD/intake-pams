package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.util.Util;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenIProgressThenIntakeProcess extends Stage<ThenIProgressThenIntakeProcess> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenIProgressThenIntakeProcess.class);

    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InIntake intake;

    public ThenIProgressThenIntakeProcess i_can_progress_the_intake_process() {

        InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");

        intake.getProjection();
        intake.getStartDate();
        intake.getEndDate();
        policyService.startIntakeTask(intake);

        List<Task> tasks = policyService.findAssignedIntakeTasks(0, 100);
        for (Task task : tasks) {

            // tambah policy
            // tambah offering
            // tambah studyenter
            //
            policyService.completeTask(task);
        }
        // logout kerani

        // pegawai CPS login
        List<Task> verifyTasks = policyService.findPooledIntakeTasks(0, 100);
        for (Task verifyTask : verifyTasks) {
            policyService.assignTask(verifyTask, Util.getCurrentUser());
        }

        List<Task> verifyAssignedTasks = policyService.findAssignedIntakeTasks(0, 100);
        for (Task verifyAssignedTask : verifyAssignedTasks) {
            // kemaskini sikit
            // betulkan yang salah
            policyService.completeTask(verifyAssignedTask);
        }


        Assert.notNull(intake, "projection cannot be empty"); // todo( Needs better assert)
        return self();
    }
}
    
    	
 
