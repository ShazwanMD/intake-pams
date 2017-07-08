import {Result} from '../../../../shared/model/application/result.interface';
import {IntakeApplicationActions} from './intake-application.action';
import {Action} from '@ngrx/store';

export type ResultListState = Result[];

const initialState: ResultListState = <Result[]>[];

export function resultListReducer(state = initialState, action: Action): ResultListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_RESULTS_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
