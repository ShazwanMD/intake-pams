import { ReligionCode } from './../common/religion-codes/religion-code.interface';

import { ReligionCodeListPage } from './religion-codes/religion-code-list.page';
import { SetupPage } from './setup.page';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {NgModule, ModuleWithProviders} from "@angular/core";
import {CovalentCoreModule} from '@covalent/core';
import {CommonModule} from "../common/index";
import {BankCode} from "../common/bank-codes/bank-code.interface";
import {bankCodeListReducer, BankCodeListState} from "./bank-codes/bank-code-list.reducer";
import {religionCodeListReducer, ReligionCodeListState} from "./religion-codes/religion-code-list.reducer";
import {SetupEffects} from "./setup.effect";
import {EffectsModule} from "@ngrx/effects";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";
import {SetupActions} from "./setup.action";
import {graduateCentreListReducer, GraduateCentreListState} from "./graduate-centres/graduate-centre-list.reducer";
import {GraduateCentre} from "../common/graduate-centres/graduate-centre.interface";
import {GraduateCentreListPage} from "./graduate-centres/graduate-centre-list.page";
import {GraduateCentreCreatorDialog} from "./graduate-centres/dialog/graduate-centre-creator.dialog";
import {BankCodeCreatorDialog} from "./bank-codes/dialog/bank-code-creator.dialog";

export interface SetupModuleState {
  bankCodes: BankCodeListState;
  graduateCentres: GraduateCentreListState;
};

export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    bankCodes: <BankCode[]>[],
    graduateCentres: <GraduateCentre[]>[],
    religionCode: <ReligionCode[]>[],

  };
export const setupModuleReducers = {
  bankCodes: bankCodeListReducer,
  graduateCentres: graduateCentreListReducer,
  religionCodes: religionCodeListReducer,
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
    // page
    SetupPage,
    BankCodeListPage,
    GraduateCentreListPage,
    ReligionCodeListPage,

    // dialog
    BankCodeCreatorDialog,
    GraduateCentreCreatorDialog,
  ],
  exports: [],
  entryComponents: [
    BankCodeCreatorDialog,
    GraduateCentreCreatorDialog,
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
