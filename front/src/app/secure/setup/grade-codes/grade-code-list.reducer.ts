import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {GradeCode} from '../../../shared/model/common/grade-code.interface';

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
