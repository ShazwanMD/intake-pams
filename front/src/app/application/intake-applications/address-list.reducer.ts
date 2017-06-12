import {Address} from './address.interface';
import {Action} from '@ngrx/store';
import {IntakeApplicationActions} from "./intake-application.action";

export type AddressListState = Address[];

const initialState: AddressListState = <Address[]>[];

export function addressListReducer(state = initialState, action: Action): AddressListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_ADDRESSES_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
