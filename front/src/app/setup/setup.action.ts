import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';

@Injectable()
export class SetupActions {

  static CHANGE_TITLE = '[Setup] Change Title';

  changeTitle(title): Action {
    console.log("changeTitle");
    return {
      type: SetupActions.CHANGE_TITLE,
      payload: title
    };
  }

  static CHANGE_TITLE_SUCCESS = '[Setup] Change Title Success';

  changeTitleSuccess(title): Action {
    console.log("changeTitleSuccess");
    return {
      type: SetupActions.CHANGE_TITLE_SUCCESS,
      payload: title
    };
  }


  static FIND_BANK_CODES = '[Setup] Find Bank Codes';

  findBankCodes(): Action {
    console.log("findBankCodes");
    return {
      type: SetupActions.FIND_BANK_CODES,
    };
  }

  static FIND_BANK_CODES_SUCCESS = '[Setup] Find Bank Codes Success';

  findBankCodesSuccess(codes): Action {
    console.log("findBankCodesSuccess");
    return {
      type: SetupActions.FIND_BANK_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_BANK_CODE = '[Setup] Save Bank Code';

  saveBankCode(code): Action {
    console.log("saveBankCode");
    return {
      type: SetupActions.SAVE_BANK_CODE,
      payload: code
    };
  }

  static SAVE_BANK_CODE_SUCCESS = '[Setup] Save Bank Code  Success';

  saveBankCodeSuccess(message): Action {
    console.log("saveBankCodeSuccess");
    return {
      type: SetupActions.SAVE_BANK_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_BANK_CODE = '[Setup] Update Bank Code';

  updateBankCode(code): Action {
    console.log("updateBankCode");
    return {
      type: SetupActions.UPDATE_BANK_CODE,
      payload: code
    };
  }

  static UPDATE_BANK_CODE_SUCCESS = '[Setup] Update Bank Code  Success';

  updateBankCodeSuccess(message): Action {
    console.log("updateBankCodeSuccess");
    return {
      type: SetupActions.UPDATE_BANK_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_GRADUATE_CENTRES = '[Setup] Find Graduate Centres';

  findGraduateCentres(): Action {
    console.log("findGraduateCentres");
    return {
      type: SetupActions.FIND_GRADUATE_CENTRES,
    };
  }

  static FIND_GRADUATE_CENTRES_SUCCESS = '[Setup] Find Graduate Centres Success';

  findGraduateCentresSuccess(codes): Action {
    console.log("findGraduateCentresSuccess");
    return {
      type: SetupActions.FIND_GRADUATE_CENTRES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_GRADUATE_CENTRE = '[Setup] Save Graduate Centre';

  saveGraduateCentre(code): Action {
    console.log("saveGraduateCentre");
    return {
      type: SetupActions.SAVE_GRADUATE_CENTRE,
      payload: code
    };
  }

  static SAVE_GRADUATE_CENTRE_SUCCESS = '[Setup] Save Graduate Centre  Success';

  saveGraduateCentreSuccess(message): Action {
    console.log("saveGraduateCentreSuccess");
    return {
      type: SetupActions.SAVE_GRADUATE_CENTRE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_GRADUATE_CENTRE = '[Setup] Update Graduate Centre';

  updateGraduateCentre(code): Action {
    console.log("updateGraduateCentre");
    return {
      type: SetupActions.UPDATE_GRADUATE_CENTRE,
      payload: code
    };
  }

  static UPDATE_GRADUATE_CENTRE_SUCCESS = '[Setup] Update Graduate Centre  Success';

  updateGraduateCentreSuccess(message): Action {
    console.log("updateGraduateCentreSuccess");
    return {
      type: SetupActions.UPDATE_GRADUATE_CENTRE_SUCCESS,
      payload: message
    };
  }

  static FIND_RELIGION_CODES = '[Setup] Find Religion Codes';

  findReligionCodes(): Action {
    console.log("findReligionCodes");
    return {
      type: SetupActions.FIND_RELIGION_CODES,
    };
  }

  static FIND_RELIGION_CODES_SUCCESS = '[Setup] Find Religion Codes Success';

  findReligionCodesSuccess(codes): Action {
    console.log("findReligionCodesSuccess");
    return {
      type: SetupActions.FIND_RELIGION_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_RELIGION_CODE = '[Setup] Save Religion Code';

  saveReligionCode(code): Action {
    console.log("saveReligionCode");
    return {
      type: SetupActions.SAVE_RELIGION_CODE,
      payload: code
    };
  }

  static SAVE_RELIGION_CODE_SUCCESS = '[Setup] Save Religion Code Success';

  saveReligionCodeSuccess(message): Action {
    console.log("saveReligionCodeSuccess");
    return {
      type: SetupActions.SAVE_RELIGION_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_RELIGION_CODE = '[Setup] Update Religion Code';

  updateReligionCode(code): Action {
    console.log("updateReligionCode");
    return {
      type: SetupActions.UPDATE_RELIGION_CODE,
      payload: code
    };
  }

  static UPDATE_RELIGION_CODE_SUCCESS = '[Setup] Update Religion Code  Success';

  updateReligionCodeSuccess(message): Action {
    console.log("updateReligionCodeSuccess");
    return {
      type: SetupActions.UPDATE_RELIGION_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_MARITAL_CODES = '[Setup] Find Marital Codes';

  findMaritalCodes(): Action {
    console.log("findMaritalCodes");
    return {
      type: SetupActions.FIND_MARITAL_CODES,
    };
  }

  static FIND_MARITAL_CODES_SUCCESS = '[Setup] Find Marital Codes Success';

  findMaritalCodesSuccess(codes): Action {
    console.log("findMaritalCodesSuccess");
    return {
      type: SetupActions.FIND_MARITAL_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_MARITAL_CODE = '[Setup] Save Marital Code';

  saveMaritalCode(code): Action {
    console.log("saveMaritalCode");
    return {
      type: SetupActions.SAVE_MARITAL_CODE,
      payload: code
    };
  }

  static SAVE_MARITAL_CODE_SUCCESS = '[Setup] Save Marital Code Success';

  saveMaritalCodeSuccess(message): Action {
    console.log("saveMaritalCodeSuccess");
    return {
      type: SetupActions.SAVE_MARITAL_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_MARITAL_CODE = '[Setup] Update Marital Code';

  updateMaritalCode(code): Action {
    console.log("updateMaritalCode");
    return {
      type: SetupActions.UPDATE_MARITAL_CODE,
      payload: code
    };
  }

  static UPDATE_MARITAL_CODE_SUCCESS = '[Setup] Update Marital Code  Success';

  updateMaritalCodeSuccess(message): Action {
    console.log("updateMaritalCodeSuccess");
    return {
      type: SetupActions.UPDATE_MARITAL_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_MARITAL_CODE = '[Setup] Remove Marital Code';

  removeMaritalCode(code): Action {
    console.log("removeMaritalCode");
    return {
      type: SetupActions.REMOVE_MARITAL_CODE,
      payload: code
    };
  }

  static REMOVE_MARITAL_CODE_SUCCESS = '[Setup] Remove Marital Code  Success';

  removeMaritalCodeSuccess(message): Action {
    console.log("removeMaritalCodeSuccess");
    return {
      type: SetupActions.REMOVE_MARITAL_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_COUNTRY_CODES = '[Common] Find CountryCodes';

  findCountryCodes(): Action {
    console.log("findCountryCodes");
    return {
      type: SetupActions.FIND_COUNTRY_CODES,
    };
  }

  static FIND_COUNTRY_CODES_SUCCESS = '[Common] Find CountryCodes Success';

  findCountryCodesSuccess(codes): Action {
    console.log("findCountryCodesSuccess");
    return {
      type: SetupActions.FIND_COUNTRY_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_COUNTRY_CODE = '[Setup] Save Country Code';

  saveCountryCode(code): Action {
    console.log("saveCountryCode");
    return {
      type: SetupActions.SAVE_COUNTRY_CODE,
      payload: code
    };
  }

  static FIND_STATE_CODES_SUCCESS = '[Common] Find StateCodes Success';

  findStateCodesSuccess(codes): Action {
    console.log("findStateCodesSuccess");
    return {
      type: SetupActions.FIND_STATE_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_STATE_CODE = '[Setup] Save State Code';

  saveStateCode(code): Action {
    console.log("saveStateCode");
    return {
      type: SetupActions.SAVE_STATE_CODE,
      payload: code
    };
  }

  static FIND_STATE_CODES = '[Common] Find StateCodes';

  findStateCodes(): Action {
    console.log("findStateCodes");
    return {
      type: SetupActions.FIND_STATE_CODES,
    };
  }

  static FIND_PROGRAM_CODES = '[Common] Find ProgramCodes';

  findProgramCodes(): Action {
    console.log("findProgramCodes");
    return {
      type: SetupActions.FIND_PROGRAM_CODES,
    };
  }

  static FIND_PROGRAM_CODES_SUCCESS = '[Common] Find ProgramCodes Success';

  findProgramCodesSuccess(codes): Action {
    console.log("findProgramCodesSuccess");
    return {
      type: SetupActions.FIND_PROGRAM_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_PROGRAM_CODE = '[Setup] Save Program Code';

  saveProgramCode(code): Action {
    console.log("saveProgramCode");
    return {
      type: SetupActions.SAVE_PROGRAM_CODE,
      payload: code
    };
  }

  static SAVE_PROGRAM_CODE_SUCCESS = '[Setup] Save Program Code Success';

  saveProgramCodeSuccess(message): Action {
    console.log("saveProgramCodeSuccess");
    return {
      type: SetupActions.SAVE_PROGRAM_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_PROGRAM_CODE = '[Setup] Remove Program Code';

  removeProgramCode(code): Action {
    console.log("removeProgramCode");
    return {
      type: SetupActions.REMOVE_PROGRAM_CODE,
      payload: code
    };
  }

  static REMOVE_PROGRAM_CODE_SUCCESS = '[Setup] Remove Program Code Success';

  removeProgramCodeSuccess(message): Action {
    console.log("removeProgramCodeSuccess");
    return {
      type: SetupActions.REMOVE_PROGRAM_CODE_SUCCESS,
      payload: message
    };
  }


  static SAVE_SUPERVISOR_CODE = '[Setup] Save Supervisor Code';

  saveSupervisorCode(code): Action {
    console.log("saveSupervisorCode");
    return {
      type: SetupActions.SAVE_SUPERVISOR_CODE,
      payload: code
    };
  }

  static SAVE_SUPERVISOR_CODE_SUCCESS = '[Setup] Save Supervisor Code Success';

  saveSupervisorCodeSuccess(message): Action {
    console.log("saveSupervisorCodeSuccess");
    return {
      type: SetupActions.SAVE_SUPERVISOR_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_SUPERVISOR_CODES = '[Common] Find SupervisorCodes';

  findSupervisorCodes(): Action {
    console.log("findSupervisorCodes");
    return {
      type: SetupActions.FIND_SUPERVISOR_CODES,
    };
  }

  static FIND_SUPERVISOR_CODES_SUCCESS = '[Common] Find SupervisorCodes Success';

  findSupervisorCodesSuccess(codes): Action {
    console.log("findSupervisorCodesSuccess");
    return {
      type: SetupActions.FIND_SUPERVISOR_CODES_SUCCESS,
      payload: codes
    };
  }


  static FIND_SUPERVISOR_CODES_BY_FILTER = '[Common] Find SupervisorCodes By Filter';

  findSupervisorCodesByFilter(filter): Action {
    console.log("findSupervisorCodesByFilter");
    return {
      type: SetupActions.FIND_SUPERVISOR_CODES_BY_FILTER,
      payload: filter
    };
  }

  static FIND_SUPERVISOR_CODES_BY_FILTER_SUCCESS = '[Common] Find SupervisorCodes By Filter Success';

  findSupervisorCodesByFilterSuccess(codes): Action {
    console.log("findSupervisorCodesByFilterSuccess");
    return {
      type: SetupActions.FIND_SUPERVISOR_CODES_BY_FILTER_SUCCESS,
      payload: codes
    };
  }


  static REMOVE_SUPERVISOR_CODE = '[Setup] Remove Supervisor Code';

  removeSupervisorCode(code): Action {
    console.log("removeSupervisorCode");
    return {
      type: SetupActions.REMOVE_SUPERVISOR_CODE,
      payload: code
    };
  }

  static REMOVE_SUPERVISOR_CODE_SUCCESS = '[Setup] Remove Supervisor Code Success';

  removeSupervisorCodeSuccess(message): Action {
    console.log("removeSupervisorCodeSuccess");
    return {
      type: SetupActions.REMOVE_SUPERVISOR_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_SUPERVISOR_CODE = '[Setup] Update Supervisor Code';

  updateSupervisorCode(code): Action {
    console.log("updateSupervisorCode");
    return {
      type: SetupActions.UPDATE_SUPERVISOR_CODE,
      payload: code
    };
  }

  static UPDATE_SUPERVISOR_CODE_SUCCESS = '[Setup] Update Supervisor Code Success';

  updateSupervisorCodeSuccess(message): Action {
    console.log("updateSupervisorCodeSuccess");
    return {
      type: SetupActions.UPDATE_SUPERVISOR_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_RACE_CODES = '[Common] Find RaceCodes';

  findRaceCodes(): Action {
    console.log("findRaceCodes");
    return {
      type: SetupActions.FIND_RACE_CODES,
    };
  }

  static FIND_RACE_CODES_SUCCESS = '[Common] Find Race Codes Success';

  findRaceCodesSuccess(codes): Action {
    console.log("findRaceCodesSuccess");
    return {
      type: SetupActions.FIND_RACE_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_RACE_CODE = '[Setup] Save Race Code';

  saveRaceCode(code): Action {
    console.log("saveRaceCode");
    return {
      type: SetupActions.SAVE_RACE_CODE,
      payload: code
    };
  }

  static SAVE_RACE_CODE_SUCCESS = '[Setup] Save Race Code Success';

  saveRaceCodeSuccess(message): Action {
    console.log("saveRaceCodeSuccess");
    return {
      type: SetupActions.SAVE_RACE_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_GENDER_CODES = '[Common] Find Gender Codes';

  findGenderCodes(): Action {
    console.log("findGenderCodes");
    return {
      type: SetupActions.FIND_GENDER_CODES,
    };
  }

  static FIND_GENDER_CODES_SUCCESS = '[Common] Find Gender Codes Success';

  findGenderCodesSuccess(codes): Action {
    console.log("findGenderCodesSuccess");
    return {
      type: SetupActions.FIND_GENDER_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_GENDER_CODE = '[Setup] Save Gender Code';

  saveGenderCode(code): Action {
    console.log("saveGenderCode");
    return {
      type: SetupActions.SAVE_GENDER_CODE,
      payload: code
    };
  }

  static SAVE_GENDER_CODE_SUCCESS = '[Setup] Save Gender Code Success';

  saveGenderCodeSuccess(message): Action {
    console.log("saveGenderCodeSuccess");
    return {
      type: SetupActions.SAVE_GENDER_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_ETHNICITY_CODES = '[Common] Find Gender Codes';

  findEthnicityCodes(): Action {
    console.log("findEthnicityCodes");
    return {
      type: SetupActions.FIND_ETHNICITY_CODES,
    };
  }

  static FIND_ETHNICITY_CODES_SUCCESS = '[Common] Find Ethnicity Codes Success';

  findEthnicityCodesSuccess(codes): Action {
    console.log("findEthnicityCodesSuccess");
    return {
      type: SetupActions.FIND_ETHNICITY_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_ETHNICITY_CODE = '[Setup] Save Ethnicity Code';

  saveEthnicityCode(code): Action {
    console.log("saveEthnicityCode");
    return {
      type: SetupActions.SAVE_ETHNICITY_CODE,
      payload: code
    };
  }

  static SAVE_ETHNICITY_CODE_SUCCESS = '[Setup] Save Ethnicity Code Success';

  saveEthnicityCodeSuccess(message): Action {
    console.log("saveEthnicityCodeSuccess");
    return {
      type: SetupActions.SAVE_ETHNICITY_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_NATIONALITY_CODES = '[Common] Find Nationality Codes';

  findNationalityCodes(): Action {
    console.log("findNationalityCodes");
    return {
      type: SetupActions.FIND_NATIONALITY_CODES,
    };
  }

  static FIND_NATIONALITY_CODES_SUCCESS = '[Common] Find Nationality Codes Success';

  findNationalityCodesSuccess(codes): Action {
    console.log("findNationalityCodesSuccess");
    return {
      type: SetupActions.FIND_NATIONALITY_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_NATIONALITY_CODE = '[Setup] Save Nationality Code';

  saveNationalityCode(code): Action {
    console.log("saveNationalityCode");
    return {
      type: SetupActions.SAVE_NATIONALITY_CODE,
      payload: code
    };
  }

  static SAVE_NATIONALITY_CODE_SUCCESS = '[Setup] Save Nationality Code Success';

  saveNationalityCodeSuccess(message): Action {
    console.log("saveNationalityCodeSuccess");
    return {
      type: SetupActions.SAVE_NATIONALITY_CODE_SUCCESS,
      payload: message
    };
  }

  static SAVE_FACULTY_CODE = '[Setup] Save Faculty Code';

  saveFacultyCode(code): Action {
    console.log("saveFacultyCode");
    return {
      type: SetupActions.SAVE_FACULTY_CODE,
      payload: code
    };
  }

  static SAVE_FACULTY_CODE_SUCCESS = '[Setup] Save Faculty Code Success';

  saveFacultyCodeSuccess(message): Action {
    console.log("saveFacultyCodeSuccess");
    return {
      type: SetupActions.SAVE_FACULTY_CODE_SUCCESS,
      payload: message
    };
  }

  static FIND_FACULTY_CODES = '[Common] Find Faculty Codes';

  findFacultyCodes(): Action {
    console.log("findFacultyCodes");
    return {
      type: SetupActions.FIND_FACULTY_CODES,
    };
  }

  static FIND_FACULTY_CODES_SUCCESS = '[Common] Find SupervisorCodes Success';

  findFacultyCodesSuccess(codes): Action {
    console.log("findFacultyCodesSuccess");
    return {
      type: SetupActions.FIND_FACULTY_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_STUDY_MODE = '[Setup] Save Study Mode';

  saveStudyMode(code): Action {
    console.log("saveStudyMode");
    return {
      type: SetupActions.SAVE_STUDY_MODE,
      payload: code
    };
  }

  static SAVE_STUDY_MODE_SUCCESS = '[Setup] Save Study Mode Success';

  saveStudyModeSuccess(message): Action {
    console.log("saveStudyModeSuccess");
    return {
      type: SetupActions.SAVE_STUDY_MODE_SUCCESS,
      payload: message
    };
  }

  static FIND_STUDY_MODES = '[Common] Find Study Modes';

  findStudyModes(): Action {
    console.log("findStudyModes");
    return {
      type: SetupActions.FIND_STUDY_MODES,
    };
  }

  static FIND_STUDY_MODES_SUCCESS = '[Common] Find Study Modes Success';

  findStudyModesSuccess(codes): Action {
    console.log("findStudyModesSuccess");
    return {
      type: SetupActions.FIND_STUDY_MODES_SUCCESS,
      payload: codes
    };
  }

//=================================================================================//
//  DISABILITY_CODES                                                               //
//=================================================================================//

  static FIND_DISABILITY_CODES = '[Setup] Find Disability Codes';

  findDisabilityCodes(): Action {
    console.log("findDisabilityCodes");
    return {
      type: SetupActions.FIND_DISABILITY_CODES,
    };
  }

  static FIND_DISABILITY_CODES_SUCCESS = '[Setup] Find Disability Codes Success';

  findDisabilityCodesSuccess(codes): Action {
    console.log("findDisabilityCodesSuccess");
    return {
      type: SetupActions.FIND_DISABILITY_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_DISABILITY_CODE = '[Setup] Save Disability Code';

  saveDisabilityCode(code): Action {
    console.log("saveDisabilityCode");
    return {
      type: SetupActions.SAVE_DISABILITY_CODE,
      payload: code
    };
  }

  static SAVE_DISABILITY_CODE_SUCCESS = '[Setup] Save Disability Code Success';

  saveDisabilityCodeSuccess(message): Action {
    console.log("saveDisabilityCodeSuccess");
    return {
      type: SetupActions.SAVE_DISABILITY_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_DISABILITY_CODE = '[Setup] Update Disability Code';

  updateDisabilityCode(code): Action {
    console.log("updateDisabilityCode");
    return {
      type: SetupActions.UPDATE_DISABILITY_CODE,
      payload: code
    };
  }

  static UPDATE_DISABILITY_CODE_SUCCESS = '[Setup] Update Disability Code  Success';

  updateDisabilityCodeSuccess(message): Action {
    console.log("updateDisabilityCodeSuccess");
    return {
      type: SetupActions.UPDATE_DISABILITY_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_DISABILITY_CODE = '[Setup] Remove Disability Code';

  removeDisabilityCode(code): Action {
    console.log("removeDisabilityCode");
    return {
      type: SetupActions.REMOVE_DISABILITY_CODE,
      payload: code
    };
  }

  static REMOVE_DISABILITY_CODE_SUCCESS = '[Setup] Remove Disability Code  Success';

  removeDisabilityCodeSuccess(message): Action {
    console.log("removeDisabilityCodeSuccess");
    return {
      type: SetupActions.REMOVE_DISABILITY_CODE_SUCCESS,
      payload: message
    };
  }

//=================================================================================//
//  SCHOOL_CODES                                                                   //
//=================================================================================//

  static FIND_SCHOOL_CODES = '[Setup] Find School Codes';

  findSchoolCodes(): Action {
    console.log("findSchoolCodes");
    return {
      type: SetupActions.FIND_SCHOOL_CODES,
    };
  }

  static FIND_SCHOOL_CODES_SUCCESS = '[Setup] Find School Codes Success';

  findSchoolCodesSuccess(codes): Action {
    console.log("findSchoolCodesSuccess");
    return {
      type: SetupActions.FIND_SCHOOL_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_SCHOOL_CODE = '[Setup] Save School Code';

  saveSchoolCode(code): Action {
    console.log("saveSchoolCode");
    return {
      type: SetupActions.SAVE_SCHOOL_CODE,
      payload: code
    };
  }

  static SAVE_SCHOOL_CODE_SUCCESS = '[Setup] Save School Code Success';

  saveSchoolCodeSuccess(message): Action {
    console.log("saveSchoolCodeSuccess");
    return {
      type: SetupActions.SAVE_SCHOOL_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_SCHOOL_CODE = '[Setup] Update School Code';

  updateSchoolCode(code): Action {
    console.log("updateSchoolCode");
    return {
      type: SetupActions.UPDATE_SCHOOL_CODE,
      payload: code
    };
  }

  static UPDATE_SCHOOL_CODE_SUCCESS = '[Setup] Update School Code  Success';

  updateSchoolCodeSuccess(message): Action {
    console.log("updateSchoolCodeSuccess");
    return {
      type: SetupActions.UPDATE_SCHOOL_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_SCHOOL_CODE = '[Setup] Remove School Code';

  removeSchoolCode(code): Action {
    console.log("removeSchoolCode");
    return {
      type: SetupActions.REMOVE_SCHOOL_CODE,
      payload: code
    };
  }

  static REMOVE_SCHOOL_CODE_SUCCESS = '[Setup] Remove School Code  Success';

  removeSchoolCodeSuccess(message): Action {
    console.log("removeSchoolCodeSuccess");
    return {
      type: SetupActions.REMOVE_SCHOOL_CODE_SUCCESS,
      payload: message
    };
  }

    static FIND_STUDY_CENTER_CODES = '[Setup] Find Study Center Codes';

  findStudyCenterCodes(): Action {
    console.log("findStudyCenterCodes");
    return {
      type: SetupActions.FIND_STUDY_CENTER_CODES,
    };
  }

  static FIND_STUDY_CENTER_CODES_SUCCESS = '[Setup] Study Center Codes Success';

  findStudyCenterCodesSuccess(codes): Action {
    console.log("findStudyCenterCodesSuccess");
    return {
      type: SetupActions.FIND_STUDY_CENTER_CODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_STUDY_CENTER_CODE = '[Setup] Save Study Center Code';

  saveStudyCenterCode(code): Action {
    console.log("saveStudyCenterCode");
    return {
      type: SetupActions.SAVE_STUDY_CENTER_CODE,
      payload: code
    };
  }

 static SAVE_STUDY_CENTER_CODE_SUCCESS = '[Setup] Save Study Center Code Success';

  saveStudyCenterCodeSuccess(message): Action {
    console.log("saveStudyCenterCodeSuccess");
    return {
      type: SetupActions.SAVE_STUDY_CENTER_CODE_SUCCESS,
      payload: message
    };
  }

static UPDATE_STUDY_CENTER_CODE = '[Setup] Update Study Center Code';

  updateStudyCenterCode(code): Action {
    console.log("updateStudyCenterCode");
    return {
      type: SetupActions.UPDATE_STUDY_CENTER_CODE,
      payload: code
    };
  }

static UPDATE_STUDY_CENTER_CODE_SUCCESS = '[Setup] Update Study Center Code Success';

  updateStudyCenterCodeSuccess(message): Action {
    console.log("updateStudyCenterCodeSuccess");
    return {
      type: SetupActions.UPDATE_STUDY_CENTER_CODE_SUCCESS,
      payload: message
    };
  }

static REMOVE_STUDY_CENTER_CODE = '[Setup] Remove Study Center Code';

  removeStudyCenterCode(code): Action {
    console.log("removeStudyCenterCode");
    return {
      type: SetupActions.REMOVE_STUDY_CENTER_CODE,
      payload: code
    };
  }

static REMOVE_STUDY_CENTER_CODE_SUCCESS = '[Setup] Remove Study Center Code Success';

  removeStudyCenterCodeSuccess(message): Action {
    console.log("removeStudyCenterCodeSuccess");
    return {
      type: SetupActions.REMOVE_STUDY_CENTER_CODE_SUCCESS,
      payload: message
    };
  }

}
