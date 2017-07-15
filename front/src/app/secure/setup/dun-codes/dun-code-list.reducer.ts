import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {DunCode} from '../../../shared/model/common/dun-code.interface';

export type DunCodeListState = DunCode[];

const initialState: DunCodeListState = <DunCode[]>[];

export function dunCodeListReducer(state = initialState, action: Action): DunCodeListState {
  switch (action.type) {
    case SetupActions.FIND_DUN_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
