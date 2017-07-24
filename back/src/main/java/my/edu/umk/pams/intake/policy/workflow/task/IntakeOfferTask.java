package my.edu.umk.pams.intake.policy.workflow.task;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
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
import java.util.List;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_ID;

@Component("intake_offer_ST")
public class IntakeOfferTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger LOG = LoggerFactory.getLogger(IntakeOfferTask.class);

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
        Long intakeId = (Long) execution.getVariable(INTAKE_ID);
        InIntake intake = policyService.findIntakeById(intakeId);

        // update flow state
        intake.getFlowdata().setState(InFlowState.OFFERED);
        intake.getFlowdata().setApprovedDate(new Timestamp(currentTimeMillis()));
        intake.getFlowdata().setApproverId(securityService.getCurrentUser().getId());
        policyService.updateIntake(intake);
        
        //offer candidates
        List<InCandidate> candidate = admissionService.findCandidatesByStatus(intake, InCandidateStatus.APPROVED);
        for (InCandidate inCandidate : candidate) {
        	 admissionService.offerCandidate(inCandidate);
		}
    }
}
