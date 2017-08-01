import { Routes, Router } from '@angular/router';
import {Injectable} from "@angular/core";
import {Effect, Actions} from '@ngrx/effects';
import {RegistrationService} from "../../services/registration.service";
import {RegistrationActions} from "./registration.action";
import { NotificationService } from "../../services/notification.service";

@Injectable()
export class RegistrationEffects {
  constructor(private actions$: Actions,
              private registrationActions: RegistrationActions,
              private registrationService: RegistrationService,
              private router : Router,
              private notificationService: NotificationService,
            ) {
  }

  @Effect() registerUser$ = this.actions$
    .ofType(RegistrationActions.REGISTER_USER)
    .map(action => action.payload)
    .switchMap(registration => this.registrationService.registerUser(registration))
    .map(message => this.registrationActions.registerUserSuccess(message))
    .catch((error) => this.notificationService.showError(error))
    //.do(action => this.router.navigate(['/registration', action.payload])).ignoreElements();

  @Effect() verifyUser$ = this.actions$
    .ofType(RegistrationActions.VERIFY_USER)
    .map(action => action.payload)
    .switchMap(token => this.registrationService.verifyUser(token))
    .map(verified => this.registrationActions.verifyUserSuccess(verified));

  @Effect() forgetPassword$ = this.actions$
    .ofType(RegistrationActions.FORGET_PASSWORD)
    .map(action => action.payload)
    .switchMap(email => this.registrationService.forgetPassword(email))
    .map(message => this.registrationActions.forgetPasswordSuccess(message))
    .catch((error) => this.notificationService.showError(error));  
}
