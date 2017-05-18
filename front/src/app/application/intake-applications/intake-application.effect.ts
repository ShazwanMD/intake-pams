import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from "rxjs/observable/from";
import {IntakeApplicationActions} from "./intake-application.action";
import {ApplicationService} from "../../../services/application.service";
import {Router} from "@angular/router";
import { Store } from "@ngrx/store";
import { ApplicationModuleState } from "../index";
import {Observable} from "rxjs";
import { Intake } from "../../policy/intakes/intake.interface";


@Injectable()
export class IntakeApplicationEffects {

  private INTAKE = "applicationModuleState.intake".split(".");  
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


  @Effect() findIntakeApplications$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_APPLICATIONS)
    .switchMap(() => this.applicationService.findIntakeApplications())
    .map(applications => this.intakeApplicationActions.findIntakeApplicationsSuccess(applications));


  @Effect() applyIntakeCps$ = this.actions$
    .ofType(IntakeApplicationActions.APPLY_INTAKE_CPS)
    .map(action => action.payload)
    .switchMap(intake => this.applicationService.applyIntake(intake))
    //.withLatestFrom(this.store$.select(...this.INTAKE))
   // .map(state=>state[1])
   // .map(intake => this.intakeApplicationActions.findIntakeByReferenceNoSuccess(intake))
    //todo:uda
    .mergeMap(referenceNo => from([referenceNo,
      this.intakeApplicationActions.applyIntakeCpsSuccess(referenceNo),
      this.router.navigate(['/application/intake-applications/cps/',referenceNo])
    ]));
  
  @Effect() applyIntakeMgseb$ = this.actions$
  .ofType(IntakeApplicationActions.APPLY_INTAKE_MGSEB)
  .map(action => action.payload)
  .switchMap(intake => this.applicationService.applyIntake(intake))
  .withLatestFrom(this.store$.select(...this.INTAKE))
  .map(state=>state[1])
  .map(intake => this.intakeApplicationActions.findIntakeByReferenceNoSuccess(intake))
  //todo:uda
  .mergeMap(referenceNo => from([referenceNo,
    this.intakeApplicationActions.applyIntakeMgsebSuccess(referenceNo),
    this.router.navigate(['/application/intake-applications/mgseb/',referenceNo])
  ]));


  // ====================================================================================================
  // INTAKE APPLICATION
  // ====================================================================================================

  @Effect() findIntakeApplicationByReferenceNo$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO)
    .map(action => action.payload)
    .switchMap(referenceNo => this.applicationService.findIntakeApplicationByReferenceNo(referenceNo))
    .map(application => this.intakeApplicationActions.findIntakeApplicationByReferenceNoSuccess(application))
    .mergeMap(action => from([action,
      this.intakeApplicationActions.findEducations(action.payload),
      this.intakeApplicationActions.findEmployments(action.payload),
      this.intakeApplicationActions.findAddresses(action.payload),
    ]));

  @Effect() updateIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.updateIntakeApplication(application));
  // .map(message => this.intakeApplicationActions.updateIntakeSuccess(todo));

  @Effect() submitIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.SUBMIT_INTAKE_APPLICATION)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.submitIntakeApplication(payload.application))
    .map(referenceNo => this.intakeApplicationActions.submitIntakeApplicationSuccess(referenceNo))

  @Effect() findEducations$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_EDUCATIONS)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findEducations(application))
    .map(educations => this.intakeApplicationActions.findEducationsSuccess(educations));

  @Effect() addEducation = this.actions$
    .ofType(IntakeApplicationActions.ADD_EDUCATION)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addEducation(payload.intake, payload.education))
    .map(message => this.intakeApplicationActions.addEducationSuccess(message));

  @Effect() findEmployments$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_EMPLOYMENTS)
    .map(action => action.payload)
    .switchMap(application => this.applicationService.findEmployments(application))
    .map(employments => this.intakeApplicationActions.findEmploymentsSuccess(employments));

  @Effect() addEmployment = this.actions$
    .ofType(IntakeApplicationActions.ADD_EMPLOYMENT)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addEmployment(payload.intake, payload.employment))
    .map(message => this.intakeApplicationActions.addEmploymentSuccess(message));

  @Effect() addAddress = this.actions$
    .ofType(IntakeApplicationActions.ADD_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.applicationService.addAddress(payload.intake, payload.address))
    .map(message => this.intakeApplicationActions.addAddressSuccess(message));
}
