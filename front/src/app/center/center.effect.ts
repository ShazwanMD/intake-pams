import {Injectable} from "@angular/core";
import {Effect, Actions} from '@ngrx/effects';
import {CenterActions} from "./center.action";
import {CommonService} from "../../services/common.service";

@Injectable()
export class CenterEffects {
  constructor(private actions$: Actions,
              private centerActions: CenterActions,
              private commonService: CommonService) {
  }

  @Effect() findGraduateCenterByCode$ = this.actions$
    .ofType(CenterActions.FIND_GRADUATE_CENTER_BY_CODE)
    .map(action => action.payload)
    .switchMap(code => this.commonService.findGraduateCenterByCode(code))
    .map(graduateCenter => this.centerActions.findGraduateCenterByCodeSuccess(graduateCenter));

  @Effect() findProgramCodes$ = this.actions$
    .ofType(CenterActions.FIND_PROGRAM_CODES)
    .map(action => action.payload)
    .switchMap(graduateCenter => this.commonService.findProgramCodesByGraduateCenter(graduateCenter))
    .map(programCodes => this.centerActions.findProgramCodesSuccess(programCodes));
}
