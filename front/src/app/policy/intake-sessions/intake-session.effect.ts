import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from "rxjs/observable/from";
import {PolicyService} from "../../../services/policy.service";
import {switchMap} from "rxjs/operator/switchMap";
import {IntakeSessionActions} from "./intake-session.action";
import {ProgramLevelActions} from "../program-levels/program-level.action";


@Injectable()
export class IntakeSessionEffects {
  constructor(private actions$: Actions,
              private intakeSessionActions: IntakeSessionActions,
              private policyService: PolicyService) {
  }

  @Effect() findIntakeSessions$ = this.actions$
    .ofType(IntakeSessionActions.FIND_INTAKE_SESSIONS)
    .map(action => action.payload)
    .switchMap(() => this.policyService.findIntakeSessions())
    .map(sessions => this.intakeSessionActions.findIntakeSessionsSuccess(sessions));

  @Effect() saveIntakeSessions$ = this.actions$
    .ofType(IntakeSessionActions.SAVE_INTAKE_SESSIONS)
    .map(action => action.payload)
    .switchMap(payload => this.policyService.saveIntakeSession(payload))
    .map(message => this.intakeSessionActions.saveIntakeSessionSuccess(message))
    .mergeMap(action => from([action, this.intakeSessionActions.findIntakeSessions()]));


  @Effect() updateIntakeSession$ = this.actions$
    .ofType(IntakeSessionActions.UPDATE_INTAKE_SESSION)
    .map(action => action.payload)
    .switchMap(payload => this.policyService.updateIntakeSession(payload))
    .map(message => this.intakeSessionActions.updateIntakeSessionSuccess(message))
    .mergeMap(action => from([action, this.intakeSessionActions.findIntakeSessions()]));

  @Effect() removeIntakeSession$ = this.actions$
    .ofType(IntakeSessionActions.REMOVE_INTAKE_SESSION)
    .map(action => action.payload)
    .switchMap(payload => this.policyService.removeIntakeSession(payload))
    .map(message => this.intakeSessionActions.removeIntakeSessionSuccess(message))
    .mergeMap(action => from([action, this.intakeSessionActions.findIntakeSessions()]));

}

