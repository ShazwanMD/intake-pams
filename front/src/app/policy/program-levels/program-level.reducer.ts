import {Action} from '@ngrx/store';
import {ProgramLevelActions} from './program-level.action';
import {ProgramLevel} from '../../shared/model/policy/program-level.interface';

export type ProgramLevelListState = ProgramLevel[];

const initialState: ProgramLevelListState = <ProgramLevel[]>[];

export function programLevelListReducer(state = initialState, action: Action): ProgramLevelListState {
  switch (action.type) {
    case ProgramLevelActions.FIND_PROGRAM_LEVELS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
