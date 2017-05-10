import { GenderCode } from './../../common/gender-codes/gender-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";


export type GenderCodeListState = GenderCode[];

const initialState: GenderCodeListState = <GenderCode[]>[];

export function genderCodeListReducer(state = initialState, action: Action): GenderCodeListState {
  switch (action.type) {
    case SetupActions.FIND_GENDER_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
