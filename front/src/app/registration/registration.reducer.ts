import {Action} from '@ngrx/store';
import {RegistrationActions} from "./registration.action";

export type RegistrationState = '';
const initialState: RegistrationState = '';

export function registrationReducer(state = initialState, action: Action): RegistrationState {
  switch (action.type) {
    case RegistrationActions.REGISTER_USER_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
