import { SetupActions } from './../../setup/setup.action';
import {Action} from '@ngrx/store';

import { GradeCode } from "./grade-code.interface";


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
