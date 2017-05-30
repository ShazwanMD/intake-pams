import { ResultTypeSelectComponent } from './../component/result-type-select.component';
import { BachelorResultListComponent } from './../component/bachelor-result-list.component';
import { BachelorResultCreatorDialog } from './../component/dialog/bachelor-result-creator.dialog';
import { BachelorResult } from './../bachelor-result-interface';
import { SpmResultCreatorDialog } from './../component/dialog/spm-result-creator.dialog';
import { SpmResultListComponent } from './../component/spm-result-list.component';
import { SpmResult } from './../spm-result.interface';
import { AddressTypeSelectComponent } from './../component/address-type-select.component';
import { AddressCreatorDialog } from './../component/dialog/address-creator.dialog';
import { Address } from './../address.interface';
import { AddressListComponent } from './../component/address-list.component';
import {RefereeCreatorDialog} from './../component/dialog/referee-creator.dialog';
import {RefereeListComponent} from './../component/referee-list.component';
import {EmploymentCreatorDialog} from './../component/dialog/employment-creator.dialog';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {appRoutes, appRoutingProviders} from "../../../app.routes";
import {CpsIntakeApplicationPage} from "./intake-application.page";
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {ProgramLevelSubModule} from "../../../policy/program-levels/index";
import {CommonModule} from "../../../common/index";
import {PolicyService} from "../../../../services/policy.service";
import {IntakeSessionActions} from "../../../policy/intake-sessions/intake-session.action";
import {IntakeSubModule} from "../../../policy/intakes/index";
import {IntakeProgramOfferingSelectComponent} from "../component/intake-program-offering-select.component";
import {EmploymentListComponent} from "../component/employment-list.component";
import {ProgramChoiceComponent} from "../component/program-choice.component";
import {LanguageListComponent} from "../component/language-list.component";
import { StudyCenterCodeSelectComponent } from "../../../common/study-center-codes/component/study-center-code-select.component";




@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    IntakeSubModule.forRoot(),
    CommonModule.forRoot(),
  ],
  declarations: [
    CpsIntakeApplicationPage,
    IntakeProgramOfferingSelectComponent,

    //components
    EmploymentListComponent,
    LanguageListComponent,
    RefereeListComponent,
    ProgramChoiceComponent,
    BachelorResultListComponent,
    AddressListComponent,
    AddressTypeSelectComponent,
    SpmResultListComponent,
    ResultTypeSelectComponent,
    

    //dialogs
    EmploymentCreatorDialog,
    RefereeCreatorDialog,
    AddressCreatorDialog,
    SpmResultCreatorDialog,
    BachelorResultCreatorDialog,

  ],
  exports: [
    EmploymentListComponent,
    LanguageListComponent,
    RefereeListComponent,
    ProgramChoiceComponent,
    AddressListComponent,
    AddressTypeSelectComponent,
    SpmResultListComponent,
    BachelorResultListComponent,
    ResultTypeSelectComponent,
    
  ],

  entryComponents: [
    EmploymentCreatorDialog,
    RefereeCreatorDialog,
    AddressCreatorDialog,
    SpmResultCreatorDialog,
    BachelorResultCreatorDialog,

  ],
})
export class CpsIntakeApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CpsIntakeApplicationSubModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        IntakeSessionActions,
      ],
    };
  }
}
