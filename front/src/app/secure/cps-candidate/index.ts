import { Intake } from './../../shared/model/policy/intake.interface';
import { AdmissionCandidateCenterPage } from './admission-candidate-center.page';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../../services';
import {IdentityService, ApplicationService} from '../../../services';
import {AdmissionService} from '../../../services/admission.service';
import { PipeModule } from '../../app.pipe.module';
import { CommonModule } from '../../common';
import {EffectsModule} from '@ngrx/effects';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import {Candidate} from '../../shared/model/admission/candidate.interface';
import { CpsIntakeApplicationSubModule } from '../application/intake-applications/cps';
import { IntakeSubModule } from '../policy/intakes';
import { assignedIntakeTaskListReducer, pooledIntakeTaskListReducer } from '../policy/intakes/intake-task-list.reducer';
import { archivedIntakeListReducer } from '../account/intake-list.reducer';
import { IntakeListState } from '../application/intake-applications/intake-list.reducer';
import { CandidateTask } from '../../shared/model/admission/candidate-task.interface';
import {AdmissionCandidateActions} from './admission-candidate.action';
import {AdmissionCandidateEffects} from './admission-candidate.effect';
import { AssignedCandidateListComponent } from './component/assigned-candidate-list.component';
import { PooledCandidateListComponent } from './component/pooled-candidate-list.component';
import { ArchivedCandidateListComponent } from './component/archived-candidate-list.component';
import { CandidateTaskState, assignedCandidateListReducer, pooledCandidateListReducer 
    } from './admission-candidate-task-list.reducer';
import { CandidateAdmissionTaskState, candidateTaskReducer 
    } from './admission-candidate-task.reducer';
import { CandidatesState, candidateAdmissionReducer 
    } from './candidate.reducer';
import { CandidateListTaskWorkflowPanel } from './panel/candidate-list-task-workflow.panel';
import { CandidateDraftTaskPanel } from "./panel/candidate-draft-task.panel";
import { AdmissionTaskDetailPage } from "./admission-task-detail.page";
import { CandidateProfileComponent } from "./component/candidate-detail.component";
import { CandidateTaskStatusComponent } from "./component/candidate-task-status.component";
import { CandidateVerifyTaskPanel } from "./panel/candidate-verify-task.panel";
import { CandidatePublishTaskPanel } from "./panel/candidate-publish-task.panel.";
import { CandidateListState, candidateListReducer } from './candidate-list.reducer';
// import { AdmissionCandidateDetailPage } from "./admission-candidate-detail.page";
// import { IntakeApplicationActions } from "../application/intake-applications/intake-application.action";
// import { CandidateArchivedDetailComponent } from "./component/candidate-archived-detail.component";
// } from './candidate-list.reducer';
import { AdmissionCandidateDetailPage } from "./admission-candidate-detail.page";
import { IntakeApplicationActions } from "../application/intake-applications/intake-application.action";
import { CandidateArchivedDetailComponent } from "./component/candidate-archived-detail.component";
import { EditSupervisorDialog } from "./dialog/edit-supervisor.dialog";
import { SupervisorOfferingAdmissionSelectComponent } from "./component/supervisor-offer-select.component";
    
export interface AdmissionCandidateModuleState {
 // intakeTasks: IntakeTaskListState;
    assignedCandidate: CandidateTaskState;
    pooledCandidate: CandidateTaskState;
    archivedCandidate: CandidateListState;
    candidateTasks: CandidateAdmissionTaskState;
    candidate: CandidatesState;
}
;

export const INITIAL_ADMISSION_CANDIDATE_STATE: AdmissionCandidateModuleState =
  <AdmissionCandidateModuleState>{
  //  intakeTasks: <IntakeTask[]>[],
        assignedCandidate: <CandidateTask[]>[],
        pooledCandidate: <CandidateTask[]>[],
        archivedCandidate: <Candidate[]>[],
        candidateTasks: <CandidateTask>{},
        candidate: <Candidate>{},
  };
export const admissionCandidateModuleReducers = {
 // intakeTasks: intakeTaskListReducer,
        assignedCandidate: assignedCandidateListReducer,
        pooledCandidate: pooledCandidateListReducer,
        archivedCandidate: candidateListReducer,
        candidateTasks: candidateTaskReducer,
        candidate: candidateAdmissionReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AdmissionCandidateEffects),
    CommonModule.forRoot(),
    IntakeSubModule.forRoot(),
    CpsIntakeApplicationSubModule,
    PipeModule.forRoot(),
  ],
  declarations: [
    // page
    AdmissionCandidateCenterPage,
    AdmissionCandidateDetailPage,
    AssignedCandidateListComponent,
    PooledCandidateListComponent,
    CandidateListTaskWorkflowPanel,
    CandidateDraftTaskPanel,
    CandidateVerifyTaskPanel,
    CandidatePublishTaskPanel,
    AdmissionTaskDetailPage,
    CandidateProfileComponent,
    CandidateTaskStatusComponent,
    ArchivedCandidateListComponent,
    CandidateArchivedDetailComponent,
 
    EditSupervisorDialog,
    SupervisorOfferingAdmissionSelectComponent,
  ],
  exports: [
    AdmissionCandidateCenterPage,
    AdmissionCandidateDetailPage,
    AssignedCandidateListComponent,
    PooledCandidateListComponent,
    CandidateListTaskWorkflowPanel,
    CandidateDraftTaskPanel,
    CandidateVerifyTaskPanel,
    CandidatePublishTaskPanel,
    AdmissionTaskDetailPage,
    CandidateProfileComponent,
    CandidateTaskStatusComponent,
    ArchivedCandidateListComponent,
    CandidateArchivedDetailComponent,
  
    EditSupervisorDialog,
    SupervisorOfferingAdmissionSelectComponent,
  ],
  entryComponents: [
    AdmissionCandidateCenterPage,
    AdmissionCandidateDetailPage,
    CandidateListTaskWorkflowPanel,
    AdmissionTaskDetailPage,
    CandidateDraftTaskPanel,
    CandidateVerifyTaskPanel,
    CandidatePublishTaskPanel,
    CandidateProfileComponent,
    CandidateTaskStatusComponent,
    ArchivedCandidateListComponent,
    CandidateArchivedDetailComponent,

    EditSupervisorDialog,
    SupervisorOfferingAdmissionSelectComponent,
  ],
})
export class AdmissionCandidateModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AdmissionCandidateModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        AdmissionService,
        ApplicationService,
        AdmissionCandidateActions,
        IntakeApplicationActions,
      ],
    };
  }
}
