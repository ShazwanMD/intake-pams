import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {Intake} from "../policy/intakes/intake.interface";

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
}
