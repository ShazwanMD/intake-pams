import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {MaritalCode} from '../../../shared/model/common/marital-code.interface';

export type MaritalCodeListState = MaritalCode[];

const initialState: MaritalCodeListState = <MaritalCode[]>[];

export function maritalCodeListReducer(state = initialState, action: Action): MaritalCodeListState {
  switch (action.type) {
    case SetupActions.FIND_MARITAL_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
