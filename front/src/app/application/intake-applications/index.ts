import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {environment} from '../../../environments/environment';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {PolicyService} from "../../../services/policy.service";
import {MgsebIntakeApplicationSubModule} from "./mgseb/index";
import {CpsIntakeApplicationSubModule} from "./cps/index";
import {EffectsModule} from "@ngrx/effects";
import {IntakeApplicationEffects} from "./intake-application.effect";
import {IntakeApplicationActions} from "./intake-application.action";
import {IntakeDetailPage} from "./intake-detail.page";
import { EmploymentCreatorDialog } from "./mgseb/dialog/employment-creator.dialog";
import { EmploymentTaskListComponent } from "./mgseb/component/employment-task-list.component";
import { EducationCreatorDialog } from "./mgseb/dialog/education-creator.dialog";
import { CommonModule } from "../../common/index";
import { ProgramLevelSubModule } from "../../policy/program-levels/index";
import { ProgramOfferingSelectComponent } from "./cps/component/program-offering-select.component";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    MgsebIntakeApplicationSubModule.forRoot(),
    CpsIntakeApplicationSubModule.forRoot(),
    EffectsModule.run(IntakeApplicationEffects),
    CommonModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
  ],
  declarations: [
    IntakeDetailPage,

    //components
    EmploymentTaskListComponent,
    //dialogs
    EmploymentCreatorDialog,
    EducationCreatorDialog,
  ],
  exports: [],
  entryComponents: [
    EmploymentCreatorDialog,
    EducationCreatorDialog,
  ],
})
export class IntakeApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: IntakeApplicationSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        IntakeApplicationActions,
      ],
    };
  }
}
