import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AdmissionCandidateActions} from './admission-candidate.action';
import {AdmissionService} from '../../../services/admission.service';
import {from} from 'rxjs/observable/from';

@Injectable()
export class AdmissionCandidateEffects {

/*  private INTAKE_TASKS: string[] = 'admissionModuleState.intakeTasks'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');*/

  constructor(private actions$: Actions,
              private admissionCandidateActions: AdmissionCandidateActions,
              private admissionService: AdmissionService) {
  }
  
  @Effect() findAssignedCandidateTasks$ = this.actions$
  .ofType(AdmissionCandidateActions.FIND_ASSIGNED_CANDIDATE_TASKS)
  .switchMap(() => this.admissionService.findAssignedCandidateTasks())
  .map((tasks) => this.admissionCandidateActions.findAssignedCandidateTasksSuccess(tasks));

@Effect() findPooledCandidateTasks$ = this.actions$
  .ofType(AdmissionCandidateActions.FIND_POOLED_CANDIDATE_TASKS)
  .switchMap(() => this.admissionService.findPooledCandidateTasks())
  .map((tasks) => this.admissionCandidateActions.findPooledCandidateTasksSuccess(tasks));
}
