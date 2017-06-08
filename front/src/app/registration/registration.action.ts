import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';
@Injectable()
export class RegistrationActions {

  static REGISTER_USER = '[Registration] Register User';

  registerUser(registration): Action {
    console.log("registerUser");
    return {
      type: RegistrationActions.REGISTER_USER,
      payload: registration
    };
  }

  static REGISTER_USER_SUCCESS = '[Registration] Register User Success';

  registerUserSuccess(message): Action {
    console.log("registerUserSuccess");
    return {
      type: RegistrationActions.REGISTER_USER_SUCCESS,
      payload: message
    };
  }

  static VERIFY_USER = '[Registration] Verify User';

  verifyUser(token): Action {
    console.log("verifyUser");
    return {
      type: RegistrationActions.VERIFY_USER,
      payload: token
    };
  }

  static VERIFY_USER_SUCCESS = '[Registration] Verify User Success';

  verifyUserSuccess(verified): Action {
    console.log("verifyUserSuccess");
    return {
      type: RegistrationActions.VERIFY_USER_SUCCESS,
      payload: verified
    };
  }
}
