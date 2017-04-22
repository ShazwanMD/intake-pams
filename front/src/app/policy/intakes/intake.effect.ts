import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {IntakeActions} from "./intake.action";
import {from} from "rxjs/observable/from";
import {PolicyService} from "../../../services/policy.service";


@Injectable()
export class IntakeEffects {
  constructor(private actions$: Actions,
              private intakeActions: IntakeActions,
              private policyService: PolicyService) {
  }

  @Effect() findAssignedIntakeTasks$ = this.actions$
    .ofType(IntakeActions.FIND_ASSIGNED_INTAKE_TASKS)
    .switchMap(() => this.policyService.findAssignedIntakeTasks())
    .map(intakes => this.intakeActions.findAssignedIntakeTasksSuccess(intakes));


  @Effect() findPooledIntakeTasks$ = this.actions$
    .ofType(IntakeActions.FIND_POOLED_INTAKE_TASKS)
    .switchMap(() => this.policyService.findPooledIntakeTasks())
    .map(intakes => this.intakeActions.findPooledIntakeTasksSuccess(intakes));

  @Effect() findIntakeTaskByTaskId = this.actions$
    .ofType(IntakeActions.FIND_INTAKE_TASK_BY_TASK_ID)
    .map(action => action.payload)
    .switchMap(taskId => this.policyService.findIntakeTaskByTaskId(taskId))
    .map(task => this.intakeActions.findIntakeTaskByTaskIdSuccess(task));

  @Effect() findIntakeByReferenceNo$ = this.actions$
    .ofType(IntakeActions.FIND_INTAKE_BY_REFERENCE_NO)
    .map(action => action.payload)
    .switchMap(referenceNo => this.policyService.findIntakeByReferenceNo(referenceNo))
    .map(intake => this.intakeActions.findIntakeByReferenceNoSuccess(intake))
    .mergeMap(action => from([action,
      this.intakeActions.findProgramOfferings(action.payload),
      this.intakeActions.findSupervisorOfferings(action.payload),
      // this.intakeActions.findStudyModeOfferings(action.payload)
    ]));

  @Effect() findProgramOfferings$ = this.actions$
    .ofType(IntakeActions.FIND_PROGRAM_OFFERINGS)
    .map(action => action.payload)
    .switchMap(intake => this.policyService.findProgramOfferings(intake))
    .map(items => this.intakeActions.findProgramOfferingsSuccess(items));

  @Effect() findSupervisorOfferings$ = this.actions$
    .ofType(IntakeActions.FIND_SUPERVISOR_OFFERINGS)
    .map(action => action.payload)
    .switchMap(intake => this.policyService.findSupervisorOfferings(intake))
    .map(items => this.intakeActions.findSupervisorOfferingsSuccess(items));

  @Effect() findStudyModeOfferings$ = this.actions$
    .ofType(IntakeActions.FIND_STUDY_MODE_OFFERINGS)
    .map(action => action.payload)
    .switchMap(intake => this.policyService.findStudyModeOfferings(intake))
    .map(items => this.intakeActions.findStudyModeOfferingsSuccess(items));

  @Effect() startIntakeTask$ = this.actions$
    .ofType(IntakeActions.START_INTAKE_TASK)
    .map(action => action.payload)
    .switchMap(intake => this.policyService.startIntakeTask(intake))
    .map(() => this.intakeActions.findAssignedIntakeTasks())

  @Effect() completeIntakeTask$ = this.actions$
    .ofType(IntakeActions.COMPLETE_INTAKE_TASK)
    .map(action => action.payload);
  // todo
  // .switchMap(intake => this.policyService.startIntakeTask(intake))
  // .map(task => this.intakeActions.startIntakeTaskSuccess(task));

  @Effect() assignIntakeTask$ = this.actions$
    .ofType(IntakeActions.ASSIGN_INTAKE_TASK)
    .map(action => action.payload);
  // todo
  // .switchMap(intake => this.policyService.startIntakeTask(intake))
  // .map(task => this.intakeActions.startIntakeTaskSuccess(task));

  @Effect() releaseIntakeTask$ = this.actions$
    .ofType(IntakeActions.RELEASE_INTAKE_TASK)
    .map(action => action.payload);
  // todo
  // .switchMap(intake => this.policyService.startIntakeTask(intake))
  // .map(task => this.intakeActions.startIntakeTaskSuccess(task));

  @Effect() updateIntake$ = this.actions$
    .ofType(IntakeActions.UPDATE_INTAKE)
    .map(action => action.payload)
    .switchMap(intake => this.policyService.updateIntake(intake))
    .map(intake => this.intakeActions.updateIntakeSuccess(intake));

  @Effect() addProgramOffering$ = this.actions$
    .ofType(IntakeActions.ADD_PROGRAM_OFFERING)
    .map(action => action.payload)
    .mergeMap(payload => from([payload,
      this.policyService.addProgramOffering(payload.intake, payload.programOffering),
      this.policyService.findProgramOfferings(payload.intake)
    ]));
}
