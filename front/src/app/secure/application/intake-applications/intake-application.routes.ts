import {Routes, RouterModule} from '@angular/router';
import {IntakeDetailPage} from './intake-detail.page';
import {CpsIntakeApplicationPanel} from './cps/intake-application.panel';
import {MgsebIntakeApplicationPanel} from './mgseb/intake-application.panel';
import {MyIntakeApplicationPage} from './my-intake-application.page';

export const intakeApplicationRoutes: Routes = [
  {path: 'applicant/application/intake-detail/:referenceNo', component: IntakeDetailPage},
  {path: 'applicant/application/intake-application/my-intake-application', component: MyIntakeApplicationPage},
  {path: 'applicant/application/intake-application/cps/:referenceNo', component: CpsIntakeApplicationPanel},
  {path: 'applicant/application/intake-application/mgseb/:referenceNo', component: MgsebIntakeApplicationPanel},
];
