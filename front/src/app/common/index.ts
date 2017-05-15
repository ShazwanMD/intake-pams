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
import { maritalCodeListReducer, MaritalCodeListState } from "./marital-codes/marital-code-list.reducer";
import { MaritalCodeSelectComponent } from "./marital-codes/component/marital-code-select.component";
import {BankCodeSelectComponent} from "./bank-codes/component/bank-code-select.component";
import {BankCodeListState, bankCodeListReducer} from "./bank-codes/bank-code-list.reducer";
import { SupervisorCodeSelectComponent } from "./supervisor-codes/component/supervisor-code-select.component";
import {RaceCodeListState, raceCodeListReducer} from "./race-codes/race-code-list.reducer";
import { RaceCodeSelectComponent } from './race-codes/component/race-code-select.component';
import { StateCodeSelectComponent } from './state-codes/component/state-code-select.component';
import { StateCodeListState, stateCodeListReducer } from "./state-codes/state-code-list.reducer";
import { CountryCodeListState, countryCodeListReducer } from "./country-codes/country-code-list.reducer";
import { CountryCodeSelectComponent } from "./country-codes/component/country-code-select.component";
<<<<<<< HEAD
import { ReligionCodeListState, religionCodeListReducer } from "./religion-codes/religion-code-list.reducer";
import { ReligionCodeSelectComponent } from "./religion-codes/component/religion-code-select.component";
=======
import { disabilityCodeListReducer, DisabilityCodeListState } from "./disability-codes/disability-code-list.reducer";
import { DisabilityCodeSelectComponent } from "./disability-codes/component/disability-code-select.component";
>>>>>>> 544e99605ab47d215a0a557b2048b16fba865040

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
  stateCodes : StateCodeListState;
  countryCodes : CountryCodeListState;
<<<<<<< HEAD
  religionCodes : ReligionCodeListState;
=======
  disabilityCodes: DisabilityCodeListState;
>>>>>>> 544e99605ab47d215a0a557b2048b16fba865040
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
  stateCodes : stateCodeListReducer,
  countryCodes : countryCodeListReducer,
<<<<<<< HEAD
  religionCodes : religionCodeListReducer,
=======
  disabilityCodes: disabilityCodeListReducer,
>>>>>>> 544e99605ab47d215a0a557b2048b16fba865040
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
<<<<<<< HEAD
    ReligionCodeSelectComponent,
=======
    DisabilityCodeSelectComponent,
>>>>>>> 544e99605ab47d215a0a557b2048b16fba865040

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
<<<<<<< HEAD
    ReligionCodeSelectComponent,
=======
    DisabilityCodeSelectComponent,
>>>>>>> 544e99605ab47d215a0a557b2048b16fba865040

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
