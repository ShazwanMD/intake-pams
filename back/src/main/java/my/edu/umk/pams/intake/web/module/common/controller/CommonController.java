package my.edu.umk.pams.intake.web.module.common.controller;

import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InAutoLoginToken;
import my.edu.umk.pams.intake.web.module.common.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private AuthenticationManager authenticationManager;

    //====================================================================================================
    // BANK CODES
    //====================================================================================================

    @RequestMapping(value = "/bankCodes", method = RequestMethod.GET)
    public ResponseEntity<List<BankCode>> findBankCodes() {
        return new ResponseEntity<List<BankCode>>(commonTransformer.toBankCodeVos(
                commonService.findBankCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/bankCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<BankCode> findBankCode(@PathVariable String code) {
        return new ResponseEntity<BankCode>(commonTransformer.toBankCodeVo(
                commonService.findBankCodeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/bankCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveBankCode(@RequestBody BankCode vo) {
        dummyLogin();

        InBankCode bankCode = new InBankCodeImpl();
        bankCode.setCode(vo.getCode());
        bankCode.setName(vo.getName());
        bankCode.setIbgCode("TODO");
        bankCode.setSwiftCode("TODO");
        commonService.saveBankCode(bankCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/bankCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBankCode(@PathVariable String code, @RequestBody BankCode vo) {
        dummyLogin();

        InBankCode bankCode = commonService.findBankCodeById(vo.getId());
        bankCode.setCode(vo.getCode());
        bankCode.setName(vo.getName());
        bankCode.setIbgCode("TODO");
        bankCode.setSwiftCode("TODO");
        commonService.updateBankCode(bankCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/bankCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeBankCode(@PathVariable String code) {
        dummyLogin();

        InBankCode bankCode = commonService.findBankCodeByCode(code);
        commonService.removeBankCode(bankCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //====================================================================================================
    // DUN_CODE
    //====================================================================================================

    @RequestMapping(value = "/dunCodes", method = RequestMethod.GET)
    public ResponseEntity<List<DunCode>> findDunCodes() {
        return new ResponseEntity<List<DunCode>>(commonTransformer.toDunCodeVos(
                commonService.findDunCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/dunCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<DunCode> findDunCodeByCode(@PathVariable String code) {
        return new ResponseEntity<DunCode>(commonTransformer.toDunCodeVo(
                commonService.findDunCodeByCode(code)), HttpStatus.OK);
    }

    //====================================================================================================
    // DISTRICT_CODE
    //====================================================================================================

    @RequestMapping(value = "/districtCodes", method = RequestMethod.GET)
    public ResponseEntity<List<DistrictCode>> findDistrictCodes() {
        return new ResponseEntity<List<DistrictCode>>(commonTransformer.toDistrictCodeVos(
                commonService.findDistrictCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/districtCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<DistrictCode> findDistrictCodeByCode(@PathVariable String code) {
        return new ResponseEntity<DistrictCode>(commonTransformer.toDistrictCodeVo(
                commonService.findDistrictCodeByCode(code)), HttpStatus.OK);
    }
    
    //====================================================================================================
    // GRADUATE CENTRE
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

    @RequestMapping(value = "/graduateCentres", method = RequestMethod.POST)
    public ResponseEntity<String> saveGraduateCentre(@RequestBody GraduateCentre vo) {
        dummyLogin();

        InGraduateCentre graduateCentre = new InGraduateCentreImpl();
        graduateCentre.setCode(vo.getCode());
        graduateCentre.setDescriptionEn(vo.getDescriptionEn());
        graduateCentre.setDescriptionMs(vo.getDescriptionMs());
        commonService.saveGraduateCentre(graduateCentre);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/graduateCentres/{centre}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateGraduateCentre(@PathVariable String centre, @RequestBody GraduateCentre vo) {
        dummyLogin();

        InGraduateCentre graduateCentre = commonService.findGraduateCentreById(vo.getId());
        graduateCentre.setCode(vo.getCode());
        graduateCentre.setDescriptionEn(vo.getDescriptionEn());
        graduateCentre.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateGraduateCentre(graduateCentre);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/graduateCentres/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeGraduateCentre(@PathVariable String code) {
        dummyLogin();

        InGraduateCentre graduateCentre = commonService.findGraduateCentreByCode(code);
        commonService.removeGraduateCentre(graduateCentre);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
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
    public ResponseEntity<List<ProgramCode>> findProgramCodesByFacultyCode(@PathVariable String code, @PathVariable String levelCode) {
        InFacultyCode facultyCode = commonService.findFacultyCodeByCode(code);
        InProgramLevel programLevel = policyService.findProgramLevelByCode(levelCode);
        return new ResponseEntity<List<ProgramCode>>(commonTransformer.toProgramCodeVos(
                commonService.findProgramCodes(facultyCode, programLevel)), HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveFacultyCode(@RequestBody FacultyCode vo) {
        dummyLogin();

        InFacultyCode facultyCode = new InFacultyCodeImpl();
        facultyCode.setCode(vo.getCode());
        facultyCode.setDescription(vo.getDescription());
        commonService.saveFacultyCode(facultyCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateFacultyCode(@PathVariable String code, @RequestBody FacultyCode vo) {
        dummyLogin();

        InFacultyCode facultyCode = commonService.findFacultyCodeById(vo.getId());
        facultyCode.setCode(vo.getCode());
        facultyCode.setDescription(vo.getDescription());
        commonService.updateFacultyCode(facultyCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/facultyCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeFacultyCode(@PathVariable String code) {
        dummyLogin();

        InFacultyCode facultyCode = commonService.findFacultyCodeByCode(code);
        commonService.removeFacultyCode(facultyCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
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

    @RequestMapping(value = "/programCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveProgramCode(@RequestBody ProgramCode vo) {
        dummyLogin();


        InProgramCode programCode = new InProgramCodeImpl();
        programCode.setCode(vo.getCode());
        programCode.setDescriptionEn(vo.getDescriptionEn());
        programCode.setDescriptionMs(vo.getDescriptionMs());
        programCode.setFacultyCode(commonService.findFacultyCodeById(vo.getFacultyCode().getId()));
        programCode.setGraduateCentre(commonService.findGraduateCentreById(vo.getGraduateCentre().getId()));
        programCode.setProgramLevel(policyService.findProgramLevelById(vo.getProgramLevel().getId()));
        commonService.saveProgramCode(programCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/programCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProgramCode(@PathVariable String code, @RequestBody ProgramCode vo) {
        dummyLogin();

        InProgramCode programCode = commonService.findProgramCodeById(vo.getId());
        programCode.setCode(vo.getCode());
        programCode.setDescriptionEn(vo.getDescriptionEn());
        programCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateProgramCode(programCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/programCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeProgramCode(@PathVariable String code) {
        dummyLogin();

        InProgramCode programCode = commonService.findProgramCodeByCode(code);
        commonService.removeProgramCode(programCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    //====================================================================================================
    // RESIDENCY_CODE
    //====================================================================================================

    @RequestMapping(value = "/residencyCodes", method = RequestMethod.GET)
    public ResponseEntity<List<ResidencyCode>> findResidencyCodes() {
        return new ResponseEntity<List<ResidencyCode>>(commonTransformer.toResidencyCodeVos(
                commonService.findResidencyCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/residencyCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<ResidencyCode> findResidencyCodeByCode(@PathVariable String code) {
        return new ResponseEntity<ResidencyCode>(commonTransformer.toResidencyCodeVo(
                commonService.findResidencyCodeByCode(code)), HttpStatus.OK);
    }

    //====================================================================================================
    // SUPERVISOR CODES
    //====================================================================================================

    @RequestMapping(value = "/supervisorCodes", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorCode>> findSupervisorCodes() {
        return new ResponseEntity<List<SupervisorCode>>(commonTransformer.toSupervisorCodeVos(commonService.findSupervisorCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes/byFilter/{filter}", method = RequestMethod.GET)
    public ResponseEntity<List<SupervisorCode>> findSupervisorCodes(@PathVariable String filter) {
        List<InSupervisorCode> supervisorCodes = commonService.findSupervisorCodes(filter, 0, Integer.MAX_VALUE);
        return new ResponseEntity<List<SupervisorCode>>(
                commonTransformer.toSupervisorCodeVos(supervisorCodes), HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<SupervisorCode> findSupervisorCode(@PathVariable String code) {
        return new ResponseEntity<SupervisorCode>(commonTransformer.toSupervisorCodeVo(commonService.findSupervisorCodeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveSupervisorCode(@RequestBody SupervisorCode vo) {
        dummyLogin();

        InSupervisorCode supervisorCode = new InSupervisorCodeImpl();
        supervisorCode.setCode(vo.getCode());
        supervisorCode.setName(vo.getName());
        supervisorCode.setDescriptionEn(vo.getDescriptionEn());
        supervisorCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.saveSupervisorCode(supervisorCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSupervisorCode(@PathVariable String code, @RequestBody SupervisorCode vo) {
        dummyLogin();

        InSupervisorCode supervisorCode = commonService.findSupervisorCodeById(vo.getId());
        supervisorCode.setCode(vo.getCode());
        supervisorCode.setDescriptionEn(vo.getDescriptionEn());
        supervisorCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateSupervisorCode(supervisorCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/supervisorCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeSupervisorCode(@PathVariable String code) {
        dummyLogin();

        InSupervisorCode supervisorCode = commonService.findSupervisorCodeByCode(code);
        commonService.removeSupervisorCode(supervisorCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //====================================================================================================
    // STUDY MODES
    //====================================================================================================

    @RequestMapping(value = "/studyModes", method = RequestMethod.GET)
    public ResponseEntity<List<StudyMode>> findStudyModes() {
        return new ResponseEntity<List<StudyMode>>(commonTransformer.toStudyModeVos(commonService.findStudyModes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/studyModes/{code}", method = RequestMethod.GET)
    public ResponseEntity<StudyMode> findStudyMode(@PathVariable String code) {
        return new ResponseEntity<StudyMode>(commonTransformer.toStudyModeVo(commonService.findStudyModeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/studyModes", method = RequestMethod.POST)
    public ResponseEntity<String> saveStudyMode(@RequestBody StudyMode vo) {
        dummyLogin();

        InStudyMode studyMode = new InStudyModeImpl();
        studyMode.setCode(vo.getCode());
        studyMode.setDescriptionEn(vo.getDescriptionEn());
        studyMode.setDescriptionMs(vo.getDescriptionMs());
        commonService.saveStudyMode(studyMode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/studyModes/{mode}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateStudyMode(@PathVariable String mode, @RequestBody StudyMode vo) {
        dummyLogin();

        InStudyMode studyMode = commonService.findStudyModeById(vo.getId());
        studyMode.setCode(vo.getCode());
        studyMode.setDescriptionEn(vo.getDescriptionEn());
        studyMode.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateStudyMode(studyMode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/studyModes/{mode}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeStudyMode(@PathVariable String mode) {
        dummyLogin();

        InStudyMode studyMode = commonService.findStudyModeByCode(mode);
        commonService.removeStudyMode(studyMode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //====================================================================================================
    // GENDER CODES
    //====================================================================================================

    @RequestMapping(value = "/genderCodes", method = RequestMethod.GET)
    public ResponseEntity<List<GenderCode>> findGenderCodes() {
        return new ResponseEntity<List<GenderCode>>(commonTransformer.toGenderCodeVos(commonService.findGenderCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/genderCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<GenderCode> findGenderCode(@PathVariable String code) {
        return new ResponseEntity<GenderCode>(commonTransformer.toGenderCodeVo(commonService.findGenderCodeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/genderCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveGenderCode(@RequestBody GenderCode vo) {
        dummyLogin();

        InGenderCode genderCode = new InGenderCodeImpl();
        genderCode.setCode(vo.getCode());
        genderCode.setDescriptionEn(vo.getDescriptionEn());
        genderCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.saveGenderCode(genderCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/genderCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateGenderCode(@PathVariable String code, @RequestBody GenderCode vo) {
        dummyLogin();

        InGenderCode genderCode = commonService.findGenderCodeById(vo.getId());
        genderCode.setCode(vo.getCode());
        genderCode.setDescriptionEn(vo.getDescriptionEn());
        genderCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateGenderCode(genderCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/genderCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeGenderCode(@PathVariable String code) {
        dummyLogin();

        InGenderCode genderCode = commonService.findGenderCodeByCode(code);
        commonService.removeGenderCode(genderCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //====================================================================================================
    // MARITAL_CODE
    //====================================================================================================

    @RequestMapping(value = "/maritalCodes", method = RequestMethod.GET)
    public ResponseEntity<List<MaritalCode>> findMaritalCodes() {
        return new ResponseEntity<List<MaritalCode>>(commonTransformer.toMaritalCodeVos(
        		commonService.findMaritalCodes("%", 0, Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @RequestMapping(value = "/maritalCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<MaritalCode> findMaritalCodeByCode(@PathVariable String code) {
        return new ResponseEntity<MaritalCode>(commonTransformer.toMaritalCodeVo(
                commonService.findMaritalCodeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/maritalCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveMaritalCode(@RequestBody MaritalCode vo) {
        dummyLogin();

        InMaritalCode maritalCode = new InMaritalCodeImpl();
        maritalCode.setCode(vo.getCode());
        maritalCode.setDescriptionEn(vo.getDescriptionEn());
        maritalCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.saveMaritalCode(maritalCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/maritalCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateMaritalCode(@PathVariable String code, @RequestBody MaritalCode vo) {
        dummyLogin();

        InMaritalCode maritalCode = commonService.findMaritalCodeById(vo.getId());
        maritalCode.setCode(vo.getCode());
        maritalCode.setDescriptionEn(vo.getDescriptionEn());
        maritalCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateMaritalCode(maritalCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/maritalCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeMaritalCode(@PathVariable String code) {
        dummyLogin();

        InMaritalCode maritalCode = commonService.findMaritalCodeByCode(code);
        commonService.removeMaritalCode(maritalCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
        InAutoLoginToken token = new InAutoLoginToken("root");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }


    // ====================================================================================================
    // IN_RELIGION_CODE
    // ====================================================================================================

    @RequestMapping(value = "/religionCodes", method = RequestMethod.GET)
    public ResponseEntity<List<ReligionCode>> findReligionCodes() {
        return new ResponseEntity<List<ReligionCode>>(commonTransformer.toReligionCodeVos(
                commonService.findReligionCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/religionCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<ReligionCode> findReligionCodeByCode(@PathVariable String code) {
        return new ResponseEntity<ReligionCode>(commonTransformer.toReligionCodeVo(
                commonService.findReligionCodeByCode(code)), HttpStatus.OK);
    }

    //====================================================================================================
    // COUNTRY_CODE
    //====================================================================================================

    @RequestMapping(value = "/countryCodes", method = RequestMethod.GET)
    public ResponseEntity<List<CountryCode>> findCountryCodes() {
        return new ResponseEntity<List<CountryCode>>(commonTransformer.toCountryCodeVos(
                commonService.findCountryCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/countryCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<CountryCode> findCountryCodeByCode(@PathVariable String code) {
        return new ResponseEntity<CountryCode>(commonTransformer.toCountryCodeVo(
                commonService.findCountryCodeByCode(code)), HttpStatus.OK);
    }

    //====================================================================================================
    // STATE_CODE
    //====================================================================================================

    @RequestMapping(value = "/stateCodes", method = RequestMethod.GET)
    public ResponseEntity<List<StateCode>> findStateCodes() {
        return new ResponseEntity<List<StateCode>>(commonTransformer.toStateCodeVos(
                commonService.findStateCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/stateCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<StateCode> findStateCodeByCode(@PathVariable String code) {
        return new ResponseEntity<StateCode>(commonTransformer.toStateCodeVo(
                commonService.findStateCodeByCode(code)), HttpStatus.OK);
    }


    //====================================================================================================
    // RACE CODES
    //====================================================================================================

    @RequestMapping(value = "/raceCodes", method = RequestMethod.GET)
    public ResponseEntity<List<RaceCode>> findRaceCodes() {
        return new ResponseEntity<List<RaceCode>>(commonTransformer.toRaceCodeVos(commonService.findRaceCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/raceCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<RaceCode> findRaceCode(@PathVariable String code) {
        return new ResponseEntity<RaceCode>(commonTransformer.toRaceCodeVo(commonService.findRaceCodeByCode(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/raceCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveRaceCode(@RequestBody RaceCode vo) {
        dummyLogin();

        InRaceCode raceCode = new InRaceCodeImpl();
        raceCode.setCode(vo.getCode());
        raceCode.setDescriptionEn(vo.getDescriptionEn());
        raceCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.saveRaceCode(raceCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/raceCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateRaceCode(@PathVariable String code, @RequestBody RaceCode vo) {
        dummyLogin();

        InRaceCode raceCode = commonService.findRaceCodeById(vo.getId());
        raceCode.setCode(vo.getCode());
        raceCode.setDescriptionEn(vo.getDescriptionEn());
        raceCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateRaceCode(raceCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/raceCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeRaceCode(@PathVariable String code) {
        dummyLogin();

        InRaceCode raceCode = commonService.findRaceCodeByCode(code);
        commonService.removeRaceCode(raceCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //====================================================================================================
    // ETHNICITY_CODE
    //====================================================================================================

    @RequestMapping(value = "/ethnicityCodes", method = RequestMethod.GET)
    public ResponseEntity<List<EthnicityCode>> findEthnicityCodes() {
        return new ResponseEntity<List<EthnicityCode>>(commonTransformer.toEthnicityCodeVos(
                commonService.findEthnicityCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/ethnicityCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<EthnicityCode> findEtnicityCodeByCode(@PathVariable String code) {
        return new ResponseEntity<EthnicityCode>(commonTransformer.toEthnicityCodeVo(
                commonService.findEthnicityCodeByCode(code)), HttpStatus.OK);
    }

    //====================================================================================================
    // NATIONALITY_CODE
    //====================================================================================================

    @RequestMapping(value = "/nationalityCodes", method = RequestMethod.GET)
    public ResponseEntity<List<NationalityCode>> findNationalityCodes() {
        return new ResponseEntity<List<NationalityCode>>(commonTransformer.toNationalityCodeVos(
                commonService.findNationalityCodes()), HttpStatus.OK);
    }

    @RequestMapping(value = "/nationalityCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<NationalityCode> findNationalityCodeByCode(@PathVariable String code) {
        return new ResponseEntity<NationalityCode>(commonTransformer.toNationalityCodeVo(
                commonService.findNationalityCodeByCode(code)), HttpStatus.OK);
    }

    //====================================================================================================
    // DISABILITY_CODE
    //====================================================================================================

    @RequestMapping(value = "/disabilityCodes", method = RequestMethod.GET)
    public ResponseEntity<List<DisabilityCode>> findDisabilityCodes() {
        return new ResponseEntity<List<DisabilityCode>>(commonTransformer.toDisabilityCodeVos(
        		commonService.findDisabilityCodes("%", 0, Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @RequestMapping(value = "/disabilityCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<DisabilityCode> findDisabilityCodeByCode(@PathVariable String code) {
        return new ResponseEntity<DisabilityCode>(commonTransformer.toDisabilityCodeVo(
                commonService.findDisabilityCodeByCode(code)), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/disabilityCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveDisabilityCode(@RequestBody DisabilityCode vo) {
        dummyLogin();

        InDisabilityCode disabilityCode = new InDisabilityCodeImpl();
        disabilityCode.setCode(vo.getCode());
        disabilityCode.setDescriptionEn(vo.getDescriptionEn());
        disabilityCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.saveDisabilityCode(disabilityCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/disabilityCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateDisabilityCode(@PathVariable String code, @RequestBody DisabilityCode vo) {
        dummyLogin();

        InDisabilityCode disabilityCode = commonService.findDisabilityCodeById(vo.getId());
        disabilityCode.setCode(vo.getCode());
        disabilityCode.setDescriptionEn(vo.getDescriptionEn());
        disabilityCode.setDescriptionMs(vo.getDescriptionMs());
        commonService.updateDisabilityCode(disabilityCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/disabilityCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeDisabilityCode(@PathVariable String code) {
        dummyLogin();

        InDisabilityCode disabilityCode = commonService.findDisabilityCodeByCode(code);
        commonService.removeDisabilityCode(disabilityCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //====================================================================================================
    // SCHOOL_CODE
    //====================================================================================================

    @RequestMapping(value = "/schoolCodes", method = RequestMethod.GET)
    public ResponseEntity<List<SchoolCode>> findSchoolCodes() {
        return new ResponseEntity<List<SchoolCode>>(commonTransformer.toSchoolCodeVos(
        		commonService.findSchoolCodes("%", 0, Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @RequestMapping(value = "/schoolCodes/{code}", method = RequestMethod.GET)
    public ResponseEntity<SchoolCode> findSchoolCodeByCode(@PathVariable String code) {
        return new ResponseEntity<SchoolCode>(commonTransformer.toSchoolCodeVo(
                commonService.findSchoolCodeByCode(code)), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/schoolCodes", method = RequestMethod.POST)
    public ResponseEntity<String> saveSchoolCode(@RequestBody SchoolCode vo) {
        dummyLogin();

        InSchoolCode schoolCode = new InSchoolCodeImpl();
        schoolCode.setCode(vo.getCode());
        schoolCode.setDescription(vo.getDescription());
        commonService.saveSchoolCode(schoolCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/schoolCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSchoolCode(@PathVariable String code, @RequestBody SchoolCode vo) {
        dummyLogin();

        InSchoolCode schoolCode = commonService.findSchoolCodeById(vo.getId());
        schoolCode.setCode(vo.getCode());
        schoolCode.setDescription(vo.getDescription());
        commonService.updateSchoolCode(schoolCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/schoolCodes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeSchoolCode(@PathVariable String code) {
        dummyLogin();

        InSchoolCode schoolCode = commonService.findSchoolCodeByCode(code);
        commonService.removeSchoolCode(schoolCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}

	