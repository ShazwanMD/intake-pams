import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {IntakeApplication} from '../../../shared/model/application/intake-application.interface';

export type IntakeRejectedApplicationListState = IntakeApplication[];

const initialState: IntakeRejectedApplicationListState = <IntakeApplication[]>[];

export function intakeRejectedApplicationListReducer(state = initialState, action: Action): IntakeRejectedApplicationListState {
  switch (action.type) {
    case IntakeActions.FIND_REJECTED_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
