import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from 'rxjs/observable/from';
import {IntakeApplicationActions} from './intake-application.action';
import {ApplicationService} from '../../../services/application.service';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../index';
import {Observable} from 'rxjs';
import {Intake} from '../../policy/intakes/intake.interface';
import {IntakeApplication} from './intake-application.interface';
import {IntakeActions} from '../../policy/intakes/intake.action';

@Injectable()
export class IntakeApplicationEffects {

  private INTAKE: string[] = 'applicationModuleState.intake'.split('.');
  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  private intake$: Observable<Intake>;

  constructor(private actions$: Actions,
              private intakeApplicationActions: IntakeApplicationActions,
              private intakeActions: IntakeActions,
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
    .map((intakes) => this.intakeApplicationActions.findIntakesSuccess(intakes));

  @Effect() findPublishedIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_PUBLISHED_INTAKES)
    .switchMap(() => this.applicationService.findPublishedIntakes())
    .map((intakes) => this.intakeApplicationActions.findPublishedIntakesSuccess(intakes));

  @Effect() findIntakeByReferenceNo$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.applicationService.findIntakeByReferenceNo(referenceNo))
    .map((intake) => this.intakeApplicationActions.findIntakeByReferenceNoSuccess(intake))
    .mergeMap((action) => from([action,
      this.intakeApplicationActions.findProgramOfferingsByIntake(action.payload),
      this.intakeApplicationActions.findStudyModeOfferingsByIntake(action.payload),
      this.intakeApplicationActions.findSupervisorOfferingsByIntake(action.payload),
    ]));

  @Effect() applyIntake$ = this.actions$
    .ofType(IntakeApplicationActions.APPLY_INTAKE)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.applyIntake(intake))
    .do((application) =>
      this.router.navigate(['/application/intake-applications/',
        application.intake.graduateCenter.code.toLocaleLowerCase(),
        application.referenceNo]),
    ).ignoreElements();

  // ====================================================================================================
  // PROGRAM_OFFERING
  // ====================================================================================================

  @Effect() findProgramOfferingsByIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_PROGRAM_OFFERINGS_BY_INTAKE)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findProgramOfferingsByIntake(intake))
    .map((offerings) => this.intakeApplicationActions.findProgramOfferingsByIntakeSuccess(offerings));

  // ====================================================================================================
  // SUPERVISOR_OFFERING
  // ====================================================================================================

  @Effect() findSupervisorOfferingsByIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_SUPERVISOR_OFFERINGS_BY_INTAKE)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findSupervisorOfferingsByIntake(intake))
    .map((offerings) => this.intakeApplicationActions.findSupervisorOfferingsByIntakeSuccess(offerings));

  // ====================================================================================================
  // STUDY_MODE_OFFERING
  // ====================================================================================================

  @Effect() findStudyModeOfferingsByIntake$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_STUDY_MODE_OFFERINGS_BY_INTAKE)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findStudyModeOfferingsByIntake(intake))
    .map((offerings) => this.intakeApplicationActions.findStudyModeOfferingsByIntakeSuccess(offerings));

  // ====================================================================================================
  // INTAKE_APPLICATION
  // ====================================================================================================

  @Effect() findIntakeApplications$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_APPLICATIONS)
    .switchMap(() => this.applicationService.findIntakeApplications())
    .map((applications) => this.intakeApplicationActions.findIntakeApplicationsSuccess(applications));

  @Effect() findIntakeApplicationByReferenceNo$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.applicationService.findIntakeApplicationByReferenceNo(referenceNo))
    .map((application) => this.intakeApplicationActions.findIntakeApplicationByReferenceNoSuccess(application))
    .mergeMap((action) => from([action,
      this.intakeApplicationActions.findEmploymentsByIntakeApplication(action.payload),
      this.intakeApplicationActions.findEducationsByIntakeApplication(action.payload),
      this.intakeApplicationActions.findRefereesByIntakeApplication(action.payload),
      this.intakeApplicationActions.findLanguagesByIntakeApplication(action.payload),
      this.intakeApplicationActions.findAttachmentsByIntakeApplication(action.payload),
      this.intakeApplicationActions.findResultsByIntakeApplication(action.payload),
    ]));

  @Effect() updateIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.updateIntakeApplication(application))
    .map((message) => this.intakeApplicationActions.updateIntakeSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() submitIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.SUBMIT_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.submitIntakeApplication(application))
    .map((message) => this.intakeApplicationActions.submitIntakeApplicationSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((applications) => this.intakeApplicationActions.findIntakeApplications());

  @Effect() selectIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.SELECT_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.selectIntakeApplication(application))
    .map((message) => this.intakeApplicationActions.selectIntakeApplicationSuccess(message));

  @Effect() rejectIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.REJECT_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.rejectIntakeApplication(application))
    .map((message) => this.intakeApplicationActions.rejectIntakeApplicationSuccess(message));

  @Effect() findSubmittedIntakeApplications$ = this.actions$
    .ofType(IntakeActions.FIND_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findSubmittedIntakeApplications(intake))
    .map((applications) => this.intakeActions.findIntakeApplicationsSuccess(applications));

  // ====================================================================================================
  // EDUCATION
  // ====================================================================================================

  @Effect() findEducationsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_EDUCATIONS_BY_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.findEducationsByIntakeApplication(application))
    .map((educations) => this.intakeApplicationActions.findEducationsByIntakeApplicationSuccess(educations));

  @Effect() addEducation = this.actions$
    .ofType(IntakeApplicationActions.ADD_EDUCATION)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.addEducation(payload.intake, payload.education))
    .map((message) => this.intakeApplicationActions.addEducationSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  // ====================================================================================================
  // REFEREE
  // ====================================================================================================

  @Effect() findRefereesByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_REFEREES_BY_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.findRefereesByIntakeApplication(application))
    .map((referees) => this.intakeApplicationActions.findRefereesByIntakeApplicationSuccess(referees));

  @Effect() addReferee = this.actions$
    .ofType(IntakeApplicationActions.ADD_REFEREE)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.addReferee(payload.application, payload.referee))
    .map((message) => this.intakeApplicationActions.addRefereeSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() deleteReferee$ = this.actions$
    .ofType(IntakeApplicationActions.DELETE_REFEREE)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.deleteReferee(payload.application, payload.referee))
    .map((message) => this.intakeApplicationActions.deleteRefereeSucces(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() updateReferee$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_REFEREE)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.updateReferee(payload.application, payload.referee))
    .map((message) => this.intakeApplicationActions.updateRefereeSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  // ====================================================================================================
  // EMPLOYMENT
  // ====================================================================================================

  @Effect() findEmploymentsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.findEmploymentsByIntakeApplication(application))
    .map((employments) => this.intakeApplicationActions.findEmploymentsByIntakeApplicationSuccess(employments));

  @Effect() addEmployment = this.actions$
    .ofType(IntakeApplicationActions.ADD_EMPLOYMENT)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.addEmployment(payload.application, payload.employment))
    .map((message) => this.intakeApplicationActions.addEmploymentSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() deleteEmployment$ = this.actions$
    .ofType(IntakeApplicationActions.DELETE_EMPLOYMENT)
    .map((action) => action.payload)
    .flatMap((payload) => this.applicationService.deleteEmployment(payload.application, payload.employment))
    .map((message) => this.intakeApplicationActions.deleteEmploymentSucces(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() updateEmployment$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_EMPLOYMENT)
    .map((action) => action.payload)
    .flatMap((payload) => this.applicationService.updateEmployment(payload.application, payload.employment))
    .map((message) => this.intakeApplicationActions.updateEmploymentSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  // ====================================================================================================
  // LANGUAGE
  // ====================================================================================================

  @Effect() findLanguagesByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_LANGUAGES_BY_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.findLanguagesByIntakeApplication(application))
    .map((languages) => this.intakeApplicationActions.findLanguagesByIntakeApplicationSuccess(languages));

  @Effect() addLanguage = this.actions$
    .ofType(IntakeApplicationActions.ADD_LANGUAGE)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.addLanguage(payload.application, payload.language))
    .map((message) => this.intakeApplicationActions.addLanguageSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() deleteLanguage$ = this.actions$
    .ofType(IntakeApplicationActions.DELETE_LANGUAGE)
    .map((action) => action.payload)
    .flatMap((payload) => this.applicationService.deleteLanguage(payload.application, payload.language))
    .map((message) => this.intakeApplicationActions.deleteLanguageSucces(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() updateLanguage$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_LANGUAGE)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.updateLanguage(payload.application, payload.language))
    .map((message) => this.intakeApplicationActions.updateLanguageSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  // ====================================================================================================
  // ATTACHMENT
  // ====================================================================================================

  @Effect() findAttachmentsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_ATTACHMENTS_BY_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.findAttachmentsByIntakeApplication(application))
    .map((attachments) => this.intakeApplicationActions.findAttachmentsByIntakeApplicationSuccess(attachments));

  @Effect() addAttachment = this.actions$
    .ofType(IntakeApplicationActions.ADD_ATTACHMENT)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.addAttachment(payload.application, payload.file, payload.attachmentType))
    .map((message) => this.intakeApplicationActions.addAttachmentSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() downloadAttachment = this.actions$
    .ofType(IntakeApplicationActions.DOWNLOAD_ATTACHMENT)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.downloadAttachment(payload.attachment))
    .map((file) => {
      let url = URL.createObjectURL(file);
      let a = document.createElement('a');
      a.href = url;
      a.download = file.name;
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
      URL.revokeObjectURL(url);
    }).ignoreElements();

  // ====================================================================================================
  // RESULT
  // ====================================================================================================

  @Effect() findResultsByIntakeApplication$ = this.actions$
    .ofType(IntakeApplicationActions.FIND_RESULTS_BY_INTAKE_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.applicationService.findResultsByIntakeApplication(application))
    .map((results) => this.intakeApplicationActions.findResultsByIntakeApplicationSuccess(results));

  @Effect() addResult = this.actions$
    .ofType(IntakeApplicationActions.ADD_RESULT)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.addResult(payload.application, payload.result))
    .map((message) => this.intakeApplicationActions.addResultSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() deleteResult$ = this.actions$
    .ofType(IntakeApplicationActions.DELETE_RESULT)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.deleteResult(payload.application, payload.result))
    .map((message) => this.intakeApplicationActions.deleteResultSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() updateResult$ = this.actions$
    .ofType(IntakeApplicationActions.UPDATE_RESULT)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.updateResult(payload.application, payload.result))
    .map((message) => this.intakeApplicationActions.updateResultSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  // ====================================================================================================
  // SELECT
  // ====================================================================================================

  @Effect() selectProgramOffering = this.actions$
    .ofType(IntakeApplicationActions.SELECT_PROGRAM_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.selectProgramOffering(payload.application, payload.offering))
    .map((message) => this.intakeApplicationActions.selectProgramOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() selectSupervisorOffering = this.actions$
    .ofType(IntakeApplicationActions.SELECT_SUPERVISOR_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.selectSupervisorOffering(payload.application, payload.offering))
    .map((message) => this.intakeApplicationActions.selectSupervisorOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

  @Effect() selectStudyModeOffering = this.actions$
    .ofType(IntakeApplicationActions.SELECT_STUDY_MODE_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.applicationService.selectStudyModeOffering(payload.application, payload.offering))
    .map((message) => this.intakeApplicationActions.selectStudyModeOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_APPLICATION))
    .map((state) => state[1])
    .map((application: IntakeApplication) => this.intakeApplicationActions.findIntakeApplicationByReferenceNo(application.referenceNo));

}
