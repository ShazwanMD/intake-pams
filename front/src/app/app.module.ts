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
import {MainComponent} from './main/main.component';
import {HomePage} from './home/home.page';
import {LoginPage} from './login/login.page';
import {ForgetPasswordComponent} from './login/forget-password.page';
import {appRoutes, appRoutingProviders} from './app.routes';

import {RequestInterceptor} from '../config/interceptors/request.interceptor';

import {NgxChartsModule} from '@swimlane/ngx-charts';
import {UrlSerializer} from '@angular/router';
import {CustomUrlSerializer} from './common/custom-url-serializer';
import {
  ApplicationModule, ApplicationModuleState, INITIAL_APPLICATION_STATE,
  applicationModuleReducers,
} from './secure/applicant/application/index';
import {PolicyModule, PolicyModuleState, INITIAL_POLICY_STATE, policyModuleReducers} from './policy/index';
import {
  AdmissionModuleState, INITIAL_ADMISSION_STATE, admissionModuleReducers,
  AdmissionModule,
} from './admission/index';
import {
  RegistrationModule, registrationModuleReducers, RegistrationModuleState,
  INITIAL_REGISTRATION_STATE,
} from './registration/index';
import {centerModuleReducers, INITIAL_CENTER_STATE, CenterModuleState, CenterModule} from './center/index';
import {CommonModuleState, INITIAL_COMMON_STATE, commonModuleReducers, CommonModule} from './common/index';
import {INITIAL_SETUP_STATE, SetupModule, setupModuleReducers, SetupModuleState} from './setup/index';
import {PipeModule} from './app.pipe.module';
import {environment} from '../environments/environment';
import {AuthenticationService} from '../services/authentication.service';
import {AuthorizationService} from '../services/authorization.service';
import {SystemService} from '../services/system.service';
import {AuthenticationGuard} from './identity/guard/authentication.guard';
import {AuthorizationGuard} from './identity/guard/authorization.guard';
import {AuthorizedShowDirective} from './identity/directive/authorized-show.directive';
import {AuthenticatedShowDirective} from './identity/directive/authenticated-show.directive';
import {NotAuthenticatedShowDirective} from './identity/directive/not-authenticated-show.directive';
import {SecurePage} from './secure/secure.page';
import {ApplicantDashboardPage} from './secure/applicant/applicant-dashboard.page';
import {AdministratorDashboardPage} from './secure/administrator/administrator-dashboard.page';

// interceptor
const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

// state
interface ApplicationState {
  commonModuleState: CommonModuleState;
  policyModuleState: PolicyModuleState;
  applicationModuleState: ApplicationModuleState;
  admissionModuleState: AdmissionModuleState;
  registrationModuleState: RegistrationModuleState;
  centerModuleState: CenterModuleState;
  setupModuleState: SetupModuleState;
}
;

// initial state
export const INITIAL_APP_STATE: ApplicationState =
  <ApplicationState>{
    commonModuleState: INITIAL_COMMON_STATE,
    policyModuleState: INITIAL_POLICY_STATE,
    applicationModuleState: INITIAL_APPLICATION_STATE,
    admissionModuleState: INITIAL_ADMISSION_STATE,
    registrationModuleState: INITIAL_REGISTRATION_STATE,
    centerModuleState: INITIAL_CENTER_STATE,
    setupModuleState: INITIAL_SETUP_STATE,
  };

// combine reducer
export const applicationReducers = {
  commonModuleState: combineReducers({...commonModuleReducers}),
  policyModuleState: combineReducers({...policyModuleReducers}),
  applicationModuleState: combineReducers({...applicationModuleReducers}),
  admissionModuleState: combineReducers({...admissionModuleReducers}),
  registrationModuleState: combineReducers({...registrationModuleReducers}),
  centerModuleState: combineReducers({...centerModuleReducers}),
  setupModuleState: combineReducers({...setupModuleReducers}),
};
export const productionReducer: ActionReducer<ApplicationState> = combineReducers(applicationReducers);
export function applicationReducer(applicationState: any = INITIAL_APP_STATE, action: any) {
  return productionReducer(applicationState, action);
}

@NgModule({

  declarations: [
    AppComponent,
    MainComponent,
    LoginPage,
    HomePage,
    SecurePage,
    AdministratorDashboardPage,
    ApplicantDashboardPage,
    ForgetPasswordComponent,
    AuthorizedShowDirective,
    AuthenticatedShowDirective,
    NotAuthenticatedShowDirective,
  ], // directives, components, and pipes owned by this NgModule
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
    StoreModule.provideStore(applicationReducer),
    environment.imports,

    PipeModule,

    // DashboardModule.forRoot(),
    CommonModule.forRoot(),
    CenterModule.forRoot(),
    PolicyModule.forRoot(),
    ApplicationModule.forRoot(),
    AdmissionModule.forRoot(),
    RegistrationModule.forRoot(),
    SetupModule.forRoot(),
  ],
  providers: [
    appRoutingProviders,
    httpInterceptorProviders,
    AuthenticationService,
    AuthorizationService,
    SystemService,
    AuthenticationGuard,
    AuthorizationGuard,
    Title,
    {provide: UrlSerializer, useClass: CustomUrlSerializer},
  ], // additional providers needed for this module
  entryComponents: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
