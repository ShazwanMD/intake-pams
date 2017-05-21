import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';

import {CovalentCoreModule} from '@covalent/core';
import {appRoutes, appRoutingProviders} from "../../../app.routes";
import {IntakeApplicationPage} from "./intake-application.page";
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {ProgramLevelSubModule} from "../../../policy/program-levels/index";
import {CommonModule} from "../../../common/index";
import {EmploymentCreatorDialog} from "./dialog/employment-creator.dialog";
import { ProgramOfferingSelectComponent } from "./component/program-offering-select.component";
import { PolicyService } from "../../../../services/policy.service";
import { IntakeSessionActions } from "../../../policy/intake-sessions/intake-session.action";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    CommonModule.forRoot(),
  ],
  declarations: [
    IntakeApplicationPage,
    EmploymentCreatorDialog,
    ProgramOfferingSelectComponent,
  ],
  exports: [ProgramOfferingSelectComponent],
  entryComponents: [],
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
