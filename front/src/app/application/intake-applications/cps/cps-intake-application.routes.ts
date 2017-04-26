import {Routes, RouterModule} from '@angular/router';
import {IntakeApplicationPersonalPage} from "./intake-application-personal.page";
import {IntakeApplicationEducationPage} from "./intake-application-education.page";


export const CpsIntakeApplicationRoutes: Routes = [
  {path: 'application/intake-applications/cps/personal', component: IntakeApplicationPersonalPage},
  {path: 'application/intake-applications/cps/education', component: IntakeApplicationEducationPage},
];
