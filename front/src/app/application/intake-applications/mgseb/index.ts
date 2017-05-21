import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';

import {CovalentCoreModule} from '@covalent/core';
import {appRoutes, appRoutingProviders} from "../../../app.routes";
import {IntakeApplicationPersonalPage} from "./intake-application-personal.page";
import {IntakeApplicationEducationPage} from "./intake-application-education.page";
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {CommonModule} from "../../../common/index";
import {ProgramLevelSubModule} from "../../../policy/program-levels/index";
import { IntakeApplicationActions } from "../intake-application.action";
import { CommonActions } from "../../../common/common.action";
import { EmploymentCreatorDialog } from "./dialog/employment-creator.dialog";
import { EmploymentTaskListComponent } from "./component/employment-task-list.component";
import { ProgramOfferingSelectComponent } from "../cps/component/program-offering-select.component";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
  ],
  declarations: [
    IntakeApplicationPersonalPage,
    IntakeApplicationEducationPage,
    
  ],
  exports: [],
  entryComponents: [
    EmploymentTaskListComponent,
    ProgramOfferingSelectComponent,

  ],
})
export class MgsebIntakeApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: MgsebIntakeApplicationSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        IntakeApplicationActions,
         CommonActions,
         
      ],
    };
  }
}
