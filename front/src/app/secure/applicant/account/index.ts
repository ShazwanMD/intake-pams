import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../../../services';
import {IdentityService} from '../../../../services';
import {ApplicationService} from '../../../../services/application.service';
import {PolicyService} from '../../../../services/policy.service';
import {IntakeApplicationSubModule} from '../application/intake-applications/index';
import {CommonModule} from '../../../common/index';
import {ProgramLevelSubModule} from '../../../policy/program-levels/index';
import {CpsIntakeApplicationSubModule} from '../application/intake-applications/cps/index';
import {ApplicationPage} from '../application/application.page';
import {IntakeListState} from '../application/intake-applications/intake-list.reducer';
import {IntakeApplicationListState} from '../application/intake-applications/intake-application-list.reducer';
import {openIntakeListReducer} from './intake-list.reducer';
import {IntakeApplicationState} from '../application/intake-applications/intake-application.reducer';
import {
  draftedIntakeApplicationListReducer,
  submittedIntakeApplicationListReducer,
} from './intake-application-list.reducer';

export interface AccountModuleState {
  openIntakes: IntakeListState;
  submittedIntakeApplications: IntakeApplicationListState;
  draftedIntakeApplication: IntakeApplicationState;
}
;

export const INITIAL_ACCOUNT_STATE: AccountModuleState = <AccountModuleState>{
  openIntakes: [],
  submittedIntakeApplications: [],
  draftedIntakeApplications: [],

};

export const accountModuleReducers = {
  openIntakes: openIntakeListReducer,
  draftedIntakeApplication: draftedIntakeApplicationListReducer,
  submittedIntakeApplications: submittedIntakeApplicationListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    IntakeApplicationSubModule.forRoot(),
    CommonModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    CpsIntakeApplicationSubModule.forRoot(),
  ],
  declarations: [
    // page
    ApplicationPage,
  ],
  exports: [],

  entryComponents: [],
})
export class AccountModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AccountModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        ApplicationService,
      ],
    };
  }
}
