import { ReligionCode } from "./../../common/religion-codes/religion-code.interface";
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";

export type ReligionCodeListState = ReligionCode[];

const initialState: ReligionCodeListState = <ReligionCode[]>[];

export function religionCodeListReducer(state = initialState, action: Action): ReligionCodeListState {
  switch (action.type) {
    case SetupActions.FIND_RELIGION_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
