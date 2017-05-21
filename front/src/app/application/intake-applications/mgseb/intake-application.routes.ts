import {Routes, RouterModule} from '@angular/router';

import {IntakeApplicationEducationPage} from "./intake-application-education.page";
import { MgsebIntakeApplicationPage } from "./intake-application.page";

export const MgsebIntakeApplicationRoutes: Routes = [
  {path: 'application/intake-applications/mgseb/intake-application', component: MgsebIntakeApplicationPage},
  {path: 'application/intake-applications/mgseb', component: IntakeApplicationEducationPage}
];
