import {Action} from '@ngrx/store';

import { ParliamentCode } from '../../shared/model/common/parliament-code.interface';
import {SetupActions} from '../../secure/setup/setup.action';

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
