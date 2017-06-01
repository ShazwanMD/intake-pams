import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {CovalentCoreModule, CovalentFileModule} from '@covalent/core';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {PolicyService} from "../../../services/policy.service";
import {MgsebIntakeApplicationSubModule} from "./mgseb/index";
import {CpsIntakeApplicationSubModule} from "./cps/index";
import {EffectsModule} from "@ngrx/effects";
import {IntakeApplicationEffects} from "./intake-application.effect";
import {IntakeApplicationActions} from "./intake-application.action";
import {IntakeDetailPage} from "./intake-detail.page";
import {EducationCreatorDialog} from "./component/dialog/education-creator.dialog";
import {CommonModule} from "../../common/index";
import {ProgramLevelSubModule} from "../../policy/program-levels/index";
import {MyIntakeApplicationPage} from "./my-intake-application.page";
import {ProgramOfferingSelectorDialog} from "./component/dialog/program-offering-selector.dialog";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CovalentFileModule.forRoot(),
    MgsebIntakeApplicationSubModule.forRoot(),
    CpsIntakeApplicationSubModule.forRoot(),
    CommonModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    EffectsModule.run(IntakeApplicationEffects),
  ],
  declarations: [
    IntakeDetailPage,
    MyIntakeApplicationPage,

    //components
    //AddressTypeSelectComponent,

    //dialogs
    EducationCreatorDialog,
    ProgramOfferingSelectorDialog,
  ],
  exports: [
  ],
  entryComponents: [
    EducationCreatorDialog,
    ProgramOfferingSelectorDialog,
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
