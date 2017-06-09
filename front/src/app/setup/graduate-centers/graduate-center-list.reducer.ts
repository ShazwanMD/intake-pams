import {Action} from '@ngrx/store';
import {GraduateCenter} from "../../common/graduate-centers/graduate-center.interface";
import {SetupActions} from "../setup.action";

export type GraduateCenterListState = GraduateCenter[];

const initialState: GraduateCenterListState = <GraduateCenter[]>[];

export function graduateCenterListReducer(state = initialState, action: Action): GraduateCenterListState {
  switch (action.type) {
    case SetupActions.FIND_GRADUATE_CENTERS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
