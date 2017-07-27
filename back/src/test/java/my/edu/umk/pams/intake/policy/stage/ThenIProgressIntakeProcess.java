package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.util.Util;

import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenIProgressIntakeProcess extends Stage<ThenIProgressIntakeProcess> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenIProgressIntakeProcess.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private SecurityService securityService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ExpectedScenarioState
    private InIntake intake;

    public ThenIProgressIntakeProcess i_can_progress_the_intake_process() {
        InIntake intake = policyService.findIntakeByReferenceNo(INTAKE_REFERENCE_NO_MGSSEB);
        intake.getProjection();
        intake.getStartDate();
        intake.getEndDate();
        String referenceNo = policyService.startIntakeTask(intake);

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
            policyService.assignTask(verifyTask, securityService.getCurrentUser());
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
    
    	
 
