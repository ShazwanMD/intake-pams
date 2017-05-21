import {Routes, RouterModule} from '@angular/router';

import {IntakeApplicationEducationPage} from "./intake-application-education.page";
import { IntakeApplicationPage } from "./intake-application.page";

export const MgsebIntakeApplicationRoutes: Routes = [
  {path: 'application/intake-applications/mgseb/intake-application', component: IntakeApplicationPage},
  {path: 'application/intake-applications/mgseb', component: IntakeApplicationEducationPage}
];
