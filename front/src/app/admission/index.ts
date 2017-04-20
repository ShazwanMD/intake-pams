
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {environment} from '../../environments/environment';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {AdmissionPage} from "./admission.page";
import {AdmissionService} from "../../services/admission.service";
import {ActionReducer, combineReducers} from "@ngrx/store";

export interface AdmissionModuleState {
};

export const INITIAL_ADMISSION_STATE: AdmissionModuleState = <AdmissionModuleState>{};
export const admissionModuleReducers = {
 };

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    // AdmissionSubModule.forRoot(),
  ],
  declarations: [
    // page
    AdmissionPage,
  ],
  exports: [],
})
export class AdmissionModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AdmissionModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        AdmissionService,
      ],
    };
  }
}
