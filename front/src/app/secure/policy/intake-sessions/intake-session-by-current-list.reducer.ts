import {Action} from '@ngrx/store';
import {IntakeSessionActions} from './intake-session.action';
import {IntakeSession} from '../../../shared/model/policy/intake-session.interface';

export type IntakeSessionByCurrentListState = IntakeSession[];

const initialState: IntakeSessionByCurrentListState = <IntakeSession[]>[];

export function intakeSessionByCurrentListReducer(state = initialState, action: Action): IntakeSessionByCurrentListState {
  switch (action.type) {
    case IntakeSessionActions.FIND_INTAKE_SESSIONS_BY_CURRENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
