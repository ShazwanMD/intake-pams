import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AccountActions {
  static FIND_INTAKES = '[Intake] Find Intakes';

  findIntakes(): Action {
    console.log("findIntakes");
    return {
      type: AccountActions.FIND_INTAKES,
    };
  }

  static FIND_INTAKES_SUCCESS = '[Intake] Find Intakes Success';

  findIntakesSuccess(intakes): Action {
    console.log("findIntakesSuccess");
    return {
      type: AccountActions.FIND_INTAKES_SUCCESS,
      payload: intakes
    };
  }

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

  static FIND_MY_INTAKE_APPLICATIONS = '[Account] Find My Intake Applications';

  findMyIntakeApplications(): Action {
    return {
      type: AccountActions.FIND_MY_INTAKE_APPLICATIONS,
    };
  }

  static FIND_MY_INTAKE_APPLICATIONS_SUCCESS = '[Account] Find My Intake Applications Success';

  findMyIntakeApplicationsSuccess(myIntakeApplications): Action {
     console.log('findMyIntakeApplicationsSuccess');
    return {
      type: AccountActions.FIND_MY_INTAKE_APPLICATIONS_SUCCESS,
      payload: myIntakeApplications,
    };
  }

  static FIND_CANDIDATES = '[Account] Find Candidates';

  findCandidates(): Action {
    return {
      type: AccountActions.FIND_CANDIDATES,
    };
  }

  static FIND_CANDIDATES_SUCCESS = '[Account] Find Intake Candidates Success';

  findCandidatesSuccess(candidates): Action {
    // console.log('findIntakeApplicationsSuccess');
    return {
      type: AccountActions.FIND_CANDIDATES_SUCCESS,
      payload: candidates,
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

  static UPDATE_INTAKE_APPLICATION = '[Account] Update Intake Application';

  updateIntakeApplication(intakeApplication): Action {
    console.log('update IntakeApplication');
    return {
      type: AccountActions.UPDATE_INTAKE_APPLICATION,
      payload: intakeApplication,
    };
  }

  static UPDATE_INTAKE_APPLICATION_SUCCESS = '[Account] Update Intake Application';

  updateIntakeApplicationSuccess(message): Action {
    console.log('updateIntakeApplicationSucces');
    return {
      type: AccountActions.UPDATE_INTAKE_APPLICATION_SUCCESS,
      payload: message,
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


  static CHANGE_APPLICANT_EMAIL = '[Account] Change Applicant Email';

  changeApplicantEmail(change): Action {
    console.log('changeApplicantEmail');
    return {
      type: AccountActions.CHANGE_APPLICANT_EMAIL,
      payload: change,
    };
  }

  static CHANGE_APPLICANT_EMAIL_SUCCESS = '[Account] Change Applicant Email Success';

  changeApplicantEmailSuccess(message): Action {
    console.log('changeApplicantEmailSuccess');
    return {
      type: AccountActions.CHANGE_APPLICANT_EMAIL_SUCCESS,
      payload: message,
    };
  }

  static CHANGE_APPLICANT_ADDRESS = '[Account] Change Applicant Address';

  changeApplicantAddress(changeAddress): Action {
    console.log('changeApplicantAddress');
    return {
      type: AccountActions.CHANGE_APPLICANT_ADDRESS,
      payload: changeAddress,
    };
  }

  static CHANGE_APPLICANT_ADDRESS_SUCCESS = '[Account] Change Applicant Address Success';

  changeApplicantAddressSuccess(message): Action {
    console.log('changeApplicantAddressSuccess');
    return {
      type: AccountActions.CHANGE_APPLICANT_ADDRESS_SUCCESS,
      payload: message,
    };
  } 
  
   static ACCEPT_CANDIDATE = '[Account] Accept Candidate';

  acceptCandidate(accept): Action {
    return {
      type: AccountActions.ACCEPT_CANDIDATE,
      payload: accept,
    };
  }

  static ACCEPT_CANDIDATE_SUCCESS = '[Account] Accept Candidate Success';

  acceptCandidateSuccess(message): Action {
     console.log('acceptCandidateSuccess');
    return {
      type: AccountActions.ACCEPT_CANDIDATE_SUCCESS,
      payload: message,
    };
  }

  static DECLINED_CANDIDATE = '[Account] Declined Candidate';

  declinedCandidate(decline): Action {
    return {
      type: AccountActions.DECLINED_CANDIDATE,
      payload: decline,
    };
  }

  static DECLINED_CANDIDATE_SUCCESS = '[Account] Declined Candidate Success';

  declinedCandidateSuccess(message): Action {
     console.log('declinedCandidateSuccess');
    return {
      type: AccountActions.DECLINED_CANDIDATE_SUCCESS,
      payload: message,
    };
  }

}
