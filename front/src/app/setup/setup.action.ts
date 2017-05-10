import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';

@Injectable()
export class SetupActions {

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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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
      payload:code
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

  static SAVE_SUPERVISOR_CODE = '[Setup] Save Supervisor Code';

  saveSupervisorCode(code): Action {
    console.log("saveSupervisorCode");
    return {
      type: SetupActions.SAVE_SUPERVISOR_CODE,
      payload:code
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

 static SAVE_SUPERVISOR_CODE_SUCCESS = '[Setup] Save Supervisor Code Success';

saveSupervisorCodeSuccess(message): Action {
  console.log("saveSupervisorCodeSuccess");
  return {
      type: SetupActions.SAVE_SUPERVISOR_CODE_SUCCESS,
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
      payload:code
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
      payload:code
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

}