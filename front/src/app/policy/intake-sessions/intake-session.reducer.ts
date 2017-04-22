import {Action} from '@ngrx/store';
import {IntakeSession} from "./intake-session.interface";
import {IntakeSessionActions} from "./intake-session.action";

export type IntakeSessionListState = IntakeSession[];

const initialState: IntakeSessionListState = <IntakeSession[]>[];

export function intakeSessionListReducer(state = initialState, action: Action): IntakeSessionListState {
  switch (action.type) {
    case IntakeSessionActions.FIND_INTAKE_SESSIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
