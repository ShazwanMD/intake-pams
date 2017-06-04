import {Routes, RouterModule} from '@angular/router';
import {RegistrationPage} from "./registration.page";
import { ValidationPage } from "./validation.page";


export const RegistrationModuleRoutes: Routes = [
  {path: 'registration', component: RegistrationPage},
  {path: 'validation', component: ValidationPage},
];
