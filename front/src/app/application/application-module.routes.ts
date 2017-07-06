import {Routes, RouterModule} from '@angular/router';
import {ApplicationPage} from './application.page';
import {intakeApplicationRoutes} from './intake-applications/intake-application.routes';
import {AuthenticationGuard} from '../identity/guard/authentication.guard';

export const applicationModuleRoutes: Routes = [
  {path: 'application', component: ApplicationPage, canActivate: [AuthenticationGuard]},
  ...intakeApplicationRoutes,

];
