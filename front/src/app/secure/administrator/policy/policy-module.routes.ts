import {Routes, RouterModule} from '@angular/router';
import {PolicyPage} from './policy.page';
import {IntakeRoutes} from './intakes/intake.routes';
import {IntakeSessionRoutes} from './intake-sessions/intake-session.routes';
import {AuthenticationGuard} from '../../../identity/guard/authentication.guard';

export const policyModuleRoutes: Routes = [
  {path: 'policy', component: PolicyPage, canActivate: [AuthenticationGuard]},
  ...IntakeRoutes,
  ...IntakeSessionRoutes,
];
