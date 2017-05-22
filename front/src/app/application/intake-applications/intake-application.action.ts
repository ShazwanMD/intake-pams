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
    return {
      type: IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO,
      payload: referenceNo
    };
  }

  static FIND_INTAKE_BY_REFERENCE_NO_SUCCESS = '[Intake] Find Intake By Reference No Success';

  findIntakeByReferenceNoSuccess(intake): Action {
    console.log("findIntakeSuccess");
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
    console.log("findProgramOfferingsByIntakeSuccess");
    return {
      type: IntakeApplicationActions.FIND_PROGRAM_OFFERINGS_BY_INTAKE_APPLICATION_SUCCESS,
      payload: offerings
    };
  }


  // ====================================================================================================
  // INTAKE APPLICATION
  // ====================================================================================================

  static APPLY_INTAKE_CPS = '[Intake Application] Apply Intake Cps';

  applyIntakeCps(intake): Action {
    return {
      type: IntakeApplicationActions.APPLY_INTAKE_CPS,
      payload: intake
    };
  }

  static APPLY_INTAKE_CPS_SUCCESS = '[Intake Application] Apply Intake Cps Success ';

  applyIntakeCpsSuccess(referenceNo): Action {
    return {
      type: IntakeApplicationActions.APPLY_INTAKE_CPS_SUCCESS,
      payload: referenceNo
    };
  }

  static APPLY_INTAKE_MGSEB = '[Intake Application] Apply Intake Mgseb';

  applyIntakeMgseb(intake): Action {
    return {
      type: IntakeApplicationActions.APPLY_INTAKE_MGSEB,
      payload: intake
    };
  }

  static APPLY_INTAKE_MGSEB_SUCCESS = '[Intake Application] Apply Intake Mgseb Success ';

  applyIntakeMgsebSuccess(referenceNo): Action {
    return {
      type: IntakeApplicationActions.APPLY_INTAKE_MGSEB_SUCCESS,
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

  static FIND_EDUCATIONS__BY_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Find Educations Success';

  findEducationsByIntakeApplicationSuccess(educations): Action {
    console.log("findEducationsSuccess");
    return {
      type: IntakeApplicationActions.FIND_EDUCATIONS__BY_INTAKE_APPLICATION_SUCCESS,
      payload: educations
    };
  }


  static FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION = '[Intake Application] Find Employments';

  findEmploymentsByIntakeApplication(application): Action {
    return {
      type: IntakeApplicationActions.FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION,
      payload: application
    };
  }

  static FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION_SUCCESS = '[Intake Application] Find Employments Success';

  findEmploymentsByIntakeApplicationSuccess(employments): Action {
    console.log("findEmploymentsSuccess");
    return {
      type: IntakeApplicationActions.FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION_SUCCESS,
      payload: employments
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

  findAddressesSuccessByIntakeApplication(addresss): Action {
    console.log("findAddressesSuccess");
    return {
      type: IntakeApplicationActions.FIND_ADDRESSES_BY_INTAKE_APPLICATION_SUCCESS,
      payload: addresss
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
    return {
      type: IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO,
      payload: referenceNo
    };
  }

  static FIND_INTAKE_APPLICATION_BY_REFERENCE_NO_SUCCESS = '[Intake Application] Find Intake Application By Reference No Success';

  findIntakeApplicationByReferenceNoSuccess(application): Action {
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

  updateIntakeSuccess(application): Action {
    return {
      type: IntakeApplicationActions.UPDATE_INTAKE_APPLICATION_SUCCESS,
      payload: application
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

  static ADD_EMPLOYMENT = '[Intake Application] Add Employment';

  addEmployment(intake, employment) {
    return {
      type: IntakeApplicationActions.ADD_EMPLOYMENT,
      payload: {intake: intake, employment: employment}
    };
  }

  static ADD_EMPLOYMENT_SUCCESS = '[Intake Application] Add Employment Success';

  addEmploymentSuccess(message) {
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
