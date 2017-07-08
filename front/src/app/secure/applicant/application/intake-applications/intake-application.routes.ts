import {Routes, RouterModule} from '@angular/router';
import {IntakeDetailPage} from './intake-detail.page';
import {CpsIntakeApplicationPage} from './cps/intake-application.page';
import {MgsebIntakeApplicationPage} from './mgseb/intake-application.page';
import {MyIntakeApplicationPage} from './my-intake-application.page';

export const intakeApplicationRoutes: Routes = [
  {path: 'application/intake-detail/:referenceNo', component: IntakeDetailPage},
  {path: 'application/intake-application/my-intake-application', component: MyIntakeApplicationPage},
  {path: 'application/intake-application/cps/:referenceNo', component: CpsIntakeApplicationPage},
  {path: 'application/intake-application/mgseb/:referenceNo', component: MgsebIntakeApplicationPage},
];
