import {Action} from '@ngrx/store';
import {RegistrationActions} from './registration.action';

export type VerificationState = boolean;
const initialState: VerificationState = false;

export function registrationReducer(state = initialState, action: Action): VerificationState {
  switch (action.type) {
    case RegistrationActions.VERIFY_USER_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
