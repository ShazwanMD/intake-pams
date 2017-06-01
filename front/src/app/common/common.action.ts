import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';

@Injectable()
export class CommonActions {

  static FIND_DUN_CODES = '[Common] Find DunCodes';

  findDunCodes(): Action {
    console.log("findDunCodes");
    return {
      type: CommonActions.FIND_DUN_CODES
    };
  }

  static FIND_DUN_CODES_SUCCESS = '[Common] Find DunCodes Success';

  findDunCodesSuccess(codes): Action {
    console.log("findDunCodesSuccess");
    return {
      type: CommonActions.FIND_DUN_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_PARLIAMENT_CODES = '[Common] Find ParliamentCodes';

  findParliamentCodes(): Action {
    console.log("findParliamentCodes");
    return {
      type: CommonActions.FIND_PARLIAMENT_CODES
    };
  }

  static FIND_PARLIAMENT_CODES_SUCCESS = '[Common] Find ParliamentCodes Success';

  findParliamentCodesSuccess(codes): Action {
    console.log("findParliamentCodesSuccess");
    return {
      type: CommonActions.FIND_PARLIAMENT_CODES_SUCCESS,
      payload: codes
    };
  }


  static FIND_GENDER_CODES = '[Common] Find Gender Codes';

  findGenderCodes(): Action {
    console.log("findGenderCodes");
    return {
      type: CommonActions.FIND_GENDER_CODES,
    };
  }

  static FIND_GENDER_CODES_SUCCESS = '[Common] Find Gender Codes Success';

  findGenderCodesSuccess(codes): Action {
    console.log("findGenderCodesSuccess");
    return {
      type: CommonActions.FIND_GENDER_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_BANK_CODES = '[Common] Find Bank Codes';

  findBankCodes(): Action {
    console.log("findBankCodes");
    return {
      type: CommonActions.FIND_BANK_CODES,
    };
  }

  static FIND_BANK_CODES_SUCCESS = '[Common] Find Bank Codes Success';

  findBankCodesSuccess(codes): Action {
    console.log("findBankCodesSuccess");
    return {
      type: CommonActions.FIND_BANK_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_MARITAL_CODES = '[Common] Find Marital Codes';

  findMaritalCodes(): Action {
    console.log("findMaritalCodes");
    return {
      type: CommonActions.FIND_MARITAL_CODES,
    };
  }

  static FIND_MARITAL_CODES_SUCCESS = '[Common] Find Marital Codes Success';

  findMaritalCodesSuccess(codes): Action {
    console.log("findMaritalCodesSuccess");
    return {
      type: CommonActions.FIND_MARITAL_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_LANGUAGE_CODES = '[Common] Find Language Codes';

  findLanguageCodes(): Action {
    console.log("findLanguageCodes");
    return {
      type: CommonActions.FIND_LANGUAGE_CODES,
    };
  }

  static FIND_LANGUAGE_CODES_SUCCESS = '[Common] Find Language Codes Success';

  findLanguageCodesSuccess(codes): Action {
    console.log("findLanguageCodesSuccess");
    return {
      type: CommonActions.FIND_LANGUAGE_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_DISABILITY_CODES = '[Common] Find Disability Codes';

  findDisabilityCodes(): Action {
    console.log("findDisabilityCodes");
    return {
      type: CommonActions.FIND_DISABILITY_CODES,
    };
  }

  static FIND_DISABILITY_CODES_SUCCESS = '[Common] Find Disability Codes Success';

  findDisabilityCodesSuccess(codes): Action {
    console.log("findDisabilityCodesSuccess");
    return {
      type: CommonActions.FIND_DISABILITY_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_SCHOOL_CODES = '[Common] Find School Codes';

  findSchoolCodes(): Action {
    console.log("findSchoolCodes");
    return {
      type: CommonActions.FIND_SCHOOL_CODES,
    };
  }

  static FIND_SCHOOL_CODES_SUCCESS = '[Common] Find School Codes Success';

  findSchoolCodesSuccess(codes): Action {
    console.log("findSchoolCodesSuccess");
    return {
      type: CommonActions.FIND_SCHOOL_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_FACULTY_CODES = '[Common] Find Faculty Codes';

  findFacultyCodes(): Action {
    console.log("findFacultyCodes");
    return {
      type: CommonActions.FIND_FACULTY_CODES,
    };
  }

  static FIND_FACULTY_CODES_SUCCESS = '[Common] Find Faculty Codes Success';

  findFacultyCodesSuccess(codes): Action {
    console.log("findFacultyCodesSuccess");
    return {
      type: CommonActions.FIND_FACULTY_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_GRADUATE_CENTRES = '[Common] Find Graduate Centres';

  findGraduateCentres(): Action {
    console.log("findGraduateCentres");
    return {
      type: CommonActions.FIND_GRADUATE_CENTRES,
    };
  }

  static FIND_GRADUATE_CENTRES_SUCCESS = '[Common] Find Graduate Centres Success';

  findGraduateCentresSuccess(centres): Action {
    console.log("findGraduateCentresSuccess");
    return {
      type: CommonActions.FIND_GRADUATE_CENTRES_SUCCESS,
      payload: centres
    };
  }

  static FIND_PROGRAM_CODES = '[Common] Find Program Codes';

  findProgramCodes(): Action {
    console.log("findProgramCodes");
    return {
      type: CommonActions.FIND_PROGRAM_CODES,
    };
  }

  static FIND_PROGRAM_CODES_SUCCESS = '[Common] Find Program Codes Success';

  findProgramCodesSuccess(codes): Action {
    console.log("findProgramCodesSuccess");
    return {
      type: CommonActions.FIND_PROGRAM_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_SUPERVISOR_CODES = '[Common] Find Supervisor Codes';

  findSupervisorCodes(): Action {
    console.log("findSupervisorCodes");
    return {
      type: CommonActions.FIND_SUPERVISOR_CODES,
    };
  }

  static FIND_SUPERVISOR_CODES_SUCCESS = '[Common] Find Supervisor Codes Success';

  findSupervisorCodesSuccess(codes): Action {
    console.log("findSupervisorCodesSuccess");
    return {
      type: CommonActions.FIND_SUPERVISOR_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_STUDY_MODES = '[Common] Find Study Modes';

  findStudyModes(): Action {
    console.log("findStudyModes");
    return {
      type: CommonActions.FIND_STUDY_MODES,
    };
  }

  static FIND_STUDY_MODES_SUCCESS = '[Common] Find Study Modes Success';

  findStudyModeSuccess(codes): Action {
    console.log("findStudyModeSuccess");
    return {
      type: CommonActions.FIND_STUDY_MODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_RACE_CODES = '[Common] Find Race Codes';

  findRaceCodes(): Action {
    console.log("findRaceCodes");
    return {
      type: CommonActions.FIND_RACE_CODES,
    };
  }

  static FIND_RACE_CODES_SUCCESS = '[Common] Find Race Codes Success';

  findRaceCodesSuccess(codes): Action {
    console.log("findRaceCodesSuccess");
    return {
      type: CommonActions.FIND_RACE_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_STATE_CODES = '[Common] Find State Codes';

  findStateCodes(): Action {
    console.log("findStateCodes");
    return {
      type: CommonActions.FIND_STATE_CODES,
    };
  }

  static FIND_STATE_CODES_SUCCESS = '[Common] Find State Codes Success';

  findStateCodesSuccess(codes): Action {
    console.log("findStateCodesSuccess");
    return {
      type: CommonActions.FIND_STATE_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_COUNTRY_CODES = '[Common] Find Country Codes';

  findCountryCodes(): Action {
    console.log("findCountryCodes");
    return {
      type: CommonActions.FIND_COUNTRY_CODES,
    };
  }

  static FIND_COUNTRY_CODES_SUCCESS = '[Common] Find Country Codes Success';

  findCountryCodesSuccess(codes): Action {
    console.log("findCountryCodesSuccess");
    return {
      type: CommonActions.FIND_COUNTRY_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_STUDY_CENTER_CODES = '[Common] Find Study Center Codes';

  findStudyCenterCodes(): Action {
    console.log("findStudyCenterCodes");
    return {
      type: CommonActions.FIND_STUDY_CENTER_CODES,
    };
  }

  static FIND_STUDY_CENTER_CODES_SUCCESS = '[Common] Find Study Center Codes Success';

  findStudyCenterCodesSuccess(codes): Action {
    console.log("findStudyCenterCodesSuccess");
    return {
      type: CommonActions.FIND_STUDY_CENTER_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_RELIGION_CODES = '[Common] Find Religion Codes';

  findReligionCodes(): Action {
    console.log("findReligionCodes");
    return {
      type: CommonActions.FIND_RELIGION_CODES,
    };
  }

  static FIND_RELIGION_CODES_SUCCESS = '[Common] Find Religion Codes Success';

  findReligionCodesSuccess(codes): Action {
    console.log("findReligionCodesSuccess");
    return {
      type: CommonActions.FIND_RELIGION_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_ETHNICITY_CODES = '[Common] Find Ethnicity Codes';

  findEthnicityCodes(): Action {
    console.log("findEthnicityCodes");
    return {
      type: CommonActions.FIND_ETHNICITY_CODES,
    };
  }

  static FIND_ETHNICITY_CODES_SUCCESS = '[Common] Find Ethnicity Codes Success';

  findEthnicityCodesSuccess(codes): Action {
    console.log("findEthnicityCodesSuccess");
    return {
      type: CommonActions.FIND_ETHNICITY_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_NATIONALITY_CODES = '[Common] Find Nationality Codes';

  findNationalityCodes(): Action {
    console.log("findNationalityCodes");
    return {
      type: CommonActions.FIND_NATIONALITY_CODES,
    };
  }

  static FIND_NATIONALITY_CODES_SUCCESS = '[Common] Find Nationality Codes Success';

  findNationalityCodesSuccess(codes): Action {
    console.log("findNationalityCodesSuccess");
    return {
      type: CommonActions.FIND_NATIONALITY_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_RESIDENCY_CODES = '[Common] Find Residency Codes';

  findResidencyCodes(): Action {
    console.log("findResidencyCodes");
    return {
      type: CommonActions.FIND_RESIDENCY_CODES,
    };
  }

  static FIND_RESIDENCY_CODES_SUCCESS = '[Common] Find Residency Codes Success';

  findResidencyCodesSuccess(codes): Action {
    console.log("findResidencyCodesSuccess");
    return {
      type: CommonActions.FIND_RESIDENCY_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_SUBJECT_CODES = '[Common] Find Subject Codes';

  findSubjectCodes(): Action {
    console.log("findSubjectCodes");
    return {
      type: CommonActions.FIND_SUBJECT_CODES,
    };
  }

  static FIND_SUBJECT_CODES_SUCCESS = '[Common] Find Subject Codes Success';

  findSubjectCodesSuccess(codes): Action {
    console.log("findSubjectCodesSuccess");
    return {
      type: CommonActions.FIND_SUBJECT_CODES_SUCCESS,
      payload: codes
    };
  }
}
