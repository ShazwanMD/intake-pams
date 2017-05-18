import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {ApplicationActions} from "./application.action";
import {ApplicationService} from "../../services/application.service";
import {Router, ActivatedRoute} from '@angular/router';


@Injectable()
export class ApplicationEffects {
  constructor(private actions$: Actions,
              private router: Router,
              private applicationActions: ApplicationActions,
              private applicationService: ApplicationService) {
  }
  
  // find intake app
  // route navigate ke form dgn refno

  // @Effect() findPublishedIntakes$ = this.actions$
  //   .ofType(ApplicationActions.FIND_PUBLISHED_INTAKE)
  //   .switchMap(() => this.applicationService.findPublishedIntakes())
  //   .map(applications => this.applicationActions.findPublishedIntakesSuccess(applications));
  //
  // @Effect() findIntakeById = this.actions$
  //   .ofType(ApplicationActions.FIND_INTAKE_BY_ID)
  //   .map(action => action.payload)
  //   .switchMap(taskId => this.applicationService.findIntakeById(taskId))
  //   .map(task => this.applicationActions.findIntakeByIdSuccess(task));
}
