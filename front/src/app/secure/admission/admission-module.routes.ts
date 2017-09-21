import { AdmissionCenterPage } from './admission-center.page';
import {Routes, RouterModule} from '@angular/router';
import { IntakeTaskDetailPage } from './intake-task-detail.page';
import {IntakeTaskViewPage} from './intake-task-view.page';

export const admissionModuleRoutes: Routes = [
  {path: 'admission', component: AdmissionCenterPage},
  {path: 'admission/view-task/:taskId', component: IntakeTaskDetailPage},
];
