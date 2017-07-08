import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {BankCode} from '../../../../shared/model/common/bank-code.interface';

export type BankCodeListState = BankCode[];

const initialState: BankCodeListState = <BankCode[]>[];

export function bankCodeListReducer(state = initialState, action: Action): BankCodeListState {
  switch (action.type) {
    case SetupActions.FIND_BANK_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
