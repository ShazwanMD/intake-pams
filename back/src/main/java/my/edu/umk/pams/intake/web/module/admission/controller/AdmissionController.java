package my.edu.umk.pams.intake.web.module.admission.controller;

import static java.util.stream.Collectors.toCollection;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import my.edu.umk.pams.intake.web.module.admission.vo.CandidateTask;
import my.edu.umk.pams.intake.web.module.application.controller.ApplicationTransformer;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeTask;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;

@RestController
@RequestMapping("/api/admission")
public class AdmissionController {

	private static final Logger LOG = LoggerFactory.getLogger(AdmissionController.class);
	
	@Autowired
	private AdmissionService admissionService;

	@Autowired
	private PolicyService policyService;

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
    private WorkflowService workflowService;

	@Autowired
	private AdmissionTransformer admissionTransformer;

	@Autowired
	private PolicyTransformer policyTransformer;
	
	@Autowired
	private ApplicationTransformer applicationTransformer;

	@Autowired
	private AuthenticationManager authenticationManager;

	// ====================================================================================================
	// INTAKES
	// ====================================================================================================

	@RequestMapping(value = "/intakes/assignedTasks", method = RequestMethod.GET)
	public ResponseEntity<List<IntakeTask>> findAssignedIntakes() {
		List<Task> tasks = policyService.findAssignedIntakeTasks(0, 100);
		return new ResponseEntity<List<IntakeTask>>(decorateIntakeTasks(policyTransformer.toIntakeTaskVos(tasks)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/intakes/pooledTasks", method = RequestMethod.GET)
	public ResponseEntity<List<IntakeTask>> findPooledIntakes() {
		List<Task> tasks = policyService.findPooledIntakeTasks(0, 100);
		return new ResponseEntity<List<IntakeTask>>(decorateIntakeTasks(policyTransformer.toIntakeTaskVos(tasks)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/intakes/viewTask/{taskId}", method = RequestMethod.GET)
	public ResponseEntity<IntakeTask> findIntakeTaskByTaskId(@PathVariable String taskId) {
		return new ResponseEntity<IntakeTask>(
				decorateIntakeTask(policyTransformer.toIntakeTaskVo(policyService.findIntakeTaskByTaskId(taskId))),
				HttpStatus.OK);
	}

	// ====================================================================================================
	// CANDIDATES WORKFLOWS
	// ====================================================================================================

	@RequestMapping(value = "/candidates/assignedCandidateTasks", method = RequestMethod.GET)
	public ResponseEntity<List<CandidateTask>> findAssignedCandidateTasks() {
		
		List<Task> tasks = admissionService.findAssignedCandidateTasks(0, 100);
		LOG.debug("Task id baca : {}", tasks);
		return new ResponseEntity<List<CandidateTask>>(admissionTransformer.toCandidateTaskVos(tasks), HttpStatus.OK);
	}

	@RequestMapping(value = "/candidates/pooledCandidateTasks", method = RequestMethod.GET)
	public ResponseEntity<List<CandidateTask>> findPooledCandidateTasks() {

		List<Task> tasks = admissionService.findPooledCandidateTasks(0, 100);
		return new ResponseEntity<List<CandidateTask>>(admissionTransformer.toCandidateTaskVos(tasks), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/candidates/archived", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findArchivedCandidates() {
        List<InCandidate> tasks = admissionService.findCandidatesByFlowStates(InFlowState.CANCELLED, InFlowState.REMOVED, InFlowState.COMPLETED);
        return new ResponseEntity<List<Candidate>>(admissionTransformer.toCandidateVos(tasks), HttpStatus.OK);
    }
	
    @RequestMapping(value = "/candidates/completeTask", method = RequestMethod.POST)
    public void completeCandidateTask(@RequestBody CandidateTask vo) {
        Task task = admissionService.findCandidateTaskByTaskId(vo.getTaskId());
        workflowService.completeTask(task);
    }
    
    @RequestMapping(value = "/candidates/claimTask", method = RequestMethod.POST)
    public ResponseEntity<String> claimCandidateTask(@RequestBody CandidateTask vo) {
    	
        Task task = admissionService.findCandidateTaskByTaskId(vo.getTaskId());
        workflowService.claimTask(task);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/candidates/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<CandidateTask> findCandidateTaskByTaskId(@PathVariable String taskId) {
        return new ResponseEntity<CandidateTask>(admissionTransformer
                .toCandidateTaskVo(admissionService.findCandidateTaskByTaskId(taskId)), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/candidates/{id}", method = RequestMethod.GET)
    public ResponseEntity<Candidate> findCandidateById(@PathVariable Long id) {
    	InCandidate candidate = admissionService.findCandidateById(id);
    	LOG.debug("Candidate id baca : {}", candidate.getName());
        return new ResponseEntity<Candidate>(admissionTransformer.toCandidateVo(candidate), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/candidates/application/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<Candidate> findCandidateByReferenceNo(@PathVariable String referenceNo) {
    	InCandidate candidate = admissionService.findCandidateByReferenceNo(referenceNo);
    	LOG.debug("Candidate id baca : {}", candidate.getName());
        return new ResponseEntity<Candidate>(admissionTransformer.toCandidateVo(candidate), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/candidates/intakeApplication/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<Candidate> findCandidateByIntakeApplicationReferenceNo(@PathVariable String referenceNo) {
    	InCandidate candidate = admissionService.findCandidateByIntakeApplicationReferenceNo(referenceNo);
    	LOG.debug("Candidate id baca : {}", candidate.getName());
        return new ResponseEntity<Candidate>(admissionTransformer.toCandidateVo(candidate), HttpStatus.OK);
    }
	
	// ====================================================================================================
	// CANDIDATES
	// ====================================================================================================

	@RequestMapping(value = "/intakes/{referenceNo}/candidates", method = RequestMethod.GET)
	public ResponseEntity<List<Candidate>> findCandidates(@PathVariable String referenceNo) {
		InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
		System.out.println("intake " + intake.getReferenceNo());
		return new ResponseEntity<List<Candidate>>(
				admissionTransformer.toCandidateVos(admissionService.findCandidates(intake)), HttpStatus.OK);
	}

	@RequestMapping(value = "/intakes/{referenceNo}/candidates/candidateStatus/{candidateStatus}", method = RequestMethod.GET)
	public ResponseEntity<List<Candidate>> findSelecedCandidates(@PathVariable String referenceNo,
			@PathVariable String candidateStatus) {
		InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
		return new ResponseEntity<List<Candidate>>(
				admissionTransformer.toCandidateVos(
						admissionService.findCandidatesByStatus(intake, InCandidateStatus.valueOf(candidateStatus))),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/intakes/{referenceNo}/candidates/candidateStatus/{candidateStatus}/accepted", method = RequestMethod.GET)
	public ResponseEntity<List<Candidate>> findOfferAcceptCandidates(@PathVariable String referenceNo,
			@PathVariable String candidateStatus) {
		InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
		return new ResponseEntity<List<Candidate>>(admissionTransformer.toCandidateVos(
				admissionService.findCandidatesAcceptOffered(intake, InCandidateStatus.valueOf(candidateStatus))),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/intakes/{referenceNo}/candidates/offer", method = RequestMethod.PUT)
	public ResponseEntity<String> offerCandidates(@PathVariable String referenceNo) {
		InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
		List<InCandidate> candidates = admissionService.findCandidatesByStatus(intake, InCandidateStatus.APPROVED);
		for (InCandidate candidate : candidates) {
			admissionService.offerCandidate(candidate);
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/preSelect", method = RequestMethod.PUT)
	public ResponseEntity<String> preSelectCandidate(@PathVariable String referenceNo, @RequestBody Candidate vo) {
		InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
		admissionService.preSelectCandidate(candidate);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/select", method = RequestMethod.PUT)
	public ResponseEntity<String> selectCandidate(@PathVariable String referenceNo, @RequestBody Candidate vo) {
		InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
		admissionService.selectCandidate(candidate);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/offer", method = RequestMethod.PUT)
	public ResponseEntity<String> offerCandidate(@PathVariable String referenceNo, @RequestBody Candidate vo) {
		InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
		admissionService.selectCandidate(candidate);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/register", method = RequestMethod.PUT)
	public ResponseEntity<String> registerCandidate(@PathVariable String referenceNo, @RequestBody Candidate vo) {
		InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
		admissionService.registerCandidate(candidate);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/reject", method = RequestMethod.PUT)
	public ResponseEntity<String> rejectCandidate(@PathVariable String referenceNo, @RequestBody Candidate vo) {
		InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
		InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
		System.out.println("reason : " + vo.getReason());
		candidate.setReason(vo.getReason());
		admissionService.rejectCandidate(candidate);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// PRIVATE METHODS
	// ====================================================================================================

	private IntakeTask decorateIntakeTask(IntakeTask intakeTask) {
		InIntake intake = policyService.findIntakeById(intakeTask.getIntake().getId());
		intakeTask.setCandidateCount(admissionService.countCandidate(intake));
		return intakeTask;
	}

	public List<IntakeTask> decorateIntakeTasks(List<IntakeTask> tasks) {
		return tasks.stream().map((task) -> decorateIntakeTask(task))
				.collect(toCollection(() -> new ArrayList<IntakeTask>()));
	}
	
	private CandidateTask decorateCandidateTask(CandidateTask candidateTask) {
		InCandidate candidate = admissionService.findCandidateById(candidateTask.getId());
		return candidateTask;
	}

	public List<CandidateTask> decorateCandidateTasks(List<CandidateTask> tasks) {
		return tasks.stream().map((task) -> decorateCandidateTask(task))
				.collect(toCollection(() -> new ArrayList<CandidateTask>()));
	}
}
