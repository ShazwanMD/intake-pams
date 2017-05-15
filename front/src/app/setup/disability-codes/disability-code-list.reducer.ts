import { DisabilityCode } from './../../common/disability-codes/disability-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";

export type DisabilityCodeListState = DisabilityCode[];

const initialState: DisabilityCodeListState = <DisabilityCode[]>[];

export function disabilityCodeListReducer(state = initialState, action: Action): DisabilityCodeListState {
  switch (action.type) {
    case SetupActions.FIND_DISABILITY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}