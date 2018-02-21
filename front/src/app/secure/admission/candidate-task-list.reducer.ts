import { Type } from '@angular/core';
import { CandidateTask } from './../../shared/model/admission/candidate-task.interface';
import { Candidate } from '../../shared/model/admission/candidate.interface';
import { AdmissionActions } from './admission.action';
import { Action } from '@ngrx/store';


/*export type CandidateTaskListState = CandidateTask[];

const initialState: CandidateTaskListState = <CandidateTask[]>[];*/

/*export function assignedTaskCandidateListReducer(state = initialState, action: Action): CandidateTaskListState{
    switch(action.type){

        case AdmissionActions.FIND_ASSIGNED_CANDIDATE_TASKS_SUCCESS:{
            return action.payload;
        }
        default:{
            return state;
        }

    }
}

export function pooledTaskCandidateListReducer(state = initialState, action: Action): CandidateTaskListState{
    switch (action.type){
        case AdmissionActions.FIND_POOLED_CANDIDATE_TASKS_SUCCESS:{
            return action.payload;
        }
        default:{
            return state;
        }
    }
}*/