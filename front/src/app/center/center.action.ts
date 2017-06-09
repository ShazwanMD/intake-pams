import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';
@Injectable()
//test
export class CenterActions {

  static FIND_GRADUATE_CENTER_BY_CODE = '[Center] Find Graduate Center By Code';

  findGraduateCenterByCode(code): Action {
    console.log("findGraduateCenterByCode");
    return {
      type: CenterActions.FIND_GRADUATE_CENTER_BY_CODE,
      payload: code
    };
  }

  static FIND_GRADUATE_CENTER_BY_CODE_SUCCESS = '[Center] Find Graduate Center By Code Success';

  findGraduateCenterByCodeSuccess(center): Action {
    console.log("findGraduateCenterByCodeSuccess");
    return {
      type: CenterActions.FIND_GRADUATE_CENTER_BY_CODE_SUCCESS,
      payload: center
    };
  }

  static FIND_GRADUATE_CENTERS = '[Center] Find Graduate Centers';

  findGraduateCenters(): Action {
    console.log("findGraduateCenters");
    return {
      type: CenterActions.FIND_GRADUATE_CENTERS,
    };
  }

  static FIND_GRADUATE_CENTERS_SUCCESS = '[Center] Find Gradudate Centers Success';

  findGraduateCentersSuccess(centers): Action {
    console.log("findGraduateCentersSuccess");
    return {
      type: CenterActions.FIND_GRADUATE_CENTERS_SUCCESS,
      payload: centers
    };
  }

  static FIND_FACULTY_CODE_BY_CODE = '[Center] Find Faculty Code By Code';

  findFacultyCodeByCode(code): Action {
    console.log("findFacultyCodeByCode");
    return {
      type: CenterActions.FIND_FACULTY_CODE_BY_CODE,
      payload: code
    };
  }

  static FIND_FACULTY_CODE_BY_CODE_SUCCESS = '[Center] Find Faculty Code By Code Success';

  findFacultyCodeByCodeSuccess(facultyCode): Action {
    console.log("findFacultyCodeByCodeSuccess");
    return {
      type: CenterActions.FIND_FACULTY_CODE_BY_CODE_SUCCESS,
      payload: facultyCode
    };
  }

  static FIND_PROGRAM_CODES = '[Center] Find Program Codes';
  findProgramCodes(graduateCenter): Action {
    console.log("findProgramCodes");
    return {
      type: CenterActions.FIND_PROGRAM_CODES,
      payload: graduateCenter
    };
  }

  static FIND_PROGRAM_CODES_SUCCESS = '[Center] Find Program Codes Success';

  findProgramCodesSuccess(programCodes): Action {
    console.log("findProgramCodesSuccess");
    return {
      type: CenterActions.FIND_PROGRAM_CODES_SUCCESS,
      payload: programCodes
    };
  }
}
