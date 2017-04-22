import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';
@Injectable()
export class ProgramLevelActions {

  static FIND_PROGRAM_LEVELS = '[Common] Find Program Levels';

  findProgramLevels(): Action {
    console.log("findProgramLevels");
    return {
      type: ProgramLevelActions.FIND_PROGRAM_LEVELS,
    };
  }

  static FIND_PROGRAM_LEVELS_SUCCESS = '[Common] Find Program Levels Success';

  findProgramLevelsSuccess(levels): Action {
    console.log("findProgramLevelsSuccess");
    return {
      type: ProgramLevelActions.FIND_PROGRAM_LEVELS_SUCCESS,
      payload: levels
    };
  }
}
