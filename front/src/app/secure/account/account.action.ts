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

  static FIND_APPLICANT = '[Account] Find Applicant';

  findApplicant(): Action {
    return {
      type: AccountActions.FIND_APPLICANT,
    };
  }

  static FIND_APPLICANT_SUCCESS = '[Account] Find Applicant Success';

  findApplicantSuccess(applicant): Action {
    console.log('findApplicantSuccess');
    return {
      type: AccountActions.FIND_APPLICANT_SUCCESS,
      payload: applicant,
    };
  }

  static FIND_INTAKE_APPLICATIONS = '[Account] Find Intake Applications';

  findIntakeApplications(): Action {
    return {
      type: AccountActions.FIND_INTAKE_APPLICATIONS,
    };
  }

  static FIND_INTAKE_APPLICATIONS_SUCCESS = '[Account] Find Intake Applications Success';

  findIntakeApplicationsSuccess(applcations): Action {
    console.log('findIntakeApplicationsSuccess');
    return {
      type: AccountActions.FIND_INTAKE_APPLICATIONS_SUCCESS,
      payload: applcations,
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

// ====================================================================================================
  // USER
  // ====================================================================================================

  static FIND_USER = '[Account] Find User';

  findUser(): Action {
    console.log('findUsers');
    return {
      type: AccountActions.FIND_USER,
    };
  }

  static FIND_USER_SUCCESS = '[Account] Find User Success';

  findUserSuccess(user): Action {
    console.log('findUserSuccess');
    return {
      type: AccountActions.FIND_USER_SUCCESS,
      payload: user,
    };
  }

  static SAVE_USER = '[Account] Save User';

  saveUser(user): Action {
    console.log('saveUser');
    return {
      type: AccountActions.SAVE_USER,
      payload: user,
    };
  }

  static SAVE_USER_SUCCESS = '[Account] Save User Success';

  saveUserSuccess(message): Action {
    console.log('saveUserSuccess');
    return {
      type: AccountActions.SAVE_USER_SUCCESS,
      payload: message,
    };
  }

  static UPDATE_USER = '[Account] Update User';

  updateUser(user): Action {
    console.log('updateUser');
    return {
      type: AccountActions.UPDATE_USER,
      payload: user,
    };
  }

  static UPDATE_USER_SUCCESS = '[Account] Update User Success';

  updateUserSuccess(message): Action {
    console.log('updateUserSuccess');
    return {
      type: AccountActions.UPDATE_USER_SUCCESS,
      payload: message,
    };
  }

  static CHANGE_USER_PASSWORD = '[Account] Change User Password';

  changeUserPassword(change): Action {
    console.log('changeUserPassword');
    return {
      type: AccountActions.CHANGE_USER_PASSWORD,
      payload: change,
    };
  }

  static CHANGE_USER_PASSWORD_SUCCESS = '[Account] Change User Password Success';

  changeUserPasswordSuccess(message): Action {
    console.log('changeUserPasswordSuccess');
    return {
      type: AccountActions.CHANGE_USER_PASSWORD_SUCCESS,
      payload: message,
    };
  }


  static CHANGE_USER_EMAIL = '[Account] Change User Email';

  changeUserEmail(change): Action {
    console.log('changeUserEmail');
    return {
      type: AccountActions.CHANGE_USER_EMAIL,
      payload: change,
    };
  }

  static CHANGE_USER_EMAIL_SUCCESS = '[Account] Change User Email Success';

  changeUserEmailSuccess(message): Action {
    console.log('changeUserEmailSuccess');
    return {
      type: AccountActions.CHANGE_USER_EMAIL_SUCCESS,
      payload: message,
    };
  }

}
