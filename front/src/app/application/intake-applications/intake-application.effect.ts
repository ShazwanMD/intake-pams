import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from "rxjs/observable/from";
import {IntakeApplicationActions} from "./intake-application.action";
import {ApplicationService} from "../../../services/application.service";
import {Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../index";
import {Observable} from "rxjs";
import {Intake} from "../../policy/intakes/intake.interface";
import {IntakeApplication} from "./intake-application.interface";


@Injectable()
export class IntakeApplicationEffects {

  private INTAKE = "applicationModuleState.intake".split(".");
  private INTAKE_APPLICATION = "applicationModuleState.intakeApplication".split(".");
  private intake$: Observable<Intake>;

  constructor(private actions$: Actions,
              private intakeApplicationActions: IntakeApplicationActions,
              private applicationService: ApplicationService,
              private router: Router,
              private store$: Store<ApplicationModuleState>) {
    this.intake$ = this.store$.select(...this.INTAKE);
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  @Effect() findIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKES)
    .switchMap(() => this.applicationService.findIntakes())
    .map(intakes => this.intakeApplicationActions.findIntakesSuccess(intakes));

  @Effect() findPublishedIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_PUBLISHED_INTAKES)
    .switchMap(() => this.applicationService.findPublishedIntakes())
    .map(intakes => this.intakeApplicationActions.findPublishedIntakesSuccess(intakes));


  @Effect() findIntakeByReferenceNo$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO)
    .map(action => action.payload)
    .switchMap(referenceNo => this.applicationService.findIntakeByReferenceNo(referenceNo))
    .map(intake => this.intakeApplicationActions.findIntakeByReferenceNoSuccess(intake))
    .mergeMap(action => from([action,
      this.intakeApplicationActions.findProgramOfferingsByIntake(action.payload),
      this.intakeApplicationActions.findStudyModeOfferingsByIntake(action.payload)
    ]));

  @Effect() findProgramOfferingsByIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_PROGRAM_OFFERINGS_BY_INTAKE)
    .map(action => action.payload)
    .switchMap(intake => this.applicationService.findProgramOfferingsByIntake(intake))
    .map(offerings => this.intakeApplicationActions.findProgramOfferingsByIntakeSuccess(offerings));


  @Effect() findStudyModeOfferingsByIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_STUDY_MODE_OFFERINGS_BY_INTAKE)
    .map(action => action.payload)
    .switchMap(intake => this.applicationService.findStudyModeOfferingsByIntake(intake))
    .map(offerings => this.intakeApplicationActions.findStudyModeOfferingsByIntakeSuccess(offerings));


  @Effect() findIntakeApplications$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_APPLICATIONS)
    .switchMap(() => this.applicationService.findIntakeApplications())
    .map(applications => this.intakeApplicationActions.findIntakeApplicationsSuccess(applications));


  @Effect() applyIntake$ = this.actions$
    .ofType(IntakeApplicationActions.APPLY_INTAKE)
    .map(action => action.payload)
    .switchMap(intake => this.applicationService.applyIntake(intake))
    .do(application =>
      this.router.navigate(['/application/intake-applications/',
        application.intake.graduateCentre.code.toLocaleLowerCase(),
        application.referenceNo])
    ).ignoreElements();

  // ====================================================================================================
  // INTAKE APPLICATION
  // ====================================================================================================

  @Effect() findIntakeApplicationByReferenceNo$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO)
    .map(action => action.payload)
    .switchMap(referenceNo => this.applicationService.findIntakeApplicationByReferenceNo(referenceNo))
    .map(application => this.intakeApplicationActions.findIntakeApplicationByReferenceNoSuccess(application))
    .mergeMap(action => from([action,
      this.intakeApplicationActions.findEmploymentsByIntakeApplication(action.payload),
      this.intakeApplicationActions.findEducationsByIntakeApplication(action.payload),
      this.intakeApplicationActions.findAddressesByIntakeApplication(action.payload),
      this.intakeApplicationActions.findRefereesByIntakeApplication(action.payload),
      this.intakeApplicationActions.findLanguagesByIntakeApplication(action.payload),
      this.intakeApplicationActions.findSpmResultsByIntakeApplication(action.payload),
      this.intakeApplicationActions.findBachelorResultsByIntakeApplication(action.payload),
      this.intakeApplicationActions.findDiplomaResultsByIntakeApplication(action.payload),

    ]));

  @Effect() updateIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.updateIntakeApplication(application))
    .map(message => this.intakeApplicationActions.updateIntakeSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() submitIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.SUBMIT_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.submitIntakeApplication(payload.application))
    .map(referenceNo => this.intakeApplicationActions.submitIntakeApplicationSuccess(referenceNo))

  @Effect() findEducationsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_EDUCATIONS_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findEducationsByIntakeApplication(application))
    .map(educations => this.intakeApplicationActions.findEducationsByIntakeApplicationSuccess(educations));

  @Effect() findRefereesByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_REFEREES_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findRefereesByIntakeApplication(application))
    .map(referees => this.intakeApplicationActions.findRefereesByIntakeApplicationSuccess(referees));

  @Effect() findEmploymentsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findEmploymentsByIntakeApplication(application))
    .map(employments => this.intakeApplicationActions.findEmploymentsByIntakeApplicationSuccess(employments));

  @Effect() findLanguagesByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_LANGUAGES_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findLanguagesByIntakeApplication(application))
    .map(languages => this.intakeApplicationActions.findLanguagesByIntakeApplicationSuccess(languages));


  @Effect() findAddressesByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_ADDRESSES_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findAddressesByIntakeApplication(application))
    .map(addresses => this.intakeApplicationActions.findAddressesByIntakeApplicationSuccess(addresses));

  @Effect() addEducation = this.actions$
    .ofType(IntakeApplicationActions.ADD_EDUCATION)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addEducation(payload.intake, payload.education))
    .map(message => this.intakeApplicationActions.addEducationSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() addEmployment = this.actions$
    .ofType(IntakeApplicationActions.ADD_EMPLOYMENT)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addEmployment(payload.application, payload.employment))
    .map(message => this.intakeApplicationActions.addEmploymentSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() addLanguage = this.actions$
    .ofType(IntakeApplicationActions.ADD_LANGUAGE)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addLanguage(payload.application, payload.language))
    .map(message => this.intakeApplicationActions.addLanguageSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() addAddress = this.actions$
    .ofType(IntakeApplicationActions.ADD_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addAddress(payload.application, payload.address))
    .map(message => this.intakeApplicationActions.addAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() addReferee = this.actions$
    .ofType(IntakeApplicationActions.ADD_REFEREE)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addReferee(payload.application, payload.referee))
    .map(message => this.intakeApplicationActions.addRefereeSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() findSpmResultsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_SPM_RESULTS_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findSpmResultsByIntakeApplication(application))
    .map(spmResults => this.intakeApplicationActions.findSpmResultsByIntakeApplicationSuccess(spmResults));

  @Effect() addSpmResult = this.actions$
    .ofType(IntakeApplicationActions.ADD_SPM_RESULT)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addSpmResult(payload.application, payload.spmResult))
    .map(message => this.intakeApplicationActions.addSpmResultSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() selectProgramOffering = this.actions$
    .ofType(IntakeApplicationActions.SELECT_PROGRAM_OFFERING)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.selectProgramOffering(payload.application, payload.offering))
    .map(message => this.intakeApplicationActions.selectProgramOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() selectStudyModeOffering = this.actions$
    .ofType(IntakeApplicationActions.SELECT_STUDY_MODE_OFFERING)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.selectStudyModeOffering(payload.application, payload.offering))
    .map(message => this.intakeApplicationActions.selectStudyModeOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() findBachelorResultsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_BACHELOR_RESULTS_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findBachelorResultsByIntakeApplication(application))
    .map(bachelorResults => this.intakeApplicationActions.findBachelorResultsByIntakeApplicationSuccess(bachelorResults));

  @Effect() addBachelorResult = this.actions$
    .ofType(IntakeApplicationActions.ADD_BACHELOR_RESULT)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addBachelorResult(payload.application, payload.bachelorResult))
    .map(message => this.intakeApplicationActions.addBachelorResultSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() findDiplomaResultsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_DIPLOMA_RESULTS_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findDiplomaResultsByIntakeApplication(application))
    .map(diplomaResults => this.intakeApplicationActions.findDiplomaResultsByIntakeApplicationSuccess(diplomaResults));

  @Effect() addDiplomaResult = this.actions$
    .ofType(IntakeApplicationActions.ADD_DIPLOMA_RESULT)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addDiplomaResult(payload.application, payload.diplomaResult))
    .map(message => this.intakeApplicationActions.addDiplomaResultSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() deleteEmployment$ = this.actions$
   .ofType(IntakeApplicationActions.DELETE_EMPLOYMENT)
   .map(action => action.payload)
   .switchMap(payload => this.applicationService.deleteEmployment(payload.application, payload.employment))
   .map(message => this.intakeApplicationActions.deleteEmploymentSucces(message))
   .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
   .map(state => state[1])
   .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() deleteAddress$ = this.actions$
   .ofType(IntakeApplicationActions.DELETE_ADDRESS)
   .map(action => action.payload)
   .switchMap(payload => this.applicationService.deleteAddress(payload.application, payload.employment))
   .map(message => this.intakeApplicationActions.deleteAddressSucces(message))
   .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
   .map(state => state[1])
   .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));       

}
