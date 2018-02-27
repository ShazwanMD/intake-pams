package my.edu.umk.pams.intake.admission.workflow.task;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.intake.core.InFlowState.PUBLISHED;

import java.sql.Timestamp;

import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;

@Component("candidate_publish_ST")
public class CandidatePublishTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CandidatePublishTask.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private AdmissionService admissionService;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    /**
     * @param execution
     * @throws Exception
     */
    public void execute(ActivityExecution execution) throws Exception {
        LOG.debug("publishing candidate");

        // retrieve intake from variable      
        Long candidateId = (Long) execution.getVariable(IntakeConstants.CANDIDATE_ID);
        InCandidate candidate = admissionService.findCandidateById(candidateId);

        // update flow state
        candidate.getFlowdata().setState(PUBLISHED);
        candidate.getFlowdata().setPublishedDate(new Timestamp(currentTimeMillis()));
        candidate.getFlowdata().setPublisherId(securityService.getCurrentUser().getId());
        admissionService.updateSelectedCandidate(candidate);
                
    }
}
