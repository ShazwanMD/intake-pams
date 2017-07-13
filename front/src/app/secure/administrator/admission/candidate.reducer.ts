import {Action} from '@ngrx/store';
import {AdmissionActions} from './admission.action';
import {Candidate} from '../../../shared/model/admission/candidate.interface';

export type CandidateState = Candidate;

const initialState: CandidateState = <Candidate>{};

export function candidateListReducer(state = initialState, action: Action): CandidateState {
  switch (action.type) {
    case AdmissionActions.FIND_CANDIDATES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
