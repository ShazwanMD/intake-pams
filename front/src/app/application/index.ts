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
import {intakeApplicationListReducer,IntakeApplicationListState} from "./intake-applications/intake-application-list.reducer";
import {intakeListReducer, IntakeListState} from "./intake-applications/intake-list.reducer";
import {intakeReducer, IntakeState} from "./intake-applications/intake.reducer";
import { CommonModule } from "../common/index";
import { ProgramLevelSubModule } from "../policy/program-levels/index";
import { ProgramOfferingSelectComponent } from "./intake-applications/cps/component/program-offering-select.component";
import { EmploymentCreatorDialog } from "./intake-applications/cps/dialog/employment-creator.dialog";
import { CpsIntakeApplicationSubModule } from "./intake-applications/cps/index";

export interface ApplicationModuleState {
  intakes:IntakeListState;
  intake:IntakeState;
  intakeApplications: IntakeApplicationListState;
  intakeApplication: IntakeApplicationState;
};

export const INITIAL_APPLICATION_STATE: ApplicationModuleState = <ApplicationModuleState>{};
export const applicationModuleReducers = {
   intakes:intakeListReducer,
   intake:intakeReducer,
   intakeApplications:intakeApplicationListReducer,
   intakeApplication:intakeApplicationReducer

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
    EmploymentCreatorDialog,
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
