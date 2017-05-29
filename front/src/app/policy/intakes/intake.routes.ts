import {Routes, RouterModule} from '@angular/router';
import {IntakeCenterPage} from "./intake-center.page";
import {IntakeTaskDetailPage} from "./intake-task-detail.page";


export const IntakeRoutes: Routes = [
  {path: 'policy/intakes', component: IntakeCenterPage},
  {path: 'policy/intakes/view-task/:taskId', component: IntakeTaskDetailPage},
];
