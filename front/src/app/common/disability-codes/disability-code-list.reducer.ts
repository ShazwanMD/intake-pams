import {Action} from '@ngrx/store';
import {DisabilityCode} from "./disability-code.interface";
import {CommonActions} from "../common.action";

export type DisabilityCodeListState = DisabilityCode[];

const initialState: DisabilityCodeListState = <DisabilityCode[]>[];

export function disabilityCodeListReducer(state = initialState, action: Action): DisabilityCodeListState {
  switch (action.type) {
    case CommonActions.FIND_DISABILITY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
