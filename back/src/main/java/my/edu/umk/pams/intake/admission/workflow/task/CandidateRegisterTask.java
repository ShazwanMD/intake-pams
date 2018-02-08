package my.edu.umk.pams.intake.admission.workflow.task;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.core.InFlowState;
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
import static my.edu.umk.pams.intake.IntakeConstants.CANDIDATE_ID;

@Component("candidate_register_ST")
public class CandidateRegisterTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger LOG = LoggerFactory.getLogger(CandidateRegisterTask.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private AdmissionService admissionService;

    /**
     * @param execution
     * @throws Exception
     */
    public void execute(ActivityExecution execution) throws Exception {
        LOG.debug("approving intake");

        // retrieve intake from variable
        Long candidateId = (Long) execution.getVariable(CANDIDATE_ID);
        InCandidate candidate = admissionService.findCandidateById(candidateId);

        // update flow state
        candidate.getFlowdata().setState(InFlowState.REGISTERED);
        candidate.getFlowdata().setApprovedDate(new Timestamp(currentTimeMillis()));
        candidate.getFlowdata().setApproverId(securityService.getCurrentUser().getId());
        admissionService.updateSelectedCandidate(candidate);
    }
}
