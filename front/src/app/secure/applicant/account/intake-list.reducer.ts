import {Action} from '@ngrx/store';
import {Intake} from '../../../shared/model/policy/intake.interface';
import {AccountActions} from './account.action';

export type IntakeListState = Intake[];

const initialState: IntakeListState = <Intake[]>[];

export function publishedIntakeListReducer(state = initialState, action: Action): IntakeListState {
  switch (action.type) {
    case AccountActions.FIND_PUBLISHED_INTAKES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
