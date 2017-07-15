import {Action} from '@ngrx/store';
import {GradeCode} from '../../shared/model/common/grade-code.interface';
import {SetupActions} from '../../secure/setup/setup.action';

export type GradeCodeListState = GradeCode[];

const initialState: GradeCodeListState = <GradeCode[]>[];

export function gradeCodeListReducer(state = initialState, action: Action): GradeCodeListState {
  switch (action.type) {
    case SetupActions.FIND_GRADE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
