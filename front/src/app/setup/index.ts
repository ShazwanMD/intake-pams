import { SchoolCodeEditorDialog } from './school-codes/dialog/school-code-editor.dialog';
import { SchoolCodeListPage } from './school-codes/school-code-list-page';
import { DisabilityCode } from './../common/disability-codes/disability-code.interface';
import { DisabilityCodeEditorDialog } from './disability-codes/dialog/disability-code-editor.dialog';
import { IntakeSessionSubModule } from './../policy/intake-sessions/index';
import { ProgramLevelSubModule } from './../policy/program-levels/index';
import { FacultyCodeSelectComponent } from './../common/faculty-codes/component/faculty-code-select.component';
import { ProgramCodeSelectComponent } from './../common/program-codes/component/program-code-select.component';
import { StudyModeSelectComponent } from './../common/study-modes/component/study-mode-select.component';
import { ProgramLevelSelectComponent } from './../policy/program-levels/component/program-level-select.component';
import { GraduateCentreSelectComponent } from './../common/graduate-centres/component/graduate-centre-select.component';
import { SupervisorCodeEditorDialog } from './supervisor-codes/dialog/supervisor-code-editor.dialog';
import { StudyMode } from './../common/study-modes/study-mode.interface';
import { StudyModeListPage } from './study-modes/study-mode-list.page';
import { StudyModeCreatorDialog } from './study-modes/dialog/study-mode-creator.dialog';
import { FacultyCodeCreatorDialog } from './faculty-codes/dialog/faculty-code-creator.dialog';
import { FacultyCodeListPage } from './faculty-codes/faculty-code-list.page';
import { FacultyCode } from './../common/faculty-codes/faculty-code.interface';
import { NationalityCodeCreatorDialog } from './nationality-codes/dialog/nationality-code-creator.dialog';
import { NationalityCodeListPage } from './nationality-codes/nationality-code-list.page';
import { NationalityCode } from './../common/nationality-codes/nationality-code.interface';
import { EthnicityCodeCreatorDialog } from './ethnicity-codes/dialog/ethnicity-code-creator.dialog';
import { EthnicityCodeListPage } from './ethnicity-codes/ethnicity-code-list.page';
import { EthnicityCode } from './../common/ethnicity-codes/ethnicity-code.interface';
import { GenderCodeCreatorDialog } from './gender-codes/dialog/gender-code-creator.dialog';
import { GenderCodeListPage } from './gender-codes/gender-code-list.page';
import { GenderCode } from './../common/gender-codes/gender-code.interface';
import { RaceCodeCreatorDialog } from './race-codes/dialog/race-code-creator.dialog';
import { RaceCodeListPage } from './race-codes/race-code-list.page';
import { RaceCode } from './../common/race-codes/race-code.interface';
import { SupervisorCodeListPage } from './supervisor-codes/supervisor-code-list.page';
import { SupervisorCode } from './../common/supervisor-codes/supervisor-code.interface';
import { ReligionCodeCreatorDialog } from './religion-codes/dialog/religion-code-creator.dialog';
import { ProgramCodeCreatorDialog } from './program-codes/dialog/program-code-creator.dialog';
import { ProgramCodeListPage } from './program-codes/program-code-list.page';
import { ProgramCode } from './../common/program-codes/program-code.interface';
import { StateCodeCreatorDialog } from './state-codes/dialog/state-code-creator.dialog';
import { StateCodeListPage } from './state-codes/state-code-list.page';
import { StateCode } from './../common/state-codes/state-code.interface';
import { CountryCodeCreatorDialog } from './country-codes/dialog/country-code-creator.dialog';
import { CountryCodeListPage } from './country-codes/country-code-list.page';
import { CountryCode } from './../common/country-codes/country-code.interface';
import { MaritalCodeListPage } from './marital-codes/marital-code-list-page';
import { BankCode } from './../common/bank-codes/bank-code.interface';
import { MaritalCode } from './../common/marital-codes/marital-code.interface';
import { ReligionCode } from './../common/religion-codes/religion-code.interface';
import { ReligionCodeListPage } from './religion-codes/religion-code-list.page';
import { SetupPage } from './setup.page';
import { DisabilityCodeListPage } from './disability-codes/disability-code-list-page';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {NgModule, ModuleWithProviders} from "@angular/core";
import {CovalentCoreModule} from '@covalent/core';
import {CommonModule} from "../common/index";
import {bankCodeListReducer, BankCodeListState} from "./bank-codes/bank-code-list.reducer";
import {maritalCodeListReducer, MaritalCodeListState} from "./marital-codes/marital-code-list.reducer";
import {religionCodeListReducer, ReligionCodeListState} from "./religion-codes/religion-code-list.reducer";
import {SetupEffects} from "./setup.effect";
import {EffectsModule} from "@ngrx/effects";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";
import {SetupActions} from "./setup.action";
import {graduateCentreListReducer, GraduateCentreListState} from "./graduate-centres/graduate-centre-list.reducer";
import {GraduateCentre} from "../common/graduate-centres/graduate-centre.interface";
import {GraduateCentreListPage} from "./graduate-centres/graduate-centre-list.page";
import {GraduateCentreCreatorDialog} from "./graduate-centres/dialog/graduate-centre-creator.dialog";
import {BankCodeCreatorDialog} from "./bank-codes/dialog/bank-code-creator.dialog";
import {countryCodeListReducer, CountryCodeListState} from "./country-codes/country-code-list.reducer";
import {stateCodeListReducer, StateCodeListState} from "./state-codes/state-code-list.reducer";
import {programCodeListReducer, ProgramCodeListState} from "./program-codes/program-code-list.reducer";
import {supervisorCodeListReducer, SupervisorCodeListState} from "./supervisor-codes/supervisor-code-list.reducer";
import {raceCodeListReducer, RaceCodeListState} from "./race-codes/race-code-list.reducer";
import {genderCodeListReducer, GenderCodeListState} from "./gender-codes/gender-code-list.reducer";
import {ethnicityCodeListReducer, EthnicityCodeListState} from "./ethnicity-codes/ethnicity-code-list.reducer";
import {nationalityCodeListReducer, NationalityCodeListState} from "./nationality-codes/nationality-code-list.reducer";
import {facultyCodeListReducer, FacultyCodeListState} from "./faculty-codes/faculty-code-list.reducer";
import {studyModeListReducer, StudyModeListState} from './study-modes/study-mode-list.reducer';
import {titleReducer, TitleState} from "./title.reducer";
import {MaritalCodeEditorDialog} from "./marital-codes/dialog/marital-code-editor.dialog";
import {disabilityCodeListReducer, DisabilityCodeListState} from "./disability-codes/disability-code-list.reducer";
import {schoolCodeListReducer, SchoolCodeListState} from "./school-codes/school-code-list.reducer";
import { SchoolCode } from './../common/school-codes/school-code.interface';



export interface SetupModuleState {
  title:TitleState;
  maritalCodes: MaritalCodeListState;
  bankCodes: BankCodeListState;
  graduateCentres: GraduateCentreListState;
  religionCodes : ReligionCodeListState;
  countryCodes : CountryCodeListState;
  stateCodes : StateCodeListState;
  programCodes : ProgramCodeListState;
  supervisorCodes : SupervisorCodeListState;
  raceCodes : RaceCodeListState;
  genderCodes : GenderCodeListState;
  ethnicityCodes : EthnicityCodeListState;
  nationalityCodes : NationalityCodeListState;
  facultyCodes : FacultyCodeListState;
  studyModes : StudyModeListState;
  disabilityCodes: DisabilityCodeListState;
  schoolCodes: SchoolCodeListState;
};

export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    title:'Setup Codes',
    bankCodes: <BankCode[]>[],
    graduateCentres: <GraduateCentre[]>[],
    religionCodes: <ReligionCode[]>[],
    supervisorCodes: <SupervisorCode[]>[],
    programCodes: <ProgramCode[]>[],
    stateCodes: <StateCode[]>[],
    countryCodes: <CountryCode[]>[],
    raceCodes: <RaceCode[]>[],
    genderCodes: <GenderCode[]>[],
    maritalCodes: <MaritalCode[]>[],
    ethnicityCodes: <EthnicityCode[]>[],
    nationalityCodes: <NationalityCode[]>[],
    facultyCodes: <FacultyCode[]>[],
    studyModes: <StudyMode[]>[],
    disabilityCodes: <DisabilityCode[]>[],
    schoolCodes: <SchoolCode[]>[]
  };


export const setupModuleReducers = {
  title:titleReducer,
  bankCodes: bankCodeListReducer,
  graduateCentres: graduateCentreListReducer,
  religionCodes: religionCodeListReducer,
  maritalCodes: maritalCodeListReducer,
  countryCodes: countryCodeListReducer,
  stateCodes: stateCodeListReducer,
  programCodes: programCodeListReducer,
  supervisorCodes: supervisorCodeListReducer,
  raceCodes: raceCodeListReducer,
  genderCodes: genderCodeListReducer,
  ethnicityCodes: ethnicityCodeListReducer,
  nationalityCodes: nationalityCodeListReducer,
  facultyCodes: facultyCodeListReducer,
  studyModes: studyModeListReducer,
  disabilityCodes: disabilityCodeListReducer,
  schoolCodes: schoolCodeListReducer,
}

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    ProgramLevelSubModule.forRoot(),
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    IntakeSessionSubModule.forRoot(),
    EffectsModule.run(SetupEffects),

  ],
  declarations: [
    // page
    SetupPage,
    BankCodeListPage,
    GraduateCentreListPage,
    ReligionCodeListPage,
    MaritalCodeListPage,
    CountryCodeListPage,
    StateCodeListPage,
    ProgramCodeListPage,
    SupervisorCodeListPage,
    RaceCodeListPage,
    GenderCodeListPage,
    EthnicityCodeListPage,
    NationalityCodeListPage,
    FacultyCodeListPage,
    StudyModeListPage,
    DisabilityCodeListPage,
    SchoolCodeListPage,
  
    // dialog
    MaritalCodeEditorDialog,
    BankCodeCreatorDialog,
    GraduateCentreCreatorDialog,
    CountryCodeCreatorDialog,
    StateCodeCreatorDialog,
    ProgramCodeCreatorDialog,
    ReligionCodeCreatorDialog,
    SupervisorCodeEditorDialog,
    RaceCodeCreatorDialog,
    GenderCodeCreatorDialog,
    EthnicityCodeCreatorDialog,
    NationalityCodeCreatorDialog,
    FacultyCodeCreatorDialog,
    StudyModeCreatorDialog,
    DisabilityCodeEditorDialog,
    SchoolCodeEditorDialog,
  ],
  exports: [],
  entryComponents: [
    MaritalCodeEditorDialog,
    BankCodeCreatorDialog,
    GraduateCentreCreatorDialog,
    ReligionCodeCreatorDialog,
    CountryCodeCreatorDialog,
    StateCodeCreatorDialog,
    ProgramCodeCreatorDialog,
    SupervisorCodeEditorDialog,
    GenderCodeCreatorDialog,
    EthnicityCodeCreatorDialog,
    NationalityCodeCreatorDialog,
    FacultyCodeCreatorDialog,
    StudyModeCreatorDialog,
    DisabilityCodeEditorDialog,
    SchoolCodeEditorDialog,

  ],

})
export class SetupModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SetupModule,
      providers: [
        appRoutingProviders,
        SetupActions
      ],
    };
  }
}
