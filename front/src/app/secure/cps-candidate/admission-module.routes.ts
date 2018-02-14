import { AdmissionCandidateCenterPage } from './admission-candidate-center.page';
import {Routes, RouterModule} from '@angular/router';

export const admissionCandidateModuleRoutes: Routes = [
  {path: 'cps-candidate', component: AdmissionCandidateCenterPage},
  //{path: 'admission/view-task/:taskId', component: IntakeTaskDetailPage},
];
