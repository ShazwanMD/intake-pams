
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {environment} from '../../environments/environment';
import {EffectsModule} from "@ngrx/effects";

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {ProgramCodeListComponent} from "./component/program-code-list.component";
import {ProgramCodeListState, programCodeListReducer} from "./program-code-list.reducer";
import {GraduateCenterState, graduateCenterReducer} from "./graduate-center.reducer";
import {GraduateCenter} from "../common/graduate-centers/graduate-center.interface";
import {MgsebCenterPage} from "./mgseb-center.page";
import {CpsCenterPage} from "./cps-center.page";
import {CenterPage} from "./center.page";
import {CenterEffects} from "./center.effect";
import {CenterActions} from "./center.action";

export interface CenterModuleState {
  graduateCenter:GraduateCenterState,
  programCodes:ProgramCodeListState,
};

export const INITIAL_CENTER_STATE: CenterModuleState =
  <CenterModuleState>{
    graduateCenter:<GraduateCenter>{},
    programCodes:[]
  };

export const centerModuleReducers = {
  graduateCenter:graduateCenterReducer,
  programCodes:programCodeListReducer
 };

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(CenterEffects),

  ],
  declarations: [
    // page
    CenterPage,
    CpsCenterPage,
    MgsebCenterPage,

    // component
    ProgramCodeListComponent,
  ],
  exports: [],
})
export class CenterModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CenterModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        CenterActions,
      ],
    };
  }
}
