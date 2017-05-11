import {Injectable} from "@angular/core";
import {Effect, Actions} from '@ngrx/effects';
import {SetupActions} from "./setup.action";
import {CommonService} from "../../services/common.service";
import {from} from "rxjs/observable/from";

@Injectable()
export class SetupEffects {
  constructor(private actions$: Actions,
              private commonActions: SetupActions,
              private commonService: CommonService) {
  }

  @Effect() findBankCode$ = this.actions$
    .ofType(SetupActions.FIND_BANK_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findBankCodes())
    .map(codes => this.commonActions.findBankCodesSuccess(codes))

  @Effect() findGraduateCentres$ = this.actions$
    .ofType(SetupActions.FIND_GRADUATE_CENTRES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGraduateCentres())
    .map(codes => this.commonActions.findGraduateCentresSuccess(codes))

  @Effect() saveGraduateCentre$ = this.actions$
    .ofType(SetupActions.SAVE_GRADUATE_CENTRE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveGraduateCentre(payload))
    .map(message => this.commonActions.saveGraduateCentreSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findGraduateCentres()]));

   @Effect() findReligionCode$ = this.actions$
    .ofType(SetupActions.FIND_RELIGION_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findReligionCodes())
    .map(codes => this.commonActions.findReligionCodesSuccess(codes))

    @Effect() findMaritalCode$ = this.actions$
    .ofType(SetupActions.FIND_MARITAL_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findMaritalCodes())
    .map(codes => this.commonActions.findMaritalCodesSuccess(codes))

    @Effect() findCountryCodes$ = this.actions$
    .ofType(SetupActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.commonActions.findCountryCodesSuccess(codes));

    @Effect() findStateCodes$ = this.actions$
    .ofType(SetupActions.FIND_STATE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStateCodes())
    .map(codes => this.commonActions.findStateCodesSuccess(codes));

    @Effect() findProgramCodes$ = this.actions$
    .ofType(SetupActions.FIND_PROGRAM_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findProgramCodes())
    .map(codes => this.commonActions.findProgramCodesSuccess(codes));

    @Effect() saveProgramCodes$ = this.actions$
    .ofType(SetupActions.SAVE_PROGRAM_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveProgramCode(payload))
    .map(message => this.commonActions.saveProgramCodeSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findProgramCodes()]));

    @Effect() findSupervisorCodes$ = this.actions$
    .ofType(SetupActions.FIND_SUPERVISOR_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findSupervisorCodes())
    .map(codes => this.commonActions.findSupervisorCodesSuccess(codes));

    @Effect() saveSupervisorCodes$ = this.actions$
    .ofType(SetupActions.SAVE_SUPERVISOR_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveSupervisorCode(payload))
    .map(message => this.commonActions.saveSupervisorCodeSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findSupervisorCodes()]));

    @Effect() removeSupervisorCodes$ = this.actions$
    .ofType(SetupActions.REMOVE_SUPERVISOR_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeSupervisorCode(payload))
    .map(message => this.commonActions.removeSupervisorCodeSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findSupervisorCodes()]));

    @Effect() updateSupervisorCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_SUPERVISOR_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateSupervisorCode(payload))
    .map(message => this.commonActions.updateSupervisorCodeSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findSupervisorCodes()]));

    @Effect() findRaceCodes$ = this.actions$
    .ofType(SetupActions.FIND_RACE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findRaceCodes())
    .map(codes => this.commonActions.findRaceCodesSuccess(codes));

    @Effect() saveRaceCodes$ = this.actions$
    .ofType(SetupActions.SAVE_RACE_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveRaceCode(payload))
    .map(message => this.commonActions.saveRaceCodeSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findRaceCodes()]));    

    @Effect() findGenderCodes$ = this.actions$
    .ofType(SetupActions.FIND_GENDER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGenderCodes())
    .map(codes => this.commonActions.findGenderCodesSuccess(codes));

    @Effect() saveGenderCodes$ = this.actions$
    .ofType(SetupActions.SAVE_GENDER_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveGenderCode(payload))
    .map(message => this.commonActions.saveGenderCodeSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findGenderCodes()]));     

     @Effect() findEthnicityCodes$ = this.actions$
    .ofType(SetupActions.FIND_ETHNICITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findEthnicityCodes())
    .map(codes => this.commonActions.findEthnicityCodesSuccess(codes));

     @Effect() findNationalityCodes$ = this.actions$
    .ofType(SetupActions.FIND_NATIONALITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findNationalityCodes())
    .map(codes => this.commonActions.findNationalityCodesSuccess(codes));    

    @Effect() findFacultyCodes$ = this.actions$
    .ofType(SetupActions.FIND_FACULTY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findFacultyCodes())
    .map(codes => this.commonActions.findFacultyCodesSuccess(codes));

    @Effect() saveFacultyCodes$ = this.actions$
    .ofType(SetupActions.SAVE_FACULTY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveFacultyCode(payload))
    .map(message => this.commonActions.saveFacultyCodeSuccess(message))
    .mergeMap(action => from([action, this.commonActions.findFacultyCodes()]));     

}