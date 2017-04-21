import {Routes, RouterModule} from '@angular/router';
import {IntakeCenterPage} from "./intake-center.page";
import {IntakeTaskViewPage} from "./intake-task-view.page";


export const IntakeRoutes: Routes = [
  {path: 'policy/intakes', component: IntakeCenterPage},
  // {path: 'policy/intakes/assigned-tasks', component: IntakeAssignedTaskPage},
  // {path: 'policy/intakes/pooled-tasks', component: IntakePooledTaskPage},
  {path: 'policy/intakes/view-task/:taskId', component: IntakeTaskViewPage},
];
