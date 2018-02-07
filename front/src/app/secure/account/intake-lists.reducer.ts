import {Action} from '@ngrx/store';
import { Intake } from '../../shared/model/policy/intake.interface';
import { AccountActions } from './account.action';

export type IntakeListsState = Intake[];

const initialState: IntakeListsState = <Intake[]>[];

export function intakeListReducer(state = initialState, action: Action): IntakeListsState {
  switch (action.type) {
    case AccountActions.FIND_INTAKES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
