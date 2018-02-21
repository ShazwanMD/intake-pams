import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {Intake} from '../../shared/model/policy/intake.interface';

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
  
  static PRESELECT_CANDIDATE = '[Admission] Pre Select Candidate';

  preSelectCandidate(candidate): Action {
    return {
      type: AdmissionActions.PRESELECT_CANDIDATE,
      payload: candidate,
    };
  }

  static PRESELECT_CANDIDATE_SUCCESS = '[Admission] Pre Select Candidate Success';

  preSelectCandidateSuccess(message): Action {
    return {
      type: AdmissionActions.PRESELECT_CANDIDATE_SUCCESS,
      payload: message,
    };
  }
  
  static REJECT_CANDIDATE = '[Admission] Reject Candidate';

  rejectCandidate(candidate): Action {
    return {
      type: AdmissionActions.REJECT_CANDIDATE,
      payload: candidate,
    };
  }

  static REJECT_CANDIDATE_SUCCESS = '[Admission] Reject Candidate Success';

  rejectCandidateSuccess(message): Action {
    return {
      type: AdmissionActions.REJECT_CANDIDATE_SUCCESS,
      payload: message,
    };
  }
  
  
  static SELECT_CANDIDATE = '[Admission] Select Candidate';

  selectCandidate(candidate): Action {
    return {
      type: AdmissionActions.SELECT_CANDIDATE,
      payload: candidate,
    };
  }

  static SELECT_CANDIDATE_SUCCESS = '[Admission] Select Candidate Success';

  selectCandidateSuccess(message): Action {
    return {
      type: AdmissionActions.SELECT_CANDIDATE_SUCCESS,
      payload: message,
    };
  }
  
  static OFFER_CANDIDATE = '[Admission] Offer Candidate';

  offerCandidates(intake): Action {
    return {
      type: AdmissionActions.OFFER_CANDIDATE,
      payload: intake,
    };
  }

  static OFFER_CANDIDATE_SUCCESS = '[Admission] Offer Candidate Success';

  offerCandidateSuccess(message): Action {
    return {
      type: AdmissionActions.OFFER_CANDIDATE_SUCCESS,
      payload: message,
    };
  }
  
  static REGISTER_CANDIDATE = '[Admission] Register Candidate';

  registerCandidate(intake): Action {
    return {
      type: AdmissionActions.REGISTER_CANDIDATE,
      payload: intake,
    };
  }

  static REGISTER_CANDIDATE_SUCCESS = '[Admission] Register Candidate Success';

  registerCandidateSuccess(message): Action {
    return {
      type: AdmissionActions.REGISTER_CANDIDATE_SUCCESS,
      payload: message,
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
    console.log('findSelectedCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_SELECTED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }
  
  static FIND_APPROVED_CANDIDATES = '[Admission] Find Approved Candidates';

  findApprovedCandidates(intake): Action {
    console.log('findApprovedCandidates');
    return {
      type: AdmissionActions.FIND_APPROVED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_APPROVED_CANDIDATES_SUCCESS = '[Admission] Find Approved Candidates Success';

  findApprovedCandidatesSuccess(candidates): Action {
    console.log('findApprovedCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_APPROVED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }
  
  static FIND_ACCEPTED_CANDIDATES = '[Admission] Find Accepted Candidates';

  findAcceptedCandidates(intake): Action {
    console.log('findAcceptedCandidates');
    return {
      type: AdmissionActions.FIND_ACCEPTED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_ACCEPTED_CANDIDATES_SUCCESS = '[Admission] Find Accepted Candidates Success';

  findAcceptedCandidatesSuccess(candidates): Action {
    console.log('findApprovedCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_ACCEPTED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }
  
  static FIND_OFFERED_CANDIDATES = '[Admission] Find Offered Candidates';

  findOfferedCandidates(intake): Action {
    console.log('findOfferedCandidates');
    return {
      type: AdmissionActions.FIND_OFFERED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_OFFERED_CANDIDATES_SUCCESS = '[Admission] Find Offered Candidates Success';

  findOfferedCandidatesSuccess(candidates): Action {
    console.log('findOfferedCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_OFFERED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }
  
  static FIND_ACCEPT_OFFERED_CANDIDATES = '[Admission] Find Accept Offered Candidates';

  findAcceptOfferedCandidates(intake): Action {
    console.log('findAcceptOfferedCandidates');
    return {
      type: AdmissionActions.FIND_ACCEPT_OFFERED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_ACCEPT_OFFERED_CANDIDATES_SUCCESS = '[Admission] Find Accept Offered Candidates Success';

  findAcceptOfferedCandidatesSuccess(candidates): Action {
    console.log('findAcceptOfferedCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_ACCEPT_OFFERED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }
  
  static FIND_REGISTERED_CANDIDATES = '[Admission] Find Registered Candidates';

  findRegisteredCandidates(intake): Action {
    console.log('findRegisteredCandidates');
    return {
      type: AdmissionActions.FIND_REGISTERED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_REGISTERED_CANDIDATES_SUCCESS = '[Admission] Find Registered Candidates Success';

  findRegisteredCandidatesSuccess(candidates): Action {
    console.log('findRegisteredCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_REGISTERED_CANDIDATES_SUCCESS,
      payload: candidates,
    };
  }
  
  static FIND_PRE_SELECTED_CANDIDATES = '[Admission] Find Pre Selected Candidates';

  findPreSelectedCandidates(intake): Action {
    console.log('findPreSelectedCandidates');
    return {
      type: AdmissionActions.FIND_PRE_SELECTED_CANDIDATES,
      payload: intake,
    };
  }

  static FIND_PRE_SELECTED_CANDIDATES_SUCCESS = '[Admission] Find Pre Selected Candidates Success';

  findPreSelectedCandidatesSuccess(candidates): Action {
    console.log('findPreSelectedCandidatesSuccess');
    return {
      type: AdmissionActions.FIND_PRE_SELECTED_CANDIDATES_SUCCESS,
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
