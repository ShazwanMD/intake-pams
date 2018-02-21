import { CandidateTask } from './../../shared/model/admission/candidate-task.interface';
import { Action } from '@ngrx/store';
import { AdmissionCandidateActions } from './admission-candidate.action';

export type CandidateTaskState = CandidateTask[];

const initialState: CandidateTaskState = <CandidateTask[]>[];

 export function assignedCandidateListReducer(state = initialState, action: Action):CandidateTaskState {
     switch (action.type){
         case AdmissionCandidateActions.FIND_ASSIGNED_CANDIDATE_TASKS_SUCCESS:{
             console.log("assigned" + action.payload);
             return action.payload;
         }
         default:{
             return state;
         }
     }
 }
 
 export function pooledCandidateListReducer(state = initialState, action: Action): CandidateTaskState{
     switch (action.type){
         case AdmissionCandidateActions.FIND_POOLED_CANDIDATE_TASKS_SUCCESS:{
             return action.payload;
         }
         default:{
             return state;
         }
     }
 }