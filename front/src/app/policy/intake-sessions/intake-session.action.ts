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

  static FIND_ASSIGNED_INTAKE_SESSIONS = '[Common] Find Assigned Intake Sessions';

  findAssignedIntakeSessions(sessions): Action {
    console.log("findAssignedIntakeSessions");
    return {
      type: IntakeSessionActions.FIND_ASSIGNED_INTAKE_SESSIONS,
      payload: sessions
    };
  }

  static FIND_ASSIGNED_INTAKE_SESSION_TASKS = '[Common] Find Assigned Intake Session Tasks';

  findAssignedIntakeSessionTasks(sessions): Action {
    console.log("findAssignedIntakeSessionTasks");
    return {
      type: IntakeSessionActions.FIND_ASSIGNED_INTAKE_SESSION_TASKS,
      payload: sessions
    };
  }

  //findIntakeSessionTaskByTaskId
   static FIND_INTAKE_SESSIONS_TASK_BY_TASK_ID = '[Common] Find Intake Sessions Task';

  findIntakeSessionTaskByTaskId(taskId): Action {
    console.log("findIntakeSessionTaskByTaskId");
    return {
      type: IntakeSessionActions.FIND_INTAKE_SESSIONS_TASK_BY_TASK_ID,
      payload: taskId
    };
  }

}
