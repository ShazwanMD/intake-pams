import {Routes, RouterModule} from '@angular/router';
//import {CpsIntakeApplicationRoutes} from "./cps/intake-application.routes";
//import {MgsebIntakeApplicationRoutes} from "./mgseb/intake-application.routes";
import {IntakeDetailPage} from "./intake-detail.page";


export const IntakeApplicationRoutes: Routes = [
  {path: 'application/intake-applications/:referenceNo', component: IntakeDetailPage},
 // ...CpsIntakeApplicationRoutes,
 // ...MgsebIntakeApplicationRoutes,
];
