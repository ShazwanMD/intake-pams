import { IntakeTaskViewPage } from './intake-task-view.page';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {AdmissionPage} from './admission.page';
import {AdmissionService} from '../../../services/admission.service';
import { PipeModule } from '../../app.pipe.module';
import { CommonModule } from '../../common';
import {intakeTaskListReducer, IntakeTaskListState} from './intake-task-list.reducer';
import {intakeTaskReducer, IntakeTaskState} from './intake-task.reducer';
import {
  candidateListReducer, CandidateListState, rejectedCandidateListReducer,
  selectedCandidateListReducer, preSelectedCandidateListReducer,approvedCandidateListReducer, offeredCandidateListReducer,
} from './candidate-list.reducer';
import {AdmissionActions} from './admission.action';
import {AdmissionEffects} from './admission.effect';
import {EffectsModule} from '@ngrx/effects';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import {Candidate} from '../../shared/model/admission/candidate.interface';
import { CpsIntakeApplicationSubModule } from '../application/intake-applications/cps';
import { IntakeSubModule } from '../policy/intakes';
import { CandidateListComponent } from './component/candidate-list.component';
import { CandidatePreSelectListComponent } from './component/candidate-preselect-list.component';
import {CandidateApproveListComponent} from './component/candidate-approve-list.component';
import { CandidateOfferListComponent } from './component/candidate-offer-list.component';
import { CandidateRecommendListComponent } from './component/candidate-recommend-list.component';
import { CandidateRejectedListComponent } from './component/candidate-rejected-list.component';
import { CandidateTaskListComponent } from './component/candidate-task-list.component';
import { CandidateTaskStatusComponent } from './component/candidate-task-status.component';
import { CandidateProfilePreSelectDialog } from './dialog/candidate-profile-pre-select.dialog';
import { CandidateProfileRegisterDialog } from './dialog/candidate-profile-register.dialog';
import { CandidateProfileRejectDialog } from './dialog/candidate-profile-reject.dialog';
import { CandidateProfileSelectDialog } from './dialog/candidate-profile-select.dialog';
import { CandidateProfileDialog } from './dialog/candidate-profile.dialog';
import { IntakeTaskDetailPage } from './intake-task-detail.page';
import { CandidateApproveTaskPanel } from './panel/candidate-approve-task.panel';
import { CandidateOfferTaskPanel } from './panel/candidate-offer-task.panel';
import { CandidatePreApproveTaskPanel } from './panel/candidate-preapprove-task.panel';
import { CandidateRegisterTaskPanel } from './panel/candidate-register-task.panel';
import { CandidateTaskWorkflowPanel } from './panel/candidate-task-workflow.panel';

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
    offeredCandidates: <Candidate[]>[],
  };
export const admissionModuleReducers = {
  intakeTasks: intakeTaskListReducer,
  intakeTask: intakeTaskReducer,
  candidates: candidateListReducer,
  selectedCandidates: selectedCandidateListReducer,
  preSelectedCandidates: preSelectedCandidateListReducer,
  rejectedCandidates: rejectedCandidateListReducer,
  approvedCandidates: approvedCandidateListReducer,
  offeredCandidates: offeredCandidateListReducer,
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
    PipeModule.forRoot(),
  ],
  declarations: [
    // page
    AdmissionPage,
    CandidateListComponent,
    CandidatePreSelectListComponent,
    CandidateApproveListComponent,
    CandidateProfileSelectDialog,
    CandidateProfileRejectDialog,
    CandidateProfileDialog,
    CandidateProfilePreSelectDialog,
    CandidateRejectedListComponent,
    CandidateTaskListComponent,
    CandidateApproveTaskPanel,
    CandidatePreApproveTaskPanel,
    CandidateRegisterTaskPanel,
    CandidateTaskWorkflowPanel,
    IntakeTaskDetailPage,
    IntakeTaskViewPage,
    CandidateTaskStatusComponent,
    CandidateRecommendListComponent,
    CandidateOfferTaskPanel,
    CandidateOfferListComponent,
    CandidateProfileRegisterDialog,
  ],
  exports: [CandidateListComponent,
    CandidateProfileSelectDialog,
    CandidateProfileRejectDialog,
    CandidateProfileDialog,
    CandidateProfilePreSelectDialog,
    CandidatePreSelectListComponent,
    CandidateApproveListComponent,
    CandidateRejectedListComponent,
    CandidateTaskListComponent,
    CandidateApproveTaskPanel,
    CandidatePreApproveTaskPanel,
    CandidateRegisterTaskPanel,
    CandidateTaskWorkflowPanel,
    IntakeTaskDetailPage,
    IntakeTaskViewPage,
    CandidateTaskStatusComponent,
    CandidateRecommendListComponent,
    CandidateOfferTaskPanel,
    CandidateOfferListComponent,
    CandidateProfileRegisterDialog,
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
    CandidateTaskListComponent,
    CandidateApproveTaskPanel,
    CandidatePreApproveTaskPanel,
    CandidateRegisterTaskPanel,
    CandidateTaskWorkflowPanel,
    IntakeTaskDetailPage,
    IntakeTaskViewPage,
    CandidateTaskStatusComponent,
    CandidateRecommendListComponent,
    CandidateOfferTaskPanel,
    CandidateOfferListComponent,
    CandidateProfileRegisterDialog,
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
