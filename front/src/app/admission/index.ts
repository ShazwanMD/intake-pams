import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {AdmissionPage} from "./admission.page";
import {AdmissionService} from "../../services/admission.service";
import {IntakeTaskListComponent} from "./component/intake-task-list.component";
import {Candidate} from "./candidate.interface";
import {intakeTaskListReducer, IntakeTaskListState} from "./intake-task-list.reducer";
import {intakeTaskReducer, IntakeTaskState} from "./intake-task.reducer";
import {candidateListReducer, CandidateListState} from "./candidate-list.reducer";
import {IntakeTask} from "../policy/intakes/intake-task.interface";
import {AdmissionActions} from "./admission.action";
import {AdmissionEffects} from "./admission.effect";
import {EffectsModule} from "@ngrx/effects";
import {IntakeTaskViewPage} from "./intake-task-view.page";

export interface AdmissionModuleState {
  intakeTasks: IntakeTaskListState;
  intakeTask: IntakeTaskState;
  candidates: CandidateListState;
}
;

export const INITIAL_ADMISSION_STATE: AdmissionModuleState =
  <AdmissionModuleState>{
    intakeTasks: <IntakeTask[]>[],
    intakeTask: <IntakeTask>{},
    candidates: <Candidate[]>[],
    candidate: <Candidate>{},
  };
export const admissionModuleReducers = {
  intakeTasks: intakeTaskListReducer,
  intakeTask: intakeTaskReducer,
  candidates: candidateListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AdmissionEffects),
  ],
  declarations: [
    // page
    AdmissionPage,
    IntakeTaskViewPage,
    IntakeTaskListComponent,
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
        AdmissionActions,
      ],
    };
  }
}
