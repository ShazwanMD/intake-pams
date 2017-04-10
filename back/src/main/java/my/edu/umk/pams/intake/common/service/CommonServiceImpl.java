package my.edu.umk.pams.intake.common.service;

import my.edu.umk.pams.intake.common.dao.*;
import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.util.Util;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {

    @Autowired
    private InCountryCodeDao countryCodeDao;

    @Autowired
    private InStateCodeDao stateCodeDao;

    @Autowired
    private InCityCodeDao cityCodeDao;

    @Autowired
    private InDistrictCodeDao districtCodeDao;

    @Autowired
    private InProgramCodeDao programCodeDao;

    @Autowired
    private InFieldCodeDao fieldCodeDao;

    @Autowired
    private InGradeCodeDao gradeCodeDao;

    @Autowired
    private InSubjectCodeDao subjectCodeDao;

    @Autowired
    private InMaritalCodeDao maritalCodeDao;

    @Autowired
    private InDependencyCodeDao dependencyCodeDao;

    @Autowired
    private InDisabilityCodeDao disabilityCodeDao;

    @Autowired
    private InBankCodeDao bankCodeDao;

    @Autowired
    private InGenderCodeDao genderCodeDao;

    @Autowired
    private InBumiCodeDao bumiCodeDao;

    @Autowired
    private InRaceCodeDao raceCodeDao;

    @Autowired
    private InEthnicityCodeDao ethnicityCodeDao;

    @Autowired
    private InNationalityCodeDao nationalityCodeDao;

    @Autowired
    private InResidencyCodeDao residencyCodeDao;

    @Autowired
    private InSchoolCodeDao schoolCodeDao;

    @Autowired
    private InReligionCodeDao religionCodeDao;

    @Autowired
    private InResidencyCodeDao residenceCodeDao;

    @Autowired
    private InFacultyCodeDao facultyCodeDao;

    @Autowired
    private InStudyCenterCodeDao studyCenterCodeDao;

    @Autowired
    private InVenueCodeDao venueCodeDao;

    @Autowired
    private InInvolvementTypeCodeDao involvementTypeCodeDao;

    @Autowired
    private InInvolvementLevelCodeDao involvementLevelCodeDao;

    @Autowired
    private InInvolvementTitleCodeDao involvementTitleCodeDao;

    @Autowired
    private InEmploymentFieldCodeDao employmentFieldCodeDao;

    @Autowired
    private InEmploymentLevelCodeDao employmentLevelCodeDao;

    @Autowired
    private InEmploymentSectorCodeDao employmentSectorCodeDao;

    @Autowired
    private InStudyModeDao studyModeDao;

    @Autowired
    private InDunCodeDao dunCodeDao;

    @Autowired
    private InParliamentCodeDao parliamentCodeDao;

    @Autowired
    private InSupervisorCodeDao supervisorCodeDao;
    
    @Autowired
    private SessionFactory sessionFactory;

    //====================================================================================================
    // COUNTRY CODE
    //====================================================================================================


    @Override
    public InCountryCode findCountryCodeById(Long id) {
        return countryCodeDao.findById(id);
    }

    @Override
    public InCountryCode findCountryCodeByCode(String code) {
        return countryCodeDao.findByCode(code);
    }

    @Override
    public List<InCountryCode> findCountryCodes(String filter, Integer offset, Integer limit) {
        return countryCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countCountryCode(String filter) {
        return countryCodeDao.count(filter);
    }


    @Override
    public void saveCountryCode(InCountryCode countryCode) {
        countryCodeDao.save(countryCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateCountryCode(InCountryCode countryCode) {
        countryCodeDao.update(countryCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeCountryCode(InCountryCode countryCode) {
        countryCodeDao.remove(countryCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // STATE CODE
    //====================================================================================================

    @Override
    public InStateCode findStateCodeById(Long id) {
        return stateCodeDao.findById(id);
    }

    @Override
    public InStateCode findStateCodeByCode(String code) {
        return stateCodeDao.findByCode(code);
    }

    @Override
    public List<InStateCode> findStateCodes(Integer offset, Integer limit) {
        return stateCodeDao.find(offset, limit);
    }

    @Override
    public List<InStateCode> findStateCodes(String filter, Integer offset, Integer limit) {
        return stateCodeDao.find(filter, offset, limit);
    }

    @Override
    public List<InStateCode> findStateCodes(InCountryCode countryCode, Integer offset, Integer limit) {
        return stateCodeDao.find(countryCode, offset, limit);
    }

    @Override
    public List<InStateCode> findStateCodes(String filter, InCountryCode countryCode, Integer offset, Integer limit) {
        return stateCodeDao.find(filter, countryCode, offset, limit);
    }

    @Override
    public Integer countStateCode() {
        return stateCodeDao.count();
    }

    @Override
    public Integer countStateCode(String filter) {
        return stateCodeDao.count(filter);
    }

    @Override
    public Integer countStateCode(InCountryCode countryCode) {
        return stateCodeDao.count(countryCode);
    }

    @Override
    public Integer countStateCode(String filter, InCountryCode countryCode) {
        return stateCodeDao.count(filter, countryCode);
    }

    @Override
    public void saveStateCode(InStateCode stateCode) {
        stateCodeDao.save(stateCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStateCode(InStateCode stateCode) {
        stateCodeDao.update(stateCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeStateCode(InStateCode stateCode) {
        stateCodeDao.remove(stateCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // DISTRICT CODE
    //====================================================================================================


    @Override
    public InDistrictCode findDistrictCodeById(Long id) {
        return districtCodeDao.findById(id);
    }

    @Override
    public InDistrictCode findDistrictCodeByCode(String code) {
        return districtCodeDao.findByCode(code);
    }

    @Override
    public List<InDistrictCode> findDistrictCodes(InStateCode stateCode, Integer offset, Integer limit) {
        return districtCodeDao.find(offset, limit);
    }

    @Override
    public List<InDistrictCode> findDistrictCodes(String filter, InStateCode stateCode, Integer offset, Integer limit) {
        return districtCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countDistrictCode(InStateCode stateCode) {
        return districtCodeDao.count();
    }

    @Override
    public Integer countDistrictCode(String filter, InStateCode stateCode) {
        return districtCodeDao.count(filter);
    }


    @Override
    public void saveDistrictCode(InDistrictCode districtCode) {
        districtCodeDao.save(districtCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateDistrictCode(InDistrictCode districtCode) {
        districtCodeDao.update(districtCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeDistrictCode(InDistrictCode districtCode) {
        districtCodeDao.remove(districtCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // CITY CODE
    //====================================================================================================

    @Override
    public InCityCode findCityCodeById(Long id) {
        return cityCodeDao.findById(id);
    }

    @Override
    public InCityCode findCityCodeByCode(String code) {
        return cityCodeDao.findByCode(code);
    }

    @Override
    public List<InCityCode> findCityCodes(InStateCode stateCode, Integer offset, Integer limit) {
        return cityCodeDao.find(stateCode, offset, limit);
    }

    @Override
    public List<InCityCode> findCityCodes(String filter, InStateCode stateCode, Integer offset, Integer limit) {
        return cityCodeDao.find(filter, stateCode, offset, limit);
    }

    @Override
    public Integer countCityCode(InStateCode stateCode) {
        return cityCodeDao.count(stateCode);
    }

    @Override
    public Integer countCityCode(String filter, InStateCode stateCode) {
        return cityCodeDao.count(filter, stateCode);
    }

    @Override
    public void saveCityCode(InCityCode cityCode) {
        cityCodeDao.save(cityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateCityCode(InCityCode cityCode) {
        cityCodeDao.update(cityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeCityCode(InCityCode cityCode) {
        cityCodeDao.remove(cityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // SUBJECT CODE
    //====================================================================================================


    @Override
    public InSubjectCode findSubjectCodeById(Long id) {
        return subjectCodeDao.findById(id);
    }

    @Override
    public InSubjectCode findSubjectCodeByCode(String code) {
        return subjectCodeDao.findByCode(code);
    }

    @Override
    public List<InSubjectCode> findSubjectCodes() {
        return subjectCodeDao.find();
    }

    @Override
    public List<InSubjectCode> findSubjectCodes(Integer offset, Integer limit) {
        return subjectCodeDao.find(offset, limit);
    }

    @Override
    public List<InSubjectCode> findSubjectCodes(String filter, Integer offset, Integer limit) {
        return subjectCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countSubjectCode() {
        return subjectCodeDao.count();
    }

    @Override
    public Integer countSubjectCode(String filter) {
        return subjectCodeDao.count(filter);
    }

    @Override
    public void saveSubjectCode(InSubjectCode subjectCode) {
        subjectCodeDao.save(subjectCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateSubjectCode(InSubjectCode subjectCode) {
        subjectCodeDao.update(subjectCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeSubjectCode(InSubjectCode subjectCode) {
        subjectCodeDao.remove(subjectCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // GRADE CODE
    //====================================================================================================

    @Override
    public InGradeCode findGradeCodeById(Long id) {
        return gradeCodeDao.findById(id);
    }

    @Override
    public InGradeCode findGradeCodeByCode(String code) {
        return gradeCodeDao.findByCode(code);
    }

    @Override
    public List<InGradeCode> findGradeCodes() {
        return gradeCodeDao.find();
    }

    @Override
    public List<InGradeCode> findGradeCodes(Integer offset, Integer limit) {
        return gradeCodeDao.find(offset, limit);
    }

    @Override
    public List<InGradeCode> findGradeCodes(String filter, Integer offset, Integer limit) {
        return gradeCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countGradeCode() {
        return gradeCodeDao.count();
    }

    @Override
    public Integer countGradeCode(String filter) {
        return gradeCodeDao.count(filter);
    }

    @Override
    public void saveGradeCode(InGradeCode gradeCode) {
        gradeCodeDao.save(gradeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateGradeCode(InGradeCode gradeCode) {
        gradeCodeDao.update(gradeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeGradeCode(InGradeCode gradeCode) {
        gradeCodeDao.remove(gradeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // PROGRAM CODE
    //====================================================================================================

    @Override
    public InProgramCode findProgramCodeById(Long id) {
        return programCodeDao.findById(id);
    }

    @Override
    public InProgramCode findProgramCodeByCode(String code) {
        return programCodeDao.findByCode(code);
    }

    @Override
    public InProgramCode findProgramCodeByUpuCode(String upuCode) {
        return programCodeDao.findByUpuCode(upuCode);
    }

    @Override
    public List<InProgramCode> findProgramCodes() {
        return programCodeDao.find();
    }

    @Override
    public List<InProgramCode> findProgramCodes(String filter, Integer offset, Integer limit) {
        return programCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countProgramCode() {
        return programCodeDao.count();
    }

    @Override
    public Integer countProgramCode(String filter) {
        return programCodeDao.count(filter);
    }

    @Override
    public void saveProgramCode(InProgramCode programCode) {
        programCodeDao.save(programCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateProgramCode(InProgramCode programCode) {
        programCodeDao.update(programCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeProgramCode(InProgramCode programCode) {
        programCodeDao.remove(programCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // FIELD CODE
    //====================================================================================================

    @Override
    public InFieldCode findFieldCodeById(Long id) {
        return fieldCodeDao.findById(id);
    }

    @Override
    public InFieldCode findFieldCodeByCode(String code) {
        return fieldCodeDao.findByCode(code);
    }

    @Override
    public List<InFieldCode> findFieldCodes() {
        return fieldCodeDao.find();
    }

    @Override
    public List<InFieldCode> findFieldCodes(Integer offset, Integer limit) {
        return fieldCodeDao.find(offset, limit);
    }

    @Override
    public List<InFieldCode> findFieldCodes(String filter, Integer offset, Integer limit) {
        return fieldCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countFieldCode() {
        return fieldCodeDao.count();
    }

    @Override
    public Integer countFieldCode(String filter) {
        return fieldCodeDao.count(filter);
    }

    @Override
    public void saveFieldCode(InFieldCode fieldCode) {
        fieldCodeDao.save(fieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateFieldCode(InFieldCode fieldCode) {
        fieldCodeDao.update(fieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeFieldCode(InFieldCode fieldCode) {
        fieldCodeDao.remove(fieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // GENDER CODE
    //====================================================================================================
    @Override
    public InGenderCode findGenderCodeById(Long id) {
        return genderCodeDao.findById(id);
    }

    @Override
    public InGenderCode findGenderCodeByCode(String code) {
        return genderCodeDao.findByCode(code);
    }

    @Override
    public List<InGenderCode> findGenderCodes() {
        return genderCodeDao.find();
    }

    @Override
    public List<InGenderCode> findGenderCodes(String filter, Integer offset, Integer limit) {
        return genderCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countGenderCode() {
        return genderCodeDao.count();
    }

    @Override
    public Integer countGenderCode(String filter) {
        return genderCodeDao.count(filter);
    }

    @Override
    public void saveGenderCode(InGenderCode genderCode) {
        genderCodeDao.save(genderCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateGenderCode(InGenderCode genderCode) {
        genderCodeDao.update(genderCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeGenderCode(InGenderCode genderCode) {
        genderCodeDao.remove(genderCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // BUMI CODE
    //====================================================================================================

    @Override
    public InBumiCode findBumiCodeById(Long id) {
        return bumiCodeDao.findById(id);
    }

    @Override
    public InBumiCode findBumiCodeByCode(String code) {
        return bumiCodeDao.findByCode(code);
    }

    @Override
    public List<InBumiCode> findBumiCodes() {
        return bumiCodeDao.find();
    }

    @Override
    public List<InBumiCode> findBumiCodes(String filter, Integer offset, Integer limit) {
        return bumiCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countBumiCode() {
        return bumiCodeDao.count();
    }

    @Override
    public Integer countBumiCode(String filter) {
        return bumiCodeDao.count(filter);
    }


    @Override
    public void saveBumiCode(InBumiCode bumiCode) {
        bumiCodeDao.save(bumiCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateBumiCode(InBumiCode bumiCode) {
        bumiCodeDao.update(bumiCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeBumiCode(InBumiCode bumiCode) {
        bumiCodeDao.remove(bumiCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // RACE CODE
    //====================================================================================================

    @Override
    public InRaceCode findRaceCodeById(Long id) {
        return raceCodeDao.findById(id);
    }

    @Override
    public InRaceCode findRaceCodeByCode(String code) {
        return raceCodeDao.findByCode(code);
    }

    @Override
    public List<InRaceCode> findRaceCodes() {
        return raceCodeDao.find();
    }

    @Override
    public List<InRaceCode> findRaceCodes(String filter, Integer offset, Integer limit) {
        return raceCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countRaceCode() {
        return raceCodeDao.count();
    }

    @Override
    public Integer countRaceCode(String filter) {
        return raceCodeDao.count(filter);
    }


    @Override
    public void saveRaceCode(InRaceCode raceCode) {
        raceCodeDao.save(raceCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateRaceCode(InRaceCode raceCode) {
        raceCodeDao.update(raceCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeRaceCode(InRaceCode raceCode) {
        raceCodeDao.remove(raceCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // ETHNICITY CODE
    //====================================================================================================

    @Override
    public InEthnicityCode findEthnicityCodeById(Long id) {
        return ethnicityCodeDao.findById(id);
    }

    @Override
    public InEthnicityCode findEthnicityCodeByCode(String code) {
        return ethnicityCodeDao.findByCode(code);
    }

    @Override
    public List<InEthnicityCode> findEthnicityCodes() {
        return ethnicityCodeDao.find();
    }

    @Override
    public List<InEthnicityCode> findEthnicityCodes(String filter, Integer offset, Integer limit) {
        return ethnicityCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countEthnicityCode() {
        return ethnicityCodeDao.count();
    }

    @Override
    public Integer countEthnicityCode(String filter) {
        return ethnicityCodeDao.count(filter);
    }

    @Override
    public void saveEthnicityCode(InEthnicityCode ethnicityCode) {
        ethnicityCodeDao.save(ethnicityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEthnicityCode(InEthnicityCode ethnicityCode) {
        ethnicityCodeDao.update(ethnicityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEthnicityCode(InEthnicityCode ethnicityCode) {
        ethnicityCodeDao.remove(ethnicityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // RELIGION CODE
    //====================================================================================================


    @Override
    public InReligionCode findReligionCodeById(Long id) {
        return religionCodeDao.findById(id);
    }

    @Override
    public InReligionCode findReligionCodeByCode(String code) {
        return religionCodeDao.findByCode(code);
    }

    @Override
    public List<InReligionCode> findReligionCodes() {
        return religionCodeDao.find();
    }

    @Override
    public List<InReligionCode> findReligionCodes(String filter, Integer offset, Integer limit) {
        return religionCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countReligionCode() {
        return religionCodeDao.count();
    }

    @Override
    public Integer countReligionCode(String filter) {
        return religionCodeDao.count(filter);
    }


    @Override
    public void saveReligionCode(InReligionCode religionCode) {
        religionCodeDao.save(religionCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateReligionCode(InReligionCode religionCode) {
        religionCodeDao.update(religionCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeReligionCode(InReligionCode religionCode) {
        religionCodeDao.remove(religionCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // MARITAL CODE
    //====================================================================================================

    //====================================================================================================
    // DISABILITY CODE
    //====================================================================================================

    @Override
    public InDisabilityCode findDisabilityCodeById(Long id) {
        return disabilityCodeDao.findById(id);
    }

    @Override
    public InDisabilityCode findDisabilityCodeByCode(String code) {
        return disabilityCodeDao.findByCode(code);
    }

    @Override
    public List<InDisabilityCode> findDisabilityCodes() {
        return disabilityCodeDao.find();
    }

    @Override
    public List<InDisabilityCode> findDisabilityCodes(String filter, Integer offset, Integer limit) {
        return disabilityCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countDisabilityCode() {
        return disabilityCodeDao.count();
    }

    @Override
    public Integer countDisabilityCode(String filter) {
        return disabilityCodeDao.count(filter);
    }


    @Override
    public void saveDisabilityCode(InDisabilityCode disabilityCode) {
        disabilityCodeDao.save(disabilityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateDisabilityCode(InDisabilityCode disabilityCode) {
        disabilityCodeDao.update(disabilityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeDisabilityCode(InDisabilityCode disabilityCode) {
        disabilityCodeDao.remove(disabilityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // NATIONALITY CODE
    //====================================================================================================

    @Override
    public InNationalityCode findNationalityCodeById(Long id) {
        return nationalityCodeDao.findById(id);
    }

    @Override
    public InNationalityCode findNationalityCodeByCode(String code) {
        return nationalityCodeDao.findByCode(code);
    }

    @Override
    public List<InNationalityCode> findNationalityCodes() {
        return nationalityCodeDao.find();
    }

    @Override
    public List<InNationalityCode> findNationalityCodes(String filter, Integer offset, Integer limit) {
        return nationalityCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countNationalityCode() {
        return nationalityCodeDao.count();
    }

    @Override
    public Integer countNationalityCode(String filter) {
        return nationalityCodeDao.count(filter);
    }


    @Override
    public void saveNationalityCode(InNationalityCode nationalityCode) {
        nationalityCodeDao.save(nationalityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateNationalityCode(InNationalityCode nationalityCode) {
        nationalityCodeDao.update(nationalityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeNationalityCode(InNationalityCode nationalityCode) {
        nationalityCodeDao.remove(nationalityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // RESIDENCY CODE
    //====================================================================================================

    @Override
    public InResidencyCode findResidencyCodeById(Long id) {
        return residencyCodeDao.findById(id);
    }

    @Override
    public InResidencyCode findResidencyCodeByCode(String code) {
        return residencyCodeDao.findByCode(code);
    }

    @Override
    public List<InResidencyCode> findResidencyCodes() {
        return residencyCodeDao.find();
    }

    @Override
    public List<InResidencyCode> findResidencyCodes(String filter, Integer offset, Integer limit) {
        return residencyCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countResidencyCode() {
        return residencyCodeDao.count();
    }

    @Override
    public Integer countResidencyCode(String filter) {
        return residencyCodeDao.count(filter);
    }


    @Override
    public void saveResidencyCode(InResidencyCode residencyCode) {
        residencyCodeDao.save(residencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateResidencyCode(InResidencyCode residencyCode) {
        residencyCodeDao.update(residencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeResidencyCode(InResidencyCode residencyCode) {
        residencyCodeDao.remove(residencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // SCHOOL CODE
    //====================================================================================================

    @Override
    public InSchoolCode findSchoolCodeById(Long id) {
        return schoolCodeDao.findById(id);
    }

    @Override
    public InSchoolCode findSchoolCodeByCode(String code) {
        return schoolCodeDao.findByCode(code);
    }

    @Override
    public List<InSchoolCode> findSchoolCodes(String filter, Integer offset, Integer limit) {
        return schoolCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countSchoolCode(String filter) {
        return schoolCodeDao.count(filter);
    }


    @Override
    public void saveSchoolCode(InSchoolCode schoolCode) {
        schoolCodeDao.save(schoolCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateSchoolCode(InSchoolCode schoolCode) {
        schoolCodeDao.update(schoolCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeSchoolCode(InSchoolCode schoolCode) {
        schoolCodeDao.remove(schoolCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // FACULTY CODE
    //====================================================================================================
    @Override
    public InFacultyCode findFacultyCodeById(Long id) {
        return facultyCodeDao.findById(id);
    }

    @Override
    public InFacultyCode findFacultyCodeByCode(String code) {
        return facultyCodeDao.findByCode(code);
    }

    @Override
    public List<InFacultyCode> findFacultyCodes() {
        return facultyCodeDao.find();
    }

    @Override
    public List<InFacultyCode> findFacultyCodes(String filter, Integer offset, Integer limit) {
        return facultyCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countFacultyCode() {
        return facultyCodeDao.count();
    }

    @Override
    public Integer countFacultyCode(String filter) {
        return facultyCodeDao.count(filter);
    }

    @Override
    public void saveFacultyCode(InFacultyCode facultyCode) {
        facultyCodeDao.save(facultyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateFacultyCode(InFacultyCode facultyCode) {
        facultyCodeDao.update(facultyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeFacultyCode(InFacultyCode facultyCode) {
        facultyCodeDao.remove(facultyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // STUDY CENTER CODE
    //====================================================================================================

    @Override
    public InStudyCenterCode findStudyCenterCodeById(Long id) {
        return studyCenterCodeDao.findById(id);
    }

    @Override
    public InStudyCenterCode findStudyCenterCodeByCode(String code) {
        return studyCenterCodeDao.findByCode(code);
    }

    @Override
    public List<InStudyCenterCode> findStudyCenterCodes() {
        return studyCenterCodeDao.find();
    }

    @Override
    public List<InStudyCenterCode> findStudyCenterCodes(String filter, Integer offset, Integer limit) {
        return studyCenterCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countStudyCenterCode() {
        return studyCenterCodeDao.count();
    }

    @Override
    public Integer countStudyCenterCode(String filter) {
        return studyCenterCodeDao.count(filter);
    }


    @Override
    public void saveStudyCenterCode(InStudyCenterCode studyCenterCode) {
        studyCenterCodeDao.save(studyCenterCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStudyCenterCode(InStudyCenterCode studyCenterCode) {
        studyCenterCodeDao.update(studyCenterCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeStudyCenterCode(InStudyCenterCode studyCenterCode) {
        studyCenterCodeDao.remove(studyCenterCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // VENUE CODE
    //====================================================================================================

    @Override
    public InVenueCode findVenueCodeById(Long id) {
        return venueCodeDao.findById(id);
    }

    @Override
    public InVenueCode findVenueCodeByCode(String code) {
        return venueCodeDao.findByCode(code);
    }

    @Override
    public List<InVenueCode> findVenueCodes() {
        return venueCodeDao.find();
    }

    @Override
    public List<InVenueCode> findVenueCodes(String filter, Integer offset, Integer limit) {
        return venueCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countVenueCode() {
        return venueCodeDao.count();
    }

    @Override
    public Integer countVenueCode(String filter) {
        return venueCodeDao.count(filter);
    }

    @Override
    public void saveVenueCode(InVenueCode venueCode) {
        venueCodeDao.save(venueCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateVenueCode(InVenueCode venueCode) {
        venueCodeDao.update(venueCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeVenueCode(InVenueCode venueCode) {
        venueCodeDao.remove(venueCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // DEPENDENCY CODE
    //====================================================================================================
    @Override
    public InDependencyCode findDependencyCodeById(Long id) {
        return dependencyCodeDao.findById(id);
    }

    @Override
    public InDependencyCode findDependencyCodeByCode(String code) {
        return dependencyCodeDao.findByCode(code);
    }

    @Override
    public List<InDependencyCode> findDependencyCodes() {
        return dependencyCodeDao.find();
    }

    @Override
    public List<InDependencyCode> findDependencyCodes(String filter, Integer offset, Integer limit) {
        return dependencyCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countDependencyCode() {
        return dependencyCodeDao.count();
    }

    @Override
    public Integer countDependencyCode(String filter) {
        return dependencyCodeDao.count(filter);
    }


    @Override
    public void saveDependencyCode(InDependencyCode dependencyCode) {
        dependencyCodeDao.save(dependencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateDependencyCode(InDependencyCode dependencyCode) {
        dependencyCodeDao.update(dependencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeDependencyCode(InDependencyCode dependencyCode) {
        dependencyCodeDao.remove(dependencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // BANK CODE
    //====================================================================================================

    @Override
    public InBankCode findBankCodeById(Long id) {
        return bankCodeDao.findById(id);
    }

    @Override
    public InBankCode findBankCodeByCode(String code) {
        return bankCodeDao.findByCode(code);
    }

    @Override
    public List<InBankCode> findBankCodes() {
        return bankCodeDao.find();
    }

    @Override
    public List<InBankCode> findBankCodes(String filter, Integer offset, Integer limit) {
        return bankCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countBankCode() {
        return bankCodeDao.count();
    }

    @Override
    public Integer countBankCode(String filter) {
        return bankCodeDao.count(filter);
    }


    @Override
    public void saveBankCode(InBankCode bankCode) {
        bankCodeDao.save(bankCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateBankCode(InBankCode bankCode) {
        bankCodeDao.update(bankCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeBankCode(InBankCode bankCode) {
        bankCodeDao.remove(bankCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // MARITAL CODE
    //====================================================================================================

    @Override
    public InMaritalCode findMaritalCodeById(Long id) {
        return maritalCodeDao.findById(id);
    }

    @Override
    public InMaritalCode findMaritalCodeByCode(String code) {
        return maritalCodeDao.findByCode(code);
    }

    @Override
    public List<InMaritalCode> findMaritalCodes() {
        return maritalCodeDao.find();
    }

    @Override
    public List<InMaritalCode> findMaritalCodes(String filter, Integer offset, Integer limit) {
        return maritalCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countMaritalCode() {
        return maritalCodeDao.count();
    }

    @Override
    public Integer countMaritalCode(String filter) {
        return maritalCodeDao.count(filter);
    }

    @Override
    public void saveMaritalCode(InMaritalCode MaritalCode) {
        maritalCodeDao.save(MaritalCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateMaritalCode(InMaritalCode MaritalCode) {
        maritalCodeDao.update(MaritalCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeMaritalCode(InMaritalCode MaritalCode) {
        maritalCodeDao.remove(MaritalCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INVOLVEMENT TYPE CODE
    //====================================================================================================


    @Override
    public InInvolvementTypeCode findInvolvementTypeCodeById(Long id) {
        return involvementTypeCodeDao.findById(id);
    }

    @Override
    public InInvolvementTypeCode findInvolvementTypeCodeByCode(String code) {
        return involvementTypeCodeDao.findByCode(code);
    }

    @Override
    public List<InInvolvementTypeCode> findInvolvementTypeCodes() {
        return involvementTypeCodeDao.find();
    }

    @Override
    public List<InInvolvementTypeCode> findInvolvementTypeCodes(Integer offset, Integer limit) {
        return involvementTypeCodeDao.find();
    }

    @Override
    public List<InInvolvementTypeCode> findInvolvementTypeCodes(String filter, Integer offset, Integer limit) {
        return involvementTypeCodeDao.find();
    }

    @Override
    public Integer countInvolvementTypeCode() {
        return involvementTypeCodeDao.count();
    }

    @Override
    public Integer countInvolvementTypeCode(String filter) {
        return involvementTypeCodeDao.count();
    }

    @Override
    public void saveInvolvementTypeCode(InInvolvementTypeCode involvementTypeCode) {
        involvementTypeCodeDao.save(involvementTypeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateInvolvementTypeCode(InInvolvementTypeCode involvementTypeCode) {
        involvementTypeCodeDao.update(involvementTypeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeInvolvementTypeCode(InInvolvementTypeCode involvementTypeCode) {
        involvementTypeCodeDao.remove(involvementTypeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INVOLVEMENT LEVEL CODE
    //====================================================================================================

    @Override
    public InInvolvementLevelCode findInvolvementLevelCodeById(Long id) {
        return involvementLevelCodeDao.findById(id);
    }

    @Override
    public InInvolvementLevelCode findInvolvementLevelCodeByCode(String code) {
        return involvementLevelCodeDao.findByCode(code);
    }

    @Override
    public List<InInvolvementLevelCode> findInvolvementLevelCodes() {
        return involvementLevelCodeDao.find();
    }

    @Override
    public List<InInvolvementLevelCode> findInvolvementLevelCodes(Integer offset, Integer limit) {
        return involvementLevelCodeDao.find();
    }

    @Override
    public List<InInvolvementLevelCode> findInvolvementLevelCodes(String filter, Integer offset, Integer limit) {
        return involvementLevelCodeDao.find();
    }

    @Override
    public Integer countInvolvementLevelCode() {
        return involvementLevelCodeDao.count();
    }

    @Override
    public Integer countInvolvementLevelCode(String filter) {
        return involvementLevelCodeDao.count();
    }


    @Override
    public void saveInvolvementLevelCode(InInvolvementLevelCode involvementLevelCode) {
        involvementLevelCodeDao.save(involvementLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateInvolvementLevelCode(InInvolvementLevelCode involvementLevelCode) {
        involvementLevelCodeDao.update(involvementLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeInvolvementLevelCode(InInvolvementLevelCode involvementLevelCode) {
        involvementLevelCodeDao.remove(involvementLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INVOLVEMENT TITLE CODE
    //====================================================================================================

    @Override
    public InInvolvementTitleCode findInvolvementTitleCodeById(Long id) {
        return involvementTitleCodeDao.findById(id);
    }

    @Override
    public InInvolvementTitleCode findInvolvementTitleCodeByCode(String code) {
        return involvementTitleCodeDao.findByCode(code);
    }

    @Override
    public List<InInvolvementTitleCode> findInvolvementTitleCodes() {
        return involvementTitleCodeDao.find();
    }

    @Override
    public List<InInvolvementTitleCode> findInvolvementTitleCodes(Integer offset, Integer limit) {
        return involvementTitleCodeDao.find();
    }

    @Override
    public List<InInvolvementTitleCode> findInvolvementTitleCodes(String filter, Integer offset, Integer limit) {
        return involvementTitleCodeDao.find();
    }

    @Override
    public Integer countInvolvementTitleCode() {
        return involvementTitleCodeDao.count();
    }

    @Override
    public Integer countInvolvementTitleCode(String filter) {
        return involvementTitleCodeDao.count();
    }


    @Override
    public void saveInvolvementTitleCode(InInvolvementTitleCode involvementTitleCode) {
        involvementTitleCodeDao.save(involvementTitleCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateInvolvementTitleCode(InInvolvementTitleCode involvementTitleCode) {
        involvementTitleCodeDao.update(involvementTitleCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeInvolvementTitleCode(InInvolvementTitleCode involvementTitleCode) {
        involvementTitleCodeDao.remove(involvementTitleCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // EMPLOYMENT FIELD CODE
    //====================================================================================================


    @Override
    public InEmploymentFieldCode findEmploymentFieldCodeById(Long id) {
        return employmentFieldCodeDao.findById(id);
    }

    @Override
    public InEmploymentFieldCode findEmploymentFieldCodeByCode(String code) {
        return employmentFieldCodeDao.findByCode(code);
    }

    @Override
    public List<InEmploymentFieldCode> findEmploymentFieldCodes() {
        return employmentFieldCodeDao.find();
    }

    @Override
    public List<InEmploymentFieldCode> findEmploymentFieldCodes(Integer offset, Integer limit) {
        return employmentFieldCodeDao.find();
    }

    @Override
    public List<InEmploymentFieldCode> findEmploymentFieldCodes(String filter, Integer offset, Integer limit) {
        return employmentFieldCodeDao.find();
    }

    @Override
    public Integer countEmploymentFieldCode() {
        return employmentLevelCodeDao.count();
    }

    @Override
    public Integer countEmploymentFieldCode(String filter) {
        return employmentLevelCodeDao.count();
    }


    @Override
    public void saveEmploymentFieldCode(InEmploymentFieldCode employmentFieldCode) {
        employmentFieldCodeDao.save(employmentFieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEmploymentFieldCode(InEmploymentFieldCode employmentFieldCode) {
        employmentFieldCodeDao.update(employmentFieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEmploymentFieldCode(InEmploymentFieldCode employmentFieldCode) {
        employmentFieldCodeDao.remove(employmentFieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // EMPLOYMENT LEVEL CODE
    //====================================================================================================

    @Override
    public InEmploymentLevelCode findEmploymentLevelCodeById(Long id) {
        return employmentLevelCodeDao.findById(id);
    }

    @Override
    public InEmploymentLevelCode findEmploymentLevelCodeByCode(String code) {
        return employmentLevelCodeDao.findByCode(code);
    }

    @Override
    public List<InEmploymentLevelCode> findEmploymentLevelCodes() {
        return employmentLevelCodeDao.find();
    }

    @Override
    public List<InEmploymentLevelCode> findEmploymentLevelCodes(Integer offset, Integer limit) {
        return employmentLevelCodeDao.find();
    }

    @Override
    public List<InEmploymentLevelCode> findEmploymentLevelCodes(String filter, Integer offset, Integer limit) {
        return employmentLevelCodeDao.find();
    }

    @Override
    public Integer countEmploymentLevelCode() {
        return employmentLevelCodeDao.count();
    }

    @Override
    public Integer countEmploymentLevelCode(String filter) {
        return employmentLevelCodeDao.count();
    }

    @Override
    public void saveEmploymentLevelCode(InEmploymentLevelCode employmentLevelCode) {
        employmentLevelCodeDao.save(employmentLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEmploymentLevelCode(InEmploymentLevelCode employmentLevelCode) {
        employmentLevelCodeDao.update(employmentLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEmploymentLevelCode(InEmploymentLevelCode employmentLevelCode) {
        employmentLevelCodeDao.remove(employmentLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // EMPLOYMENT SECTOR CODE
    //====================================================================================================

    @Override
    public InEmploymentSectorCode findEmploymentSectorCodeById(Long id) {
        return employmentSectorCodeDao.findById(id);
    }

    @Override
    public InEmploymentSectorCode findEmploymentSectorCodeByCode(String code) {
        return employmentSectorCodeDao.findByCode(code);
    }

    @Override
    public List<InEmploymentSectorCode> findEmploymentSectorCodes() {
        return employmentSectorCodeDao.find();
    }

    @Override
    public List<InEmploymentSectorCode> findEmploymentSectorCodes(Integer offset, Integer limit) {
        return employmentSectorCodeDao.find();
    }

    @Override
    public List<InEmploymentSectorCode> findEmploymentSectorCodes(String filter, Integer offset, Integer limit) {
        return employmentSectorCodeDao.find();
    }

    @Override
    public Integer countEmploymentSectorCode() {
        return employmentSectorCodeDao.count();
    }

    @Override
    public Integer countEmploymentSectorCode(String filter) {
        return employmentSectorCodeDao.count();
    }

    @Override
    public void saveEmploymentSectorCode(InEmploymentSectorCode employmentSectorCode) {
        employmentSectorCodeDao.save(employmentSectorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEmploymentSectorCode(InEmploymentSectorCode employmentSectorCode) {
        employmentSectorCodeDao.update(employmentSectorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEmploymentSectorCode(InEmploymentSectorCode employmentSectorCode) {
        employmentSectorCodeDao.remove(employmentSectorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // DUN CODE
    //====================================================================================================

    @Override
    public InDunCode findDunCodeById(Long id) {
        return dunCodeDao.findById(id);
    }

    @Override
    public InDunCode findDunCodeByCode(String code) {
        return dunCodeDao.findByCode(code);
    }

    @Override
    public List<InDunCode> findDunCodes() {
        return dunCodeDao.find();
    }

    @Override
    public List<InDunCode> findDunCodes(String filter, Integer offset, Integer limit) {
        return dunCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countDunCode() {
        return dunCodeDao.count();
    }

    @Override
    public Integer countDunCode(String filter) {
        return dunCodeDao.count(filter);
    }

    @Override
    public void saveDunCode(InDunCode DunCode) {
        dunCodeDao.save(DunCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateDunCode(InDunCode DunCode) {
        dunCodeDao.update(DunCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeDunCode(InDunCode DunCode) {
        dunCodeDao.remove(DunCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // PARLIAMENT CODE
    //====================================================================================================

    @Override
    public InParliamentCode findParliamentCodeById(Long id) {
        return parliamentCodeDao.findById(id);
    }

    @Override
    public InParliamentCode findParliamentCodeByCode(String code) {
        return parliamentCodeDao.findByCode(code);
    }

    @Override
    public List<InParliamentCode> findParliamentCodes() {
        return parliamentCodeDao.find();
    }

    @Override
    public List<InParliamentCode> findParliamentCodes(String filter, Integer offset, Integer limit) {
        return parliamentCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countParliamentCode() {
        return parliamentCodeDao.count();
    }

    @Override
    public Integer countParliamentCode(String filter) {
        return parliamentCodeDao.count(filter);
    }

    @Override
    public void saveParliamentCode(InParliamentCode ParliamentCode) {
        parliamentCodeDao.save(ParliamentCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateParliamentCode(InParliamentCode ParliamentCode) {
        parliamentCodeDao.update(ParliamentCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeParliamentCode(InParliamentCode ParliamentCode) {
        parliamentCodeDao.remove(ParliamentCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // STUDY MODE
    //====================================================================================================

    @Override
    public InStudyMode findStudyModeById(Long id) {
        return studyModeDao.findById(id);
    }

    @Override
    public InStudyMode findStudyModeByCode(String code) {
        return studyModeDao.findByCode(code);
    }

    @Override
    public List<InStudyMode> findStudyModes() {
        return studyModeDao.find();
    }

    @Override
    public List<InStudyMode> findStudyModes(String filter, Integer offset, Integer limit) {
        return studyModeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countStudyMode() {
        return studyModeDao.count();
    }

    @Override
    public Integer countStudyMode(String filter) {
        return studyModeDao.count(filter);
    }


    @Override
    public void saveStudyMode(InStudyMode studyMode) {
        studyModeDao.save(studyMode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStudyMode(InStudyMode studyMode) {
        studyModeDao.update(studyMode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeStudyMode(InStudyMode studyMode) {
        studyModeDao.remove(studyMode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

  //====================================================================================================
    // SUPERVISOR CODE
    //====================================================================================================

    @Override
    public InSupervisorCode findSupervisorCodeById(Long id) {
        return supervisorCodeDao.findById(id);
    }

    @Override
    public InSupervisorCode findSupervisorCodeByCode(String code) {
        return supervisorCodeDao.findByCode(code);
    }

    @Override
    public List<InSupervisorCode> findSupervisorCodes() {
        return supervisorCodeDao.find();
    }

    @Override
    public List<InSupervisorCode> findSupervisorCodes(String filter, Integer offset, Integer limit) {
        return supervisorCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countSupervisorCode() {
        return supervisorCodeDao.count();
    }

    @Override
    public Integer countSupervisorCode(String filter) {
        return supervisorCodeDao.count(filter);
    }


    @Override
    public void saveSupervisorCode(InSupervisorCode supervisorCode) {
        supervisorCodeDao.save(supervisorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateSupervisorCode(InSupervisorCode supervisorCode) {
        supervisorCodeDao.update(supervisorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeSupervisorCode(InSupervisorCode supervisorCode) {
        supervisorCodeDao.remove(supervisorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
    
}
