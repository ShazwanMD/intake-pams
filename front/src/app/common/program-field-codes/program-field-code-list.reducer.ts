import {Action} from '@ngrx/store';
import {ProgramFieldCode} from '../../shared/model/common/program-field-code.interface';
import {CommonActions} from '../common.action';

export type ProgramFieldCodeListState = ProgramFieldCode[];

const initialState: ProgramFieldCodeListState = <ProgramFieldCode[]>[];

export function programFieldCodeListReducer(state = initialState, action: Action): ProgramFieldCodeListState {
  switch (action.type) {
    case CommonActions.FIND_PROGRAM_FIELD_CODES_SUCCESS: {
      return action.payload;
    }
    case CommonActions.FIND_PROGRAM_FIELD_CODES_BY_PROGRAM_LEVEL_SUCCESS: {
        return action.payload;
      }
    default: {
      return state;
    }
  }
}
