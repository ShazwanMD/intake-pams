import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class IntakeApplicationActions {

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  // todo: published intakes
  static FIND_INTAKES = '[Intake Application] Find Intakes';

  findIntakes(): Action {
    return {
      type: IntakeApplicationActions.FIND_INTAKES
    };
  }

  static FIND_INTAKES_SUCCESS = '[Intake Application] Find Intakes Success';

  findIntakesSuccess(intakes): Action {
    console.log("findIntakesSuccess");
    return {
      type: IntakeApplicationActions.FIND_INTAKES_SUCCESS,
      payload: intakes
    };
  }

  static FIND_INTAKE_BY_REFERENCE_NO = '[Intake] Find Intake By Reference No';

  findIntakeByReferenceNo(referenceNo): Action {
    console.log("findIntakeByReferenceNo");
    return {
      type: IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO,
      payload: referenceNo
    };
  }

  static FIND_INTAKE_BY_REFERENCE_NO_SUCCESS = '[Intake] Find Intake By Reference No Success';

  findIntakeByReferenceNoSuccess(intake): Action {
    console.log("findIntakeByReferenceNoSuccess");
    return {
      type: IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO_SUCCESS,
      payload: intake
    };
  }

  static FIND_PROGRAM_OFFERINGS_BY_INTAKE_APPLICATION = '[Intake] Find Program Offerings By Intake Application';

  findProgramOfferingsByIntakeApplication(application): Action {
    console.log("findProgramOfferingsByIntakeApplication");
    return {
      type: IntakeApplicationActions.FIND_PROGRAM_OFFERINGS_BY_INTAKE_APPLICATION,
      payload: application
    };
  }

  static FIND_PROGRAM_OFFERINGS_BY_INTAKE_APPLICATION_SUCCESS = '[Intake] Find Program Offerings By Intake Application Success';

  findProgramOfferingsByIntakeApplicationSuccess(offerings): Action {
    console.log("findProgramOfferingsByIntakeApplicationSuccess");
    return {
      type: IntakeApplicationActions.FIND_PROGRAM_OFFERINGS_BY_INTAKE_APPLICATION_SUCCESS,
      payload: offerings
    };
  }


  // ====================================================================================================
  // INTAKE APPLICATION
  // ====================================================================================================

  static APPLY_INTAKE = '[Intake Application] Apply Intake';

  applyIntake(intake): Action {
    console.log("applyIntake");
    return {
      type: IntakeApplicationActions.APPLY_INTAKE,
      payload: intake
    };
  }

  static APPLY_INTAKE_SUCCESS = '[Intake Application] Apply Intake Success ';

  applyIntakeSuccess(referenceNo): Action {
    console.log("applyIntakeSuccess");
    return {
      type: IntakeApplicationActions.APPLY_INTAKE_SUCCESS,
      payload: referenceNo
    };
  }

  static FIND_INTAKE_APPLICATIONS = '[Intake Application] Find Intake Applications';

  findIntakeApplications(): Action {
    return {
      type: IntakeApplicationActions.FIND_INTAKE_APPLICATIONS
    };
  }

  static FIND_INTAKE_APPLICATIONS_SUCCESS = '[Intake Application] Find Intake Applications Success';

  findIntakeApplicationsSuccess(applcations): Action {
    console.log("findIntakeApplicationsSuccess");
    return {
      type: IntakeApplicationActions.FIND_INTAKE_APPLICATIONS_SUCCESS,
      payload: applcations
    };
  }

  static FIND_EDUCATIONS_BY_INTAKE_APPLICATION = '[Intake Application] Find Educations';

  findEducationsByIntakeApplication(application): Action {
    return {
      type: IntakeApplicationActions.FIND_EDUCATIONS_BY_INTAKE_APPLICATION,
      payload: application
    };
  }

  static FIND_EDUCATIONS_BY_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Find Educations Success';

  findEducationsByIntakeApplicationSuccess(educations): Action {
    console.log("findEducationsByIntakeApplicationSuccess");
    return {
      type: IntakeApplicationActions.FIND_EDUCATIONS_BY_INTAKE_APPLICATION_SUCCESS,
      payload: educations
    };
  }


  static FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION = '[Intake Application] Find Employments';

  findEmploymentsByIntakeApplication(application): Action {
    console.log("findEmploymentsByIntakeApplication");
    return {
      type: IntakeApplicationActions.FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION,
      payload: application
    };
  }

  static FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Find Employments Success';

  findEmploymentsByIntakeApplicationSuccess(employments): Action {
    console.log("findEmploymentsByIntakeApplicationSuccess");
    return {
      type: IntakeApplicationActions.FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION_SUCCESS,
      payload: employments
    };
  }

    static FIND_REFEREES_BY_INTAKE_APPLICATION = '[Intake Application] Find Referees';

  findRefereesByIntakeApplication(application): Action {
    console.log("findRefereesByIntakeApplication");
    return {
      type: IntakeApplicationActions.FIND_REFEREES_BY_INTAKE_APPLICATION,
      payload: application
    };
  }

  static FIND_REFEREES_BY_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Find Referees Success';

  findRefereesByIntakeApplicationSuccess(referees): Action {
    console.log("findRefereesByIntakeApplicationSuccess");
    return {
      type: IntakeApplicationActions.FIND_REFEREES_BY_INTAKE_APPLICATION_SUCCESS,
      payload: referees
    };
  }


  static FIND_ADDRESSES_BY_INTAKE_APPLICATION = '[Intake Application] Find Addresses';

  findAddressesByIntakeApplication(application): Action {
    return {
      type: IntakeApplicationActions.FIND_ADDRESSES_BY_INTAKE_APPLICATION,
      payload: application
    };
  }

  static FIND_ADDRESSES_BY_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Find Addresses Success';

  findAddressesByIntakeApplicationSuccess(addresses): Action {
 
    console.log("findAddressesSuccess");
    return {
      type: IntakeApplicationActions.FIND_ADDRESSES_BY_INTAKE_APPLICATION_SUCCESS,
      payload: addresses
    };
  }

  static FIND_SPM_RESULTS_BY_INTAKE_APPLICATION = '[Intake Application] Find Spm Results';

  findSpmResultsByIntakeApplication(application): Action {
    return {
      type: IntakeApplicationActions.FIND_SPM_RESULTS_BY_INTAKE_APPLICATION,
      payload: application
    };
  }

  static FIND_SPM_RESULTS_BY_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Find Spm Results Success';

  findSpmResultsByIntakeApplicationSuccess(spmResult): Action {
    console.log("findSpmResultsSuccess");
    return {
      type: IntakeApplicationActions.FIND_SPM_RESULTS_BY_INTAKE_APPLICATION_SUCCESS,
      payload: spmResult
    };
  }

  static SUBMIT_INTAKE_APPLICATION = '[Intake Application] Submit Intake Application';

  submitIntakeApplication(application): Action {
    return {
      type: IntakeApplicationActions.SUBMIT_INTAKE_APPLICATION,
      payload: application
    };
  }

  static SUBMIT_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Submit Intake Application Success';

  submitIntakeApplicationSuccess(referenceNo): Action {
    return {
      type: IntakeApplicationActions.SUBMIT_INTAKE_APPLICATION_SUCCESS,
      payload: referenceNo
    };
  }

  static FIND_INTAKE_APPLICATION_BY_REFERENCE_NO = '[Intake Application] Find Intake By Reference No';

  findIntakeApplicationByReferenceNo(referenceNo): Action {
    console.log("findIntakeApplicationByReferenceNo: " + referenceNo);
    return {
      type: IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO,
      payload: referenceNo
    };
  }

  static FIND_INTAKE_APPLICATION_BY_REFERENCE_NO_SUCCESS = '[Intake Application] Find Intake Application By Reference No Success';

  findIntakeApplicationByReferenceNoSuccess(application): Action {
    console.log("findIntakeApplicationByReferenceNoSuccess");
    return {
      type: IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO_SUCCESS,
      payload: application
    };
  }

  // todo: find employment, education, address


  static UPDATE_INTAKE_APPLICATION = '[Intake Application] Update Intake Application';

  updateIntakeApplication(application): Action {
    return {
      type: IntakeApplicationActions.UPDATE_INTAKE_APPLICATION,
      payload: application
    };
  }

  static UPDATE_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Update Intake Success';

  updateIntakeSuccess(message): Action {
    return {
      type: IntakeApplicationActions.UPDATE_INTAKE_APPLICATION_SUCCESS,
      payload: message
    };
  }

  static ADD_EDUCATION = '[Intake Application] Add Education';

  addEducation(intake, education) {
    return {
      type: IntakeApplicationActions.ADD_EDUCATION,
      payload: {intake: intake, education: education}
    };
  }

  static ADD_EDUCATION_SUCCESS = '[Intake Application] Add Education Success';

  addEducationSuccess(message) {
    return {
      type: IntakeApplicationActions.ADD_EDUCATION_SUCCESS,
      payload: message
    };
  }

  static DELETE_EDUCATION = '[Intake Application] Delete Education';

  deleteEducation(intake, education) {
    return {
      type: IntakeApplicationActions.DELETE_EDUCATION,
      payload: {intake: intake, education: education}
    };
  }

  static DELETE_EDUCATION_SUCCESS = '[Intake Application] Delete Education Success';

  deleteEducationSucces(message) {
    return {
      type: IntakeApplicationActions.DELETE_EDUCATION_SUCCESS,
      payload: message
    };
  }

  static ADD_EMPLOYMENT = '[Intake Application] Save Employment';

  addEmployment(application, employment): Action {
    console.log("addEmployment");
    return {
      type: IntakeApplicationActions.ADD_EMPLOYMENT,
      payload: {application: application, employment: employment}
    };
  }

  static ADD_EMPLOYMENT_SUCCESS = '[Intake Application] Add Employment Success';

  addEmploymentSuccess(message): Action {
    console.log("addEmploymentSuccess");
    return {
      type: IntakeApplicationActions.ADD_EMPLOYMENT_SUCCESS,
      payload: message
    };
  }

  static DELETE_EMPLOYMENT = '[Intake Application] Delete Employment';

  deleteEmployment(intake, employment) {
    return {
      type: IntakeApplicationActions.DELETE_EMPLOYMENT,
      payload: {intake: intake, employment: employment}
    };
  }

  static DELETE_EMPLOYMENT_SUCCESS = '[Intake Application] Delete Employment Success';

  deleteEmploymentSucces(message) {
    return {
      type: IntakeApplicationActions.DELETE_EMPLOYMENT_SUCCESS,
      payload: message
    };
  }

  static ADD_REFEREE = '[Intake Application] Save Referee';

    addReferee(application, referee): Action {
    console.log("addReferee");
    return {
      type: IntakeApplicationActions.ADD_REFEREE,
      payload: {application: application, referee: referee}
    };
  }

  static ADD_REFEREE_SUCCESS = '[Intake Application] Add Referee Success';

  addRefereeSuccess(message): Action {
    console.log("addRefereeSuccess");
    return {
      type: IntakeApplicationActions.ADD_REFEREE_SUCCESS,
      payload: message
    };
  }

  static DELETE_REFEREE = '[Intake Application] Delete Referee';

  deleteReferee(intake, referee) {
    return {
      type: IntakeApplicationActions.DELETE_REFEREE,
      payload: {intake: intake, referee: referee}
    };
  }

  static DELETE_REFEREE_SUCCESS = '[Intake Application] Delete Referee Success';

  deleteRefereeSucces(message) {
    return {
      type: IntakeApplicationActions.DELETE_REFEREE_SUCCESS,
      payload: message
    };
  }

  static ADD_ADDRESS = '[Intake Application] Add Address';

  addAddress(intake, address) {
    return {
      type: IntakeApplicationActions.ADD_ADDRESS,
      payload: {intake: intake, address: address}
    };
  }

  static ADD_ADDRESS_SUCCESS = '[Intake Application] Add Address Success';

  addAddressSuccess(message) {
    return {
      type: IntakeApplicationActions.ADD_ADDRESS_SUCCESS,
      payload: message
    };
  }

  static DELETE_ADDRESS = '[Intake Application] Delete Address';

  deleteAddress(intake, address) {
    return {
      type: IntakeApplicationActions.DELETE_ADDRESS,
      payload: {intake: intake, address: address}
    };
  }

  static DELETE_ADDRESS_SUCCESS = '[Intake Application] Delete Address Success';

  deleteAddressSucces(message) {
    return {
      type: IntakeApplicationActions.DELETE_ADDRESS_SUCCESS,
      payload: message
    };
  }

  static ADD_SPM_RESULT = '[Intake Application] Add Spm Result';

  addSpmResult(intake, spmResult) {
    return {
      type: IntakeApplicationActions.ADD_SPM_RESULT,
      payload: {intake: intake, spmResult: spmResult}
    };
  }

  static ADD_SPM_RESULT_SUCCESS = '[Intake Application] Add Spm Result Success';

  addSpmResultSuccess(message) {
    return {
      type: IntakeApplicationActions.ADD_SPM_RESULT_SUCCESS,
      payload: message
    };
  }

  static DELETE_SPM_RESULT = '[Intake Application] Delete Spm Result';

  deleteSpmResult(intake, spmResult) {
    return {
      type: IntakeApplicationActions.DELETE_SPM_RESULT,
      payload: {intake: intake, spmResult: spmResult}
    };
  }

  static DELETE_SPM_RESULT_SUCCESS = '[Intake Application] Delete Spm Result Success';

  deleteSpmResultSucces(message) {
    return {
      type: IntakeApplicationActions.DELETE_SPM_RESULT_SUCCESS,
      payload: message
    };
  }
}
