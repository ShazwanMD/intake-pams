import { BachelorResult } from './bachelor-result-interface';
import { IntakeApplicationActions } from './intake-application.action';
import {Action} from '@ngrx/store';

export type BachelorResultListState = BachelorResult[];

const initialState: BachelorResultListState = <BachelorResult[]>[];

export function bachelorResultListReducer(state = initialState, action: Action): BachelorResultListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_BACHELOR_RESULTS_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
