import {NgModule, Type} from '@angular/core';
import {BrowserModule, Title}  from '@angular/platform-browser';

import {CovalentCoreModule} from '@covalent/core';
import {CovalentExpansionPanelModule} from '@covalent/core';
import {CovalentHttpModule, IHttpInterceptor} from '@covalent/http';
import {CovalentHighlightModule} from '@covalent/highlight';
import {CovalentMarkdownModule} from '@covalent/markdown';
import {CovalentChartsModule} from '@covalent/charts';
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {StoreModule, combineReducers, ActionReducer} from "@ngrx/store";

import {AppComponent} from './app.component';
import {MainComponent} from './main/main.component';
import {DashboardPage} from './dashboard/dashboard.page';
import {LoginComponent} from './login/login.component';
import {ForgetPasswordComponent} from './login/forget-password.component';
import {appRoutes, appRoutingProviders} from './app.routes';

import {RequestInterceptor} from '../config/interceptors/request.interceptor';

import {NgxChartsModule} from '@swimlane/ngx-charts';
import {UrlSerializer} from "@angular/router";
import {CustomUrlSerializer} from "./common/custom-url-serializer";
import {
  ApplicationModule, ApplicationModuleState, INITIAL_APPLICATION_STATE,
  applicationModuleReducers
} from "./application/index";
import {PolicyModule, PolicyModuleState, INITIAL_POLICY_STATE, policyModuleReducers} from "./policy/index";
import {
  AdmissionModuleState, INITIAL_ADMISSION_STATE, admissionModuleReducers,
  AdmissionModule
} from "./admission/index";
import {
  RegistrationModule, registrationModuleReducers, RegistrationModuleState,
  INITIAL_REGISTRATION_STATE
} from "./registration/index";
import {centreModuleReducers, INITIAL_CENTRE_STATE, CentreModuleState, CentreModule} from "./centre/index";
import {DashboardModule} from "./dashboard/index";
import {CommonModuleState, INITIAL_COMMON_STATE, commonModuleReducers, CommonModule} from "./common/index";
import { intakeTaskListReducer } from "./policy/intakes/intake-task-list.reducer";
import {SetupModule} from "./setup/index";


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
  centreModuleState: CentreModuleState;
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
    centreModuleState: INITIAL_CENTRE_STATE,
  };

// combine reducer
export const applicationReducers = {
  commonModuleState: combineReducers({...commonModuleReducers,}),
  policyModuleState: combineReducers({...policyModuleReducers}),
  applicationModuleState: combineReducers({...applicationModuleReducers}),
  admissionModuleState: combineReducers({...admissionModuleReducers,}),
  registrationModuleState: combineReducers({...registrationModuleReducers,}),
  centreModuleState: combineReducers({...centreModuleReducers}),
};
export const productionReducer: ActionReducer<ApplicationState> = combineReducers(applicationReducers);
export function applicationReducer(applicationState: any = INITIAL_APP_STATE, action: any) {
  return productionReducer(applicationState, action);
}


@NgModule({

  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    ForgetPasswordComponent,
  ], // directives, components, and pipes owned by this NgModule

  imports: [
    appRoutes,
    BrowserModule,
    CovalentExpansionPanelModule,
    CovalentCoreModule.forRoot(),
    CovalentChartsModule.forRoot(),
    CovalentHttpModule.forRoot({
      interceptors: [{
        interceptor: RequestInterceptor, paths: ['**'],
      }],
    }),
    CovalentHighlightModule.forRoot(),
    CovalentMarkdownModule.forRoot(),
    NgxChartsModule,

    StoreModule.provideStore(applicationReducer),
    StoreDevtoolsModule.instrumentOnlyWithExtension(),
    DashboardModule.forRoot(),
    CommonModule.forRoot(),
    CentreModule.forRoot(),
    PolicyModule.forRoot(),
    ApplicationModule.forRoot(),
    AdmissionModule.forRoot(),
    RegistrationModule.forRoot(),
    SetupModule.forRoot(),
  ], // modules needed to run this module
  providers: [
    appRoutingProviders,
    httpInterceptorProviders,
    Title,
    {provide: UrlSerializer, useClass: CustomUrlSerializer}
  ], // additional providers needed for this module
  entryComponents: [],
  bootstrap: [AppComponent],
})
export class AppModule {

}
