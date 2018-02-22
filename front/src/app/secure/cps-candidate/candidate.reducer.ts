import {Action} from '@ngrx/store';
import { Candidate } from './../../shared/model/admission/candidate.interface';
import { AdmissionCandidateActions } from './admission-candidate.action';

export type CandidatesState = Candidate;

const initialState: CandidatesState = <CandidatesState>{};

export function candidateReducer(state = initialState, action: Action): CandidatesState {
  switch (action.type) {
    case AdmissionCandidateActions.FIND_CANDIDATE_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
