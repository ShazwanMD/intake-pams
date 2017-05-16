import { StudyCenterCode } from './../../common/study-center-codes/study-center-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";

export type StudyCenterCodeListState = StudyCenterCode[];

const initialState: StudyCenterCodeListState = <StudyCenterCode[]>[];

export function studyCenterCodeListReducer(state = initialState, action: Action): StudyCenterCodeListState {
  switch (action.type) {
    case SetupActions.FIND_STUDY_CENTER_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}