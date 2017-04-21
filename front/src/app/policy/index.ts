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

export interface PolicyModuleState {
  intakeTasks: IntakeTaskListState;
  intakeTask: IntakeTaskState;
  intake: IntakeState;
  programOfferings: ProgramOfferingListState;
  supervisorOfferings: SupervisorOfferingListState;
  studyModeOfferings: StudyModeOfferingListState;
}
;

export const INITIAL_POLICY_STATE: PolicyModuleState = <PolicyModuleState>{};
export const policyModuleReducers = {
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
