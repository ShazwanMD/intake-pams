import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {Store} from '@ngrx/store';
import {AccountActions} from './account.action';
import {Router, ActivatedRoute} from '@angular/router';
import {AccountService} from '../../../services/account.service';
import {ApplicationContextActions} from '../../application-context.action';
import {Observable} from 'rxjs/Observable';
import {ApplicationError} from '../../shared/model/application-error.interface';
import {ApplicationContextState} from '../../application-context.reducer';

@Injectable()
export class AccountEffects {
  constructor(private actions$: Actions,
              private router: Router,
              private accountActions: AccountActions,
              private accountService: AccountService,
              private ctxActions: ApplicationContextActions) {
  }

  @Effect() findPublishedIntakes$ = this.actions$
    .ofType(AccountActions.FIND_PUBLISHED_INTAKES)
    .switchMap(() => this.accountService.findPublishedIntakes())
    .map((intakes) => this.accountActions.findPublishedIntakesSuccess(intakes));

  @Effect() findApplicant = this.actions$
    .ofType(AccountActions.FIND_APPLICANT)
    .switchMap(() => this.accountService.findApplicant())
    .map((applicant) => this.accountActions.findApplicantSuccess(applicant))
    .catch((error) => Observable.of(this.ctxActions.setErrorMessage(error.error)));

  @Effect() findIntakeApplications = this.actions$
    .ofType(AccountActions.FIND_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.accountService.findIntakeApplications())
    .map((applications) => this.accountActions.findIntakeApplicationsSuccess(applications))
    .catch((error) => Observable.of(this.ctxActions.setErrorMessage(error.error)));

  @Effect() findMyIntakeApplications = this.actions$
    .ofType(AccountActions.FIND_MY_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap(() => this.accountService.findMyIntakeApplications())
    .map((applications) => this.accountActions.findMyIntakeApplicationsSuccess(applications))
    .catch((error) => Observable.of(this.ctxActions.setErrorMessage(error.error)));    

  @Effect() findCandidates = this.actions$
    .ofType(AccountActions.FIND_CANDIDATES)
    .map((action) => action.payload)
    .switchMap((intake) => this.accountService.findCandidates())
    .map((candidates) => this.accountActions.findCandidatesSuccess(candidates))
    .catch((error) => Observable.of(this.ctxActions.setErrorMessage(error.error)));    

  @Effect() findDraftedIntakeApplications = this.actions$
    .ofType(AccountActions.FIND_DRAFTED_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.accountService.findDraftedIntakeApplications())
    .map((applications) => this.accountActions.findDraftedIntakeApplicationsSuccess(applications));

  @Effect() findSubmittedIntakeApplications = this.actions$
    .ofType(AccountActions.FIND_SUBMITTED_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.accountService.findSubmittedIntakeApplications())
    .map((applications) => this.accountActions.findSubmittedIntakeApplicationsSuccess(applications));

  // ====================================================================================================
  // USER
  // ====================================================================================================

  @Effect() findUser$ = this.actions$
    .ofType(AccountActions.FIND_USER)
    .map((action) => action.payload)
    .switchMap(() => this.accountService.findUser())
    .map((user) => this.accountActions.findUserSuccess(user));

  @Effect() saveUser$ = this.actions$
    .ofType(AccountActions.SAVE_USER)
    .map((action) => action.payload)
    .switchMap((payload) => this.accountService.saveUser(payload))
    .map((message) => this.accountActions.saveUserSuccess(message));

  @Effect() updateUser$ = this.actions$
    .ofType(AccountActions.UPDATE_USER)
    .map((action) => action.payload)
    .switchMap((payload) => this.accountService.updateUser(payload))
    .map((message) => this.accountActions.updateUserSuccess(message));

  @Effect() changeUserPassword$ = this.actions$
    .ofType(AccountActions.CHANGE_USER_PASSWORD)
    .map((action) => action.payload)
    .switchMap((payload) => this.accountService.changeUserPassword(payload))
    .map((message) => this.accountActions.changeUserPasswordSuccess(message));

    @Effect() changeApplicantEmail$ = this.actions$
    .ofType(AccountActions.CHANGE_APPLICANT_EMAIL)
    .map((action) => action.payload)
    .switchMap((payload) => this.accountService.changeApplicantEmail(payload))
    .map((message) => this.accountActions.changeApplicantEmailSuccess(message));

    @Effect() changeApplicantAddress$ = this.actions$
    .ofType(AccountActions.CHANGE_APPLICANT_ADDRESS)
    .map((action) => action.payload)
    .switchMap((payload) => this.accountService.changeApplicantAddress(payload))
    .map((message) => this.accountActions.changeApplicantAddressSuccess(message));    

    



}

