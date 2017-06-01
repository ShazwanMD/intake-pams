import {Action} from '@ngrx/store';
import {SubjectCode} from "./subject-code.interface";
import {CommonActions} from "../common.action";

export type SubjectCodeListState = SubjectCode[];

const initialState: SubjectCodeListState = <SubjectCode[]>[];

export function subjectCodeListReducer(state = initialState, action: Action): SubjectCodeListState {
  switch (action.type) {
    case CommonActions.FIND_SUBJECT_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
