import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {Intake} from '../../shared/model/policy/intake.interface';

@Injectable()
export class AdmissionCandidateActions {

    static FIND_ASSIGNED_CANDIDATE_TASKS = '[Admission] Find Assigned Candidate Tasks';

    findAssignedCandidateTasks(): Action {
      return {
        type: AdmissionCandidateActions.FIND_ASSIGNED_CANDIDATE_TASKS,
      };
    }

    static FIND_ASSIGNED_CANDIDATE_TASKS_SUCCESS = '[Admission] Find Assigned Candidate Tasks Success';

    findAssignedCandidateTasksSuccess(tasks): Action {
      console.log('findAssignedCandidateTasksSuccess di action'+tasks);
      return {
        type: AdmissionCandidateActions.FIND_ASSIGNED_CANDIDATE_TASKS_SUCCESS,
        payload: tasks,
      };
    }
    
    static FIND_POOLED_CANDIDATE_TASKS = '[Admission] Find Pooled Candidate Tasks';

    findPooledCandidateTasks(): Action {
      return {
        type: AdmissionCandidateActions.FIND_POOLED_CANDIDATE_TASKS,
      };
    }

    static FIND_POOLED_CANDIDATE_TASKS_SUCCESS = '[Admission] Find Pooled Candidate Tasks Success';

    findPooledCandidateTasksSuccess(tasks): Action {
      console.log('findPooledCandidateTasksSuccess');
      return {
        type: AdmissionCandidateActions.FIND_POOLED_CANDIDATE_TASKS_SUCCESS,
        payload: tasks,
      };
    }
    
    static FIND_CANDIDATE_TASK_BY_TASK_ID = '[Admission] Find Candidate Task By Task Id';

    findCandidateTaskByTaskId(taskId): Action {
      console.log('findIntakeTaskByTaskId');
      return {
        type: AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID,
        payload: taskId,
      };
    }

    static FIND_CANDIDATE_TASK_BY_TASK_ID_SUCCESS = '[Admission] Find Candidate Task By Task Id Success';

    findCandidateTaskByTaskIdSuccess(task): Action {
      console.log('findIntakeTaskByTaskIdSuccess');
      return {
        type: AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID_SUCCESS,
        payload: task,
      };
    }
}
