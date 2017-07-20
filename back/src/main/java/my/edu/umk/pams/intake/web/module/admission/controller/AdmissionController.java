package my.edu.umk.pams.intake.web.module.admission.controller;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeTask;
import org.activiti.engine.task.Task;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

@RestController
@RequestMapping("/api/admission")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private AdmissionTransformer admissionTransformer;

    @Autowired
    private PolicyTransformer policyTransformer;

    @Autowired
    private AuthenticationManager authenticationManager;

    // ====================================================================================================
    // INTAKES
    // ====================================================================================================

    @RequestMapping(value = "/intakes/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeTask>> findAssignedIntakes() {
        dummyLogin();
        List<Task> tasks = policyService.findAssignedIntakeTasks(0, 100);
        return new ResponseEntity<List<IntakeTask>>(
                decorateIntakeTasks(policyTransformer.toIntakeTaskVos(tasks)), HttpStatus.OK);
    }


    @RequestMapping(value = "/intakes/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeTask>> findPooledIntakes() {
        dummyLogin();
        List<Task> tasks = policyService.findPooledIntakeTasks(0, 100);
        return new ResponseEntity<List<IntakeTask>>(
                decorateIntakeTasks(policyTransformer.toIntakeTaskVos(tasks)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<IntakeTask> findIntakeTaskByTaskId(@PathVariable String taskId) {
        return new ResponseEntity<IntakeTask>(
                decorateIntakeTask(policyTransformer.toIntakeTaskVo(policyService.findIntakeTaskByTaskId(taskId))), HttpStatus.OK);
    }

    // ====================================================================================================
    // CANDIDATES
    // ====================================================================================================

    @RequestMapping(value = "/intakes/{referenceNo}/candidates", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findCandidates(@PathVariable String referenceNo) {
        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        System.out.println("intake "+intake.getReferenceNo());
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(admissionService.findCandidates(intake)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/candidates/candidateStatus/{candidateStatus}", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findSelecedCandidates(@PathVariable String referenceNo, @PathVariable String candidateStatus) {
        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(
                        admissionService.findCandidatesByStatus(intake, InCandidateStatus.valueOf(candidateStatus))), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/preSelect", method = RequestMethod.PUT)
    public ResponseEntity<String> preSelectCandidate(@PathVariable String referenceNo,
                                                          @RequestBody Candidate vo) {
    	InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
        admissionService.preSelectCandidate(candidate);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/select", method = RequestMethod.PUT)
    public ResponseEntity<String> selectCandidate(@PathVariable String referenceNo,
                                                          @RequestBody Candidate vo) {
    	InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
        admissionService.selectCandidate(candidate);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/application/{referenceNo}/candidates/candidateStatus/reject", method = RequestMethod.PUT)
    public ResponseEntity<String> rejectCandidate(@PathVariable String referenceNo,
                                                          @RequestBody Candidate vo) {
    	InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo(referenceNo);
        InCandidate candidate = admissionService.findCandidateByIntakeApplication(intakeApplication);
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
        return tasks.stream()
                .map((task) -> decorateIntakeTask(task))
                .collect(toCollection(() -> new ArrayList<IntakeTask>()));
    }

    private void dummyLogin() {
//        Noop
//        InAutoLoginToken token = new InAutoLoginToken("root");
//        Authentication authed = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
