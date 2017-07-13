import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {IntakeActions} from './intake.action';
import {from} from 'rxjs/observable/from';
import {PolicyService} from '../../../../../services/policy.service';
import {PolicyModuleState} from '../index';
import {Store} from '@ngrx/store';
import {ApplicationService} from '../../../../../services/application.service';
import {IntakeTask} from '../../../../shared/model/policy/intake-task.interface';

@Injectable()
export class IntakeEffects {

  private INTAKE: string[] = 'policyModuleState.intake'.split('.');
  private INTAKE_TASK: string[] = 'policyModuleState.intakeTask'.split('.');

  constructor(private actions$: Actions,
              private intakeActions: IntakeActions,
              private policyService: PolicyService,
              private applicationService: ApplicationService,
              private store$: Store<PolicyModuleState>) {
  }

  @Effect() findAssignedIntakeTasks$ = this.actions$
    .ofType(IntakeActions.FIND_ASSIGNED_INTAKE_TASKS)
    .switchMap(() => this.policyService.findAssignedIntakeTasks())
    .map((intakes) => this.intakeActions.findAssignedIntakeTasksSuccess(intakes));

  @Effect() findPooledIntakeTasks$ = this.actions$
    .ofType(IntakeActions.FIND_POOLED_INTAKE_TASKS)
    .switchMap(() => this.policyService.findPooledIntakeTasks())
    .map((intakes) => this.intakeActions.findPooledIntakeTasksSuccess(intakes));

  @Effect() findIntakeTaskByTaskId = this.actions$
    .ofType(IntakeActions.FIND_INTAKE_TASK_BY_TASK_ID)
    .map((action) => action.payload)
    .switchMap((taskId) => this.policyService.findIntakeTaskByTaskId(taskId))
    .map((task) => this.intakeActions.findIntakeTaskByTaskIdSuccess(task));

  @Effect() findIntakeByReferenceNo$ = this.actions$
    .ofType(IntakeActions.FIND_INTAKE_BY_REFERENCE_NO)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.policyService.findIntakeByReferenceNo(referenceNo))
    .map((intake) => this.intakeActions.findIntakeByReferenceNoSuccess(intake))
    .mergeMap((action) => from([action,
      this.intakeActions.findProgramOfferings(action.payload),
      this.intakeActions.findSupervisorOfferings(action.payload),
      this.intakeActions.findStudyModeOfferings(action.payload),
      this.intakeActions.findIntakeApplications(action.payload),
    ]));

  @Effect() findIntakeByReferenceNoAndBidStatus$ = this.actions$
    .ofType(IntakeActions.FIND_INTAKE_BY_REFERENCE_NO_AND_BID_STATUS)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.applicationService.findIntakeByReferenceNo(referenceNo))
    .map((intake) => this.intakeActions.findIntakeByReferenceNoSuccess(intake))
    .mergeMap((action) => from([action,
      this.intakeActions.findProgramOfferings(action.payload),
      this.intakeActions.findSupervisorOfferings(action.payload),
      this.intakeActions.findStudyModeOfferings(action.payload),
      this.intakeActions.findSubmittedIntakeApplications(action.payload),
      this.intakeActions.findSelectedIntakeApplications(action.payload),
      this.intakeActions.findRejectedIntakeApplications(action.payload),
      this.intakeActions.findVerifiedIntakeApplications(action.payload),
    ]));

  @Effect() findProgramOfferings$ = this.actions$
    .ofType(IntakeActions.FIND_PROGRAM_OFFERINGS)
    .map((action) => action.payload)
    .switchMap((intake) => this.policyService.findProgramOfferings(intake))
    .map((items) => this.intakeActions.findProgramOfferingsSuccess(items));

  @Effect() findSupervisorOfferings$ = this.actions$
    .ofType(IntakeActions.FIND_SUPERVISOR_OFFERINGS)
    .map((action) => action.payload)
    .switchMap((intake) => this.policyService.findSupervisorOfferings(intake))
    .map((items) => this.intakeActions.findSupervisorOfferingsSuccess(items));

  @Effect() findStudyModeOfferings$ = this.actions$
    .ofType(IntakeActions.FIND_STUDY_MODE_OFFERINGS)
    .map((action) => action.payload)
    .switchMap((intake) => this.policyService.findStudyModeOfferings(intake))
    .map((items) => this.intakeActions.findStudyModeOfferingsSuccess(items));

  @Effect() findIntakeApplications = this.actions$
    .ofType(IntakeActions.FIND_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findIntakeApplications())
    .map((applications) => this.intakeActions.findIntakeApplicationsSuccess(applications));

  @Effect() findSelectedIntakeApplications = this.actions$
    .ofType(IntakeActions.FIND_SELECTED_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findSelectedIntakeApplications(intake))
    .map((applications) => this.intakeActions.findSelectedIntakeApplicationsSuccess(applications));

  @Effect() findRejectedIntakeApplications = this.actions$
    .ofType(IntakeActions.FIND_REJECTED_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findRejectedIntakeApplications(intake))
    .map((applications) => this.intakeActions.findRejectedIntakeApplicationsSuccess(applications));

  @Effect() findVerifiedIntakeApplications = this.actions$
    .ofType(IntakeActions.FIND_VERIFIED_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findVerifiedInternationalIntakeApplications(intake))
    .map((applications) => this.intakeActions.findVerifiedIntakeApplicationsSuccess(applications));

  @Effect() findSubmittedIntakeApplications = this.actions$
    .ofType(IntakeActions.FIND_SUBMITTED_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.applicationService.findSubmittedIntakeApplications(intake))
    .map((applications) => this.intakeActions.findSubmittedIntakeApplicationsSuccess(applications));

  @Effect() startIntakeTask$ = this.actions$
    .ofType(IntakeActions.START_INTAKE_TASK)
    .map((action) => action.payload)
    .switchMap((intake) => this.policyService.startIntakeTask(intake))
    .map((message) => this.intakeActions.startIntakeTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.intakeActions.findAssignedIntakeTasks(),
        this.intakeActions.findPooledIntakeTasks(),
      ],
    ));

  @Effect() completeIntakeTask$ = this.actions$
    .ofType(IntakeActions.COMPLETE_INTAKE_TASK)
    .map((action) => action.payload)
    .switchMap((intakeTask) => this.policyService.completeIntakeTask(intakeTask))
    .map((message) => this.intakeActions.completeIntakeTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.intakeActions.findAssignedIntakeTasks(),
        this.intakeActions.findPooledIntakeTasks(),
      ],
    ));

  @Effect() copyIntakeTask$ = this.actions$
    .ofType(IntakeActions.COPY_INTAKE_TASK)
    .map((action) => action.payload)
    .switchMap((intakeTask) => this.policyService.copyIntakeTask(intakeTask))
    .map((message) => this.intakeActions.copyIntakeTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.intakeActions.findAssignedIntakeTasks(),
        this.intakeActions.findPooledIntakeTasks(),
      ],
    ));

  @Effect() processIntakeCandidate$ = this.actions$
    .ofType(IntakeActions.COPY_INTAKE_TASK)
    .map((action) => action.payload)
    .switchMap((intakeTask) => this.applicationService.processIntakeCandidate(intakeTask))
    .map((message) => this.intakeActions.processIntakeCandidateSuccess(message))
    .mergeMap((action) => from([action,
        this.intakeActions.findAssignedIntakeTasks(),
        this.intakeActions.findPooledIntakeTasks(),
      ],
    ));

  @Effect() claimIntakeTask$ = this.actions$
    .ofType(IntakeActions.CLAIM_INTAKE_TASK)
    .map((action) => action.payload)
    .switchMap((intakeTask) => this.policyService.claimIntakeTask(intakeTask))
    .map((message) => this.intakeActions.claimIntakeTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.intakeActions.findAssignedIntakeTasks(),
        this.intakeActions.findPooledIntakeTasks(),
      ],
    ));

  @Effect() releaseIntakeTask$ = this.actions$
    .ofType(IntakeActions.RELEASE_INTAKE_TASK)
    .map((action) => action.payload)
    .switchMap((intakeTask) => this.policyService.releaseIntakeTask(intakeTask))
    .map((message) => this.intakeActions.releaseIntakeTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.intakeActions.findAssignedIntakeTasks(),
        this.intakeActions.findPooledIntakeTasks(),
      ],
    ));

  @Effect() updateIntake$ = this.actions$
    .ofType(IntakeActions.UPDATE_INTAKE)
    .map((action) => action.payload)
    .switchMap((intake) => this.policyService.updateIntake(intake))
    .map((message) => this.intakeActions.updateIntakeSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE_TASK))
    .map((state) => state[1])
    .map((intakeTask: IntakeTask) => this.intakeActions.findIntakeTaskByTaskId(intakeTask.taskId));

  @Effect() addProgramOffering$ = this.actions$
    .ofType(IntakeActions.ADD_PROGRAM_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.policyService.addProgramOffering(payload.intake, payload.programOffering))
    .map((message) => this.intakeActions.addProgramOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE))
    .map((state) => state[1])
    .map((intake) => this.intakeActions.findProgramOfferings(intake));

  @Effect() updateProgramOffering$ = this.actions$
    .ofType(IntakeActions.UPDATE_PROGRAM_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.policyService.updateProgramOffering(payload.intake, payload.programOffering))
    .map((message) => this.intakeActions.updateProgramOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE))
    .map((state) => state[1])
    .map((intake) => this.intakeActions.findProgramOfferings(intake));

  @Effect() deleteProgramOfferin$ = this.actions$
    .ofType(IntakeActions.DELETE_PROGRAM_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.policyService.deleteProgramOffering(payload.intake, payload.programOffering))
    .map((message) => this.intakeActions.deleteProgramOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE))
    .map((state) => state[1])
    .map((intake) => this.intakeActions.findProgramOfferings(intake));

  @Effect() addStudyModeOffering$ = this.actions$
    .ofType(IntakeActions.ADD_STUDY_MODE_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.policyService.addStudyModeOffering(payload.intake, payload.studyModeOffering))
    .map((message) => this.intakeActions.addStudyModeOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE))
    .map((state) => state[1])
    .map((intake) => this.intakeActions.findStudyModeOfferings(intake));

  @Effect() deleteStudyModeOffering$ = this.actions$
    .ofType(IntakeActions.DELETE_STUDY_MODE_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.policyService.deleteStudyModeOffering(payload.intake, payload.studyModeOffering))
    .map((message) => this.intakeActions.deleteStudyModeOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE))
    .map((state) => state[1])
    .map((intake) => this.intakeActions.findStudyModeOfferings(intake));

  @Effect() addSupervisorOffering$ = this.actions$
    .ofType(IntakeActions.ADD_SUPERVISOR_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.policyService.addSupervisorOffering(payload.intake, payload.supervisorOffering))
    .map((message) => this.intakeActions.addSupervisorOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE))
    .map((state) => state[1])
    .map((intake) => this.intakeActions.findSupervisorOfferings(intake));

  @Effect() deleteSupervisorOffering$ = this.actions$
    .ofType(IntakeActions.DELETE_SUPERVISOR_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.policyService.deleteSupervisorOffering(payload.intake, payload.supervisorOffering))
    .map((message) => this.intakeActions.deleteSupervisorOfferingSuccess(message))
    .withLatestFrom(this.store$.select(...this.INTAKE))
    .map((state) => state[1])
    .map((intake) => this.intakeActions.findSupervisorOfferings(intake));
}