import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';

import {CovalentCoreModule} from '@covalent/core';
import {appRoutes, appRoutingProviders} from "../../../app.routes";
import {IntakeApplicationPage} from "./intake-application.page";
import {IdentityService} from "../../../../services/identity.service";
import { CommonService } from "../../../../services/common.service";
import { ProgramLevelSubModule } from "../../../policy/program-levels/index";
import { CommonModule } from "../../../common/index";


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
  ],
  exports: [],
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
      ],
    };
  }
}
