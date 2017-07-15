import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {Intake} from '../../../shared/model/policy/intake.interface';

export type IntakeState = Intake;

const initialState: IntakeState = <IntakeState>{};

export function intakeReducer(state = initialState, action: Action): IntakeState {
  switch (action.type) {
    case IntakeActions.FIND_INTAKE_BY_ID_SUCCESS: {
      return action.payload;
    }
    case IntakeActions.FIND_INTAKE_BY_REFERENCE_NO_SUCCESS: {
      return action.payload;
    }
    case IntakeActions.FIND_SUBMITTED_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
