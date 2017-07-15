import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {IntakeApplication} from '../../../shared/model/application/intake-application.interface';

export type IntakeVerifiedApplicationListState = IntakeApplication[];

const initialState: IntakeVerifiedApplicationListState = <IntakeApplication[]>[];

export function intakeVerifiedApplicationListReducer(state = initialState, action: Action): IntakeVerifiedApplicationListState {
  switch (action.type) {
    case IntakeActions.FIND_VERIFIED_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
