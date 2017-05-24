import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {ApplicationPage} from "./application.page";
import {ApplicationService} from "../../services/application.service";
import {PolicyService} from "../../services/policy.service";
import {IntakeApplicationSubModule} from "./intake-applications/index";
import {intakeApplicationReducer, IntakeApplicationState} from "./intake-applications/intake-application.reducer";
import {
  intakeApplicationListReducer,
  IntakeApplicationListState
} from "./intake-applications/intake-application-list.reducer";
import {intakeListReducer, IntakeListState} from "./intake-applications/intake-list.reducer";
import {intakeReducer, IntakeState} from "./intake-applications/intake.reducer";
import {CommonModule} from "../common/index";
import {ProgramLevelSubModule} from "../policy/program-levels/index";
import {CpsIntakeApplicationSubModule} from "./intake-applications/cps/index";
import {
  intakeProgramOfferingListReducer,
  IntakeProgramOfferingListState
} from "./intake-applications/intake-program-offering-list.reducer";
import {
  intakeStudyModeOfferingListReducer,
  IntakeStudyModeOfferingListState
} from "./intake-applications/intake-study-mode-offering-list.reducer";
import {
  intakeSupervisorOfferingListReducer,
  IntakeSupervisorOfferingListState
} from "./intake-applications/intake-supervisor-offering-list.reducer";
import {employmentListReducer, EmploymentListState} from "./intake-applications/employment-list.reducer";

export interface ApplicationModuleState {
  intakes: IntakeListState;
  intake: IntakeState;
  employments:EmploymentListState;
  programOfferings: IntakeProgramOfferingListState;
  supervisorOfferings: IntakeSupervisorOfferingListState;
  studyModeOfferings: IntakeStudyModeOfferingListState;
  intakeApplications: IntakeApplicationListState;
  intakeApplication: IntakeApplicationState;
}
;

export const INITIAL_APPLICATION_STATE: ApplicationModuleState = <ApplicationModuleState>{
  intakes:[],
  intake:{},
  employments:[],
  programOfferings:[],
  supervisorOfferings:[],
  studyModeOfferings:[],
  intakeApplications:[],
  intakeApplication:{}
};
export const applicationModuleReducers = {
  intakes: intakeListReducer,
  intake: intakeReducer,
  employments: employmentListReducer,
  programOfferings: intakeProgramOfferingListReducer,
  supervisorOfferings: intakeSupervisorOfferingListReducer,
  studyModeOfferings: intakeStudyModeOfferingListReducer,
  intakeApplications: intakeApplicationListReducer,
  intakeApplication: intakeApplicationReducer
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    IntakeApplicationSubModule.forRoot(),
    CommonModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    CpsIntakeApplicationSubModule.forRoot(),
  ],
  declarations: [
    // page
    ApplicationPage,
  ],
  exports: [],

  entryComponents: [

  ],
})
export class ApplicationModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ApplicationModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        ApplicationService,
      ],
    };
  }
}
