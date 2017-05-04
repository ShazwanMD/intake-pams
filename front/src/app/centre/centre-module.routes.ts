import {Routes, RouterModule} from '@angular/router';
import {CentrePage} from "./centre.page";
import {MgsebCentrePage} from "./mgseb-centre.page";
import {CpsCentrePage} from "./cps-centre.page";
import {AbcPage} from "./abc.page";

export const CentreModuleRoutes: Routes = [
  {path: 'centre', component: CentrePage},
  {path: 'centre/MGSEB', redirectTo: 'centre/mgseb'},
  {path: 'centre/mgseb', component: MgsebCentrePage},
  {path: 'centre/CPS', redirectTo: 'centre/cps'},
  {path: 'centre/cps', component: CpsCentrePage},

];
