import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from "rxjs/observable/from";
import {switchMap} from "rxjs/operator/switchMap";
import {AdmissionActions} from "./admission.action";
import {AdmissionService} from "../../services/admission.service";


@Injectable()
export class AdmissionEffects {
  constructor(private actions$: Actions,
              private admissionActions: AdmissionActions,
              private admissionService: AdmissionService) {
  }

  @Effect() findAssignedIntakeTasks$ = this.actions$
    .ofType(AdmissionActions.FIND_ASSIGNED_INTAKE_TASKS)
    .switchMap(() => this.admissionService.findAssignedIntakeTasks())
    .map(admissions => this.admissionActions.findAssignedIntakeTasksSuccess(admissions));


  @Effect() findPooledIntakeTasks$ = this.actions$
    .ofType(AdmissionActions.FIND_POOLED_INTAKE_TASKS)
    .switchMap(() => this.admissionService.findPooledIntakeTasks())
    .map(admissions => this.admissionActions.findPooledIntakeTasksSuccess(admissions));

  @Effect() findIntakeTaskByTaskId = this.actions$
    .ofType(AdmissionActions.FIND_INTAKE_TASK_BY_TASK_ID)
    .map(action => action.payload)
    .switchMap(taskId => this.admissionService.findIntakeTaskByTaskId(taskId))
    .map(task => this.admissionActions.findIntakeTaskByTaskIdSuccess(task));
}
