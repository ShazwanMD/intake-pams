package my.edu.umk.pams.intake.admission.workflow.task;

import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_ID;

@Component("candidate_complete_ST")
public class CandidateCompleteTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CandidateApproveTask.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PolicyService policyService;

    /**
     * @param execution
     * @throws Exception
     */
    public void execute(ActivityExecution execution) throws Exception {
        LOG.debug("completing intake");

        // retrieve intake from variable
        Long intakeId = (Long) execution.getVariable(INTAKE_ID);
        InIntake intake = policyService.findIntakeById(intakeId);

        // update flow state
        intake.getFlowdata().setState(InFlowState.COMPLETED);
        policyService.updateIntake(intake);
    }
}