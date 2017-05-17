import {Routes, RouterModule} from '@angular/router';
import {ApplicationPage} from "./application.page";
import {IntakeApplicationRoutes} from "./intake-applications/intake-application.routes";


export const ApplicationModuleRoutes: Routes = [
  {path: 'application', component: ApplicationPage},
  ...IntakeApplicationRoutes,

];
