import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {Intake} from '../../shared/model/policy/intake.interface';

@Injectable()
export class AdmissionCandidateActions {

    static FIND_ASSIGNED_CANDIDATE_TASKS = '[Candidate] Find Assigned Candidate Tasks';

    findAssignedCandidateTasks(): Action {
      return {
        type: AdmissionCandidateActions.FIND_ASSIGNED_CANDIDATE_TASKS,
      };
    }

    static FIND_ASSIGNED_CANDIDATE_TASKS_SUCCESS = '[Candidate] Find Assigned Candidate Tasks Success';

    findAssignedCandidateTasksSuccess(tasks): Action {
      console.log('findAssignedCandidateTasksSuccess');
      return {
        type: AdmissionCandidateActions.FIND_ASSIGNED_CANDIDATE_TASKS_SUCCESS,
        payload: tasks,
      };
    }
    
    static FIND_POOLED_CANDIDATE_TASKS = '[Candidate] Find Pooled Candidate Tasks';

    findPooledCandidateTasks(): Action {
      return {
        type: AdmissionCandidateActions.FIND_POOLED_CANDIDATE_TASKS,
      };
    }

    static FIND_POOLED_CANDIDATE_TASKS_SUCCESS = '[Candidate] Find Pooled Candidate Tasks Success';

    findPooledCandidateTasksSuccess(tasks): Action {
      console.log('findPooledCandidateTasksSuccess');
      return {
        type: AdmissionCandidateActions.FIND_POOLED_CANDIDATE_TASKS_SUCCESS,
        payload: tasks,
      };
    }
}
