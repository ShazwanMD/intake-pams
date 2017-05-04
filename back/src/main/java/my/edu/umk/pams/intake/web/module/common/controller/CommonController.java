package my.edu.umk.pams.intake.web.module.common.controller;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InGraduateCentre;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.web.module.common.vo.FacultyCode;
import my.edu.umk.pams.intake.web.module.common.vo.GenderCode;
import my.edu.umk.pams.intake.web.module.common.vo.GraduateCentre;
import my.edu.umk.pams.intake.web.module.common.vo.ProgramCode;
import my.edu.umk.pams.intake.web.module.common.vo.StudyMode;
import my.edu.umk.pams.intake.web.module.common.vo.SupervisorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonTransformer commonTransformer;

    //====================================================================================================
    // FACULTY CODES
    //====================================================================================================

    @RequestMapping(value = "/graduateCentres", method = RequestMethod.GET)
    public ResponseEntity<List<GraduateCentre>> findGraduateCentres() {
        return new ResponseEntity<List<GraduateCentre>>(commonTransformer.toGraduateCentreVos(
                commonService.findGraduateCentres()), HttpStatus.OK);
    }

    @RequestMapping(value = "/graduateCentres/{code}", method = RequestMethod.GET)
    public ResponseEntity<GraduateCentre> findGraduateCentreByCode(@PathVariable String code) {
        return new ResponseEntity<GraduateCentre>(commonTransformer.toGraduateCentreVo(
                commonService.findGraduateCentreByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/graduateCentres/{code}/programCodes", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramCode>> findProgramCodesByGraduateCentreCode(@PathVariable String code) {
        InGraduateCentre graduateCentre = commonService.findGraduateCentreByCode(code);
        return new ResponseEntity<List<ProgramCode>>(commonTransformer.toProgramCodeVos(
                commonService.findProgramCodes(graduateCentre)), HttpStatus.OK);
    }

    // localhost:8080/api/common/graduateCentres/MGSEB/programCodes/PHD
    @RequestMapping(value = "/graduateCentres/{code}/programCodes/{levelCode}", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramCode>> findProgramCodesByGraduateCentreCode(@PathVariable String code, @PathVariable String levelCode) {
        InGraduateCentre graduateCentre = commonService.findGraduateCentreByCode(code);
        InProgramLevel programLevel = policyService.findProgramLevelByCode(levelCode);
        return new ResponseEntity<List<ProgramCode>>(commonTransformer.toProgramCodeVos(
                commonService.findProgramCodes(graduateCentre, programLevel)), HttpStatus.OK);
    }

    //====================================================================================================
    // FACULTY CODES
    //====================================================================================================

    @RequestMapping(value = "/facultyCodes", method = RequestMethod.GET)
    public ResponseEntity<List<FacultyCode>> findFacultyCodes() {
        return new ResponseEntity<List<FacultyCode>>(commonTransformer.toFacultyCodeVos(
                commonService.findFacultyCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<FacultyCode> findFacultyCode(@PathVariable String code) {
        return new ResponseEntity<FacultyCode>(commonTransformer.toFacultyCodeVo(
                commonService.findFacultyCodeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCodes/{code}/programCodes", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramCode>> findProgramCodesByFacultyCode(@PathVariable String code) {
        InFacultyCode facultyCode = commonService.findFacultyCodeByCode(code);
        return new ResponseEntity<List<ProgramCode>>(commonTransformer.toProgramCodeVos(
                commonService.findProgramCodes(facultyCode)), HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCodes/{code}/programCodes/{levelCode}", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramCode>> findProgramCodesByFacultyCode(@PathVariable String code,@PathVariable String levelCode) {
        InFacultyCode facultyCode = commonService.findFacultyCodeByCode(code);
        InProgramLevel programLevel = policyService.findProgramLevelByCode(levelCode);
        return new ResponseEntity<List<ProgramCode>>(commonTransformer.toProgramCodeVos(
                commonService.findProgramCodes(facultyCode,programLevel)), HttpStatus.OK);
    }

    //====================================================================================================
    // PROGRAM CODES
    //====================================================================================================

    @RequestMapping(value = "/programCodes", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramCode>> findProgramCodes() {
        return new ResponseEntity<List<ProgramCode>>(commonTransformer.toProgramCodeVos(commonService.findProgramCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/programCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<ProgramCode> findProgramCode(@PathVariable String code) {
        return new ResponseEntity<ProgramCode>(commonTransformer.toProgramCodeVo(commonService.findProgramCodeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorCode>> findSupervisorCodes() {
        return new ResponseEntity<List<SupervisorCode>>(commonTransformer.toSupervisorCodeVos(commonService.findSupervisorCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<SupervisorCode> findSupervisorCode(@PathVariable String code) {
        return new ResponseEntity<SupervisorCode>(commonTransformer.toSupervisorCodeVo(commonService.findSupervisorCodeByCode(code)), HttpStatus.OK);
    }
    
  //====================================================================================================
    // STUDY MODES
    //====================================================================================================

    @RequestMapping(value = "/studyMode", method = RequestMethod.GET)
    public ResponseEntity<List<StudyMode>> findStudyMode() {
        return new ResponseEntity<List<StudyMode>>(commonTransformer.toStudyModeVos(commonService.findStudyModes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/studyMode/{code}", method = RequestMethod.GET)
    public ResponseEntity<StudyMode> findStudyMode(@PathVariable String code) {
        return new ResponseEntity<StudyMode>(commonTransformer.toStudyModeVo(commonService.findStudyModeByCode(code)), HttpStatus.OK);
    }

}
