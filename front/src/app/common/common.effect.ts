import {Injectable} from "@angular/core";
import {Effect, Actions} from '@ngrx/effects';
import {CommonService} from "../../services/common.service";
import {CommonActions} from "./common.action";

@Injectable()
export class CommonEffects {
  constructor(private actions$: Actions,
              private commonActions: CommonActions,
              private commonService: CommonService) {
  }

  @Effect() findFacultyCodes$ = this.actions$
    .ofType(CommonActions.FIND_FACULTY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findFacultyCodes())
    .map(codes => this.commonActions.findFacultyCodesSuccess(codes));


  @Effect() findProgramCodes$ = this.actions$
    .ofType(CommonActions.FIND_PROGRAM_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findProgramCodes())
    .map(codes => this.commonActions.findProgramCodesSuccess(codes));

  // @Effect() findSupervisorCodes$ = this.actions$
  //   .ofType(CommonActions.FIND_SUPERVISOR_CODES)
  //   .map(action => action.payload)
  //   .switchMap(() => this.commonService.findSupervisorCodes(code))
  //   .map(codes => this.commonActions.findSupervisorCodesSuccess(codes));

  // @Effect() findStudyModes$ = this.actions$
  //   .ofType(CommonActions.FIND_STUDY_MODES)
  //   .map(action => action.payload)
  //   .switchMap(() => this.commonService.findStudyModes())
  //   .map(codes => this.commonActions.findStudyModesSuccess(codes));
}
