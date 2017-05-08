import { MaritalCodeListPage } from './marital-codes/marital-code-list-page';
import { ReligionCodeListPage } from './religion-codes/religion-code-list.page';
import { SetupModule } from './index';
import {Routes, RouterModule} from '@angular/router';
import {SetupPage} from "./setup.page";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";
import {GraduateCentreListPage} from "./graduate-centres/graduate-centre-list.page";



export const SetupModuleRoutes: Routes = [
  {path: 'setup', component: SetupPage},
  {path: 'setup/bank-codes', component: BankCodeListPage},
  {path: 'setup/graduate-centres', component: GraduateCentreListPage},
  {path: 'setup/religion-codes', component: ReligionCodeListPage},
  {path: 'setup/marital-codes', component: MaritalCodeListPage},

];