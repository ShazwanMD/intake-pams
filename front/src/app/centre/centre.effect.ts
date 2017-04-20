import {Injectable} from "@angular/core";
import {Effect, Actions} from '@ngrx/effects';
import {CentreActions} from "./centre.action";
import {CommonService} from "../../services/common.service";

@Injectable()
export class CentreEffects {
  constructor(private actions$: Actions,
              private centreActions: CentreActions,
              private commonService: CommonService) {
  }

  @Effect() findGraduateCentreByCode$ = this.actions$
    .ofType(CentreActions.FIND_GRADUATE_CENTRE_BY_CODE)
    .map(action => action.payload)
    .switchMap(code => this.commonService.findGraduateCentreByCode(code))
    .map(graduateCentre => this.centreActions.findGraduateCentreByCodeSuccess(graduateCentre));

  @Effect() findProgramCodes$ = this.actions$
    .ofType(CentreActions.FIND_PROGRAM_CODES)
    .map(action => action.payload)
    .switchMap(graduateCentre => this.commonService.findProgramCodesByGraduateCentre(graduateCentre))
    .map(programCodes => this.centreActions.findProgramCodesSuccess(programCodes));
}
