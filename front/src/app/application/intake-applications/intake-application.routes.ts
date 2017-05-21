import {Routes, RouterModule} from '@angular/router';
import {IntakeDetailPage} from "./intake-detail.page";
import {CpsIntakeApplicationPage} from "./cps/intake-application.page";
import {MgsebIntakeApplicationPage} from "./mgseb/intake-application.page";

export const IntakeApplicationRoutes: Routes = [
  {path: 'application/intake-detail/:referenceNo', component: IntakeDetailPage},
  {path: 'application/intake-applications/cps/:referenceNo', component: CpsIntakeApplicationPage},
  {path: 'application/intake-applications/mgseb/:referenceNo', component: MgsebIntakeApplicationPage},
];
