import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {EffectsModule} from "@ngrx/effects";
import {CommonEffects} from "./common.effect";
import {CommonActions} from "./common.action";
import {ProgramCodeListState, programCodeListReducer} from "./program-codes/program-code-list.reducer";
import {StudyModeListState, studyModeListReducer} from "./study-modes/study-mode-list.reducer";
import {SupervisorCodeListState, supervisorCodeListReducer} from "./supervisor-codes/supervisor-code-list.reducer";
import {GraduateCentreListState, graduateCentreListReducer} from "./graduate-centres/graduate-centre-list.reducer";
import {GraduateCentreSelectComponent} from "./graduate-centres/component/graduate-centre-select.component";
import {ProgramCodeSelectComponent} from "./program-codes/component/program-code-select.component";

export interface CommonModuleState {
  programCodes: ProgramCodeListState;
  studyModes: StudyModeListState;
  supervisorCodes: SupervisorCodeListState;
  graduateCentres: GraduateCentreListState;
}
;

export const INITIAL_COMMON_STATE: CommonModuleState = <CommonModuleState>{};
export const commonModuleReducers = {
  programCodes: programCodeListReducer,
  studyModes: studyModeListReducer,
  supervisorCodes: supervisorCodeListReducer,
  graduateCentres: graduateCentreListReducer,
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
    GraduateCentreSelectComponent,
    ProgramCodeSelectComponent,
  ],
  exports: [
    GraduateCentreSelectComponent,
    ProgramCodeSelectComponent,
  ],
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
