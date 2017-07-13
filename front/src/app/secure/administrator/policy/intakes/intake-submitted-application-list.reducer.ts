import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';

export type IntakeSubmittedApplicationListState = IntakeApplication[];

const initialState: IntakeSubmittedApplicationListState = <IntakeApplication[]>[];

export function intakeSubmittedApplicationListReducer(state = initialState, action: Action): IntakeSubmittedApplicationListState {
  switch (action.type) {
    case IntakeActions.FIND_SUBMITTED_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
