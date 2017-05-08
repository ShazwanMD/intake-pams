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
import {ProgramEffects} from "./program.effect";
import {ProgramActions} from "./program.action";
import {ProgramOfferingCenterPage} from "./program-offering-center.page";
import {CommonModule} from "../../common/index";
import {CommonActions} from "../../common/common.action";
import {ProgramOfferingCreatorDialog} from "./dialog/program-offering-creator.dialog";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
   EffectsModule.run(ProgramEffects),
  ],
  declarations: [
    // page
    ProgramOfferingCenterPage,

    // dialogs
    ProgramOfferingCreatorDialog,
    
],
   exports: [],
   entryComponents: [
   ProgramOfferingCreatorDialog,
  
  ],

})
export class ProgramModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ProgramModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        ProgramActions,
        CommonActions,
      ],
    };
  }
}
