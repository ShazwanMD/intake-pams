import {Action} from '@ngrx/store';
import {SupervisorCode} from "./supervisor-code.interface";
import {CommonActions} from "../common.action";

export type SupervisorCodeListState = SupervisorCode[];

const initialState: SupervisorCodeListState = <SupervisorCode[]>[];

export function supervisorCodeListReducer(state = initialState, action: Action): SupervisorCodeListState {
  switch (action.type) {
    case CommonActions.FIND_SUPERVISOR_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
