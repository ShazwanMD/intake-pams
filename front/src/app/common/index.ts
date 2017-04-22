import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {programCodeListReducer, ProgramCodeListState} from "./program-code-list.reducer";
import {StudyModeListState, studyModeListReducer} from "./study-mode-list.reducer";
import {SupervisorCodeListState, supervisorCodeListReducer} from "./supervisor-code-list.reducer";
import {EffectsModule} from "@ngrx/effects";
import {CommonEffects} from "./common.effect";
import {CommonActions} from "./common.action";

export interface CommonModuleState {
  programCodes: ProgramCodeListState;
  studyModes: StudyModeListState;
  supervisorCodes: SupervisorCodeListState;
}
;

export const INITIAL_COMMON_STATE: CommonModuleState = <CommonModuleState>{};
export const commonModuleReducers = {
  programCodes: programCodeListReducer,
  studyModes: studyModeListReducer,
  supervisorCodes: supervisorCodeListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(CommonEffects),
  ],
  declarations: [
  ],
  exports: [],
})
export class CommonModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CommonModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        CommonActions
      ],
    };
  }
}
