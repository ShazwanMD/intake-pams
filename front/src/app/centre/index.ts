
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
import {GraduateCentreState, graduateCentreReducer} from "./graduate-centre.reducer";
import {GraduateCentre} from "../common/graduate-centres/graduate-centre.interface";
import {MgsebCentrePage} from "./mgseb-centre.page";
import {CpsCentrePage} from "./cps-centre.page";
import {CentrePage} from "./centre.page";
import {CentreEffects} from "./centre.effect";
import {CentreActions} from "./centre.action";

export interface CentreModuleState {
  graduateCentre:GraduateCentreState,
  programCodes:ProgramCodeListState,
};

export const INITIAL_CENTRE_STATE: CentreModuleState =
  <CentreModuleState>{
    graduateCentre:<GraduateCentre>{},
    programCodes:[]
  };

export const centreModuleReducers = {
  graduateCentre:graduateCentreReducer,
  programCodes:programCodeListReducer
 };

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(CentreEffects),

  ],
  declarations: [
    // page
    CentrePage,
    CpsCentrePage,
    MgsebCentrePage,
    ProgramCodeListComponent,
  ],
  exports: [],
})
export class CentreModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CentreModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        CentreActions,
      ],
    };
  }
}
