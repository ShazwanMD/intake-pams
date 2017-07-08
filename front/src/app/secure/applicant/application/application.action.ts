import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class ApplicationActions {

  static FIND_PUBLISHED_INTAKE_TASKS = '[Application] Find Published Intakes';

  findPublishedIntakeTasks(): Action {
    return {
      type: ApplicationActions.FIND_PUBLISHED_INTAKE_TASKS
    };
  }

  static FIND_PUBLISHED_INTAKES_SUCCESS = '[Application] Find Published Application Success';

  findPublishedIntakesSuccess(intakes): Action {
    console.log("findPublishedIntakesSuccess");
    return {
      type: ApplicationActions.FIND_PUBLISHED_INTAKES_SUCCESS,
      payload: intakes
    };
  }

  static APPLY_INTAKE = '[Application] Apply Intake Application';

  applyIntake(intakes): Action {
    console.log("applyIntake");
    return {
      type: ApplicationActions.APPLY_INTAKE,
      payload: intakes
    };
  }

  static APPLY_INTAKE_SUCCESS = '[Application] Apply Intake Application Success';

  applyIntakeSuccess(intakes): Action {
    console.log("applyIntake Success");
    return {
      type: ApplicationActions.APPLY_INTAKE_SUCCESS,
      payload: intakes
    };
  }
}
