import {Action} from '@ngrx/store';
import {IntakeSessionActions} from './intake-session.action';
import {IntakeSession} from '../../../shared/model/policy/intake-session.interface';

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
