import {Routes, RouterModule} from '@angular/router';
import {IntakeApplicationPersonalPage} from "./intake-application-personal.page";
import {IntakeApplicationEducationPage} from "./intake-application-education.page";


export const IntakeApplicationRoutes: Routes = [
  {path: 'application/intake-applications/personal', component: IntakeApplicationPersonalPage},
  {path: 'application/intake-applications/education', component: IntakeApplicationEducationPage},
];
