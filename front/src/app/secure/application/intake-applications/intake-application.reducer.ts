import {Action} from '@ngrx/store';
import {IntakeApplication} from '../../../shared/model/application/intake-application.interface';
import {IntakeApplicationActions} from './intake-application.action';

export type IntakeApplicationState = IntakeApplication;

const initialState: IntakeApplicationState = <IntakeApplicationState>{};

export function intakeApplicationReducer(state = initialState, action: Action): IntakeApplicationState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO_SUCCESS: {
      return action.payload;
    }
    case IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_CANDIDATE_SUCCESS: {
        return action.payload;
      }
    default: {
      return state;
    }
  }
}
