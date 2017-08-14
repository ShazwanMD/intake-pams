import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {PolicyPage} from './policy.page';
import {PolicyService} from '../../../services/policy.service';
import {IntakeSubModule} from './intakes/index';
import {IntakeState, intakeReducer} from './intakes/intake.reducer';
import {IntakeTaskState, intakeTaskReducer} from './intakes/intake-task.reducer';
import {SupervisorOfferingListState, supervisorOfferingListReducer} from './intakes/supervisor-offering-list.reducer';
import {StudyModeOfferingListState, studyModeOfferingListReducer} from './intakes/study-mode-offering-list.reducer';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import {Intake} from '../../shared/model/policy/intake.interface';
import {ProgramOffering} from '../../shared/model/policy/program-offering.interface';
import {SupervisorOffering} from '../../shared/model/policy/supervisor-offering.interface';
import {StudyModeOffering} from '../../shared/model/policy/study-mode-offering.interface';
import {IntakeSession} from '../../shared/model/policy/intake-session.interface';
import {IntakeSessionSubModule} from './intake-sessions/index';
import {ProgramLevelSubModule} from './program-levels/index';
import {ProgramLevel} from '../../shared/model/policy/program-level.interface';
import {ProgramLevelListState, programLevelListReducer} from './program-levels/program-level.reducer';
import {programOfferingListReducer, ProgramOfferingListState} from './intakes/program-offering-list.reducer';
import {
  assignedIntakeTaskListReducer, IntakeTaskListState,
  pooledIntakeTaskListReducer,
} from './intakes/intake-task-list.reducer';
import {intakeSessionListReducer, IntakeSessionListState} from './intake-sessions/intake-session-list.reducer';
import {IntakeApplication} from '../../shared/model/application/intake-application.interface';
import {intakeApplicationListReducer, IntakeApplicationListState} from './intakes/intake-application-list.reducer';
import {
  intakeSubmittedApplicationListReducer,
  IntakeSubmittedApplicationListState,
} from './intakes/intake-submitted-application-list.reducer';
import {
  intakeSelectedApplicationListReducer,
  IntakeSelectedApplicationListState,
} from './intakes/intake-selected-application-list.reducer';
import {
  intakeRejectedApplicationListReducer,
  IntakeRejectedApplicationListState,
} from './intakes/intake-rejected-application-list.reducer';
import {
  intakeVerifiedApplicationListReducer,
  IntakeVerifiedApplicationListState,
} from './intakes/intake-verified-application-list.reducer';
import {IntakeListState} from '../application/intake-applications/intake-list.reducer';
import {archivedIntakeListReducer} from '../account/intake-list.reducer';
import { IntakeSessionByCurrentListState, intakeSessionByCurrentListReducer } from "./intake-sessions/intake-session-by-current-list.reducer";

export interface PolicyModuleState {
  intakeSessions: IntakeSessionListState;
  intakeSessionsByCurrent: IntakeSessionByCurrentListState;
  programLevels: ProgramLevelListState;
  assignedIntakeTasks: IntakeTaskListState;
  pooledIntakeTasks: IntakeTaskListState;
  archivedIntakes: IntakeListState;
  intakeTask: IntakeTaskState;
  intake: IntakeState;
  programOfferings: ProgramOfferingListState;
  supervisorOfferings: SupervisorOfferingListState;
  studyModeOfferings: StudyModeOfferingListState;
  intakeApplications: IntakeApplicationListState;
  intakeSubmittedApplications: IntakeSubmittedApplicationListState;
  intakeSelectedApplications: IntakeSelectedApplicationListState;
  intakeRejectedApplications: IntakeRejectedApplicationListState;
  intakeVerifiedApplications: IntakeVerifiedApplicationListState;
}
;

export const INITIAL_POLICY_STATE: PolicyModuleState =
  <PolicyModuleState>{
    intakeSessions: <IntakeSession[]>[],
    intakeSessionsByCurrent: <IntakeSession[]>[],
    programLevels: <ProgramLevel[]>[],
    assignedIntakeTasks: <IntakeTask[]>[],
    pooledIntakeTasks: <IntakeTask[]>[],
    archivedIntakes: <Intake[]>[],
    intakeTask: <IntakeTask>{},
    intake: <Intake>{},
    intakeSession: <IntakeSession>{},
    programOfferings: <ProgramOffering[]>[],
    supervisorOfferings: <SupervisorOffering[]>[],
    studyModeOfferings: <StudyModeOffering[]>[],
    intakeApplications: <IntakeApplication[]>[],
    intakeSubmittedApplications: <IntakeApplication[]>[],
    intakeSelectedApplications: <IntakeApplication[]>[],
    intakeRejectedApplications: <IntakeApplication[]>[],
    intakeVerifiedApplications: <IntakeApplication[]>[],
  };

export const policyModuleReducers = {
  intakeSessions: intakeSessionListReducer,
  intakeSessionsByCurrent: intakeSessionByCurrentListReducer,
  programLevels: programLevelListReducer,
  assignedIntakeTasks: assignedIntakeTaskListReducer,
  pooledIntakeTasks: pooledIntakeTaskListReducer,
  archivedIntakes: archivedIntakeListReducer,
  intakeTask: intakeTaskReducer,
  intake: intakeReducer,
  programOfferings: programOfferingListReducer,
  supervisorOfferings: supervisorOfferingListReducer,
  studyModeOfferings: studyModeOfferingListReducer,
  intakeApplications: intakeApplicationListReducer,
  intakeSubmittedApplications: intakeSubmittedApplicationListReducer,
  intakeSelectedApplications: intakeSelectedApplicationListReducer,
  intakeRejectedApplications: intakeRejectedApplicationListReducer,
  intakeVerifiedApplications: intakeVerifiedApplicationListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    IntakeSessionSubModule.forRoot(),
    IntakeSubModule.forRoot(),

  ],
  declarations: [
    // page
    PolicyPage,

    // dialog
  ],

  exports: [],
  entryComponents: [],

})

export class PolicyModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: PolicyModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
      ],
    };
  }
}
