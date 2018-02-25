import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { AdmissionCandidateActions } from './admission-candidate.action';
import { AdmissionService } from '../../../services/admission.service';
import { from } from 'rxjs/observable/from';
import { IntakeApplicationActions } from "../application/intake-applications/intake-application.action";

@Injectable()
export class AdmissionCandidateEffects {

    /*  private INTAKE_TASKS: string[] = 'admissionModuleState.intakeTasks'.split('.');
      private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');*/

    private CANDIDATE_TASK: string[] = 'admissionCandidateModuleState.candidateTask'.split( '.' );

    constructor( private actions$: Actions,
        private admissionCandidateActions: AdmissionCandidateActions,
        private intakeApplicationActions: IntakeApplicationActions,
        private admissionService: AdmissionService ) {
    }

    @Effect() findAssignedCandidateTasks$ = this.actions$
        .ofType( AdmissionCandidateActions.FIND_ASSIGNED_CANDIDATE_TASKS )
        .switchMap(() => this.admissionService.findAssignedCandidateTasks() )
        .map(( tasks ) => this.admissionCandidateActions.findAssignedCandidateTasksSuccess( tasks ) );

    @Effect() findPooledCandidateTasks$ = this.actions$
        .ofType( AdmissionCandidateActions.FIND_POOLED_CANDIDATE_TASKS )
        .switchMap(() => this.admissionService.findPooledCandidateTasks() )
        .map(( tasks ) => this.admissionCandidateActions.findPooledCandidateTasksSuccess( tasks ) );

    @Effect() findCandidateTaskByTaskId = this.actions$
        .ofType( AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID )
        .map(( action ) => action.payload )
        .switchMap(( taskId ) => this.admissionService.findCandidateTaskByTaskId(taskId) )
        .map(( task ) => this.admissionCandidateActions.findCandidateTaskByTaskIdSuccess(task) );
//        .mergeMap(( action ) => from( [action,
//            this.admissionCandidateActions.findCandidateById( action.payload ),
///*            this.admissionActions.findPreSelectedCandidates( action.payload ),
//            this.admissionActions.findApprovedCandidates( action.payload ),
//            this.admissionActions.findRejectedCandidates( action.payload ),
//            this.admissionActions.findOfferedCandidates( action.payload ),
//            this.admissionActions.findAcceptOfferedCandidates( action.payload ),
//            this.admissionActions.findRegisteredCandidates( action.payload ),*/
//        ] ) );
    
    @Effect() findCandidateById = this.actions$
    .ofType(AdmissionCandidateActions.FIND_CANDIDATE_BY_ID)
    .map(action => action.payload)
    .switchMap(candidate => this.admissionService.findCandidateById(candidate))
    .map(candidates => this.admissionCandidateActions.findCandidateByIdSuccess(candidates));

    @Effect() completeCandidateTask = this.actions$
    .ofType(AdmissionCandidateActions.COMPLETE_CANDIDATE_TASK)
    .map(action => action.payload)
    .switchMap(candidateTask => this.admissionService.completeCandidateTask(candidateTask))
    .map(message => this.admissionCandidateActions.completeCandidateTaskSuccess(message));
    
    @Effect() claimCandidateTask = this.actions$
    .ofType(AdmissionCandidateActions.CLAIM_CANDIDATE_TASK)
    .map(action => action.payload)
    .switchMap(candidateTask => this.admissionService.claimCandidateTask(candidateTask))
    .map(message => this.admissionCandidateActions.claimCandidateTaskSuccess(message));
}
