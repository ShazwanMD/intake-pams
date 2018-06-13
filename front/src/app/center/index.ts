import { ProgramFieldCodeListComponent } from './component/program-field-code-list.component';
import { ProgramFieldCodeListState } from './../secure/setup/program-field-codes/program-field-code-list.reducer';
import { ProgramFieldCode } from './../shared/model/common/program-field-code.interface';
import { ProgramFieldCodeListPage } from './../secure/setup/program-field-codes/program-field-code-list.page';

import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {environment} from '../../environments/environment';
import {EffectsModule} from '@ngrx/effects';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {ProgramCodeListComponent} from './component/program-code-list.component';
import {ProgramCodeListState, programCodeListReducer} from './program-code-list.reducer';
import {GraduateCenterState, graduateCenterReducer} from './graduate-center.reducer';
import {MgsebCenterPage} from './mgseb-center.page';
import {CpsCenterPage} from './cps-center.page';
import {CenterPage} from './center.page';
import {CenterEffects} from './center.effect';
import {CenterActions} from './center.action';
import {GraduateCenter} from '../shared/model/common/graduate-center.interface';
import { programFieldCodeListReducer } from '../common/program-field-codes/program-field-code-list.reducer';

export interface CenterModuleState {
  graduateCenter: GraduateCenterState;
  programCodes: ProgramCodeListState;
  programFieldCodes: ProgramFieldCodeListState;
};

export const INITIAL_CENTER_STATE: CenterModuleState =
  <CenterModuleState>{
    graduateCenter: <GraduateCenter>{},
    programFieldCodes:[],
    programCodes: [],

  };

export const centerModuleReducers = {
  graduateCenter: graduateCenterReducer,
  programCodes: programCodeListReducer,
  programFieldCodes: programFieldCodeListReducer,

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
    ProgramFieldCodeListComponent,
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
