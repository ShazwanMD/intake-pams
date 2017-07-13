import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {Intake} from '../../../shared/model/policy/intake.interface';

@Injectable()
export class AdmissionActions {

  static FIND_ASSIGNED_INTAKE_TASKS = '[Admission] Find Assigned Admission Tasks';

  findAssignedIntakeTasks(): Action {
    return {
      type: AdmissionActions.FIND_ASSIGNED_INTAKE_TASKS,
    };
  }

  static FIND_ASSIGNED_INTAKE_TASKS_SUCCESS = '[Admission] Find Assigned Admission Tasks Success';

  findAssignedIntakeTasksSuccess(tasks): Action {
    console.log('findAssignedIntakeTasksSuccess');
    return {
      type: AdmissionActions.FIND_ASSIGNED_INTAKE_TASKS_SUCCESS,
      payload: tasks,
    };
  }

  static FIND_POOLED_INTAKE_TASKS = '[Admission] Find Pooled Admission Tasks';

  findPooledIntakeTasks(): Action {
    return {
      type: AdmissionActions.FIND_POOLED_INTAKE_TASKS,
    };
  }

  static FIND_POOLED_INTAKE_TASKS_SUCCESS = '[Admission] Find Pooled Admission Tasks Success';

  findPooledIntakeTasksSuccess(tasks): Action {
    console.log('findAssignedIntakeTasksSuccess');
    return {
      type: AdmissionActions.FIND_POOLED_INTAKE_TASKS_SUCCESS,
      payload: tasks,
    };
  }

  static FIND_INTAKE_TASK_BY_TASK_ID = '[Intake] Find Intake Task By Task Id';

  findIntakeTaskByTaskId(taskId): Action {
    console.log('findIntakeTaskByTaskId');
    return {
      type: AdmissionActions.FIND_INTAKE_TASK_BY_TASK_ID,
      payload: taskId,
    };
  }

  static FIND_INTAKE_TASK_BY_TASK_ID_SUCCESS = '[Intake] Find Intake Task By Task Id Success';

  findIntakeTaskByTaskIdSuccess(task): Action {
    console.log('findIntakeTaskByTaskIdSuccess');
    return {
      type: AdmissionActions.FIND_INTAKE_TASK_BY_TASK_ID_SUCCESS,
      payload: task,
    };
  }

  static FIND_CANDIDATES = '[Admission] Find Candidates';

  findCandidates(intake): Action {
    console.log('findCandidates');
    return {
      type: AdmissionActions.FIND_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_CANDIDATES_SUCCESS = '[Admission] Find Candidates Success';

  findCandidatesSuccess(candidates): Action {
    console.log('findCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }

  static FIND_SELECTED_CANDIDATES = '[Admission] Find Selected Candidates';

  findSelectedCandidates(intake): Action {
    console.log('findSelectedCandidates');
    return {
      type: AdmissionActions.FIND_SELECTED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_SELECTED_CANDIDATES_SUCCESS = '[Admission] Find Selected Candidates Success';

  findSelectedCandidatesSuccess(candidates): Action {
    console.log('findCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_SELECTED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }

  static FIND_REJECTED_CANDIDATES = '[Admission] Find Rejected Candidates';

  findRejectedCandidates(intake): Action {
    console.log('findRejectedCandidates');
    return {
      type: AdmissionActions.FIND_REJECTED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_REJECTED_CANDIDATES_SUCCESS = '[Admission] Find Rejected Candidates Success';

  findRejectedCandidatesSuccess(candidates): Action {
    console.log('findCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_REJECTED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }

  static BROADCAST_INTAKE_RESULT = '[Admission] Broadcast Intake Result';

  broadcastIntakeResult(intake: Intake): Action {
    return {
      type: AdmissionActions.BROADCAST_INTAKE_RESULT,
      payload: intake,
    };
  }

  static BROADCAST_INTAKE_RESULT_SUCCESS = '[Admission] Broadcast Intake Result Success';

  broadcastIntakeResultSuccess(): Action {
    return {
      type: AdmissionActions.BROADCAST_INTAKE_RESULT_SUCCESS,
    };
  }
}
