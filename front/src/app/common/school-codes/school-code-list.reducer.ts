import {Action} from '@ngrx/store';
import {SchoolCode} from "./school-code.interface";
import {CommonActions} from "../common.action";

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
