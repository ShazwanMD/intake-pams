import {Action} from '@ngrx/store';
import {Candidate} from "./candidate.interface";
import {AdmissionActions} from "./admission.action";

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
