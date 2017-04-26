import {Routes, RouterModule} from '@angular/router';
import {IntakeApplicationPersonalPage} from "./intake-application-personal.page";
import {IntakeApplicationEducationPage} from "./intake-application-education.page";


export const MgsebIntakeApplicationRoutes: Routes = [
  {path: 'application/intake-applications/mgseb/personal', component: IntakeApplicationPersonalPage},
  {path: 'application/intake-applications/mgseb/education', component: IntakeApplicationEducationPage},
];
