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

  religionBankCode(code): Action {
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

}