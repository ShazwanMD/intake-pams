import {Action} from '@ngrx/store';
import { Candidate } from './../../shared/model/admission/candidate.interface';
import { AdmissionCandidateActions } from './admission-candidate.action';

export type CandidateListState = Candidate[];

const initialState: CandidateListState = <Candidate[]>[];

export function candidateListReducer(state = initialState, action: Action): CandidateListState {
  switch (action.type) {
    case AdmissionCandidateActions.FIND_ARCHIVED_CANDIDATE_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}