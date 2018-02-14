import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {ProgramFieldCode} from "../../../shared/model/common/program-field-code.interface";

export type ProgramFieldCodeListState = ProgramFieldCode[];

const initialState: ProgramFieldCodeListState = <ProgramFieldCode[]>[];

export function programFieldCodeListReducer(state = initialState, action: Action): ProgramFieldCodeListState {
  switch (action.type) {
    case SetupActions.FIND_PROGRAM_FIELD_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
