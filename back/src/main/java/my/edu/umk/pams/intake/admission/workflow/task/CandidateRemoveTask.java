package my.edu.umk.pams.intake.admission.workflow.task;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
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
import static my.edu.umk.pams.intake.IntakeConstants.CANDIDATE_ID;
import static org.apache.log4j.Logger.getLogger;

@Component("candidate_remove_ST")
public class CandidateRemoveTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger log = getLogger(CandidateRemoveTask.class);

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
        log.debug("removing candidate");

        // retrieve intake from variable
        Long candidateId = (Long) execution.getVariable(CANDIDATE_ID);
        InCandidate candidate = admissionService.findCandidateById(candidateId);

        // save remove comment
        String removeComment = (String) execution.getVariable(WorkflowConstants.REMOVE_COMMENT);
        candidate.setRemoveComment(removeComment);

        // update flow state
        candidate.getFlowdata().setState(InFlowState.REMOVED);
        candidate.getFlowdata().setRemovedDate(new Timestamp(currentTimeMillis()));
        candidate.getFlowdata().setRemoverId(securityService.getCurrentUser().getId());
        admissionService.updateSelectedCandidate(candidate);
    }
}
