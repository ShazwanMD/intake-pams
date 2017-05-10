import { NationalityCodeListPage } from './nationality-codes/nationality-code-list.page';
import { EthnicityCodeListPage } from './ethnicity-codes/ethnicity-code-list.page';
import { GenderCodeListPage } from './gender-codes/gender-code-list.page';
import { RaceCodeListPage } from './race-codes/race-code-list.page';
import { SupervisorCodeListPage } from './supervisor-codes/supervisor-code-list.page';
import { ProgramCodeListPage } from './program-codes/program-code-list.page';
import { StateCodeListPage } from './state-codes/state-code-list.page';
import { MaritalCodeListPage } from './marital-codes/marital-code-list-page';
import { ReligionCodeListPage } from './religion-codes/religion-code-list.page';
import { SetupModule } from './index';
import {Routes, RouterModule} from '@angular/router';
import {SetupPage} from "./setup.page";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";
import {GraduateCentreListPage} from "./graduate-centres/graduate-centre-list.page";
import { CountryCodeListPage } from './country-codes/country-code-list.page';






export const SetupModuleRoutes: Routes = [
  {path: 'setup', component: SetupPage},
  {path: 'setup/bank-codes', component: BankCodeListPage},
  {path: 'setup/graduate-centres', component: GraduateCentreListPage},
  {path: 'setup/religion-codes', component: ReligionCodeListPage},
  {path: 'setup/marital-codes', component: MaritalCodeListPage},
  {path: 'setup/country-codes', component: CountryCodeListPage},
  {path: 'setup/state-codes', component: StateCodeListPage},
  {path: 'setup/program-codes', component: ProgramCodeListPage},
  {path: 'setup/supervisor-codes', component: SupervisorCodeListPage},
  {path: 'setup/race-codes', component: RaceCodeListPage},
  {path: 'setup/gender-codes', component: GenderCodeListPage},
  {path: 'setup/ethnicity-codes', component: EthnicityCodeListPage},
  {path: 'setup/nationality-codes', component: NationalityCodeListPage},

];