import {Action} from '@ngrx/store';
import {Intake} from '../../../shared/model/policy/intake.interface';
import {IntakeApplicationActions} from './intake-application.action';

export type IntakeState = Intake;

const initialState: IntakeState = <IntakeState>{};

export function intakeReducer(state = initialState, action: Action): IntakeState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO_SUCCESS: {
      return action.payload;
    }
    case IntakeApplicationActions.FIND_INTAKE_BY_CANDIDATE_REF_NO_SUCCESS: {
        return action.payload;
      }
    default: {
      return state;
    }
  }
}
