import { NationalityCode } from './../../common/nationality-codes/nationality-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";

export type NationalityCodeListState = NationalityCode[];

const initialState: NationalityCodeListState = <NationalityCode[]>[];

export function nationalityCodeListReducer(state = initialState, action: Action): NationalityCodeListState {
  switch (action.type) {
    case SetupActions.FIND_NATIONALITY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
