import { DiplomaResult } from './diploma-result-interface';
import { IntakeApplicationActions } from './intake-application.action';
import {Action} from '@ngrx/store';

export type DiplomaResultListState = DiplomaResult[];

const initialState: DiplomaResultListState = <DiplomaResult[]>[];

export function diplomaResultListReducer(state = initialState, action: Action): DiplomaResultListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_DIPLOMA_RESULTS_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
