import {EthnicityCodeSelectComponent} from './ethnicity-codes/component/ethnicity-code-select.component';
import {NationalityCodeSelectComponent} from './nationality-codes/component/nationality-code-select.component';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {EffectsModule} from "@ngrx/effects";
import {CommonEffects} from "./common.effect";
import {CommonActions} from "./common.action";
import {ProgramCodeListState, programCodeListReducer} from "./program-codes/program-code-list.reducer";
import {StudyModeListState, studyModeListReducer} from "./study-modes/study-mode-list.reducer";
import {FacultyCodeListState, facultyCodeListReducer} from "./faculty-codes/faculty-code-list.reducer";
import {SupervisorCodeListState, supervisorCodeListReducer} from "./supervisor-codes/supervisor-code-list.reducer";
import {GraduateCentreListState, graduateCentreListReducer} from "./graduate-centres/graduate-centre-list.reducer";
import {GraduateCentreSelectComponent} from "./graduate-centres/component/graduate-centre-select.component";
import {ProgramCodeSelectComponent} from "./program-codes/component/program-code-select.component";
import {StudyModeSelectComponent} from "./study-modes/component/study-mode-select.component";
import {FacultyCodeSelectComponent} from "./faculty-codes/component/faculty-code-select.component";
import {GenderCodeSelectComponent} from "./gender-codes/component/gender-code-select.component";
import {GenderCodeListState, genderCodeListReducer} from "./gender-codes/gender-code-list.reducer";
import {maritalCodeListReducer, MaritalCodeListState} from "./marital-codes/marital-code-list.reducer";
import {MaritalCodeSelectComponent} from "./marital-codes/component/marital-code-select.component";
import {BankCodeSelectComponent} from "./bank-codes/component/bank-code-select.component";
import {BankCodeListState, bankCodeListReducer} from "./bank-codes/bank-code-list.reducer";
import {SupervisorCodeSelectComponent} from "./supervisor-codes/component/supervisor-code-select.component";
import {RaceCodeListState, raceCodeListReducer} from "./race-codes/race-code-list.reducer";
import {RaceCodeSelectComponent} from './race-codes/component/race-code-select.component';
import {StateCodeSelectComponent} from './state-codes/component/state-code-select.component';
import {StateCodeListState, stateCodeListReducer} from "./state-codes/state-code-list.reducer";
import {CountryCodeListState, countryCodeListReducer} from "./country-codes/country-code-list.reducer";
import {CountryCodeSelectComponent} from "./country-codes/component/country-code-select.component";
import {ReligionCodeListState, religionCodeListReducer} from "./religion-codes/religion-code-list.reducer";
import {ReligionCodeSelectComponent} from "./religion-codes/component/religion-code-select.component";
import {disabilityCodeListReducer, DisabilityCodeListState} from "./disability-codes/disability-code-list.reducer";
import {DisabilityCodeSelectComponent} from "./disability-codes/component/disability-code-select.component";
import {SchoolCodeSelectComponent} from "./school-codes/component/school-code-select.component";
import {schoolCodeListReducer, SchoolCodeListState} from "./school-codes/school-code-list.reducer";
import {StudyCenterCodeListState, studyCenterCodeListReducer} from "./study-center-codes/study-center-code-list.reducer";
import {StudyCenterCodeSelectComponent} from "./study-center-codes/component/study-center-code-select.component";
import {EthnicityCodeListState, ethnicityCodeListReducer} from "./ethnicity-codes/ethnicity-code-list.reducer";
import {NationalityCodeListState, nationalityCodeListReducer} from "./nationality-codes/nationality-code-list.reducer";
import {residencyCodeListReducer, ResidencyCodeListState} from "./residency-codes/residency-code-list.reducer";
import {ResidencyCodeSelectComponent} from "./residency-codes/component/residency-code-select.component";


export interface CommonModuleState {
  programCodes: ProgramCodeListState;
  studyModes: StudyModeListState;
  supervisorCodes: SupervisorCodeListState;
  graduateCentres: GraduateCentreListState;
  facultyCodes: FacultyCodeListState;
  genderCodes: GenderCodeListState;
  maritalCodes: MaritalCodeListState;
  bankCodes: BankCodeListState;
  raceCodes: RaceCodeListState;
  stateCodes: StateCodeListState;
  countryCodes: CountryCodeListState;
  disabilityCodes: DisabilityCodeListState;
  schoolCodes: SchoolCodeListState;
  studyCenterCodes: StudyCenterCodeListState;
  religionCodes: ReligionCodeListState;
  ethnicityCodes: EthnicityCodeListState;
  nationalityCodes: NationalityCodeListState;
  residencyCodes: ResidencyCodeListState;
}
;

export const INITIAL_COMMON_STATE: CommonModuleState = <CommonModuleState>{};
export const commonModuleReducers = {
  programCodes: programCodeListReducer,
  studyModes: studyModeListReducer,
  supervisorCodes: supervisorCodeListReducer,
  graduateCentres: graduateCentreListReducer,
  facultyCodes: facultyCodeListReducer,
  genderCodes: genderCodeListReducer,
  maritalCodes: maritalCodeListReducer,
  bankCodes: bankCodeListReducer,
  raceCodes: raceCodeListReducer,
  stateCodes: stateCodeListReducer,
  countryCodes: countryCodeListReducer,
  disabilityCodes: disabilityCodeListReducer,
  schoolCodes: schoolCodeListReducer,
  studyCenterCodes: studyCenterCodeListReducer,
  religionCodes: religionCodeListReducer,
  ethnicityCodes: ethnicityCodeListReducer,
  nationalityCodes: nationalityCodeListReducer,
  residencyCodes: residencyCodeListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(CommonEffects),
  ],
  declarations: [
    GraduateCentreSelectComponent,
    ProgramCodeSelectComponent,
    StudyModeSelectComponent,
    FacultyCodeSelectComponent,
    GenderCodeSelectComponent,
    MaritalCodeSelectComponent,
    BankCodeSelectComponent,
    SupervisorCodeSelectComponent,
    RaceCodeSelectComponent,
    StateCodeSelectComponent,
    CountryCodeSelectComponent,
    DisabilityCodeSelectComponent,
    SchoolCodeSelectComponent,
    StudyCenterCodeSelectComponent,
    ReligionCodeSelectComponent,
    EthnicityCodeSelectComponent,
    NationalityCodeSelectComponent,
    ResidencyCodeSelectComponent,


  ],
  exports: [
    GraduateCentreSelectComponent,
    ProgramCodeSelectComponent,
    StudyModeSelectComponent,
    FacultyCodeSelectComponent,
    GenderCodeSelectComponent,
    MaritalCodeSelectComponent,
    BankCodeSelectComponent,
    SupervisorCodeSelectComponent,
    RaceCodeSelectComponent,
    StateCodeSelectComponent,
    CountryCodeSelectComponent,
    DisabilityCodeSelectComponent,
    SchoolCodeSelectComponent,
    StudyCenterCodeSelectComponent,
    ReligionCodeSelectComponent,
    EthnicityCodeSelectComponent,
    NationalityCodeSelectComponent,
    ResidencyCodeSelectComponent,

  ],
})
export class CommonModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CommonModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        CommonActions,
      ],
    };
  }
}
