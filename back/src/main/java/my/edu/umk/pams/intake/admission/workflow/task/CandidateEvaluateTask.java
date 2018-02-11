package my.edu.umk.pams.intake.admission.workflow.task;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
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

@Component("candidate_evaluate_ST")
public class CandidateEvaluateTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CandidateEvaluateTask.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private ApplicationService applicationService;

    /**
     * @param execution
     * @throws Exception
     */
    public void execute(ActivityExecution execution) throws Exception {
        LOG.debug("evaluating candidate");

        // retrieve candidate from variable
        Long candidateId = (Long) execution.getVariable(IntakeConstants.CANDIDATE_ID);
        InCandidate candidate = admissionService.findCandidateById(candidateId);

        // update flow state
        candidate.getFlowdata().setState(EVALUATED);
        candidate.getFlowdata().setEvaluatedDate(new Timestamp(currentTimeMillis()));
        candidate.getFlowdata().setEvaluatorId(securityService.getCurrentUser().getId());
        admissionService.updateSelectedCandidate(candidate);


    }
}
