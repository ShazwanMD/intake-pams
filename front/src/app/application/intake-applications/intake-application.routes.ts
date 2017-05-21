import {Routes, RouterModule} from '@angular/router';
import {MgsebIntakeApplicationRoutes} from "./mgseb/intake-application.routes";
import {IntakeDetailPage} from "./intake-detail.page";
import { CpsIntakeApplicationPage } from "./cps/intake-application.page";
import { CpsIntakeApplicationRoutes } from "./cps/intake-application.routes";
import { MgsebIntakeApplicationPage } from "./mgseb/intake-application.page";
//import { IntakeApplicationPage } from "./cps/intake-application.page";

export const IntakeApplicationRoutes: Routes = [
  {path: 'application/intake-applications/:referenceNo', component: IntakeDetailPage},
  {path: 'application/intake-applications/cps/:referenceNo', component: CpsIntakeApplicationPage},
  {path: 'application/intake-applications/mgseb/:referenceNo', component: MgsebIntakeApplicationPage},
  //{path: 'application/intake-applications/cps/intake-application', component:IntakeApplicationPage },
  //{path: 'application/intake-applications', component: IntakeApplicationPage},
  //...CpsIntakeApplicationRoutes,
  //...MgsebIntakeApplicationRoutes,
];
