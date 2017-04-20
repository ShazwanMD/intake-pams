import {Injectable} from "@angular/core";
import {Effect, Actions} from '@ngrx/effects';
import {RegistrationService} from "../../services/registration.service";
import {RegistrationActions} from "./registration.action";

@Injectable()
export class RegistrationEffects {
  constructor(private actions$: Actions,
              private registrationActions: RegistrationActions,
              private registrationService: RegistrationService) {
  }

  @Effect() registerUser$ = this.actions$
    .ofType(RegistrationActions.REGISTER_USER)
    .map(action => action.payload)
    .switchMap(registration => this.registrationService.registerUser(registration))
    .map(message => this.registrationActions.registerUserSuccess(message));
}
