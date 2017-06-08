import {Routes} from '@angular/router';
import {RegistrationPage} from "./registration.page";
import {VerificationPage} from "./verification.page";


export const RegistrationModuleRoutes: Routes = [
  {path: 'registration', component: RegistrationPage},
  {path: 'verification/:token', component: VerificationPage},
];
