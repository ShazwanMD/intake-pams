import { SetupPage } from './setup.page';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {NgModule, ModuleWithProviders} from "@angular/core";

import {CovalentCoreModule} from '@covalent/core';
import {CommonModule} from "../common/index";
import {BankCode} from "../common/bank-codes/bank-code.interface";
import {bankCodeListReducer, BankCodeListState} from "./bank-codes/bank-code-list.reducer";
import {SetupEffects} from "./setup.effect";
import {EffectsModule} from "@ngrx/effects";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";
import {SetupActions} from "./setup.action";
import {graduateCentreListReducer, GraduateCentreListState} from "./graduate-centres/graduate-centre-list.reducer";
import {GraduateCentre} from "../common/graduate-centres/graduate-centre.interface";
import {GraduateCentreListPage} from "./graduate-centres/graduate-centre-list.page";

export interface SetupModuleState {
  bankCodes: BankCodeListState;
  graduateCentres: GraduateCentreListState;
};

export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    bankCodes: <BankCode[]>[],
    graduateCentres: <GraduateCentre[]>[],
  };
export const setupModuleReducers = {
  bankCodes: bankCodeListReducer,
  graduateCentres: graduateCentreListReducer,
};



@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    EffectsModule.run(SetupEffects),

  ],
  declarations: [
    SetupPage,
    BankCodeListPage,
    GraduateCentreListPage,

  ],
  exports: [],
  entryComponents: [

  ],

})
export class SetupModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SetupModule,
      providers: [
        appRoutingProviders,
        SetupActions
      ],
    };
  }
}
