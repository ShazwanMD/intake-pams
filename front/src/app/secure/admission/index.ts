import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {AdmissionPage} from './admission.page';
import {AdmissionService} from '../../../services/admission.service';
import { CommonModule } from '../../common';
import {IntakeTaskListComponent} from './component/intake-task-list.component';
import {intakeTaskListReducer, IntakeTaskListState} from './intake-task-list.reducer';
import {intakeTaskReducer, IntakeTaskState} from './intake-task.reducer';
import {
  candidateListReducer, CandidateListState, rejectedCandidateListReducer,
  selectedCandidateListReducer, preSelectedCandidateListReducer,approvedCandidateListReducer,
} from './candidate-list.reducer';
import {AdmissionActions} from './admission.action';
import {AdmissionEffects} from './admission.effect';
import {EffectsModule} from '@ngrx/effects';
import {IntakeTaskViewPage} from './intake-task-view.page';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import {Candidate} from '../../shared/model/admission/candidate.interface';
import { CpsIntakeApplicationSubModule } from '../application/intake-applications/cps';
import { CandidateListComponent } from './component/candidate-list.component';
import { CandidatePreSelectListComponent } from './component/candidate-preselect-list.component';
import {CandidateApproveListComponent} from './component/candidate-approve-list.component';
import { CandidateRejectedListComponent } from './component/candidate-rejected-list.component';
import { CandidateProfilePreSelectDialog } from './dialog/candidate-profile-pre-select.dialog';
import { CandidateProfileRejectDialog } from './dialog/candidate-profile-reject.dialog';
import { CandidateProfileSelectDialog } from './dialog/candidate-profile-select.dialog';
import { CandidateProfileDialog } from './dialog/candidate-profile.dialog';

export interface AdmissionModuleState {
  intakeTasks: IntakeTaskListState;
  intakeTask: IntakeTaskState;
  candidates: CandidateListState;
  selectedCandidates: CandidateListState;
  preSelectedCandidates: CandidateListState;
  rejectedCandidates: CandidateListState;
  approvedCandidates: CandidateListState;
}
;

export const INITIAL_ADMISSION_STATE: AdmissionModuleState =
  <AdmissionModuleState>{
    intakeTasks: <IntakeTask[]>[],
    intakeTask: <IntakeTask>{},
    candidates: <Candidate[]>[],
    selectedCandidates: <Candidate[]>[],
    rejectedCandidates: <Candidate[]>[],
    preSelectedCandidates: <Candidate[]>[],
    approvedCandidates: <Candidate[]>[],
  };
export const admissionModuleReducers = {
  intakeTasks: intakeTaskListReducer,
  intakeTask: intakeTaskReducer,
  candidates: candidateListReducer,
  selectedCandidates: selectedCandidateListReducer,
  preSelectedCandidates: preSelectedCandidateListReducer,
  rejectedCandidates: rejectedCandidateListReducer,
  approvedCandidates: approvedCandidateListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AdmissionEffects),
    CommonModule.forRoot(),
    CpsIntakeApplicationSubModule,
  ],
  declarations: [
    // page
    AdmissionPage,
    IntakeTaskViewPage,
    IntakeTaskListComponent,
    CandidateListComponent,
    CandidatePreSelectListComponent,
    CandidateApproveListComponent,
    CandidateProfileSelectDialog,
    CandidateProfileRejectDialog,
    CandidateProfileDialog,
    CandidateProfilePreSelectDialog,
    CandidateRejectedListComponent,
    
  ],
  exports: [CandidateListComponent,
    CandidateProfileSelectDialog,
    CandidateProfileRejectDialog,
    CandidateProfileDialog,
    CandidateProfilePreSelectDialog,
    CandidatePreSelectListComponent,
    CandidateApproveListComponent,
    CandidateRejectedListComponent,
    
  ],
  entryComponents: [
    CandidateListComponent,
    CandidateProfileSelectDialog,
    CandidateProfileRejectDialog,
    CandidateProfileDialog,
    CandidateProfilePreSelectDialog,
    CandidatePreSelectListComponent,
    CandidateApproveListComponent,
    CandidateRejectedListComponent,
  ],
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
