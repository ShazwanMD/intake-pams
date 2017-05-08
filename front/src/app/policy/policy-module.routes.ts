import {Routes, RouterModule} from '@angular/router';
import {PolicyPage} from "./policy.page";
import {IntakeRoutes} from "./intakes/intake.routes";

export const PolicyModuleRoutes: Routes = [
  {path: 'policy', component: PolicyPage},
  
  ...IntakeRoutes,
];
