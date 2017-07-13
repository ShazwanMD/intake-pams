import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';

export type IntakeApplicationListState = IntakeApplication[];

const initialState: IntakeApplicationListState = <IntakeApplication[]>[];

export function intakeApplicationListReducer(state = initialState, action: Action): IntakeApplicationListState {
  switch (action.type) {
    case IntakeActions.FIND_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
