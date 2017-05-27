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

  @Effect() findDunCodes$ = this.actions$
    .ofType(CommonActions.FIND_DUN_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findDunCodes())
    .map(codes => this.commonActions.findDunCodesSuccess(codes));

  @Effect() findParliamentCodes$ = this.actions$
    .ofType(CommonActions.FIND_PARLIAMENT_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findParliamentCodes())
    .map(codes => this.commonActions.findParliamentCodesSuccess(codes));

  @Effect() findGenderCodes$ = this.actions$
    .ofType(CommonActions.FIND_GENDER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGenderCodes())
    .map(codes => this.commonActions.findGenderCodesSuccess(codes));

  @Effect() findMaritalCodes$ = this.actions$
    .ofType(CommonActions.FIND_MARITAL_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findMaritalCodes())
    .map(codes => this.commonActions.findMaritalCodesSuccess(codes));

  @Effect() findDisabilityCodes$ = this.actions$
    .ofType(CommonActions.FIND_DISABILITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findDisabilityCodes())
    .map(codes => this.commonActions.findDisabilityCodesSuccess(codes));

  @Effect() findSchoolCodes$ = this.actions$
    .ofType(CommonActions.FIND_SCHOOL_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findSchoolCodes())
    .map(codes => this.commonActions.findSchoolCodesSuccess(codes));

  @Effect() findFacultyCodes$ = this.actions$
    .ofType(CommonActions.FIND_FACULTY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findFacultyCodes())
    .map(codes => this.commonActions.findFacultyCodesSuccess(codes));

  @Effect() findGraduateCentres$ = this.actions$
    .ofType(CommonActions.FIND_GRADUATE_CENTRES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGraduateCentres())
    .map(centres => this.commonActions.findGraduateCentresSuccess(centres));

  @Effect() findProgramCodes$ = this.actions$
    .ofType(CommonActions.FIND_PROGRAM_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findProgramCodes())
    .map(codes => this.commonActions.findProgramCodesSuccess(codes));

  @Effect() findStudyMode$ = this.actions$
    .ofType(CommonActions.FIND_STUDY_MODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStudyModes())
    .map(codes => this.commonActions.findStudyModeSuccess(codes));

  @Effect() findSupervisorCodes$ = this.actions$
    .ofType(CommonActions.FIND_SUPERVISOR_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findSupervisorCodes())
    .map(codes => this.commonActions.findSupervisorCodesSuccess(codes));

  @Effect() findRaceCodes$ = this.actions$
    .ofType(CommonActions.FIND_RACE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findRaceCodes())
    .map(codes => this.commonActions.findRaceCodesSuccess(codes));

  @Effect() findStateCodes$ = this.actions$
    .ofType(CommonActions.FIND_STATE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStateCodes())
    .map(codes => this.commonActions.findStateCodesSuccess(codes));

  @Effect() findCountryCodes$ = this.actions$
    .ofType(CommonActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.commonActions.findCountryCodesSuccess(codes));

  @Effect() findReligionCodes$ = this.actions$
    .ofType(CommonActions.FIND_RELIGION_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findReligionCodes())
    .map(codes => this.commonActions.findReligionCodesSuccess(codes));

  @Effect() findStudyCenterCodes$ = this.actions$
    .ofType(CommonActions.FIND_STUDY_CENTER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStudyCenterCodes())
    .map(codes => this.commonActions.findStudyCenterCodesSuccess(codes));

  @Effect() findEthnicityCodes$ = this.actions$
    .ofType(CommonActions.FIND_ETHNICITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findEthnicityCodes())
    .map(codes => this.commonActions.findEthnicityCodesSuccess(codes));

  @Effect() findNationalityCodes$ = this.actions$
    .ofType(CommonActions.FIND_NATIONALITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findNationalityCodes())
    .map(codes => this.commonActions.findNationalityCodesSuccess(codes));


  @Effect() findResidencyCodes$ = this.actions$
    .ofType(CommonActions.FIND_RESIDENCY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findResidencyCodes())
    .map(codes => this.commonActions.findResidencyCodesSuccess(codes));

}
