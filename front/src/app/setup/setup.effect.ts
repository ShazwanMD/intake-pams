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

  @Effect() findCountryCode$ = this.actions$
    .ofType(SetupActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.setupActions.findCountryCodesSuccess(codes));

  @Effect() saveCountryCodes$ = this.actions$
    .ofType(SetupActions.SAVE_COUNTRY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveCountryCode(payload))
    .map(message => this.setupActions.saveCountryCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findCountryCodes()]));

  @Effect() updateCountryCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_COUNTRY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateCountryCode(payload))
    .map(message => this.setupActions.updateCountryCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findCountryCodes()]));

  @Effect() removeCountryCode$ = this.actions$
    .ofType(SetupActions.REMOVE_COUNTRY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeCountryCode(payload))
    .map(message => this.setupActions.removeCountryCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findCountryCodes()]));

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

  // ====================================================================================================
  // DISABILITY CODE
  // ====================================================================================================

  @Effect() findDisabilityCode$ = this.actions$
    .ofType(SetupActions.FIND_DISABILITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findDisabilityCodes())
    .map(codes => this.setupActions.findDisabilityCodesSuccess(codes));

  @Effect() saveDisabilityCodes$ = this.actions$
    .ofType(SetupActions.SAVE_DISABILITY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveDisabilityCode(payload))
    .map(message => this.setupActions.saveDisabilityCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findDisabilityCodes()]));

  @Effect() updateDisabilityCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_DISABILITY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateDisabilityCode(payload))
    .map(message => this.setupActions.updateDisabilityCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findDisabilityCodes()]));

  @Effect() removeDisabilityCode$ = this.actions$
    .ofType(SetupActions.REMOVE_DISABILITY_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeDisabilityCode(payload))
    .map(message => this.setupActions.removeDisabilityCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findDisabilityCodes()]));

  // ====================================================================================================
  // SCHOOL CODE
  // ====================================================================================================

  @Effect() findSchoolCode$ = this.actions$
    .ofType(SetupActions.FIND_SCHOOL_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findSchoolCodes())
    .map(codes => this.setupActions.findSchoolCodesSuccess(codes));

  @Effect() saveSchoolCodes$ = this.actions$
    .ofType(SetupActions.SAVE_SCHOOL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveSchoolCode(payload))
    .map(message => this.setupActions.saveSchoolCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findSchoolCodes()]));

  @Effect() updateSchoolCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_SCHOOL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateSchoolCode(payload))
    .map(message => this.setupActions.updateSchoolCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findSchoolCodes()]));

  @Effect() removeSchoolCode$ = this.actions$
    .ofType(SetupActions.REMOVE_SCHOOL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeSchoolCode(payload))
    .map(message => this.setupActions.removeSchoolCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findSchoolCodes()]));


  //=====================================================================================================
  // STUDY CENTER CODE
  // ====================================================================================================

  @Effect() findStudyCenterCodes$ = this.actions$
    .ofType(SetupActions.FIND_STUDY_CENTER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStudyCenterCodes())
    .map(codes => this.setupActions.findStudyCenterCodesSuccess(codes));

  @Effect() saveStudyCenterCodes$ = this.actions$
    .ofType(SetupActions.SAVE_STUDY_CENTER_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveStudyCenterCode(payload))
    .map(message => this.setupActions.saveStudyCenterCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findStudyCenterCodes()]));

  @Effect() updateStudyCenterCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_STUDY_CENTER_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateStudyCenterCode(payload))
    .map(message => this.setupActions.updateStudyCenterCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findStudyCenterCodes()]));

  @Effect() removeStudyCenterCode$ = this.actions$
    .ofType(SetupActions.REMOVE_STUDY_CENTER_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeStudyCenterCode(payload))
    .map(message => this.setupActions.removeStudyCenterCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findStudyCenterCodes()]));    

    
}
