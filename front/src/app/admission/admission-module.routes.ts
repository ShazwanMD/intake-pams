import {Routes, RouterModule} from '@angular/router';
import {AdmissionPage} from "./admission.page";
import {IntakeTaskViewPage} from "./intake-task-view.page";


export const AdmissionModuleRoutes: Routes = [
  {path: 'admission', component: AdmissionPage},
  {path: 'admission/intake-task-detail/:taskId', component: IntakeTaskViewPage},
];
