import { SetupActions } from './../../setup/setup.action';
import {Action} from '@ngrx/store';

import { ParliamentCode } from './parliament-code.interface';

export type ParliamentCodeListState = ParliamentCode[];

const initialState: ParliamentCodeListState = <ParliamentCode[]>[];

export function parliamentCodeListReducer(state = initialState, action: Action): ParliamentCodeListState {
  switch (action.type) {
    case SetupActions.FIND_PARLIAMENT_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
