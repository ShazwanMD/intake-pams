import {Injectable} from "@angular/core";
import {Action} from '@ngrx/store';
@Injectable()
export class IntakeSessionActions {

  static FIND_INTAKE_SESSIONS = '[Common] Find Intake Sessions';

  findIntakeSessions(): Action {
    console.log("findIntakeSessions");
    return {
      type: IntakeSessionActions.FIND_INTAKE_SESSIONS,
    };
  }

  static FIND_INTAKE_SESSIONS_SUCCESS = '[Common] Find Intake Sessions Success';

  findIntakeSessionsSuccess(sessions): Action {
    console.log("findIntakeSessionsSuccess");
    return {
      type: IntakeSessionActions.FIND_INTAKE_SESSIONS_SUCCESS,
      payload: sessions
    };
  }
}
