import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AccountActions {

  static FIND_PUBLISHED_INTAKES = '[Account] Find Published Intakes';

  findPublishedIntakes(): Action {
    return {
      type: AccountActions.FIND_PUBLISHED_INTAKES,
    };
  }

  static FIND_PUBLISHED_INTAKES_SUCCESS = '[Account] Find Published Intakes Success';

  findPublishedIntakesSuccess(intakes): Action {
    console.log('findPublishedIntakeSuccess');
    return {
      type: AccountActions.FIND_PUBLISHED_INTAKES_SUCCESS,
      payload: intakes,
    };
  }


  static FIND_DRAFTED_INTAKE_APPLICATIONS = '[Account] Find Drafted Intake Applications';

  findDraftedIntakeApplications(): Action {
    return {
      type: AccountActions.FIND_DRAFTED_INTAKE_APPLICATIONS,
    };
  }

  static FIND_DRAFTED_INTAKE_APPLICATIONS_SUCCESS = '[Account] Find Drafted Intake Applications Success';

  findDraftedIntakeApplicationsSuccess(applcations): Action {
    console.log('findDraftedIntakeApplicationsSuccess');
    return {
      type: AccountActions.FIND_DRAFTED_INTAKE_APPLICATIONS_SUCCESS,
      payload: applcations,
    };
  }

  static FIND_SUBMITTED_INTAKE_APPLICATIONS = '[Account] Find Submitted Intake Applications';

  findSubmittedIntakeApplications(): Action {
    return {
      type: AccountActions.FIND_SUBMITTED_INTAKE_APPLICATIONS,
    };
  }

  static FIND_SUBMITTED_INTAKE_APPLICATIONS_SUCCESS = '[Account] Find Submitted Intake Applications Success';

  findSubmittedIntakeApplicationsSuccess(applcations): Action {
    console.log('findSubmittedIntakeApplicationsSuccess');
    return {
      type: AccountActions.FIND_SUBMITTED_INTAKE_APPLICATIONS_SUCCESS,
      payload: applcations,
    };
  }

}
