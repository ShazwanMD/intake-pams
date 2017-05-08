import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {environment} from '../../../environments/environment';

import {CovalentCoreModule} from '@covalent/core';

import {EffectsModule} from "@ngrx/effects";
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {PolicyService} from "../../../services/policy.service";
import {IntakeEffects} from "./intake.effect";
import {IntakeActions} from "./intake.action";
import {IntakeCenterPage} from "./intake-center.page";
import {IntakeTaskListComponent} from "./component/intake-task-list.component";
import {IntakeDraftTaskPanel} from "./panel/intake-draft-task.panel";
import {IntakeRegisterTaskPanel} from "./panel/intake-register-task.panel";
import {IntakeTaskWorkflowPanel} from "./panel/intake-task-workflow.panel";
import {IntakeTaskCreatorDialog} from "./dialog/intake-task-creator.dialog";
import {IntakeTaskViewPage} from "./intake-task-view.page";
import {ProgramOfferingListComponent} from "./component/program-offering-list.component";
import {SupervisorOfferingListComponent} from "./component/supervisor-offering-list.component";
import {StudyModeOfferingListComponent} from "./component/study-mode-offering-list.component";
import {ProgramOfferingEditorDialog} from "./dialog/program-offering-editor.dialog";
import {CommonModule} from "../../common/index";
import {CommonActions} from "../../common/common.action";
import {IntakeSessionActions} from "../intake-sessions/intake-session.action";
import {ProgramLevelSubModule} from "../program-levels/index";
import {IntakeSessionSubModule} from "../intake-sessions/index";
import {StudyModeOfferingEditorDialog} from "./dialog/study-mode-offering-editor.dialog";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    IntakeSessionSubModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    EffectsModule.run(IntakeEffects),
  ],
  declarations: [
    // page
    IntakeCenterPage,
    IntakeTaskViewPage,

    // components
    IntakeTaskListComponent,
    ProgramOfferingListComponent,
    SupervisorOfferingListComponent,
    StudyModeOfferingListComponent,

    // panels
    IntakeTaskWorkflowPanel,
    IntakeDraftTaskPanel,
    IntakeRegisterTaskPanel,

    // dialogs
    IntakeTaskCreatorDialog,
    ProgramOfferingEditorDialog,
    StudyModeOfferingEditorDialog,
  ],
  exports: [IntakeTaskListComponent],
  entryComponents: [
    IntakeDraftTaskPanel,
    IntakeRegisterTaskPanel,
    IntakeTaskCreatorDialog,
    ProgramOfferingEditorDialog,
    StudyModeOfferingEditorDialog,
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
