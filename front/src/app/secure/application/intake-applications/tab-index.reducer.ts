import {IntakeApplicationActions} from './intake-application.action';
import {Action} from '@ngrx/store';

export type TabIndexState = number;

const initialState: TabIndexState = 0;

export function tabIndexReducer(state = initialState, action: Action): TabIndexState {
  switch (action.type) {
    case IntakeApplicationActions.SELECT_TAB_INDEX_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
