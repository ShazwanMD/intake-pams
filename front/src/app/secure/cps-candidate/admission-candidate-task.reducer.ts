import {Action} from '@ngrx/store';
import { CandidateTask } from './../../shared/model/admission/candidate-task.interface';
import { AdmissionCandidateActions } from './admission-candidate.action';

export type CandidateState = CandidateTask;

const initialState: CandidateState = <CandidateState>{};

export function candidateTaskReducer(state = initialState, action: Action): CandidateState {
  switch (action.type) {
    case AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
