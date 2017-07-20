import {Action} from '@ngrx/store';
import {AdmissionActions} from './admission.action';
import {Candidate} from '../../shared/model/admission/candidate.interface';

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

export function preSelectedCandidateListReducer(state = initialState, action: Action): CandidateListState {
  switch (action.type) {
    case AdmissionActions.FIND_PRE_SELECTED_CANDIDATES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function approvedCandidateListReducer(state = initialState, action: Action): CandidateListState {
  switch (action.type) {
    case AdmissionActions.FIND_APPROVED_CANDIDATES_SUCCESS: {
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

