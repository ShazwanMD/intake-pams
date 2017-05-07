import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from "rxjs/observable/from";
import {PolicyService} from "../../../services/policy.service";
import {switchMap} from "rxjs/operator/switchMap";
import {IntakeSessionActions} from "./intake-session.action";


@Injectable()
export class IntakeSessionEffects {
  constructor(private actions$: Actions,
              private intakeSessionActions: IntakeSessionActions,
              private policyService: PolicyService) {
  }
}

