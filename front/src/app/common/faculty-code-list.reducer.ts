import {Action} from '@ngrx/store';
import {FacultyCode} from "../common/faculty-code.interface";
import {CommonActions} from "./common.action";

export type FacultyCodeListState = FacultyCode[];

const initialState: FacultyCodeListState = <FacultyCode[]>[];

export function facultyCodeListReducer(state = initialState, action: Action): FacultyCodeListState {
  switch (action.type) {
    case CommonActions.FIND_FACULTY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
