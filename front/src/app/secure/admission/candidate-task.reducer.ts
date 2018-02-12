import { CandidateTask } from './../../shared/model/admission/candidate-task.interface';
import { Action } from '@ngrx/store';
import { AdmissionActions } from './admission.action';



export type CandidateTaskState = CandidateTask;

const initialState: CandidateTaskState = <CandidateTaskState>{};

// export function candidateTaskReducer(state =initialState, action: Action):CandidateTaskState {
//     switch (action.type){
//         case AdmissionActions.FIND_CANDIDATE_TASK_BY_TASK_ID_SUCCESS:{
//             return action.payload;
//         }
//         default:{
//             return state;
//         }
//     }
// }