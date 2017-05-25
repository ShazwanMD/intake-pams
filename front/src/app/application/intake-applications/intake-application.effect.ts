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


  @Effect() findIntakeByReferenceNo$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO)
    .map(action => action.payload)
    .switchMap(referenceNo => this.applicationService.findIntakeByReferenceNo(referenceNo))
    .map(intake => this.intakeApplicationActions.findIntakeByReferenceNoSuccess(intake));

  @Effect() findProgramOfferingsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_PROGRAM_OFFERINGS_BY_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findProgramOfferingsByIntakeApplication(application))
    .map(offerings => this.intakeApplicationActions.findProgramOfferingsByIntakeApplicationSuccess(offerings));


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
    ]));

  @Effect() updateIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.updateIntakeApplication(application));

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

  @Effect() addEducation = this.actions$
    .ofType(IntakeApplicationActions.ADD_EDUCATION)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addEducation(payload.intake, payload.education))
    .map(message => this.intakeApplicationActions.addEducationSuccess(message));

  @Effect() addEmployment = this.actions$
    .ofType(IntakeApplicationActions.ADD_EMPLOYMENT)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addEmployment(payload.application, payload.employment))
    .map(message => this.intakeApplicationActions.addEmploymentSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map(state => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() addAddress = this.actions$
    .ofType(IntakeApplicationActions.ADD_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addAddress(payload.intake, payload.address))
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

}
