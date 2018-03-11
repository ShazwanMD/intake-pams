import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { AdmissionCandidateActions } from './admission-candidate.action';
import { AdmissionService } from '../../../services/admission.service';
import { from } from 'rxjs/observable/from';
import { IntakeApplicationActions } from "../application/intake-applications/intake-application.action";
import { AdmissionActions } from "../admission/admission.action";
import { ApplicationService } from "../../../services/application.service";

@Injectable()
export class AdmissionCandidateEffects {

    /*  private INTAKE_TASKS: string[] = 'admissionModuleState.intakeTasks'.split('.');
      private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');*/

    private CANDIDATE_TASK: string[] = 'admissionCandidateModuleState.candidateTask'.split( '.' );

    constructor( private actions$: Actions,
        private admissionCandidateActions: AdmissionCandidateActions,
        private intakeApplicationActions: IntakeApplicationActions,
        private applicationService: ApplicationService,
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
    
    @Effect() findArchivedCandidates$ = this.actions$
    .ofType( AdmissionCandidateActions.FIND_ARCHIVED_CANDIDATE_TASKS )
    .switchMap(() => this.admissionService.findArchivedCandidates() )
    .map(( message ) => this.admissionCandidateActions.findArchivedCandidatesSuccess(message) );

    @Effect() findCandidateTaskByTaskId = this.actions$
        .ofType( AdmissionCandidateActions.FIND_CANDIDATE_TASK_BY_TASK_ID )
        .map(( action ) => action.payload )
        .switchMap(( taskId ) => this.admissionService.findCandidateTaskByTaskId(taskId) )
        .map(( task ) => this.admissionCandidateActions.findCandidateTaskByTaskIdSuccess(task) );
    
/*    @Effect() findIntakeApplicationByReferenceNo$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.applicationService.findIntakeApplicationByReferenceNo(referenceNo))
    .map((application) => this.intakeApplicationActions.findIntakeApplicationByReferenceNoSuccess(application))*/
    
    @Effect() findCandidateById = this.actions$
    .ofType(AdmissionCandidateActions.FIND_CANDIDATE_BY_ID)
    .map(action => action.payload)
    .switchMap(candidate => this.admissionService.findCandidateById(candidate))
    .map(candidates => this.admissionCandidateActions.findCandidateByIdSuccess(candidates));
   // .mergeMap((action) => from([action, this.intakeApplicationActions.findIntakeApplicationByReferenceNo(action.payload)]));

    @Effect() findCandidateByReferenceNo = this.actions$
    .ofType(AdmissionCandidateActions.FIND_CANDIDATE_BY_REFERENCE_NO)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.admissionService.findCandidateByReferenceNo(referenceNo))
    .map((candidate) => this.admissionCandidateActions.findCandidateByReferenceNoSuccess(candidate));
    //.mergeMap((action) => from([action, this.intakeApplicationActions.findIntakeApplicationByCandidate(action.payload)]));

    @Effect() findCandidateByIntakeApplicationReferenceNo = this.actions$
    .ofType(AdmissionCandidateActions.FIND_CANDIDATE_BY_INTAKE_REFERENCE_NO)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.admissionService.findCandidateByIntakeApplicationReferenceNo(referenceNo))
    .map((candidate) => this.admissionCandidateActions.findCandidateByIntakeApplicationReferenceNoSuccess(candidate));
    
    @Effect() completeCandidateTask = this.actions$
    .ofType(AdmissionCandidateActions.COMPLETE_CANDIDATE_TASK)
    .map(action => action.payload)
    .switchMap(candidateTask => this.admissionService.completeCandidateTask(candidateTask))
    .map(message => this.admissionCandidateActions.completeCandidateTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.admissionCandidateActions.findAssignedCandidateTasks(),
        this.admissionCandidateActions.findPooledCandidateTasks(),
        this.admissionCandidateActions.findArchivedCandidates(),
      ],
    ));
   
    @Effect() claimCandidateTask = this.actions$
    .ofType(AdmissionCandidateActions.CLAIM_CANDIDATE_TASK)
    .map(action => action.payload)
    .switchMap(candidateTask => this.admissionService.claimCandidateTask(candidateTask))
    .map(message => this.admissionCandidateActions.claimCandidateTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.admissionCandidateActions.findAssignedCandidateTasks(),
        this.admissionCandidateActions.findPooledCandidateTasks(),
        this.admissionCandidateActions.findArchivedCandidates(),
      ],
    ));
}
