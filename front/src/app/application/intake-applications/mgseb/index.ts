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
  entryComponents: [],
})
export class MgsebIntakeApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: MgsebIntakeApplicationSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
      ],
    };
  }
}
