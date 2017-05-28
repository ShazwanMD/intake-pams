import { SpmResult } from './spm-result.interface';
import {Action} from '@ngrx/store';
import { IntakeApplicationActions } from "./intake-application.action";

export type SpmResultListState = SpmResult[];

const initialState: SpmResultListState = <SpmResult[]>[];

export function spmResultListReducer(state = initialState, action: Action): SpmResultListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_SPM_RESULTS_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
