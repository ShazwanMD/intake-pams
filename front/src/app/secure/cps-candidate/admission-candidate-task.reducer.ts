import {Action} from '@ngrx/store';
import { CandidateTask } from './../../shared/model/admission/candidate-task.interface';
import { AdmissionCandidateActions } from './admission-candidate.action';

export type CandidateAdmissionTaskState = CandidateTask;

const initialState: CandidateAdmissionTaskState = <CandidateAdmissionTaskState>{};

export function candidateTaskReducer(state = initialState, action: Action): CandidateAdmissionTaskState {
  switch (action.type) {
    case AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
