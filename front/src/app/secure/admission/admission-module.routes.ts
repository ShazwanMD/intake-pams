import {Routes, RouterModule} from '@angular/router';
import {AdmissionPage} from './admission.page';
import {IntakeTaskViewPage} from './intake-task-view.page';

export const admissionModuleRoutes: Routes = [
  {path: 'admission', component: AdmissionPage},
  {path: 'admission/view-task/:taskId', component: IntakeTaskViewPage},
];