import {Routes, RouterModule} from '@angular/router';
import {AdmissionPage} from "./admission.page";
import {IntakeTaskViewPage} from "./intake-task-view.page";
import {AuthenticationGuard} from "../identity/guard/authentication.guard";


export const admissionModuleRoutes: Routes = [
  {path: 'admission', component: AdmissionPage, canActivate: [AuthenticationGuard]},
  {path: 'admission/view-task/:taskId', component: IntakeTaskViewPage},
];
