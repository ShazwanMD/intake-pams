import { MgsebIntakeApplicationSubModule } from './../../application/intake-applications/mgseb/index';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {environment} from '../../../../environments/environment';

import {CovalentCoreModule} from '@covalent/core';

import {EffectsModule} from '@ngrx/effects';
import {CommonService} from '../../../../services';
import {IdentityService} from '../../../../services';
import {PolicyService} from '../../../../services/policy.service';
import {IntakeEffects} from './intake.effect';
import {IntakeActions} from './intake.action';
import {IntakeCenterPage} from './intake-center.page';
import {IntakeTaskListComponent} from './component/intake-task-list.component';
import {IntakeDraftTaskPanel} from './panel/intake-draft-task.panel';
import {IntakeTaskWorkflowPanel} from './panel/intake-task-workflow.panel';
import {IntakeTaskCreatorDialog} from './dialog/intake-task-creator.dialog';
import {ProgramOfferingListComponent} from './component/program-offering-list.component';
import {SupervisorOfferingListComponent} from './component/supervisor-offering-list.component';
import {StudyModeOfferingListComponent} from './component/study-mode-offering-list.component';
import {ProgramOfferingEditorDialog} from './dialog/program-offering-editor.dialog';
import {CommonModule} from '../../../common/index';
import {CommonActions} from '../../../common/common.action';
import {IntakeSessionActions} from '../intake-sessions/intake-session.action';
import {ProgramLevelSubModule} from '../program-levels/index';
import {IntakeSessionSubModule} from '../intake-sessions/index';
import {StudyModeOfferingEditorDialog} from './dialog/study-mode-offering-editor.dialog';
import {SupervisorOfferingEditorDialog} from './dialog/supervisor-offering-editor.dialog';
import {IntakeVerifyTaskPanel} from './panel/intake-verify-task.panel';
import {IntakeTaskStatusComponent} from './component/intake-task-status.component';
import {IntakePublishTaskPanel} from './panel/intake-publish-task.panel';
import {ProgramOfferingSelectComponent} from './component/program-offering-select.component';
import {IntakeApplicationListComponent} from './component/intake-application-list.component';
import {IntakeTaskDetailPage} from './intake-task-detail.page';
import {ProgramOfferingListEditorDialog} from './dialog/program-offering-list-editor.dialog';
import {IntakeUpdaterDialog} from './dialog/intake-updater.dialog';
import {IntakeEvaluateTaskPanel} from './panel/intake-evaluate-task.panel';
import {ApplicantProfileDialog} from './dialog/applicant-profile.dialog';
import {IntakeApplicationEvaluateListComponent} from './component/intake-application-evaluate-list.component';
import {CpsIntakeApplicationSubModule} from '../../application/intake-applications/cps/index';
import {PipeModule} from '../../../app.pipe.module';
import {ApplicantProfileRejectDialog} from './dialog/applicant-profile-reject.dialog';
import {IntakeApplicationSubmittedListComponent} from './component/intake-application-submitted-list.component';
import {IntakeApplicationSelectedListComponent} from './component/intake-application-selected-list.component';
import {IntakeApplicationRejectedListComponent} from './component/intake-application-rejected-list.component';
import {IntakeApplicationVerifiedListComponent} from './component/intake-application-verified-list.component';
import {ApplicantProfileVerifyDialog} from './dialog/applicant-profile-verify.dialog';
import {ArchivedIntakeListComponent} from './component/archived-intake-list.component';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    CpsIntakeApplicationSubModule,
    MgsebIntakeApplicationSubModule,
    IntakeSessionSubModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    EffectsModule.run(IntakeEffects),
    PipeModule,
  ],
  declarations: [
    // page
    IntakeCenterPage,
    IntakeTaskDetailPage,

    // components
    IntakeTaskListComponent,
    ArchivedIntakeListComponent,
    ProgramOfferingListComponent,
    SupervisorOfferingListComponent,
    StudyModeOfferingListComponent,
    IntakeTaskStatusComponent,
    ProgramOfferingSelectComponent,
    IntakeApplicationListComponent,
    IntakeApplicationEvaluateListComponent,
    IntakeApplicationSubmittedListComponent,
    IntakeApplicationSelectedListComponent,
    IntakeApplicationRejectedListComponent,
    IntakeApplicationVerifiedListComponent,

    // panels
    IntakeTaskWorkflowPanel,
    IntakeDraftTaskPanel,
    IntakeVerifyTaskPanel,
    IntakePublishTaskPanel,
    IntakeEvaluateTaskPanel,

    // dialogs
    IntakeTaskCreatorDialog,
    IntakeUpdaterDialog,
    ProgramOfferingEditorDialog,
    ProgramOfferingListEditorDialog,
    StudyModeOfferingEditorDialog,
    SupervisorOfferingEditorDialog,
    IntakeUpdaterDialog,
    ApplicantProfileDialog,
    ApplicantProfileRejectDialog,
    ApplicantProfileVerifyDialog,
  ],
  exports: [
    IntakeTaskListComponent,
    ProgramOfferingSelectComponent,
  ],
  entryComponents: [
    IntakeDraftTaskPanel,
    IntakeUpdaterDialog,
    IntakeVerifyTaskPanel,
    IntakePublishTaskPanel,
    IntakeEvaluateTaskPanel,
    IntakeTaskCreatorDialog,
    ProgramOfferingEditorDialog,
    ProgramOfferingListEditorDialog,
    StudyModeOfferingEditorDialog,
    SupervisorOfferingEditorDialog,
    ApplicantProfileDialog,
    ApplicantProfileRejectDialog,
    ApplicantProfileVerifyDialog,
  ],

})
export class IntakeSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: IntakeSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        IntakeActions,
        IntakeSessionActions,
        CommonActions,
      ],
    };
  }
}
