import {EmploymentCreatorDialog} from './../component/dialog/employment-creator.dialog';
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
import {EmploymentListComponent} from "../component/employment-list.component";
import {EmploymentTabComponent} from "../component/employment-tab.component";

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
    EmploymentListComponent,
    EmploymentTabComponent,

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
