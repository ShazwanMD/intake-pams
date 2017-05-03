import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';
@Injectable()
//test
export class CentreActions {

  static FIND_GRADUATE_CENTRE_BY_CODE = '[Centre] Find Graduate Centre By Code';

  findGraduateCentreByCode(code): Action {
    console.log("findGraduateCentreByCode");
    return {
      type: CentreActions.FIND_GRADUATE_CENTRE_BY_CODE,
      payload: code
    };
  }

  static FIND_GRADUATE_CENTRE_BY_CODE_SUCCESS = '[Centre] Find Graduate Centre By Code Success';

  findGraduateCentreByCodeSuccess(centre): Action {
    console.log("findGraduateCentreByCodeSuccess");
    return {
      type: CentreActions.FIND_GRADUATE_CENTRE_BY_CODE_SUCCESS,
      payload: centre
    };
  }

  static FIND_GRADUATE_CENTRES = '[Centre] Find Graduate Centres';

  findGraduateCentres(): Action {
    console.log("findGraduateCentres");
    return {
      type: CentreActions.FIND_GRADUATE_CENTRES,
    };
  }

  static FIND_GRADUATE_CENTRES_SUCCESS = '[Centre] Find Gradudate Centres Success';

  findGraduateCentresSuccess(centres): Action {
    console.log("findGraduateCentresSuccess");
    return {
      type: CentreActions.FIND_GRADUATE_CENTRES_SUCCESS,
      payload: centres
    };
  }

  static FIND_FACULTY_CODE_BY_CODE = '[Centre] Find Faculty Code By Code';

  findFacultyCodeByCode(code): Action {
    console.log("findFacultyCodeByCode");
    return {
      type: CentreActions.FIND_FACULTY_CODE_BY_CODE,
      payload: code
    };
  }

  static FIND_FACULTY_CODE_BY_CODE_SUCCESS = '[Centre] Find Faculty Code By Code Success';

  findFacultyCodeByCodeSuccess(facultyCode): Action {
    console.log("findFacultyCodeByCodeSuccess");
    return {
      type: CentreActions.FIND_FACULTY_CODE_BY_CODE_SUCCESS,
      payload: facultyCode
    };
  }

  static FIND_PROGRAM_CODES = '[Centre] Find Program Codes';
  findProgramCodes(graduateCentre): Action {
    console.log("findProgramCodes");
    return {
      type: CentreActions.FIND_PROGRAM_CODES,
      payload: graduateCentre
    };
  }

  static FIND_PROGRAM_CODES_SUCCESS = '[Centre] Find Program Codes Success';

  findProgramCodesSuccess(programCodes): Action {
    console.log("findProgramCodesSuccess");
    return {
      type: CentreActions.FIND_PROGRAM_CODES_SUCCESS,
      payload: programCodes
    };
  }
}
