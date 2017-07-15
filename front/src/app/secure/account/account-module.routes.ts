import {Routes, RouterModule} from '@angular/router';
import {AuthenticationGuard} from '../identity/guard/authentication.guard';
import {ApplicationPage} from '../application/application.page';
import {intakeApplicationRoutes} from '../application/intake-applications/intake-application.routes';

export const accountModuleRoutes: Routes = [
  {path: 'application', component: ApplicationPage, canActivate: [AuthenticationGuard]},
  ...intakeApplicationRoutes,

];
