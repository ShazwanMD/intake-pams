import {Routes, RouterModule} from '@angular/router';
import {PolicyPage} from "./policy.page";
import {IntakeRoutes} from "./intakes/intake.routes";
import {ProgramRoutes} from "./programs/program.routes";
import {ProgramOfferingCenterPage} from "./programs/program-offering-center.page";

export const PolicyModuleRoutes: Routes = [
  {path: 'policy', component: PolicyPage},
   {path: 'policy/programs', component: ProgramOfferingCenterPage},
 
  ...IntakeRoutes,
   ...ProgramRoutes,
 
];
