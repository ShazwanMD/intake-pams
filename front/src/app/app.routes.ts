import {Routes, RouterModule} from '@angular/router';

import {MainComponent} from './main/main.component';
import {LoginComponent} from './login/login.component';
import {RegistrationModuleRoutes} from './registration/registration-module.routes';
import {PolicyModuleRoutes} from './policy/policy-module.routes';
import {AdmissionModuleRoutes} from './admission/admission-module.routes';
import {CenterModuleRoutes} from './center/center-module.routes';
import {ForgetPasswordComponent} from './login/forget-password.component';
import {dashboardModuleRoutes} from './dashboard/dashboard-module.routes';
import {applicationModuleRoutes} from './application/application-module.routes';
import {setupModuleRoutes} from './setup/setup-module.routes';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'forget-password', component: ForgetPasswordComponent},
  {
    path: '', component: MainComponent,
    children: [
      ...dashboardModuleRoutes,
      ...RegistrationModuleRoutes,
      ...PolicyModuleRoutes,
      ...AdmissionModuleRoutes,
      ...CenterModuleRoutes,
      ...applicationModuleRoutes,
      ...setupModuleRoutes,
    ],
  },
];

export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: false});
