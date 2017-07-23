import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AdmissionActions} from './admission.action';
import {AdmissionService} from '../../../services/admission.service';
import {from} from 'rxjs/observable/from';

@Injectable()
export class AdmissionEffects {

  private INTAKE_TASKS: string[] = 'admissionModuleState.intakeTasks'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');

  constructor(private actions$: Actions,
              private admissionActions: AdmissionActions,
              private admissionService: AdmissionService) {
  }

  @Effect() findAssignedIntakeTasks$ = this.actions$
    .ofType(AdmissionActions.FIND_ASSIGNED_INTAKE_TASKS)
    .switchMap(() => this.admissionService.findAssignedIntakeTasks())
    .map((admissions) => this.admissionActions.findAssignedIntakeTasksSuccess(admissions));

  @Effect() findPooledIntakeTasks$ = this.actions$
    .ofType(AdmissionActions.FIND_POOLED_INTAKE_TASKS)
    .switchMap(() => this.admissionService.findPooledIntakeTasks())
    .map((admissions) => this.admissionActions.findPooledIntakeTasksSuccess(admissions));

  @Effect() findIntakeTaskByTaskId = this.actions$
    .ofType(AdmissionActions.FIND_INTAKE_TASK_BY_TASK_ID)
    .map((action) => action.payload)
    .switchMap((taskId) => this.admissionService.findIntakeTaskByTaskId(taskId))
    .map((task) => this.admissionActions.findIntakeTaskByTaskIdSuccess(task))
    .mergeMap((action) => from([action,
      this.admissionActions.findSelectedCandidates(action.payload),
      this.admissionActions.findPreSelectedCandidates(action.payload),
      this.admissionActions.findApprovedCandidates(action.payload),
      this.admissionActions.findRejectedCandidates(action.payload),
    ]));

  @Effect() findCandidates = this.actions$
    .ofType(AdmissionActions.FIND_CANDIDATES)
    .map(action => action.payload)
    .switchMap(intake => this.admissionService.findCandidates(intake))
    .map(candidates => this.admissionActions.findCandidatesSuccess(candidates));

  @Effect() findSelectedCandidates = this.actions$
    .ofType(AdmissionActions.FIND_SELECTED_CANDIDATES)
    .map(action => action.payload)
    .switchMap(intake => this.admissionService.findSelectedCandidates(intake))
    .map(candidates => this.admissionActions.findSelectedCandidatesSuccess(candidates));
  
  @Effect() findApprovedCandidates = this.actions$
    .ofType(AdmissionActions.FIND_APPROVED_CANDIDATES)
    .map(action => action.payload)
    .switchMap(intake => this.admissionService.findApprovedCandidates(intake))
    .map(candidates => this.admissionActions.findApprovedCandidatesSuccess(candidates));
  
   @Effect() findPreSelectedCandidates = this.actions$
    .ofType(AdmissionActions.FIND_PRE_SELECTED_CANDIDATES)
    .map(action => action.payload)
    .switchMap(intake => this.admissionService.findPreSelectedCandidates(intake))
    .map(candidates => this.admissionActions.findPreSelectedCandidatesSuccess(candidates));

  @Effect() findRejectedCandidates = this.actions$
    .ofType(AdmissionActions.FIND_REJECTED_CANDIDATES)
    .map(action => action.payload)
    .switchMap(intake => this.admissionService.findRejectedCandidates(intake))
    .map(candidates => this.admissionActions.findRejectedCandidatesSuccess(candidates));
  
  @Effect() preSelectCandidate$ = this.actions$
    .ofType(AdmissionActions.PRESELECT_CANDIDATE)
    .map((action) => action.payload)
    .switchMap((candidate) => this.admissionService.preSelectCandidate(candidate))
    .map((message) => this.admissionActions.preSelectCandidateSuccess(message));
  
  @Effect() selectCandidate$ = this.actions$
    .ofType(AdmissionActions.SELECT_CANDIDATE)
    .map((action) => action.payload)
    .switchMap((candidate) => this.admissionService.selectCandidate(candidate))
    .map((message) => this.admissionActions.selectCandidateSuccess(message));
  
  @Effect() offerCandidate$ = this.actions$
    .ofType(AdmissionActions.OFFER_CANDIDATE)
    .map((action) => action.payload)
    .switchMap((candidate) => this.admissionService.offerCandidate(candidate))
    .map((message) => this.admissionActions.offerCandidateSuccess(message));
  
  @Effect() rejectCandidate$ = this.actions$
    .ofType(AdmissionActions.REJECT_CANDIDATE)
    .map((action) => action.payload)
    .switchMap((candidate) => this.admissionService.rejectCandidate(candidate))
    .map((message) => this.admissionActions.rejectCandidateSuccess(message));
}
