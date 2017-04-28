import {Routes, RouterModule} from '@angular/router';
import {CpsIntakeApplicationRoutes} from "./cps/cps-intake-application.routes";
import {MgsebIntakeApplicationRoutes} from "./mgseb/mgseb-intake-application.routes";
import {IntakeDetailPage} from "./intake-detail.page";


export const IntakeApplicationRoutes: Routes = [
  {path: 'application/intakes/:referenceNo', component: IntakeDetailPage},
  ...CpsIntakeApplicationRoutes,
  ...MgsebIntakeApplicationRoutes,
];
