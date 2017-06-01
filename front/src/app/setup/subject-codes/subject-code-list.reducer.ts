import { SubjectCode } from './../../common/subject-codes/subject-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";

export type SubjectCodeListState = SubjectCode[];

const initialState: SubjectCodeListState = <SubjectCode[]>[];

export function subjectCodeListReducer(state = initialState, action: Action): SubjectCodeListState {
  switch (action.type) {
    case SetupActions.FIND_SUBJECT_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}