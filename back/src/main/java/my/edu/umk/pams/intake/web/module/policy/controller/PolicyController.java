package my.edu.umk.pams.intake.web.module.policy.controller;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InGraduateCentre;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.*;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.intake.web.module.common.vo.ProgramCode;
import my.edu.umk.pams.intake.web.module.common.vo.SupervisorCode;
import my.edu.umk.pams.intake.web.module.policy.vo.*;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
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
    private CommonTransformer commonTransformer;

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
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = (InIntake) policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<Intake>(policyTransformer.toIntakeVo(intake), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}", method = RequestMethod.PUT)
    public ResponseEntity<Intake> updateIntake(@PathVariable String referenceNo, @RequestBody Intake vo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = (InIntake) policyService.findIntakeByReferenceNo(decode);
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
        intake.setProjection(vo.getProjection());
        intake.setProgramLevel(policyService.findProgramLevelById(vo.getProgramLevel().getId()));
        intake.setSession(policyService.findIntakeSessionById(vo.getIntakeSession().getId()));
        intake.setGraduateCentre(commonService.findGraduateCentreById(vo.getGraduateCentre().getId()));
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

    @RequestMapping(value = "/intakes/{referenceNo}/programOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramOffering>> findProgramOfferings(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<ProgramOffering>>(policyTransformer
                .toProgramOfferingVos(policyService.findProgramOfferings(intake)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/programOfferings", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addProgramOfferings(@PathVariable String referenceNo,
                                                       @RequestBody ProgramOffering vo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        InProgramOffering offering = new InProgramOfferingImpl();
        offering.setProjection(vo.getProjection());
        offering.setInterview(vo.getInterview());
        // todo: offering.setStudyCenterCode();
        policyService.addProgramOffering(intake, offering);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/programOfferings/{id}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteProgramOfferings(@PathVariable String referenceNo,
                                                          @PathVariable Long id) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        InProgramOffering offering = policyService.findProgramOfferingById(id);
        policyService.deleteProgramOffering(intake, offering);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/supervisorOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorOffering>> findSupervisorOfferings(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<SupervisorOffering>>(policyTransformer
                .toSupervisorOfferingVos(policyService.findSupervisorOfferings(intake)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/supervisorOfferings", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addsupervisorOfferings(@PathVariable String referenceNo,
                                                          @RequestBody SupervisorOffering vo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        InSupervisorOffering offering = new InSupervisorOfferingImpl();
        policyService.addSupervisorOffering(intake, offering);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/supervisorOfferings/{id}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deletesupervisorOfferings(@PathVariable String referenceNo,
                                                             @PathVariable Long id) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        InSupervisorOffering offering = policyService.findSupervisorOfferingById(id);
        policyService.deleteSupervisorOffering(intake, offering);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/studyModeOfferings", method = RequestMethod.GET)
    public ResponseEntity<List<StudyModeOffering>> findstudyModeOfferings(@PathVariable String referenceNo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        return new ResponseEntity<List<StudyModeOffering>>(policyTransformer
                .toStudyModeOfferingVos(policyService.findStudyModeOfferings(intake)), HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/studyModeOfferings", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addstudyModeOfferings(@PathVariable String referenceNo,
                                                          @RequestBody StudyModeOffering vo) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        InStudyModeOffering offering = new InStudyModeOfferingImpl();
        policyService.addStudyModeOffering(intake, offering);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/intakes/{referenceNo}/studyModeOfferings/{id}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deletestudyModeOfferings(@PathVariable String referenceNo,
                                                             @PathVariable Long id) {
        String decode = URLDecoder.decode(referenceNo);
        InIntake intake = policyService.findIntakeByReferenceNo(decode);
        InStudyModeOffering offering = policyService.findStudyModeOfferingById(id);
        policyService.deleteStudyModeOffering(intake, offering);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    // ==================================================================================================== //
    //  GRADUATE CENTRE
    // ==================================================================================================== //

    @RequestMapping(value = "/graduateCentre/{code}/intakes", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findIntakesByGraduateCentre(@PathVariable String code) {
        InGraduateCentre graduateCentre = commonService.findGraduateCentreByCode(code);
        List<InIntake> intakes = policyService.findIntakes(graduateCentre); // todo(uda): pagination
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    @RequestMapping(value = "/graduateCentre/{code}/intakes/current", method = RequestMethod.GET)
    public ResponseEntity<List<Intake>> findCurrentIntakesByGraduateCentre(@PathVariable String code) {
        InGraduateCentre graduateCentre = commonService.findGraduateCentreByCode(code);
        InIntakeSession intakeSession = policyService.findCurrentIntakeSession();
        List<InIntake> intakes = policyService.findIntakes(intakeSession, graduateCentre); // todo(uda): pagination
        return new ResponseEntity<List<Intake>>(policyTransformer.toIntakeVos(intakes), HttpStatus.OK);
    }

    // ==================================================================================================== //
    //  PROGRAM CODES
    // ==================================================================================================== //

    @RequestMapping(value = "/faculty/{code}/programCodes", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramCode>> findProgramCodes(@PathVariable String code) {
        InFacultyCode facultyCode = commonService.findFacultyCodeByCode(code);
        return new ResponseEntity<List<ProgramCode>>(commonTransformer
                .toProgramCodeVos(commonService.findProgramCodes(facultyCode)), HttpStatus.OK);
    }

    // ==================================================================================================== //
    //  SUPERVISOR CODES
    // ==================================================================================================== //

    @RequestMapping(value = "/faculty/{code}/supervisorCodes", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorCode>> findSupervisorCodes(@PathVariable String code) {
        InFacultyCode facultyCode = commonService.findFacultyCodeByCode(code);
        return new ResponseEntity<List<SupervisorCode>>(commonTransformer
                .toSupervisorCodeVos(commonService.findSupervisorCodes(facultyCode)), HttpStatus.OK);
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
