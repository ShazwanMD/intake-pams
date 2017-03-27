package my.edu.umk.pams.intake.policy.workflow.task;

import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.workflow.service.WorkflowConstants;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_ID;
import static org.apache.log4j.Logger.getLogger;

@Component("intake_remove_ST")
public class IntakeRemoveTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger log = getLogger(IntakeRemoveTask.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PolicyService policyService;

    /**
     * @param execution
     * @throws Exception
     */
    public void execute(ActivityExecution execution) throws Exception {
        log.debug("removing intake");

        // retrieve intake from variable
        Long intakeId = (Long) execution.getVariable(INTAKE_ID);
        InIntake intake = policyService.findIntakeById(intakeId);

        // save remove comment
        String removeComment = (String) execution.getVariable(WorkflowConstants.REMOVE_COMMENT);
        intake.setRemoveComment(removeComment);

        // update flow state
        intake.getFlowdata().setState(InFlowState.REMOVED);
        intake.getFlowdata().setRemovedDate(new Timestamp(currentTimeMillis()));
        intake.getFlowdata().setRemoverId(securityService.getCurrentUser().getId());
        policyService.updateIntake(intake);
    }
}
