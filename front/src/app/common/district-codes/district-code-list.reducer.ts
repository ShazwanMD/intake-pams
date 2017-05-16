import {Action} from '@ngrx/store';
import {CommonActions} from "../common.action";
import { DistrictCode } from "./district-code.interface";

export type DistrictCodeListState = DistrictCode[];

const initialState: DistrictCodeListState = <DistrictCode[]>[];

export function districtCodeListReducer(state = initialState, action: Action): DistrictCodeListState {
  switch (action.type) {
    case CommonActions.FIND_DISTRICT_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
