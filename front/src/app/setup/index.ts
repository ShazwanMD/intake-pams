import { RaceCodeCreatorDialog } from './race-codes/dialog/race-code-creator.dialog';
import { RaceCodeListPage } from './race-codes/race-code-list.page';
import { RaceCode } from './../common/race-codes/race-code.interface';
import { SupervisorCodeCreatorDialog } from './supervisor-codes/dialog/supervisor-code-creator.dialog';
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
import { MaritalCodeCreatorDialog } from './marital-codes/dialog/marital-code-creator.dialog';
import { MaritalCodeListPage } from './marital-codes/marital-code-list-page';
import { BankCode } from './../common/bank-codes/bank-code.interface';
import { MaritalCode } from './../common/marital-codes/marital-code.interface';
import { ReligionCode } from './../common/religion-codes/religion-code.interface';
import { ReligionCodeListPage } from './religion-codes/religion-code-list.page';
import { SetupPage } from './setup.page';
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



export interface SetupModuleState {
  maritalCodes: MaritalCodeListState;
  bankCodes: BankCodeListState;
  graduateCentres: GraduateCentreListState;
  religionCodes : ReligionCodeListState;
  countryCodes : CountryCodeListState;
  stateCodes : StateCodeListState;
  programCodes : ProgramCodeListState;
  supervisorCodes : SupervisorCodeListState;
  raceCodes : RaceCodeListState;
  

};

export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    bankCodes: <BankCode[]>[],
    graduateCentres: <GraduateCentre[]>[],
    religionCodes: <ReligionCode[]>[],
    supervisorCodes: <SupervisorCode[]>[],
    programCodes: <ProgramCode[]>[],
    stateCodes: <StateCode[]>[],
    countryCodes: <CountryCode[]>[],
    raceCodes: <RaceCode[]>[],
   // maritalCodes: <BankCode[]>[],

  };


export const setupModuleReducers = {
  bankCodes: bankCodeListReducer,
  graduateCentres: graduateCentreListReducer,
  religionCodes: religionCodeListReducer,
  maritalCodes: maritalCodeListReducer,
  countryCodes: countryCodeListReducer,
  stateCodes: stateCodeListReducer,
  programCodes: programCodeListReducer,
  supervisorCodes: supervisorCodeListReducer,
  raceCodes: raceCodeListReducer,
};



@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
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

    // dialog
    BankCodeCreatorDialog,
    GraduateCentreCreatorDialog,
    MaritalCodeCreatorDialog,
    CountryCodeCreatorDialog,
    StateCodeCreatorDialog,
    ProgramCodeCreatorDialog,
    ReligionCodeCreatorDialog,
    SupervisorCodeCreatorDialog,
    RaceCodeCreatorDialog,
  ],
  exports: [],
  entryComponents: [
    BankCodeCreatorDialog,
    GraduateCentreCreatorDialog,
    ReligionCodeCreatorDialog,
    MaritalCodeCreatorDialog,
    CountryCodeCreatorDialog,
    StateCodeCreatorDialog,
    ProgramCodeCreatorDialog,
    SupervisorCodeCreatorDialog,
    RaceCodeCreatorDialog,
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