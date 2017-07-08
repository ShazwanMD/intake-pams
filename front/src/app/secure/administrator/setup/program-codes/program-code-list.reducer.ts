import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {ProgramCode} from "../../../../shared/model/common/program-code.interface";

export type ProgramCodeListState = ProgramCode[];

const initialState: ProgramCodeListState = <ProgramCode[]>[];

export function programCodeListReducer(state = initialState, action: Action): ProgramCodeListState {
  switch (action.type) {
    case SetupActions.FIND_PROGRAM_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
