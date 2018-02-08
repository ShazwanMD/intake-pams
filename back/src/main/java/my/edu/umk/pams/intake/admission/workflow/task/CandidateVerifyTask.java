package my.edu.umk.pams.intake.admission.workflow.task;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
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
import static my.edu.umk.pams.intake.core.InFlowState.VERIFIED;

@Component("candidate_verify_ST")
public class CandidateVerifyTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CandidateApproveTask.class);

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
        LOG.debug("verifying intake");

        // retrieve intake from variable
        Long candidateId = (Long) execution.getVariable(IntakeConstants.CANDIDATE_ID);
        InCandidate candidate = admissionService.findCandidateById(candidateId);

        // update flow state
        candidate.getFlowdata().setState(VERIFIED);
        candidate.getFlowdata().setVerifiedDate(new Timestamp(currentTimeMillis()));
        candidate.getFlowdata().setVerifierId(securityService.getCurrentUser().getId());
        admissionService.updateSelectedCandidate(candidate);
    }
}
