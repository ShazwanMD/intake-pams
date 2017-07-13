import {Routes, RouterModule} from '@angular/router';

import {LoginPage} from './login/login.page';
import {HomePage} from './home/home.page';
import {registrationModuleRoutes} from './registration/registration-module.routes';
import {policyModuleRoutes} from './secure/administrator/policy/policy-module.routes';
import {admissionModuleRoutes} from './secure/administrator/admission/admission-module.routes';
import {centerModuleRoutes} from './center/center-module.routes';
import {ForgetPasswordPage} from './login/forget-password.page';
import {applicationModuleRoutes} from './secure/applicant/application/application-module.routes';
import {SecurePage} from './secure/secure.page';
import {AuthenticationGuard} from './secure/administrator/identity/guard/authentication.guard';
import {DashboardPage} from './secure/dashboard.page';

const routes: Routes = [
    {path: 'login', component: LoginPage},
    {path: 'forget-password', component: ForgetPasswordPage},
    ...registrationModuleRoutes,
    {
      path: '', component: HomePage,
    },
    {
      path: 'secure', component: SecurePage, canActivate: [AuthenticationGuard],
      children: [
        {
          path: '', component: DashboardPage,
        },
        ...policyModuleRoutes,
        ...admissionModuleRoutes,
        ...centerModuleRoutes,
        ...applicationModuleRoutes,
      ],
    },
  ]
;

export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: false});
