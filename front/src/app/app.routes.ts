import {Routes, RouterModule} from '@angular/router';

import {LoginPage} from './login/login.page';
import {HomePage} from './home/home.page';
import {registrationModuleRoutes} from './registration/registration-module.routes';
import {policyModuleRoutes} from './policy/policy-module.routes';
import {admissionModuleRoutes} from './admission/admission-module.routes';
import {centerModuleRoutes} from './center/center-module.routes';
import {ForgetPasswordComponent} from './login/forget-password.page';
import {applicationModuleRoutes} from './application/application-module.routes';
import {setupModuleRoutes} from './setup/setup-module.routes';
import {SecurePage} from './secure/secure.page';
import {ApplicantDashboardPage} from './secure/applicant/applicant-dashboard.page';
import {AdministratorDashboardPage} from './secure/administrator/administrator-dashboard.page';
import {AuthenticationGuard} from './identity/guard/authentication.guard';

const routes: Routes = [
  {path: 'login', component: LoginPage},
  {path: 'forget-password', component: ForgetPasswordComponent},
  ...registrationModuleRoutes,
  {
    path: '', component: HomePage,
  },
  {
    path: 'secure', component: SecurePage, canActivate: [AuthenticationGuard],
    children: [
      {
        path: 'administrator', component: AdministratorDashboardPage,
        children: [
          ...registrationModuleRoutes,
          ...policyModuleRoutes,
          ...admissionModuleRoutes,
          ...centerModuleRoutes,
          ...applicationModuleRoutes,
          ...setupModuleRoutes,
        ],
      },
      {
        path: 'applicant', component: ApplicantDashboardPage,
        children: [
        ],
      }    ],
  },
  ]
;

export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: false});
