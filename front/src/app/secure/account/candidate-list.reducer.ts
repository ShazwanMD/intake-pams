import { Candidate } from './../../shared/model/admission/candidate.interface';
import {Action} from '@ngrx/store';
import {AccountActions} from './account.action';


export type CandidateListState = Candidate[];

const initialState: CandidateListState = <Candidate[]>[];

export function candidateListReducer(state = initialState, action: Action): CandidateListState {
  switch (action.type) {
    case AccountActions.FIND_CANDIDATES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}


