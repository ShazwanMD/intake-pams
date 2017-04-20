package my.edu.umk.pams.intake.web.module.policy.controller;

import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeImpl;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeTask;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.SupervisorOffering;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private PolicyTransformer policyTransformer;

    @Autowired
    private AuthenticationManager authenticationManager;

    // ==================================================================================================== //
    //  INTAKE
    // ==================================================================================================== //

    @RequestMapping(value = "/intakes/", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findIntakes() {
        List<InIntake> intakes = policyService.findIntakes(); // todo(uda): pagination
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/current", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findCurrentIntakes() {
        List<InIntake> intakes = policyService.findIntakes(policyService.findCurrentIntakeSession());
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<Intake> findIntakeByReferenceNo(@PathVariable String referenceNo) {
        InIntake intake = (InIntake) policyService.findIntakeByReferenceNo(referenceNo);
        return new ResponseEntity<Intake>(policyTransformer.toIntakeVo(intake), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}", method = RequestMethod.PUT)
    public ResponseEntity<Intake> updateIntake(@PathVariable String referenceNo, @RequestBody Intake vo) {
        InIntake intake = (InIntake) policyService.findIntakeByReferenceNo(referenceNo);
        return new ResponseEntity<Intake>(policyTransformer.toIntakeVo(intake), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeTask>> findAssignedIntakes() {
        dummyLogin();
        List<Task> tasks = policyService.findAssignedIntakeTasks(0, 100);
        return new ResponseEntity<List<IntakeTask>>(policyTransformer.toIntakeTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<IntakeTask>> findPooledIntakes() {
        dummyLogin();
        List<Task> tasks = policyService.findPooledIntakeTasks(0, 100);
        return new ResponseEntity<List<IntakeTask>>(policyTransformer.toIntakeTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/startTask", method = RequestMethod.POST)
    public ResponseEntity<String> startIntakeTask(@RequestBody Intake vo) throws Exception {
        dummyLogin();

        InIntake intake = new InIntakeImpl();
        intake.setDescription(vo.getDescription());
        intake.setStartDate(vo.getStarDate());
        intake.setEndDate(vo.getEndDate());
        // todo(uda): more props
        return new ResponseEntity<String>(policyService.startIntakeTask(intake), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<IntakeTask> findIntakeTaskByTaskId(@PathVariable String taskId) {
        return new ResponseEntity<IntakeTask>(policyTransformer
                .toIntakeTaskVo(policyService.findIntakeTaskByTaskId(taskId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/claimTask", method = RequestMethod.POST)
    public void claimIntakeTask(@RequestBody IntakeTask vo) {
        dummyLogin();
        Task task = policyService.findIntakeTaskByTaskId(vo.getTaskId());
        workflowService.claimTask(task);
    }

    @RequestMapping(value = "/intakes/completeTask", method = RequestMethod.POST)
    public void completeIntakeTask(@RequestBody IntakeTask vo) {
        Task task = policyService.findIntakeTaskByTaskId(vo.getTaskId());
        workflowService.completeTask(task);
    }

    @RequestMapping(value = "/intake/{referenceNo}/programOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramOffering>> findProgramOfferings(@PathVariable String referenceNo) {
        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        return new ResponseEntity<List<ProgramOffering>>(policyTransformer
                .toProgramOfferingVos(policyService.findProgramOfferings(intake)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intake/{referenceNo}/supervisorOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorOffering>> findSupervisorOfferings(@PathVariable String referenceNo) {
        InIntake intake = policyService.findIntakeByReferenceNo(referenceNo);
        return new ResponseEntity<List<SupervisorOffering>>(policyTransformer
                .toSupervisorOfferingVos(policyService.findSupervisorOfferings(intake)), HttpStatus.OK);
    }

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
        InAutoLoginToken token = new InAutoLoginToken("root");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
