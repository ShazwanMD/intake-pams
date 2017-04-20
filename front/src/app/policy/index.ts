
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {PolicyPage} from "./policy.page";
import {PolicyService} from "../../services/policy.service";

export interface PolicyModuleState {
  // intakes: IntakeListState;
  // intake: IntakeState;
};

export const INITIAL_POLICY_STATE: PolicyModuleState = <PolicyModuleState>{};
export const policyModuleReducers = {
   // intakes:intakeListReducer,
   // intake:intakeReducer
 };

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    // IntakeSubModule.forRoot(),
  ],
  declarations: [
    // page
    PolicyPage,
  ],
  exports: [],
})
export class PolicyModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: PolicyModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
      ],
    };
  }
}
