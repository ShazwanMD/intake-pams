import {Action} from '@ngrx/store';
import {Candidate} from "./candidate.interface";
import {AdmissionActions} from "./admission.action";

export type CandidateListState = Candidate[];

const initialState: CandidateListState = <Candidate[]>[];

export function candidateListReducer(state = initialState, action: Action): CandidateListState {
  switch (action.type) {
    case AdmissionActions.FIND_CANDIDATES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function selectedCandidateListReducer(state = initialState, action: Action): CandidateListState {
  switch (action.type) {
    case AdmissionActions.FIND_SELECTED_CANDIDATES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function rejectedCandidateListReducer(state = initialState, action: Action): CandidateListState {
  switch (action.type) {
    case AdmissionActions.FIND_REJECTED_CANDIDATES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

