import {Action} from '@ngrx/store';
import {CommonActions} from "../common.action";
import { EthnicityCode } from "./ethnicity-code.interface";

export type EthnicityCodeListState = EthnicityCode[];

const initialState: EthnicityCodeListState = <EthnicityCode[]>[];

export function ethnicityCodeListReducer(state = initialState, action: Action): EthnicityCodeListState {
  switch (action.type) {
    case CommonActions.FIND_ETHNICITY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
