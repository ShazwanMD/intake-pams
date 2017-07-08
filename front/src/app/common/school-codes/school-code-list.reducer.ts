import {Action} from '@ngrx/store';
import {CommonActions} from '../common.action';
import {SchoolCode} from '../../shared/model/common/school-code.interface';

export type SchoolCodeListState = SchoolCode[];

const initialState: SchoolCodeListState = <SchoolCode[]>[];

export function schoolCodeListReducer(state = initialState, action: Action): SchoolCodeListState {
  switch (action.type) {
    case CommonActions.FIND_SCHOOL_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
