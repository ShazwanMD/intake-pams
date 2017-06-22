import {Routes} from '@angular/router';
import {RegistrationPage} from "./registration.page";
import {VerificationPage} from "./verification.page";
import {RegistrationInformationPage} from "./registration-information.page";


export const RegistrationModuleRoutes: Routes = [
  {path: 'registration', component: RegistrationPage},
  {path: 'registrationInfo', component: RegistrationInformationPage},
  {path: 'verification/:token', component: VerificationPage},
];
