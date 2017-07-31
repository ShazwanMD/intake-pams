import { IntakeApplicationDetailPage } from './intake-application-detail.page';
import {Routes, RouterModule} from '@angular/router';
import {IntakeDetailPage} from './intake-detail.page';
import {CpsIntakeApplicationPanel} from './cps/intake-application.panel';
import {MgsebIntakeApplicationPanel} from './mgseb/intake-application.panel';
import {MyIntakeApplicationPage} from './my-intake-application.page';

export const intakeApplicationRoutes: Routes = [
  {path: 'applicant/application/intake-detail/:referenceNo', component: IntakeDetailPage},
  {path: 'application/intake-application-detail/:referenceNo', component: IntakeApplicationDetailPage},
  // {path: 'application/intake-applications/my-intake-application', component: MyIntakeApplicationPage}, // deprecated
  // {path: 'application/intake-applications/cps/:referenceNo', component: CpsIntakeApplicationPanel}, // deprecated
  // {path: 'application/intake-applications/mgseb/:referenceNo', component: MgsebIntakeApplicationPanel}, // deprecated
];
