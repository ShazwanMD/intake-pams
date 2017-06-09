import {Action} from '@ngrx/store';
import {GraduateCenter} from "./graduate-center.interface";
import {CommonActions} from "../common.action";

export type GraduateCenterListState = GraduateCenter[];

const initialState: GraduateCenterListState = <GraduateCenter[]>[];

export function graduateCenterListReducer(state = initialState, action: Action): GraduateCenterListState {
  switch (action.type) {
    case CommonActions.FIND_GRADUATE_CENTERS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
