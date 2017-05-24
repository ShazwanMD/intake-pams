import { EmploymentCreatorDialog } from './../component/dialog/employment-creator.dialog';
import { EmploymentTaskListComponent } from './../component/employment-task-list.component';
import { Employment } from './../employment.interface';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';

import {CovalentCoreModule} from '@covalent/core';
import {appRoutes, appRoutingProviders} from "../../../app.routes";
import {CpsIntakeApplicationPage} from "./intake-application.page";
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {ProgramLevelSubModule} from "../../../policy/program-levels/index";
import {CommonModule} from "../../../common/index";

import {PolicyService} from "../../../../services/policy.service";
import {IntakeSessionActions} from "../../../policy/intake-sessions/intake-session.action";
import {IntakeSubModule} from "../../../policy/intakes/index";
import {IntakeProgramOfferingSelectComponent} from "../component/intake-program-offering-select.component";
import {EmploymentListState, employmentListReducer} from "./../component/employment-task-list.reducer";

export interface IntakeApplicationModuleState {
  employments: EmploymentListState;
}
;

export const INITIAL_INTAKE_APPLICATION_STATE: IntakeApplicationModuleState =
  <IntakeApplicationModuleState>{
    employments: <Employment[]>[],
  };


export const intakeApplicationModuleReducers = {

  employments: employmentListReducer,
}

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    IntakeSubModule.forRoot(),
    CommonModule.forRoot(),
  ],
  declarations: [
    CpsIntakeApplicationPage,
    IntakeProgramOfferingSelectComponent,
        //components
    EmploymentTaskListComponent,
    //dialogs
    EmploymentCreatorDialog,
  ],
  exports: [],
  entryComponents: [
    EmploymentCreatorDialog,
   
  ],
})
export class CpsIntakeApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CpsIntakeApplicationSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        IntakeSessionActions,
      ],
    };
  }
}
