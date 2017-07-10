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
import {IntakeListState} from '../application/intake-applications/intake-list.reducer';
import {IntakeApplicationListState} from '../application/intake-applications/intake-application-list.reducer';
import {publishedIntakeListReducer} from './intake-list.reducer';
import {
  draftedIntakeApplicationListReducer,
  submittedIntakeApplicationListReducer,
} from './intake-application-list.reducer';
import {Intake} from '../../../shared/model/policy/intake.interface';
import {IntakeApplication} from '../../../shared/model/application/intake-application.interface';
import {AccountActions} from './account.action';
import {AccountEffects} from './account.effect';
import {EffectsModule} from '@ngrx/effects';

export interface AccountModuleState {
  publishedIntakes: IntakeListState;
  draftedIntakeApplications: IntakeApplicationListState;
  submittedIntakeApplications: IntakeApplicationListState;
}

export const INITIAL_ACCOUNT_STATE: AccountModuleState = <AccountModuleState>{
  publishedIntakes: <Intake[]>[],
  draftedIntakeApplications: <IntakeApplication[]>[],
  submittedIntakeApplications: <IntakeApplication[]>[],

};

export const accountModuleReducers = {
  publishedIntakes: publishedIntakeListReducer,
  draftedIntakeApplications: draftedIntakeApplicationListReducer,
  submittedIntakeApplications: submittedIntakeApplicationListReducer,
};

@NgModule({
  imports: [
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    IntakeApplicationSubModule.forRoot(),
    CommonModule.forRoot(),
    EffectsModule.run(AccountEffects),
  ],
  declarations: [
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
        AccountActions,
      ],
    };
  }
}