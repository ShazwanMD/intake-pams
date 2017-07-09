import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {ApplicationActions} from './account.action';
import {ApplicationService} from '../../../../services/application.service';
import {Router, ActivatedRoute} from '@angular/router';

@Injectable()
export class ApplicationEffects {
  constructor(private actions$: Actions,
              private router: Router,
              private applicationActions: ApplicationActions,
              private applicationService: ApplicationService) {
  }
}
