import {Routes, RouterModule} from '@angular/router';
import {RegistrationPage} from "./registration.page";
import { ValidationPage } from "./validation.page";
import { ValidationInformationPage } from "./validation-information.page";


export const RegistrationModuleRoutes: Routes = [
  {path: 'registration', component: RegistrationPage},
  {path: 'validationInfo', component: ValidationInformationPage},
  {path: 'validation', component: ValidationPage},
];
