import { User } from './../identity/user.interface';
import {Action} from '@ngrx/store';
import {Intake} from '../../shared/model/policy/intake.interface';
import {AccountActions} from './account.action';

export type UserState = User;

const initialState: UserState = <User>{};

export function userReducer(state = initialState, action: Action): UserState {
  switch (action.type) {
    case AccountActions.FIND_USER_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
