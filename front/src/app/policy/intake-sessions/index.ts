import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {environment} from '../../../environments/environment';

import {CovalentCoreModule} from '@covalent/core';
import {EffectsModule} from "@ngrx/effects";
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {PolicyService} from "../../../services/policy.service";
import {CommonModule} from "../../common/index";
import {CommonActions} from "../../common/common.action";
import {IntakeSessionActions} from "../intake-sessions/intake-session.action";
import {IntakeSessionEffects} from "./intake-session.effect";
import {IntakeSessionCenterPage} from "./intake-session-center.page";
import {IntakeSessionSelectComponent} from "./component/intake-session-select.component";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    EffectsModule.run(IntakeSessionEffects),
  ],
  declarations: [
    IntakeSessionSelectComponent,
    // page
    IntakeSessionCenterPage,
    // components
    // panels
    // dialogs
  ],
  exports: [
    IntakeSessionSelectComponent,
  ],
  entryComponents: [
  ],

})
export class IntakeSessionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: IntakeSessionSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        IntakeSessionActions,
        CommonActions,
      ],
    };
  }
}
