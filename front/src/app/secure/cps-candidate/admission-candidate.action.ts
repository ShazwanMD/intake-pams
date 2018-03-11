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
      console.log('findAssignedCandidateTasksSuccess di action'+tasks);
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
    
    static FIND_ARCHIVED_CANDIDATE_TASKS = '[Candidate] Find Archived Candidate Tasks';

    findArchivedCandidates(): Action {
      return {
        type: AdmissionCandidateActions.FIND_ARCHIVED_CANDIDATE_TASKS,
      };
    }

    static FIND_ARCHIVED_CANDIDATE_TASKS_SUCCESS = '[Candidate] Find Archived Candidate Tasks Success';

    findArchivedCandidatesSuccess(message): Action {
      console.log('findPooledCandidateTasksSuccess');
      return {
        type: AdmissionCandidateActions.FIND_ARCHIVED_CANDIDATE_TASKS_SUCCESS,
        payload: message,
      };
    }

    static FIND_CANDIDATE_TASK_BY_TASK_ID = '[Candidate] Find Candidate Task By Task Id';

    findCandidateTaskByTaskId(taskId): Action {
      console.log('findIntakeTaskByTaskId');
      return {
        type: AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID,
        payload: taskId,
      };
    }

    static FIND_CANDIDATE_TASK_BY_TASK_ID_SUCCESS = '[Candidate] Find Candidate Task By Task Id Success';

    findCandidateTaskByTaskIdSuccess(task): Action {
      console.log('findIntakeTaskByTaskIdSuccess');
      return {
        type: AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID_SUCCESS,
        payload: task,
      };
    }
    
    static FIND_CANDIDATE_BY_ID = '[Candidate] Find Candidates By Id';

    findCandidateById(candidate): Action {
      console.log('findCandidateById');
      return {
        type: AdmissionCandidateActions.FIND_CANDIDATE_BY_ID,
        payload: candidate,
      };
    }

    static FIND_CANDIDATE_BY_ID_SUCCESS = '[Candidate] Find Candidates By Id Success';

    findCandidateByIdSuccess(candidates): Action {
      console.log('findCandidateByIdSuccess');
      return {
        type: AdmissionCandidateActions.FIND_CANDIDATE_BY_ID_SUCCESS,
        payload: candidates,
      };
    }
    
    static FIND_CANDIDATE_BY_REFERENCE_NO = '[Candidate] Find Candidates By Reference No';
    
    findCandidateByReferenceNo(referenceNo): Action {
        console.log('findCandidateByReferenceNo');
        return {
          type: AdmissionCandidateActions.FIND_CANDIDATE_BY_REFERENCE_NO,
          payload: referenceNo,
        };
      }
    
    static FIND_CANDIDATE_BY_REFERENCE_NO_SUCCESS = '[Candidate] Find Candidates By Reference No Success';
    
    findCandidateByReferenceNoSuccess(candidate): Action {
        console.log('findCandidateByReferenceNoSuccess');
        return {
          type: AdmissionCandidateActions.FIND_CANDIDATE_BY_REFERENCE_NO_SUCCESS,
          payload: candidate,
        };
      }
    
    static FIND_CANDIDATE_BY_INTAKE_REFERENCE_NO = '[Candidate] Find Candidates By Intake Applications Reference No';
    
    findCandidateByIntakeApplicationReferenceNo(referenceNo): Action {
        console.log('findCandidateByReferenceNo');
        return {
          type: AdmissionCandidateActions.FIND_CANDIDATE_BY_INTAKE_REFERENCE_NO,
          payload: referenceNo,
        };
      }
    
    static FIND_CANDIDATE_BY_INTAKE_REFERENCE_NO_SUCCESS = '[Candidate] Find Candidates By Intake Applications Reference No Success';
    
    findCandidateByIntakeApplicationReferenceNoSuccess(candidate): Action {
        console.log('findCandidateByReferenceNoSuccess');
        return {
          type: AdmissionCandidateActions.FIND_CANDIDATE_BY_INTAKE_REFERENCE_NO_SUCCESS,
          payload: candidate,
        };
      }
    
    static COMPLETE_CANDIDATE_TASK = '[Candidate] Complete Candidate Task';

    completeCandidateTask(candidate): Action {
      return {
        type: AdmissionCandidateActions.COMPLETE_CANDIDATE_TASK,
        payload: candidate,
      };
    }

    static COMPLETE_CANDIDATE_TASK_SUCCESS = '[Candidate] Complete Candidate Task Success';

    completeCandidateTaskSuccess(message): Action {
      return {
        type: AdmissionCandidateActions.COMPLETE_CANDIDATE_TASK_SUCCESS,
        payload: message,
      };
    }
    
    static REMOVE_CANDIDATE_TASK = '[Candidate] Remove Candidate Task';
    
    removeCandidateTask(candidate): Action {
        return {
            type: AdmissionCandidateActions.REMOVE_CANDIDATE_TASK,
            payload: candidate,
          };
        }
    
    static REMOVE_CANDIDATE_TASK_SUCCESS = '[Candidate] Remove Candidate Task Success';

    removeCandidateTaskSuccess(message): Action {
      return {
        type: AdmissionCandidateActions.REMOVE_CANDIDATE_TASK_SUCCESS,
        payload: message,
      };
    }
    
    static CLAIM_CANDIDATE_TASK = '[Candidate] Claim Candidate Task';

    claimCandidateTask(candidate): Action {
      return {
        type: AdmissionCandidateActions.CLAIM_CANDIDATE_TASK,
        payload: candidate,
      };
    }

    static CLAIM_CANDIDATE_TASK_SUCCESS = '[Candidate] Claim Candidate Task Success';

    claimCandidateTaskSuccess(message): Action {
      return {
        type: AdmissionCandidateActions.CLAIM_CANDIDATE_TASK_SUCCESS,
        payload: message,
      };
    }
}
