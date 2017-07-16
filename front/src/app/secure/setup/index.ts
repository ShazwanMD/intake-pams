import {GradeCodeListPage} from './grade-codes/grade-code-list-page';
import {SubjectCodeEditorDialog} from './subject-codes/dialog/subject-code-editor.dialog';
import {SubjectCodeListPage} from './subject-codes/subject-code-list-page';
import {LanguageCode} from '../../shared/model/common/language-code.interface';
import {ResidencyCodeEditorDialog} from './residency-codes/dialog/residency-code-editor.dialog';
import {ResidencyCodeListPage} from './residency-codes/residency-code-list-page';
import {StateCodeEditorDialog} from './state-codes/dialog/state-code-editor.dialog';
import {DistrictCodeEditorDialog} from './district-codes/dialog/district-code-editor.dialog';
import {DistrictCodeListPage} from './district-codes/district-code-list-page';
import {DunCodeEditorDialog} from './dun-codes/dialog/dun-code-editor.dialog';
import {DunCodeListPage} from './dun-codes/dun-code-list-page';
import {GradeCodeEditorDialog} from './grade-codes/dialog/grade-code-editor.dialog';
import {ParliamentCodeEditorDialog} from './parliament-codes/dialog/parliament-code-editor.dialog';
import {ParliamentCodeListPage} from './parliament-codes/parliament-code-list-page';
import {StudyCenterCodeEditorDialog} from './study-center-codes/dialog/study-center-code-editor.dialog';
import {StudyCenterCode} from '../../shared/model/common/study-center-code.interface';
import {StudyCenterCodeListPage} from './study-center-codes/study-center-code-list.page';
import {SchoolCodeEditorDialog} from './school-codes/dialog/school-code-editor.dialog';
import {SchoolCodeListPage} from './school-codes/school-code-list-page';
import {DisabilityCode} from '../../shared/model/common/disability-code.interface';
import {DisabilityCodeEditorDialog} from './disability-codes/dialog/disability-code-editor.dialog';
import {ProgramLevelSubModule} from '../policy/program-levels/index';
import {SupervisorCodeEditorDialog} from './supervisor-codes/dialog/supervisor-code-editor.dialog';
import {StudyMode} from '../../shared/model/common/study-mode.interface';
import {StudyModeListPage} from './study-modes/study-mode-list.page';
import {StudyModeCreatorDialog} from './study-modes/dialog/study-mode-creator.dialog';
import {FacultyCodeCreatorDialog} from './faculty-codes/dialog/faculty-code-creator.dialog';
import {FacultyCodeListPage} from './faculty-codes/faculty-code-list.page';
import {NationalityCodeCreatorDialog} from './nationality-codes/dialog/nationality-code-creator.dialog';
import {NationalityCodeListPage} from './nationality-codes/nationality-code-list.page';
import {EthnicityCodeCreatorDialog} from './ethnicity-codes/dialog/ethnicity-code-creator.dialog';
import {EthnicityCodeListPage} from './ethnicity-codes/ethnicity-code-list.page';
import {GenderCodeCreatorDialog} from './gender-codes/dialog/gender-code-creator.dialog';
import {GenderCodeListPage} from './gender-codes/gender-code-list.page';
import {RaceCodeCreatorDialog} from './race-codes/dialog/race-code-creator.dialog';
import {RaceCodeListPage} from './race-codes/race-code-list.page';
import {SupervisorCodeListPage} from './supervisor-codes/supervisor-code-list.page';
import {ReligionCodeCreatorDialog} from './religion-codes/dialog/religion-code-creator.dialog';
import {ProgramCodeCreatorDialog} from './program-codes/dialog/program-code-creator.dialog';
import {ProgramCodeListPage} from './program-codes/program-code-list.page';
import {StateCodeListPage} from './state-codes/state-code-list.page';
import {CountryCodeCreatorDialog} from './country-codes/dialog/country-code-creator.dialog';
import {CountryCodeListPage} from './country-codes/country-code-list.page';
import {MaritalCodeListPage} from './marital-codes/marital-code-list-page';
import {SetupPage} from './setup.page';
import {DisabilityCodeListPage} from './disability-codes/disability-code-list-page';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {CovalentCoreModule} from '@covalent/core';
import {bankCodeListReducer, BankCodeListState} from './bank-codes/bank-code-list.reducer';
import {maritalCodeListReducer, MaritalCodeListState} from './marital-codes/marital-code-list.reducer';
import {religionCodeListReducer, ReligionCodeListState} from './religion-codes/religion-code-list.reducer';
import {SetupEffects} from './setup.effect';
import {EffectsModule} from '@ngrx/effects';
import {BankCodeListPage} from './bank-codes/bank-code-list.page';
import {SetupActions} from './setup.action';
import {graduateCenterListReducer, GraduateCenterListState} from './graduate-centers/graduate-center-list.reducer';
import {GraduateCenterListPage} from './graduate-centers/graduate-center-list.page';
import {GraduateCenterCreatorDialog} from './graduate-centers/dialog/graduate-center-creator.dialog';
import {BankCodeCreatorDialog} from './bank-codes/dialog/bank-code-creator.dialog';
import {countryCodeListReducer, CountryCodeListState} from './country-codes/country-code-list.reducer';
import {stateCodeListReducer, StateCodeListState} from './state-codes/state-code-list.reducer';
import {programCodeListReducer, ProgramCodeListState} from './program-codes/program-code-list.reducer';
import {supervisorCodeListReducer, SupervisorCodeListState} from './supervisor-codes/supervisor-code-list.reducer';
import {raceCodeListReducer, RaceCodeListState} from './race-codes/race-code-list.reducer';
import {genderCodeListReducer, GenderCodeListState} from './gender-codes/gender-code-list.reducer';
import {ethnicityCodeListReducer, EthnicityCodeListState} from './ethnicity-codes/ethnicity-code-list.reducer';
import {nationalityCodeListReducer, NationalityCodeListState} from './nationality-codes/nationality-code-list.reducer';
import {facultyCodeListReducer, FacultyCodeListState} from './faculty-codes/faculty-code-list.reducer';
import {studyModeListReducer, StudyModeListState} from './study-modes/study-mode-list.reducer';
import {titleReducer, TitleState} from './title.reducer';
import {MaritalCodeEditorDialog} from './marital-codes/dialog/marital-code-editor.dialog';
import {disabilityCodeListReducer, DisabilityCodeListState} from './disability-codes/disability-code-list.reducer';
import {schoolCodeListReducer, SchoolCodeListState} from './school-codes/school-code-list.reducer';
import {
  studyCenterCodeListReducer,
  StudyCenterCodeListState,
} from './study-center-codes/study-center-code-list.reducer';
import {districtCodeListReducer, DistrictCodeListState} from './district-codes/district-code-list.reducer';
import {dunCodeListReducer, DunCodeListState} from './dun-codes/dun-code-list.reducer';
import {parliamentCodeListReducer, ParliamentCodeListState} from './parliament-codes/parliament-code-list.reducer';
import {residencyCodeListReducer, ResidencyCodeListState} from './residency-codes/residency-code-list.reducer';
import {LanguageCodeListPage} from './language-codes/language-code-list-page';
import {LanguageCodeEditorDialog} from './language-codes/dialog/language-code-editor.dialog';
import {languageCodeListReducer, LanguageCodeListState} from './language-codes/language-code-list.reducer';
import {subjectCodeListReducer, SubjectCodeListState} from './subject-codes/subject-code-list.reducer';
import {gradeCodeListReducer, GradeCodeListState} from './grade-codes/grade-code-list.reducer';
import {ResidencyCode} from '../../shared/model/common/residency-code.interface';
import {ParliamentCode} from '../../shared/model/common/parliament-code.interface';
import {DunCode} from '../../shared/model/common/dun-code.interface';
import {SubjectCode} from '../../shared/model/common/subject-code.interface';
import {DistrictCode} from '../../shared/model/common/district-code.interface';
import {GradeCode} from '../../shared/model/common/grade-code.interface';
import {SchoolCode} from '../../shared/model/common/school-code.interface';
import {FacultyCode} from '../../shared/model/common/faculty-code.interface';
import {NationalityCode} from '../../shared/model/common/nationality-code.interface';
import {EthnicityCode} from '../../shared/model/common/ethnicity-code.interface';
import {MaritalCode} from '../../shared/model/common/marital-code.interface';
import {GenderCode} from '../../shared/model/common/gender-code.interface';
import {RaceCode} from '../../shared/model/common/race-code.interface';
import {CountryCode} from '../../shared/model/common/country-code.interface';
import {BankCode} from '../../shared/model/common/bank-code.interface';
import {GraduateCenter} from '../../shared/model/common/graduate-center.interface';
import {ReligionCode} from '../../shared/model/common/religion-code.interface';
import {SupervisorCode} from '../../shared/model/common/supervisor-code.interface';
import {ProgramCode} from '../../shared/model/common/program-code.interface';
import {StateCode} from '../../shared/model/common/state-code.interface';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {ReligionCodeListPage} from './religion-codes/religion-code-list.page';
import {CommonModule} from '../../common/index';
import {IntakeSessionSubModule} from '../policy/intake-sessions/index';

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

};

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
  exports: [
  ],
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
        SetupActions,
      ],
    };
  }
}
