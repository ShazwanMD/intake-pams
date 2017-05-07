import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {ProgramActions} from "./program.action";
import {from} from "rxjs/observable/from";
import {PolicyService} from "../../../services/policy.service";
import {switchMap} from "rxjs/operator/switchMap";


@Injectable()
export class ProgramEffects {
  constructor(private actions$: Actions,
              private programActions: ProgramActions,
              private policyService: PolicyService) {
  }

  @Effect() addProgramOffering$ = this.actions$
    .ofType(ProgramActions.ADD_PROGRAM_OFFERING)
    .map(action => action.payload)
    .switchMap(payload => this.policyService.addProgramOffering(payload.program, payload.programOffering))
    .map(message => this.programActions.addProgramOfferingSuccess(message));
}
