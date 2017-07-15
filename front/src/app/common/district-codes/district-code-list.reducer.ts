import {Action} from '@ngrx/store';
import {DistrictCode} from "../../shared/model/common/district-code.interface";
import {SetupActions} from "../../secure/setup/setup.action";


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
