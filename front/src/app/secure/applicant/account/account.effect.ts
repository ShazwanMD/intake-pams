import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AccountActions} from './account.action';
import {ApplicationService} from '../../../../services/application.service';
import {Router, ActivatedRoute} from '@angular/router';
import {AccountService} from '../../../../services/account.service';

@Injectable()
export class ApplicationEffects {
  constructor(private actions$: Actions,
              private router: Router,
              private accountActions: AccountActions,
              private accountService: AccountService) {
  }

  @Effect() findPublishedIntake$ = this.actions$
    .ofType(AccountActions.FIND_PUBLISHED_INTAKES)
    .switchMap(() => this.accountService.findPublishedIntakes())
    .map((intakes) => this.accountActions.findPublishedIntakesSuccess(intakes));

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


}
