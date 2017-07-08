import {Action} from '@ngrx/store';
import {CommonActions} from '../common.action';
import {SubjectCode} from '../../shared/model/common/subject-code.interface';

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
