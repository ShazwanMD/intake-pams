import {Routes, RouterModule} from '@angular/router';
import {IntakeSessionCenterPage} from "./intake-session-center.page";


export const IntakeSessionRoutes: Routes = [
  {path: 'policy/intake-sessions', component: IntakeSessionCenterPage},
  // {path: 'policy/intakes/assigned-tasks', component: IntakeAssignedTaskPage},
  // {path: 'policy/intakes/pooled-tasks', component: IntakePooledTaskPage},
];
