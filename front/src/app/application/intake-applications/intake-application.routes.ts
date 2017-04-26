import {Routes, RouterModule} from '@angular/router';
import {CpsIntakeApplicationRoutes} from "./cps/cps-intake-application.routes";
import {MgsebIntakeApplicationRoutes} from "./mgseb/mgseb-intake-application.routes";


export const IntakeApplicationRoutes: Routes = [
  ...CpsIntakeApplicationRoutes,
  ...MgsebIntakeApplicationRoutes,
];
