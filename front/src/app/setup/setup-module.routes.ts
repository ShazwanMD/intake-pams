import { SchoolCodeListPage } from './school-codes/school-code-list-page';
import { SchoolCode } from './../common/school-codes/school-code.interface';
import { DisabilityCodeListPage } from './disability-codes/disability-code-list-page';
import { DisabilityCode } from './../common/disability-codes/disability-code.interface';
import {StudyModeListPage} from './study-modes/study-mode-list.page';
import {FacultyCodeListPage} from './faculty-codes/faculty-code-list.page';
import {NationalityCodeListPage} from './nationality-codes/nationality-code-list.page';
import {EthnicityCodeListPage} from './ethnicity-codes/ethnicity-code-list.page';
import {GenderCodeListPage} from './gender-codes/gender-code-list.page';
import {RaceCodeListPage} from './race-codes/race-code-list.page';
import {SupervisorCodeListPage} from './supervisor-codes/supervisor-code-list.page';
import {ProgramCodeListPage} from './program-codes/program-code-list.page';
import {StateCodeListPage} from './state-codes/state-code-list.page';
import {MaritalCodeListPage} from './marital-codes/marital-code-list-page';
import {ReligionCodeListPage} from './religion-codes/religion-code-list.page';
import {SetupModule} from './index';
import {Routes, RouterModule} from '@angular/router';
import {SetupPage} from "./setup.page";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";
import {GraduateCentreListPage} from "./graduate-centres/graduate-centre-list.page";
import {CountryCodeListPage} from './country-codes/country-code-list.page';
import { StudyCenterCodeListPage } from './study-center-codes/study-center-code-list.page';
import { StudyCenterCode } from './../common/study-center-codes/study-center-code.interface';


export const SetupModuleRoutes: Routes = [
  {
    path: 'setup', component: SetupPage,
    children: [
      {path: 'bank-codes', component: BankCodeListPage},
      {path: 'graduate-centres', component: GraduateCentreListPage},
      {path: 'religion-codes', component: ReligionCodeListPage},
      {path: 'marital-codes', component: MaritalCodeListPage},
      {path: 'country-codes', component: CountryCodeListPage},
      {path: 'state-codes', component: StateCodeListPage},
      {path: 'program-codes', component: ProgramCodeListPage},
      {path: 'supervisor-codes', component: SupervisorCodeListPage},
      {path: 'race-codes', component: RaceCodeListPage},
      {path: 'gender-codes', component: GenderCodeListPage},
      {path: 'ethnicity-codes', component: EthnicityCodeListPage},
      {path: 'nationality-codes', component: NationalityCodeListPage},
      {path: 'faculty-codes', component: FacultyCodeListPage},
      {path: 'study-modes', component: StudyModeListPage},
      {path: 'disability-codes', component: DisabilityCodeListPage},
      {path: 'school-codes', component: SchoolCodeListPage},
      {path: 'study-centre-codes', component: StudyCenterCodeListPage},

    ]
  },

];
