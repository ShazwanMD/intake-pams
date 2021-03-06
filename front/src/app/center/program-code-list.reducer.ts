import {Action} from '@ngrx/store';
import {CenterActions} from './center.action';
import {ProgramCode} from '../shared/model/common/program-code.interface';
import { ProgramFieldCode } from '../shared/model/common/program-field-code.interface';

export type ProgramCodeListState = ProgramCode[];

const initialState: ProgramCodeListState = <ProgramCode[]>[];

export function programCodeListReducer(state = initialState, action: Action): ProgramCodeListState {
  switch (action.type) {
    case CenterActions.FIND_PROGRAM_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
