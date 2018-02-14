import { CandidateTask } from './../../shared/model/admission/candidate-task.interface';
import { Action } from '@ngrx/store';
import { AdmissionActions } from './admission.action';

export type CandidateTaskState = CandidateTask;

const initialState: CandidateTaskState = <CandidateTaskState>{};

 export function assignedCandidateTaskReducer(state =initialState, action: Action):CandidateTaskState {
     switch (action.type){
         case AdmissionActions.FIND_ASSIGNED_INTAKE_TASKS_SUCCESS:{
             return action.payload;
         }
         default:{
             return state;
         }
     }
 }
 
 export function pooledCandidateListReducer(state = initialState, action: Action): CandidateTaskState{
     switch (action.type){
         case AdmissionActions.FIND_POOLED_INTAKE_TASKS_SUCCESS:{
             return action.payload;
         }
         default:{
             return state;
         }
     }
 }