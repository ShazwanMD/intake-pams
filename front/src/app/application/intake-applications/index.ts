import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';

import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {PolicyService} from "../../../services/policy.service";
import {MgsebIntakeApplicationSubModule} from "./mgseb/index";
import {CpsIntakeApplicationSubModule} from "./cps/index";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    MgsebIntakeApplicationSubModule.forRoot(),
    CpsIntakeApplicationSubModule.forRoot(),
  ],
  declarations: [
  ],
  exports: [],
  entryComponents: [
  ],
})
export class IntakeApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: IntakeApplicationSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
      ],
    };
  }
}
