import { AdmissionCandidateCenterPage } from './admission-candidate-center.page';
import {Routes, RouterModule} from '@angular/router';
import { AdmissionTaskDetailPage } from "./admission-task-detail.page";
import { AdmissionCandidateDetailPage } from "./admission-candidate-detail.page";

export const admissionCandidateModuleRoutes: Routes = [
  {path: 'cps-candidate', component: AdmissionCandidateCenterPage},
  {path: 'cps-candidate/view-task/:taskId', component: AdmissionTaskDetailPage},
  {path: 'cps-candidate/candidate-view-detail/:referenceNo', component: AdmissionCandidateDetailPage},
];
