import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AccountActions} from './account.action';
import {Router, ActivatedRoute} from '@angular/router';
import {AccountService} from '../../../../services/account.service';

@Injectable()
export class AccountEffects {
  constructor(private actions$: Actions,
              private router: Router,
              private accountActions: AccountActions,
              private accountService: AccountService) {
  }

  @Effect() findPublishedIntakes$ = this.actions$
    .ofType(AccountActions.FIND_PUBLISHED_INTAKES)
    .switchMap(() => this.accountService.findPublishedIntakes())
    .map((intakes) => this.accountActions.findPublishedIntakesSuccess(intakes));

  @Effect() findApplicant = this.actions$
    .ofType(AccountActions.FIND_APPLICANT)
    .switchMap(() => this.accountService.findApplicant())
    .map((applicant) => this.accountActions.findApplicantSuccess(applicant));    

  @Effect() findIntakeApplications = this.actions$
    .ofType(AccountActions.FIND_INTAKE_APPLICATIONS)
    .map((action) => action.payload)
    .switchMap((intake) => this.accountService.findIntakeApplications())
    .map((applications) => this.accountActions.findIntakeApplicationsSuccess(applications));

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
    // .mergeMap((action) => from([action, this.accountActions.findUser()]));.

  @Effect() updateUser$ = this.actions$
    .ofType(AccountActions.UPDATE_USER)
    .map((action) => action.payload)
    .switchMap((payload) => this.accountService.updateUser(payload))
    .map((message) => this.accountActions.updateUserSuccess(message));
    // .mergeMap((action) => from([action, this.accountActions.findUser()]));
}

