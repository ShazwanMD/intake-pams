import {Injectable} from "@angular/core";
import {Effect, Actions} from '@ngrx/effects';
import {SetupActions} from "./setup.action";
import {CommonService} from "../../services/common.service";
import {from} from "rxjs/observable/from";
import {SetupModuleState} from "./index";
import {Store} from "@ngrx/store";

@Injectable()
export class SetupEffects {
  constructor(private actions$: Actions,
              private setupActions: SetupActions,
              private commonService: CommonService,
              private store: Store<SetupModuleState>) {
  }

  // ====================================================================================================
  // TITLE
  // ====================================================================================================

  @Effect() changeTitle$ = this.actions$
    .ofType(SetupActions.CHANGE_TITLE)
    .map(action => action.payload)
    .map(payload => this.setupActions.changeTitleSuccess(payload));

  @Effect() findBankCode$ = this.actions$
    .ofType(SetupActions.FIND_BANK_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findBankCodes())
    .map(codes => this.setupActions.findBankCodesSuccess(codes));

  // ====================================================================================================
  // GRADUATE CENTER
  // ====================================================================================================

  @Effect() findGraduateCentres$ = this.actions$
    .ofType(SetupActions.FIND_GRADUATE_CENTRES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGraduateCentres())
    .map(codes => this.setupActions.findGraduateCentresSuccess(codes));

  @Effect() saveGraduateCentre$ = this.actions$
    .ofType(SetupActions.SAVE_GRADUATE_CENTRE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveGraduateCentre(payload))
    .map(message => this.setupActions.saveGraduateCentreSuccess(message));

  // ====================================================================================================
  // RELIGION CODE
  // ====================================================================================================

  @Effect() findReligionCode$ = this.actions$
    .ofType(SetupActions.FIND_RELIGION_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findReligionCodes())
    .map(codes => this.setupActions.findReligionCodesSuccess(codes));

  // ====================================================================================================
  // MARITAL CODE
  // ====================================================================================================

  @Effect() findMaritalCode$ = this.actions$
    .ofType(SetupActions.FIND_MARITAL_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findMaritalCodes())
    .map(codes => this.setupActions.findMaritalCodesSuccess(codes));

  @Effect() saveMaritalCodes$ = this.actions$
    .ofType(SetupActions.SAVE_MARITAL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveMaritalCode(payload))
    .map(message => this.setupActions.saveMaritalCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findMaritalCodes()]));

  @Effect() updateMaritalCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_MARITAL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateMaritalCode(payload))
    .map(message => this.setupActions.updateMaritalCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findMaritalCodes()]));

  @Effect() removeMaritalCode$ = this.actions$
    .ofType(SetupActions.REMOVE_MARITAL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeMaritalCode(payload))
    .map(message => this.setupActions.removeMaritalCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findMaritalCodes()]));

  // ====================================================================================================
  // COUNTRY CODE
  // ====================================================================================================

  @Effect() findCountryCodes$ = this.actions$
    .ofType(SetupActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.setupActions.findCountryCodesSuccess(codes));

  // ====================================================================================================
  // STATE CODE
  // ====================================================================================================

  @Effect() findStateCodes$ = this.actions$
    .ofType(SetupActions.FIND_STATE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStateCodes())
    .map(codes => this.setupActions.findStateCodesSuccess(codes));

  // ====================================================================================================
  // PROGRAM CODE
  // ====================================================================================================

  @Effect() findProgramCodes$ = this.actions$
    .ofType(SetupActions.FIND_PROGRAM_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findProgramCodes())
    .map(codes => this.setupActions.findProgramCodesSuccess(codes));

  @Effect() saveProgramCodes$ = this.actions$
    .ofType(SetupActions.SAVE_PROGRAM_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveProgramCode(payload))
    .map(message => this.setupActions.saveProgramCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findProgramCodes()]));

  @Effect() removeProgramCode$ = this.actions$
    .ofType(SetupActions.REMOVE_PROGRAM_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeProgramCode(payload))
    .map(message => this.setupActions.removeProgramCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findProgramCodes()]));

  // ====================================================================================================
  // SUPERVISOR CODE
  // ====================================================================================================

  @Effect() findSupervisorCodes$ = this.actions$
    .ofType(SetupActions.FIND_SUPERVISOR_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findSupervisorCodes())
    .map(codes => this.setupActions.findSupervisorCodesSuccess(codes));

  @Effect() findSupervisorCodesByFilter$ = this.actions$
    .ofType(SetupActions.FIND_SUPERVISOR_CODES_BY_FILTER)
    .map(action => action.payload)
    .switchMap(filter => this.commonService.findSupervisorCodesByFilter(filter))
    .map(codes => this.setupActions.findSupervisorCodesByFilterSuccess(codes));


  @Effect() saveSupervisorCodes$ = this.actions$
    .ofType(SetupActions.SAVE_SUPERVISOR_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveSupervisorCode(payload))
    .map(message => this.setupActions.saveSupervisorCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findSupervisorCodes()]));

  @Effect() updateSupervisorCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_SUPERVISOR_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateSupervisorCode(payload))
    .map(message => this.setupActions.updateSupervisorCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findSupervisorCodes()]));

  @Effect() removeSupervisorCode$ = this.actions$
    .ofType(SetupActions.REMOVE_SUPERVISOR_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeSupervisorCode(payload))
    .map(message => this.setupActions.removeSupervisorCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findSupervisorCodes()]));

  // ====================================================================================================
  // RACE CODE
  // ====================================================================================================

  @Effect() findRaceCodes$ = this.actions$
    .ofType(SetupActions.FIND_RACE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findRaceCodes())
    .map(codes => this.setupActions.findRaceCodesSuccess(codes));

  @Effect() saveRaceCodes$ = this.actions$
    .ofType(SetupActions.SAVE_RACE_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveRaceCode(payload))
    .map(message => this.setupActions.saveRaceCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findRaceCodes()]));

  // ====================================================================================================
  // GENDER CODE
  // ====================================================================================================

  @Effect() findGenderCodes$ = this.actions$
    .ofType(SetupActions.FIND_GENDER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGenderCodes())
    .map(codes => this.setupActions.findGenderCodesSuccess(codes));

  @Effect() saveGenderCodes$ = this.actions$
    .ofType(SetupActions.SAVE_GENDER_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveGenderCode(payload))
    .map(message => this.setupActions.saveGenderCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findGenderCodes()]));

  // ====================================================================================================
  // ETHNICITY CODE
  // ====================================================================================================

  @Effect() findEthnicityCodes$ = this.actions$
    .ofType(SetupActions.FIND_ETHNICITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findEthnicityCodes())
    .map(codes => this.setupActions.findEthnicityCodesSuccess(codes));

  // ====================================================================================================
  // NATIONALITY CODE
  // ====================================================================================================

  @Effect() findNationalityCodes$ = this.actions$
    .ofType(SetupActions.FIND_NATIONALITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findNationalityCodes())
    .map(codes => this.setupActions.findNationalityCodesSuccess(codes));

  // ====================================================================================================
  // FACULTY CODE
  // ====================================================================================================

  @Effect() findFacultyCodes$ = this.actions$
    .ofType(SetupActions.FIND_FACULTY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findFacultyCodes())
    .map(codes => this.setupActions.findFacultyCodesSuccess(codes));

  @Effect() saveFacultyCodes$ = this.actions$
    .ofType(SetupActions.SAVE_FACULTY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveFacultyCode(payload))
    .map(message => this.setupActions.saveFacultyCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findFacultyCodes()]));

  // ====================================================================================================
  // STUDY CODE
  // ====================================================================================================

  @Effect() findStudyModes$ = this.actions$
    .ofType(SetupActions.FIND_STUDY_MODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStudyModes())
    .map(codes => this.setupActions.findStudyModesSuccess(codes));

  @Effect() saveStudyModes$ = this.actions$
    .ofType(SetupActions.SAVE_STUDY_MODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveStudyMode(payload))
    .map(message => this.setupActions.saveStudyModeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findStudyModes()]));

}
