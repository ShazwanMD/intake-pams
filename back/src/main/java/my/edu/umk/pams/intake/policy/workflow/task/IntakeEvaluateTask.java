package my.edu.umk.pams.intake.policy.workflow.task;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.intake.core.InFlowState.EVALUATED;

@Component("intake_evaluate_ST")
public class IntakeEvaluateTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(IntakeEvaluateTask.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ApplicationService applicationService;

    /**
     * @param execution
     * @throws Exception
     */
    public void execute(ActivityExecution execution) throws Exception {
        LOG.debug("evaluating intake");

        // retrieve intake from variable
        Long intakeId = (Long) execution.getVariable(IntakeConstants.INTAKE_ID);
        InIntake intake = policyService.findIntakeById(intakeId);

        // update flow state
        intake.getFlowdata().setState(EVALUATED);
        intake.getFlowdata().setEvaluatedDate(new Timestamp(currentTimeMillis()));
        intake.getFlowdata().setEvaluatorId(securityService.getCurrentUser().getId());
        policyService.updateIntake(intake);

        // calcualate merit
        applicationService.calculateApplicantMerit(intake);
    }
}
