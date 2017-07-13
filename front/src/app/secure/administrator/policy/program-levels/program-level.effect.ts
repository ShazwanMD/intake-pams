import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from "rxjs/observable/from";
import {PolicyService} from "../../../../../services/policy.service";
import {switchMap} from "rxjs/operator/switchMap";
import {ProgramLevelActions} from "./program-level.action";


@Injectable()
export class ProgramLevelEffects {
  constructor(private actions$: Actions,
              private programLevelActions: ProgramLevelActions,
              private policyService: PolicyService) {
  }

  @Effect() findProgramLevels$ = this.actions$
    .ofType(ProgramLevelActions.FIND_PROGRAM_LEVELS)
    .map(action => action.payload)
    .switchMap(() => this.policyService.findProgramLevels())
    .map(levels => this.programLevelActions.findProgramLevelsSuccess(levels));
}
