import {NgModule, Type} from '@angular/core';
import {BrowserModule, Title}  from '@angular/platform-browser';

import {CovalentCoreModule, CovalentFileModule} from '@covalent/core';
import {CovalentExpansionPanelModule} from '@covalent/core';
import {CovalentHttpModule, IHttpInterceptor} from '@covalent/http';
import {CovalentHighlightModule} from '@covalent/highlight';
import {CovalentMarkdownModule} from '@covalent/markdown';
import {CovalentChartsModule} from '@covalent/charts';
import {StoreModule, combineReducers, ActionReducer} from '@ngrx/store';

import {AppComponent} from './app.component';
import {HomePage} from './home/home.page';
import {LoginPage} from './login/login.page';
import {ForgetPasswordPage} from './login/forget-password.page';
import {appRoutes, appRoutingProviders} from './app.routes';

import {RequestInterceptor} from '../config/interceptors/request.interceptor';

import {EffectsModule} from '@ngrx/effects';
import {NgxChartsModule} from '@swimlane/ngx-charts';
import {
  ApplicationModule, ApplicationModuleState, INITIAL_APPLICATION_STATE,
  applicationModuleReducers,
} from './secure/applicant/application/index';
import {
  PolicyModule,
  PolicyModuleState,
  INITIAL_POLICY_STATE,
  policyModuleReducers,
} from './secure/administrator/policy/index';
import {
  AdmissionModuleState, INITIAL_ADMISSION_STATE, admissionModuleReducers,
  AdmissionModule,
} from './secure/administrator/admission/index';
import {
  RegistrationModule, registrationModuleReducers, RegistrationModuleState,
  INITIAL_REGISTRATION_STATE,
} from './registration/index';
import {centerModuleReducers, INITIAL_CENTER_STATE, CenterModuleState, CenterModule} from './center/index';
import {CommonModuleState, INITIAL_COMMON_STATE, commonModuleReducers, CommonModule} from './common/index';
import {PipeModule} from './app.pipe.module';
import {environment} from '../environments/environment';
import {AuthenticationService} from '../services/authentication.service';
import {AuthorizationService} from '../services/authorization.service';
import {SystemService} from '../services/system.service';
import {AuthenticationGuard} from './secure/administrator/identity/guard/authentication.guard';
import {AuthorizationGuard} from './secure/administrator/identity/guard/authorization.guard';
import {AuthorizedShowDirective} from './secure/administrator/identity/directive/authorized-show.directive';
import {AuthenticatedShowDirective} from './secure/administrator/identity/directive/authenticated-show.directive';
import {NotAuthenticatedShowDirective} from './secure/administrator/identity/directive/not-authenticated-show.directive';
import {SecurePage} from './secure/secure.page';
import {AccountService} from '../services/account.service';
import {
  AccountModule, accountModuleReducers, AccountModuleState,
  INITIAL_ACCOUNT_STATE,
} from './secure/applicant/account/index';
import {
  applicationContextReducer, ApplicationContextState,
  INITIAL_APPLICATION_CONTEXT_STATE,
} from './application-context.reducer';
import {ApplicationContextActions} from './application-context.action';
import {ApplicationContextEffects} from './application-context.effect';
import {DashboardPage} from './secure/dashboard.page';
import {ApplicantDashboardPanel} from './secure/applicant-dashboard.panel';
import {AdministratorDashboardPanel} from './secure/administrator-dashboard.panel';
import {SetupModule} from "./secure/administrator/setup/index";

// interceptor
const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

// state
export interface ApplicationState {
  applicationContextState: ApplicationContextState;
  commonModuleState: CommonModuleState;
  policyModuleState: PolicyModuleState;
  applicationModuleState: ApplicationModuleState;
  admissionModuleState: AdmissionModuleState;
  registrationModuleState: RegistrationModuleState;
  centerModuleState: CenterModuleState;
  accountModuleState: AccountModuleState;
}

// initial state
export const INITIAL_APP_STATE: ApplicationState =
  <ApplicationState>{
    applicationContextState: INITIAL_APPLICATION_CONTEXT_STATE,
    commonModuleState: INITIAL_COMMON_STATE,
    policyModuleState: INITIAL_POLICY_STATE,
    applicationModuleState: INITIAL_APPLICATION_STATE,
    admissionModuleState: INITIAL_ADMISSION_STATE,
    registrationModuleState: INITIAL_REGISTRATION_STATE,
    centerModuleState: INITIAL_CENTER_STATE,
    accountModuleState: INITIAL_ACCOUNT_STATE,
  };

// combine reducer
export const applicationReducers = {
  applicationContextState: applicationContextReducer,
  commonModuleState: combineReducers({...commonModuleReducers}),
  policyModuleState: combineReducers({...policyModuleReducers}),
  applicationModuleState: combineReducers({...applicationModuleReducers}),
  admissionModuleState: combineReducers({...admissionModuleReducers}),
  registrationModuleState: combineReducers({...registrationModuleReducers}),
  centerModuleState: combineReducers({...centerModuleReducers}),
  accountModuleState: combineReducers({...accountModuleReducers}),
};
export const productionReducer: ActionReducer<ApplicationState> = combineReducers(applicationReducers);
export function applicationReducer(applicationState: any = INITIAL_APP_STATE, action: any) {
  return productionReducer(applicationState, action);
}

@NgModule({
  declarations: [
    AppComponent,
    LoginPage,
    HomePage,
    SecurePage,
    DashboardPage,
    ForgetPasswordPage,
    ApplicantDashboardPanel,
    AdministratorDashboardPanel,
    AuthorizedShowDirective,
    AuthenticatedShowDirective,
    NotAuthenticatedShowDirective,
  ],
  exports: [
    AuthorizedShowDirective,
    AuthenticatedShowDirective,
    NotAuthenticatedShowDirective,
  ],
  imports: [
    appRoutes,
    BrowserModule,
    CovalentExpansionPanelModule,
    CovalentCoreModule.forRoot(),
    CovalentChartsModule.forRoot(),
    CovalentFileModule.forRoot(),
    CovalentHttpModule.forRoot({
      interceptors: [{
        interceptor: RequestInterceptor, paths: ['**'],
      }],
    }),
    CovalentHighlightModule.forRoot(),
    CovalentMarkdownModule.forRoot(),
    NgxChartsModule,
    EffectsModule.run(ApplicationContextEffects),
    StoreModule.provideStore(applicationReducer),
    environment.imports,

    PipeModule,

    CommonModule.forRoot(),
    CenterModule.forRoot(),
    PolicyModule.forRoot(),
    ApplicationModule.forRoot(),
    AdmissionModule.forRoot(),
    RegistrationModule.forRoot(),
    SetupModule.forRoot(),
    AccountModule.forRoot(),
  ],
  entryComponents: [
    ApplicantDashboardPanel,
    AdministratorDashboardPanel,
  ],
  providers: [
    appRoutingProviders,
    httpInterceptorProviders,
    AuthenticationService,
    AuthorizationService,
    AccountService,
    SystemService,
    AuthenticationGuard,
    AuthorizationGuard,
    Title,
    ApplicationContextActions,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
