package my.edu.umk.pams.intake.policy.workflow.task;

import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_ID;
import static my.edu.umk.pams.intake.core.InFlowState.DRAFTED;

@Component("intake_draft_ST")
public class IntakeDraftTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeApproveTask.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PolicyService policyService;

    /**
     * @param execution
     * @throws Exception
     */
    public void execute(ActivityExecution execution) throws Exception {
        LOG.debug("drafting intake");

        // retrieve intake from variable
        Long intakeId = (Long) execution.getVariable(INTAKE_ID);
        InIntake intake = policyService.findIntakeById(intakeId);

        // update flow state
        intake.getFlowdata().setState(DRAFTED);
        intake.getFlowdata().setRegisteredDate(new Timestamp(currentTimeMillis()));
        intake.getFlowdata().setRegistererId(securityService.getCurrentUser().getId());
        policyService.updateIntake(intake);
        LOG.debug("INTAKE_ID:{}",INTAKE_ID);
    }
}
