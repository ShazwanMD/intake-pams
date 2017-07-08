import {Action} from '@ngrx/store';
import {IntakeApplicationActions} from './intake-application.action';
import {IntakeApplication} from './intake-application.interface';

export type IntakeApplicationListState = IntakeApplication[];

const initialState: IntakeApplicationListState = <IntakeApplication[]>[];

export function intakeApplicationListReducer(state = initialState, action: Action): IntakeApplicationListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
