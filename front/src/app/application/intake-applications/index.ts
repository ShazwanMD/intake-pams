import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
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
import {EmploymentCreatorDialog} from "./component/dialog/employment-creator.dialog";
import {EducationCreatorDialog} from "./component/dialog/education-creator.dialog";
import {CommonModule} from "../../common/index";
import {ProgramLevelSubModule} from "../../policy/program-levels/index";
import {EmploymentTaskListComponent} from "./component/employment-task-list.component";
import {EmploymentListState, employmentListReducer} from "./component/employment-task-list.reducer";
import {Employment} from "./employment.interface";
import {MyIntakeApplicationPage} from "./my-intake-application.page";
import {IntakeProgramOfferingSelectComponent} from "./component/intake-program-offering-select.component";

export interface IntakeApplicationModuleState {
  employments: EmploymentListState;
}
;

export const INITIAL_INTAKE_APPLICATION_STATE: IntakeApplicationModuleState =
  <IntakeApplicationModuleState>{
    employments: <Employment[]>[],
  };


export const intakeApplicationModuleReducers = {

  employments: employmentListReducer,
}

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
    MyIntakeApplicationPage,

    //components
    EmploymentTaskListComponent,
    //dialogs
    EmploymentCreatorDialog,
    EducationCreatorDialog,
  ],
  exports: [
  ],
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
