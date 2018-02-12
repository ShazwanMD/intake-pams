package my.edu.umk.pams.intake.admission.workflow.task;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
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
import static my.edu.umk.pams.intake.core.InFlowState.DRAFTED;

@Component("candidate_draft_ST")
public class CandidateDraftTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger LOG = LoggerFactory.getLogger(CandidateApproveTask.class);

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
        LOG.debug("drafting candidate");

        // retrieve intake from variable
        Long candidateId = (Long) execution.getVariable(CANDIDATE_ID);
        LOG.debug("Candidate Draft Task:{}", CANDIDATE_ID);
        InCandidate candidate = admissionService.findCandidateById(candidateId);
        LOG.debug("Candidate Draft Task:{}", candidate.getName());
        // update flow state
        candidate.getFlowdata().setState(DRAFTED);
        candidate.getFlowdata().setRegisteredDate(new Timestamp(currentTimeMillis()));
        candidate.getFlowdata().setRegistererId(securityService.getCurrentUser().getId());
        admissionService.updateSelectedCandidate(candidate);
        LOG.debug("After Service Draft Task:{}", candidate.getName());
    }
}
