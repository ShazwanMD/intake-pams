import { GradeCodeListPage } from './grade-codes/grade-code-list-page';
import { SubjectCodeEditorDialog } from './subject-codes/dialog/subject-code-editor.dialog';
import { SubjectCodeListPage } from './subject-codes/subject-code-list-page';
import { LanguageCode } from './../common/language-codes/language-code.interface';
import { ResidencyCodeEditorDialog } from './residency-codes/dialog/residency-code-editor.dialog';
import { ResidencyCodeListPage } from './residency-codes/residency-code-list-page';
import { StateCodeEditorDialog } from './state-codes/dialog/state-code-editor.dialog';
import {DistrictCodeEditorDialog} from './district-codes/dialog/district-code-editor.dialog';
import {DistrictCodeListPage} from './district-codes/district-code-list-page';
import {DunCodeEditorDialog} from './dun-codes/dialog/dun-code-editor.dialog';
import {DunCodeListPage} from './dun-codes/dun-code-list-page';
import {GradeCodeEditorDialog} from './grade-codes/dialog/grade-code-editor.dialog';
import {ParliamentCodeEditorDialog} from './parliament-codes/dialog/parliament-code-editor.dialog';
import {ParliamentCodeListPage} from './parliament-codes/parliament-code-list-page';
import {StudyCenterCodeEditorDialog} from './study-center-codes/dialogs/study-center-code-editor.dialog';
import {StudyCenterCode} from './../common/study-center-codes/study-center-code.interface';
import {StudyCenterCodeListPage} from './study-center-codes/study-center-code-list.page';
import {SchoolCodeEditorDialog} from './school-codes/dialog/school-code-editor.dialog';
import {SchoolCodeListPage} from './school-codes/school-code-list-page';
import {DisabilityCode} from './../common/disability-codes/disability-code.interface';
import {DisabilityCodeEditorDialog} from './disability-codes/dialog/disability-code-editor.dialog';
import {IntakeSessionSubModule} from './../policy/intake-sessions/index';
import {ProgramLevelSubModule} from './../policy/program-levels/index';
import {SupervisorCodeEditorDialog} from './supervisor-codes/dialog/supervisor-code-editor.dialog';
import {StudyMode} from './../common/study-modes/study-mode.interface';
import {StudyModeListPage} from './study-modes/study-mode-list.page';
import {StudyModeCreatorDialog} from './study-modes/dialog/study-mode-creator.dialog';
import {FacultyCodeCreatorDialog} from './faculty-codes/dialog/faculty-code-creator.dialog';
import {FacultyCodeListPage} from './faculty-codes/faculty-code-list.page';
import {FacultyCode} from './../common/faculty-codes/faculty-code.interface';
import {NationalityCodeCreatorDialog} from './nationality-codes/dialog/nationality-code-creator.dialog';
import {NationalityCodeListPage} from './nationality-codes/nationality-code-list.page';
import {NationalityCode} from './../common/nationality-codes/nationality-code.interface';
import {EthnicityCodeCreatorDialog} from './ethnicity-codes/dialog/ethnicity-code-creator.dialog';
import {EthnicityCodeListPage} from './ethnicity-codes/ethnicity-code-list.page';
import {EthnicityCode} from './../common/ethnicity-codes/ethnicity-code.interface';
import {GenderCodeCreatorDialog} from './gender-codes/dialog/gender-code-creator.dialog';
import {GenderCodeListPage} from './gender-codes/gender-code-list.page';
import {GenderCode} from './../common/gender-codes/gender-code.interface';
import {RaceCodeCreatorDialog} from './race-codes/dialog/race-code-creator.dialog';
import {RaceCodeListPage} from './race-codes/race-code-list.page';
import {RaceCode} from './../common/race-codes/race-code.interface';
import {SupervisorCodeListPage} from './supervisor-codes/supervisor-code-list.page';
import {SupervisorCode} from './../common/supervisor-codes/supervisor-code.interface';
import {ReligionCodeCreatorDialog} from './religion-codes/dialog/religion-code-creator.dialog';
import {ProgramCodeCreatorDialog} from './program-codes/dialog/program-code-creator.dialog';
import {ProgramCodeListPage} from './program-codes/program-code-list.page';
import {ProgramCode} from './../common/program-codes/program-code.interface';
import {StateCodeListPage} from './state-codes/state-code-list.page';
import {StateCode} from './../common/state-codes/state-code.interface';
import {CountryCodeCreatorDialog} from './country-codes/dialog/country-code-creator.dialog';
import {CountryCodeListPage} from './country-codes/country-code-list.page';
import {CountryCode} from './../common/country-codes/country-code.interface';
import {MaritalCodeListPage} from './marital-codes/marital-code-list-page';
import {BankCode} from './../common/bank-codes/bank-code.interface';
import {MaritalCode} from './../common/marital-codes/marital-code.interface';
import {ReligionCode} from './../common/religion-codes/religion-code.interface';
import {ReligionCodeListPage} from './religion-codes/religion-code-list.page';
import {SetupPage} from './setup.page';
import {DisabilityCodeListPage} from './disability-codes/disability-code-list-page';
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
import {graduateCenterListReducer, GraduateCenterListState} from "./graduate-centers/graduate-center-list.reducer";
import {GraduateCenter} from "../common/graduate-centers/graduate-center.interface";
import {GraduateCenterListPage} from "./graduate-centers/graduate-center-list.page";
import {GraduateCenterCreatorDialog} from "./graduate-centers/dialog/graduate-center-creator.dialog";
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
import {SchoolCode} from './../common/school-codes/school-code.interface';
import {studyCenterCodeListReducer,StudyCenterCodeListState} from "./study-center-codes/study-center-code-list.reducer";
import {districtCodeListReducer, DistrictCodeListState} from "./district-codes/district-code-list.reducer";
import {DistrictCode} from './../common/district-codes/district-code.interface';
import {dunCodeListReducer, DunCodeListState} from "./dun-codes/dun-code-list.reducer";
import {DunCode} from './../common/dun-codes/dun-code.interface';
import {parliamentCodeListReducer, ParliamentCodeListState} from "./parliament-codes/parliament-code-list.reducer";
import {ParliamentCode} from './../common/parliament-codes/parliament-code.interface';
import {ResidencyCodeSelectComponent} from "../common/residency-codes/component/residency-code-select.component";
import {residencyCodeListReducer, ResidencyCodeListState} from "./residency-codes/residency-code-list.reducer";
import {ResidencyCode} from './../common/residency-codes/residency-code.interface';
import {LanguageCodeListPage} from "./language-codes/language-code-list-page";
import {LanguageCodeEditorDialog} from "./language-codes/dialog/language-code-editor.dialog";
import {LanguageCodeSelectComponent} from "../common/language-codes/component/language-code-select.component";
import {languageCodeListReducer, LanguageCodeListState} from "./language-codes/language-code-list.reducer";
import {subjectCodeListReducer, SubjectCodeListState} from "./subject-codes/subject-code-list.reducer";
import {SubjectCode} from './../common/subject-codes/subject-code.interface';
import {gradeCodeListReducer, GradeCodeListState} from "./grade-codes/grade-code-list.reducer";
import {GradeCode} from './../common/grade-codes/grade-code.interface';

export interface SetupModuleState {
  title: TitleState;
  maritalCodes: MaritalCodeListState;
  bankCodes: BankCodeListState;
  graduateCenters: GraduateCenterListState;
  religionCodes: ReligionCodeListState;
  countryCodes: CountryCodeListState;
  stateCodes: StateCodeListState;
  programCodes: ProgramCodeListState;
  supervisorCodes: SupervisorCodeListState;
  raceCodes: RaceCodeListState;
  genderCodes: GenderCodeListState;
  ethnicityCodes: EthnicityCodeListState;
  nationalityCodes: NationalityCodeListState;
  facultyCodes: FacultyCodeListState;
  studyModes: StudyModeListState;
  disabilityCodes: DisabilityCodeListState;
  schoolCodes: SchoolCodeListState;
  studyCenterCodes: StudyCenterCodeListState;
  districtCodes: DistrictCodeListState;
  dunCodes: DunCodeListState;
  parliamentCodes: ParliamentCodeListState;
  residencyCodes: ResidencyCodeListState;
  languageCodes: LanguageCodeListState;
  subjectCodes: SubjectCodeListState;
  gradeCodes: GradeCodeListState;


}
;

export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    title: 'Setup Codes',
    bankCodes: <BankCode[]>[],
    graduateCenters: <GraduateCenter[]>[],
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
    schoolCodes: <SchoolCode[]>[],
    studyCenterCodes: <StudyCenterCode[]>[],
    districtCodes: <DistrictCode[]>[],
    dunCodes: <DunCode[]>[],
    parliamentCodes: <ParliamentCode[]>[],
    residencyCodes: <ResidencyCode[]>[],
    languageCodes: <LanguageCode[]>[],
    subjectCodes: <SubjectCode[]>[],
    gradeCodes: <GradeCode[]>[],

  };


export const setupModuleReducers = {
  title: titleReducer,
  bankCodes: bankCodeListReducer,
  graduateCenters: graduateCenterListReducer,
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
  studyCenterCodes: studyCenterCodeListReducer,
  districtCodes: districtCodeListReducer,
  dunCodes: dunCodeListReducer,
  parliamentCodes: parliamentCodeListReducer,
  residencyCodes: residencyCodeListReducer,
  languageCodes: languageCodeListReducer,
  subjectCodes: subjectCodeListReducer,
  gradeCodes: gradeCodeListReducer,

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
    GraduateCenterListPage,
    ReligionCodeListPage,
    MaritalCodeListPage,
    LanguageCodeListPage,
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
    StudyCenterCodeListPage,
    DistrictCodeListPage,
    DunCodeListPage,
    ParliamentCodeListPage,
    ResidencyCodeListPage,
    SubjectCodeListPage,
    GradeCodeListPage,

    // dialog
    MaritalCodeEditorDialog,
    LanguageCodeEditorDialog,
    BankCodeCreatorDialog,
    GraduateCenterCreatorDialog,
    CountryCodeCreatorDialog,
    StateCodeEditorDialog,
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
    StudyCenterCodeEditorDialog,
    DistrictCodeEditorDialog,
    DunCodeEditorDialog,
    ParliamentCodeEditorDialog,
    ResidencyCodeEditorDialog,
    SubjectCodeEditorDialog,
    GradeCodeEditorDialog,

  ],
  exports: [],
  entryComponents: [
    MaritalCodeEditorDialog,
    LanguageCodeEditorDialog,
    BankCodeCreatorDialog,
    GraduateCenterCreatorDialog,
    ReligionCodeCreatorDialog,
    CountryCodeCreatorDialog,
    StateCodeEditorDialog,
    ProgramCodeCreatorDialog,
    SupervisorCodeEditorDialog,
    GenderCodeCreatorDialog,
    EthnicityCodeCreatorDialog,
    NationalityCodeCreatorDialog,
    FacultyCodeCreatorDialog,
    StudyModeCreatorDialog,
    DisabilityCodeEditorDialog,
    SchoolCodeEditorDialog,
    StudyCenterCodeEditorDialog,
    DistrictCodeEditorDialog,
    DunCodeEditorDialog,
    ParliamentCodeEditorDialog,
    ResidencyCodeEditorDialog,
    SubjectCodeEditorDialog,
    GradeCodeEditorDialog,

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
