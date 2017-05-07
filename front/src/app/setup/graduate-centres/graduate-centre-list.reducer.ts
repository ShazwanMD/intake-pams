import {Action} from '@ngrx/store';
import {GraduateCentre} from "../../common/graduate-centres/graduate-centre.interface";
import {SetupActions} from "../setup.action";

export type GraduateCentreListState = GraduateCentre[];

const initialState: GraduateCentreListState = <GraduateCentre[]>[];

export function graduateCentreListReducer(state = initialState, action: Action): GraduateCentreListState {
  switch (action.type) {
    case SetupActions.FIND_GRADUATE_CENTRES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
