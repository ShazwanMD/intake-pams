import { SetupActions } from './../../setup/setup.action';
import {Action} from '@ngrx/store';

import { DistrictCode } from "./district-code.interface";


export type DistrictCodeListState = DistrictCode[];

const initialState: DistrictCodeListState = <DistrictCode[]>[];

export function districtCodeListReducer(state = initialState, action: Action): DistrictCodeListState {
  switch (action.type) {
    case SetupActions.FIND_DISTRICT_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
