import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';
@Injectable()
export class CommonActions {

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

  findStudyModeCodes(): Action {
    console.log("findStudyModeCodes");
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
}
