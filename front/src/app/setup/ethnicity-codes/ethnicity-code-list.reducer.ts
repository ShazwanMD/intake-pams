import { EthnicityCode } from './../../common/ethnicity-codes/ethnicity-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";



export type EthnicityCodeListState = EthnicityCode[];

const initialState: EthnicityCodeListState = <EthnicityCode[]>[];

export function ethnicityCodeListReducer(state = initialState, action: Action): EthnicityCodeListState {
  switch (action.type) {
    case SetupActions.FIND_ETHNICITY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
