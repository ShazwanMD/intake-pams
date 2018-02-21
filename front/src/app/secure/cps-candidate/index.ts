import { Intake } from './../../shared/model/policy/intake.interface';
import { AdmissionCandidateCenterPage } from './admission-candidate-center.page';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
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
import { CandidateTaskState, assignedCandidateListReducer, pooledCandidateListReducer 
    } from './admission-candidate-task-list.reducer';
import { CandidateState, candidateTaskReducer 
    } from './admission-candidate-task.reducer';
import { CandidateListTaskWorkflowPanel } from './panel/candidate-list-task-workflow.panel';
    
export interface AdmissionCandidateModuleState {
 // intakeTasks: IntakeTaskListState;
    assignedCandidate: CandidateTaskState;
    pooledCandidate: CandidateTaskState;
    candidateTask: CandidateState;
}
;

export const INITIAL_ADMISSION_CANDIDATE_STATE: AdmissionCandidateModuleState =
  <AdmissionCandidateModuleState>{
  //  intakeTasks: <IntakeTask[]>[],
        assignedCandidate: <CandidateTask[]>[],
        pooledCandidate: <CandidateTask[]>[],
        candidateTask: <CandidateTask>{},
  };
export const admissionCandidateModuleReducers = {
 // intakeTasks: intakeTaskListReducer,
        assignedCandidate: assignedCandidateListReducer,
        pooledCandidate: pooledCandidateListReducer,
        candidateTask: candidateTaskReducer,
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
    AssignedCandidateListComponent,
    PooledCandidateListComponent,
    CandidateListTaskWorkflowPanel,
  ],
  exports: [
    AdmissionCandidateCenterPage,
    AssignedCandidateListComponent,
    PooledCandidateListComponent,
    CandidateListTaskWorkflowPanel,
  ],
  entryComponents: [
    AdmissionCandidateCenterPage,
    CandidateListTaskWorkflowPanel,
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
        AdmissionCandidateActions,
      ],
    };
  }
}
