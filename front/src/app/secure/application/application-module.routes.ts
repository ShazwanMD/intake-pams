import {Routes, RouterModule} from '@angular/router';
import {ApplicationPage} from './application.page';
import {intakeApplicationRoutes} from './intake-applications/intake-application.routes';
import {AuthenticationGuard} from '../administrator/identity/guard/authentication.guard';

export const applicationModuleRoutes: Routes = [
  {path: 'applicant/application', component: ApplicationPage, canActivate: [AuthenticationGuard]},
  ...intakeApplicationRoutes,
];
