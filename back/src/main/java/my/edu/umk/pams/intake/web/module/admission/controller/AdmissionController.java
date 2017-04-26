package my.edu.umk.pams.intake.web.module.admission.controller;

import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import my.edu.umk.pams.intake.web.module.policy.controller.PolicyTransformer;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeTask;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
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
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(admissionService.findCandidates(intake)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/candidates/selected", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findSelecedCandidates(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(
                        admissionService.findCandidatesByStatus(intake, InCandidateStatus.SELECTED)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/candidates/rejected", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findRejectedCandidates(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(
                        admissionService.findCandidatesByStatus(intake, InCandidateStatus.REJECTED)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/candidates/accepted", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> findAcceptedCandidates(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<Candidate>>(
                admissionTransformer.toCandidateVos(
                        admissionService.findCandidatesByStatus(intake, InCandidateStatus.ACCEPTED)), HttpStatus.OK);
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
        InAutoLoginToken token = new InAutoLoginToken("root");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
