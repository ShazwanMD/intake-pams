package my.edu.umk.pams.intake.policy.workflow.task;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
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
import java.util.List;
import java.util.UUID;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.intake.core.InFlowState.SELECTED;

@Component("intake_select_ST")
public class IntakeSelectTask extends BpmnActivityBehavior implements ActivityBehavior {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(IntakeSelectTask.class);

	@Autowired
	private SecurityService securityService;

	@Autowired
	private PolicyService policyService;

	@Autowired
	private AdmissionService admissionService;

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private InCandidateDao candidateDao;

	/**
	 * @param execution
	 * @throws Exception
	 */
	public void execute(ActivityExecution execution) throws Exception {
		LOG.debug("selecting intake");

		// retrieve intake from variable
		Long intakeId = (Long) execution.getVariable(IntakeConstants.INTAKE_ID);
		InIntake intake = policyService.findIntakeById(intakeId);

		// update flow state
		intake.getFlowdata().setState(SELECTED);
		intake.getFlowdata().setSelectedDate(new Timestamp(currentTimeMillis()));
		intake.getFlowdata().setSelectorId(securityService.getCurrentUser().getId());

		if (intake.getGraduateCenter().getCode().equals("MGSEB")) {
			policyService.updateIntake(intake);
			admissionService.processIntakeSelection(intake);
		}

	}
}
