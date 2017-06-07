import { EmploymentTypeSelectComponent } from './../component/employment-type-select.component';
import {DiplomaResultListComponent} from '../component/diploma-result-list.component';
import {DiplomaResultCreatorDialog} from '../component/dialog/diploma-result-creator.dialog';
import {LanguageEditorDialog} from '../component/dialog/language-editor.dialog';
import {ResultTypeSelectComponent} from '../component/result-type-select.component';
import {BachelorResultListComponent} from '../component/bachelor-result-list.component';
import {BachelorResultCreatorDialog} from '../component/dialog/bachelor-result-creator.dialog';
import {SpmResultCreatorDialog} from '../component/dialog/spm-result-creator.dialog';
import {SpmResultListComponent} from '../component/spm-result-list.component';
import {AddressTypeSelectComponent} from '../component/address-type-select.component';
import {AttachmentTypeSelectComponent} from '../component/attachment-type-select.component';
import {RefereeTypeSelectComponent} from '../component/referee-type-select.component';
import {AddressEditorDialog} from '../component/dialog/address-editor.dialog';
import {AddressListComponent} from '../component/address-list.component';
import {RefereeEditorDialog} from '../component/dialog/referee-editor.dialog';
import {RefereeListComponent} from '../component/referee-list.component';
import {EmploymentEditorDialog} from '../component/dialog/employment-editor.dialog';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule, CovalentFileModule} from '@covalent/core';
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
import {AttachmentCreatorDialog} from "../component/dialog/attachment-creator.dialog";
import {AttachmentListComponent} from "../component/attachment-list.component";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CovalentFileModule.forRoot(),
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
    AttachmentListComponent,
    ProgramChoiceComponent,
    BachelorResultListComponent,
    DiplomaResultListComponent,
    AddressListComponent,
    AddressTypeSelectComponent,
    EmploymentTypeSelectComponent,
    AttachmentTypeSelectComponent,
    RefereeTypeSelectComponent,
    SpmResultListComponent,
    ResultTypeSelectComponent,


    //dialogs
    EmploymentEditorDialog,
    RefereeEditorDialog,
    AddressEditorDialog,
    SpmResultCreatorDialog,
    BachelorResultCreatorDialog,
    DiplomaResultCreatorDialog,
    LanguageEditorDialog,
    AttachmentCreatorDialog,

  ],
  exports: [
    EmploymentListComponent,
    LanguageListComponent,
    AttachmentCreatorDialog,
    RefereeListComponent,
    AttachmentListComponent,
    ProgramChoiceComponent,
    AddressListComponent,
    AddressTypeSelectComponent,
    EmploymentTypeSelectComponent,
    RefereeTypeSelectComponent,
    AttachmentTypeSelectComponent,
    SpmResultListComponent,
    BachelorResultListComponent,
    DiplomaResultListComponent,
    ResultTypeSelectComponent,

  ],

  entryComponents: [
    EmploymentEditorDialog,
    RefereeEditorDialog,
    AddressEditorDialog,
    SpmResultCreatorDialog,
    BachelorResultCreatorDialog,
    DiplomaResultCreatorDialog,
    LanguageEditorDialog,
    AttachmentCreatorDialog,
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
