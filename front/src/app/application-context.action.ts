import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class ApplicationContextActions {

  static SET_ERROR_MESSAGE: string = '[ApplicationContext] Set Error Message';
  static SET_ERROR_MESSAGE_SUCCESS: string = '[ApplicationContext] Set Error Message Success';
  static REMOVE_ERROR_MESSAGE: string = '[ApplicationContext] Remove Error Message';
  static REMOVE_ERROR_MESSAGE_SUCCESS: string = '[ApplicationContext] Remove Error Message Success';

  setErrorMessage(errorMessage: string): Action {
    return {
      type: ApplicationContextActions.SET_ERROR_MESSAGE,
      payload: errorMessage,
    };
  }

  setErrorMessageSuccess(errorMessage:string): Action {
    return {
      type: ApplicationContextActions.SET_ERROR_MESSAGE_SUCCESS,
      payload: errorMessage,
    };
  }

  removeErrorMessage(): Action {
    return {
      type: ApplicationContextActions.REMOVE_ERROR_MESSAGE,
    };
  }

  removeErrorMessageSuccess(): Action {
    return {
      type: ApplicationContextActions.REMOVE_ERROR_MESSAGE,
    };
  }
}
