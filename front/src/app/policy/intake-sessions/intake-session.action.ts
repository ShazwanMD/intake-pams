import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';
@Injectable()
export class IntakeSessionActions {

  static FIND_INTAKE_SESSIONS = '[IntakeSession] Find Intake Sessions';

  findIntakeSessions(): Action {
    console.log("findIntakeSessions");
    return {
      type: IntakeSessionActions.FIND_INTAKE_SESSIONS,
    };
  }

  static FIND_INTAKE_SESSIONS_SUCCESS = '[IntakeSession] Find Intake Sessions Success';

  findIntakeSessionsSuccess(sessions): Action {
    console.log("findIntakeSessionsSuccess");
    return {
      type: IntakeSessionActions.FIND_INTAKE_SESSIONS_SUCCESS,
      payload: sessions
    };
  }

  static SAVE_INTAKE_SESSIONS = '[IntakeSession] Save Intake Sessions';

  saveIntakeSession(sessions): Action {
    console.log("saveIntakeSession");
    return {
      type: IntakeSessionActions.SAVE_INTAKE_SESSIONS,
      payload: sessions
    };
  }  

  static SAVE_INTAKE_SESSION_SUCCESS = '[IntakeSession] Save Intake Sessions Success';

  saveIntakeSessionSuccess(message): Action {
    console.log("saveIntakeSessionSuccess");
    return {
      type: IntakeSessionActions.SAVE_INTAKE_SESSION_SUCCESS,
      payload: message
    };
  }

  static REMOVE_INTAKE_SESSION = '[IntakeSession] Remove Intake Session';

  removeIntakeSession(code): Action {
    console.log("removeIntakeSession");
    return {
      type: IntakeSessionActions.REMOVE_INTAKE_SESSION,
      payload: code
    };
  }

  static REMOVE_INTAKE_SESSION_SUCCESS = '[IntakeSession] Remove Intake Session Success';

  removeIntakeSessionSuccess(message): Action {
    console.log("removeIntakeSessionSuccess");
    return {
      type: IntakeSessionActions.REMOVE_INTAKE_SESSION_SUCCESS,
      payload: message
    };
  }

  static UPDATE_INTAKE_SESSION = '[IntakeSession] Update Intake Session';

  updateIntakeSession(code): Action {
    console.log("updateIntakeSession");
    return {
      type: IntakeSessionActions.UPDATE_INTAKE_SESSION,
      payload: code
    };
  }

  static UPDATE_INTAKE_SESSION_SUCCESS = '[IntakeSession] Update Intake Session Success';

  updateIntakeSessionSuccess(message): Action {
    console.log("updateIntakeSessionSuccess");
    return {
      type: IntakeSessionActions.UPDATE_INTAKE_SESSION_SUCCESS,
      payload: message
    };
  }

}
