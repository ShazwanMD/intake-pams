import {Routes} from '@angular/router';
import {CenterPage} from "./center.page";
import {MgsebCenterPage} from "./mgseb-center.page";
import {CpsCenterPage} from "./cps-center.page";

export const centerModuleRoutes: Routes = [
  {path: 'center', component: CenterPage},
  {path: 'center/MGSEB', redirectTo: 'center/mgseb'},
  {path: 'center/mgseb', component: MgsebCenterPage},
  {path: 'center/CPS', redirectTo: 'center/cps'},
  {path: 'center/cps', component: CpsCenterPage},

];
