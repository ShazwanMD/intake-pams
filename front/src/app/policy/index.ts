import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {PolicyPage} from "./policy.page";
import {PolicyService} from "../../services/policy.service";
import {IntakeSubModule} from "./intakes/index";
import {IntakeState, intakeReducer} from "./intakes/intake.reducer";
import {IntakeTaskListState, intakeTaskListReducer} from "./intakes/intake-task-list.reducer";
import {IntakeTaskState, intakeTaskReducer} from "./intakes/intake-task.reducer";
import {ProgramOfferingListState, programOfferingListReducer} from "./intakes/program-offering-list.reducer";
import {SupervisorOfferingListState, supervisorOfferingListReducer} from "./intakes/supervisor-offering-list.reducer";
import {StudyModeOfferingListState, studyModeOfferingListReducer} from "./intakes/study-mode-offering-list.reducer";
import {IntakeTask} from "./intakes/intake-task.interface";
import {Intake} from "./intakes/intake.interface";
import {ProgramOffering} from "./intakes/program-offering.interface";
import {SupervisorOffering} from "./intakes/supervisor-offering.interface";
import {StudyModeOffering} from "./intakes/study-mode-offering.interface";
import {IntakeSessionListState, intakeSessionListReducer} from "./intake-sessions/intake-session.reducer";
import {IntakeSession} from "./intake-sessions/intake-session.interface";
import {IntakeSessionSubModule} from "./intake-sessions/index";
import {ProgramLevelSubModule} from "./program-levels/index";
import {ProgramLevel} from "./program-levels/program-level.interface";
import {ProgramLevelListState, programLevelListReducer} from "./program-levels/program-level.reducer";

export interface PolicyModuleState {
  intakeSessions: IntakeSessionListState;
  programLevels: ProgramLevelListState;
  intakeTasks: IntakeTaskListState;
  intakeTask: IntakeTaskState;
  intake: IntakeState;
  programOfferings: ProgramOfferingListState;
  supervisorOfferings: SupervisorOfferingListState;
  studyModeOfferings: StudyModeOfferingListState;
};

export const INITIAL_POLICY_STATE: PolicyModuleState =
  <PolicyModuleState>{
    programLevels: <ProgramLevel[]>[],
    intakeSessions: <IntakeSession[]>[],
    intakeTasks: <IntakeTask[]>[],
    intakeTask: <IntakeTask>{},
    intake: <Intake>{},
    programOfferings: <ProgramOffering[]>[],
    supervisorOfferings: <SupervisorOffering[]>[],
    studyModeOfferings: <StudyModeOffering[]>[],
  };

export const policyModuleReducers = {
  programLevels: programLevelListReducer,
  intakeSessions: intakeSessionListReducer,
  intakeTasks: intakeTaskListReducer,
  intakeTask: intakeTaskReducer,
  intake: intakeReducer,
  programOfferings: programOfferingListReducer,
  supervisorOfferings: supervisorOfferingListReducer,
  studyModeOfferings: studyModeOfferingListReducer,
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
  ],
  exports: [],
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
