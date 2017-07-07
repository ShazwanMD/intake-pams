import {Routes, RouterModule} from '@angular/router';
import {PolicyPage} from "./policy.page";
import {IntakeRoutes} from "./intakes/intake.routes";
import {IntakeSessionRoutes} from "./intake-sessions/intake-session.routes";

export const policyModuleRoutes: Routes = [
  {path: 'policy', component: PolicyPage},
  ...IntakeRoutes,
  ...IntakeSessionRoutes,
];
