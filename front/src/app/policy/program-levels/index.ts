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
import {ProgramLevelActions} from "./program-level.action";
import {ProgramLevelEffects} from "./program-level.effect";
import {ProgramLevelSelectComponent} from "./component/program-level-select.component";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    EffectsModule.run(ProgramLevelEffects),
  ],
  declarations: [
    // page
    // components
    ProgramLevelSelectComponent,
    // panels
    // dialogs
  ],
  exports: [
    ProgramLevelSelectComponent,
  ],
  entryComponents: [
  ],

})
export class ProgramLevelSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ProgramLevelSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        ProgramLevelActions,
        CommonActions,
      ],
    };
  }
}
