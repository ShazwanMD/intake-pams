import {Action} from '@ngrx/store';
import {CommonActions} from '../common.action';
import {StateCode} from '../../shared/model/common/state-code.interface';

export type StateCodeListState = StateCode[];

const initialState: StateCodeListState = <StateCode[]>[];

export function stateCodeListReducer(state = initialState, action: Action): StateCodeListState {
  switch (action.type) {
    case CommonActions.FIND_STATE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
