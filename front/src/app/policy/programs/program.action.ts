import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {Program} from "./program.interface";
import {ProgramOffering} from "./program-offering.interface";

@Injectable()
export class ProgramActions {

static FIND_PROGRAM_OFFERING_BY_CODE = '[Program] Find Program Offering';

  findProgramOfferingByCode(): Action {
    return {
      type: ProgramActions.FIND_PROGRAM_OFFERING_BY_CODE
    };
  }

  static FIND_PROGRAM_OFFERING_BY_CODE_SUCCESS = '[Program] Find Program Offering Success';

  findProgramOfferingByCodeSuccess(codes): Action {
    console.log("findBankCodesSuccess");
    return {
      type: ProgramActions.FIND_PROGRAM_OFFERING_BY_CODE_SUCCESS,
      payload: codes
    };
  }

static FIND_PROGRAM_OFFERING_BY_NAME = '[Program] Find Program Offering';

  findProgramOfferingByName(): Action {
    return {
      type: ProgramActions.FIND_PROGRAM_OFFERING_BY_NAME
    };
  }

  static FIND_PROGRAM_OFFERING_BY_NAME_SUCCESS = '[Program] Find Program Offering Success';

  findProgramOfferingByNameSuccess(codes): Action {
    console.log("findBankCodesSuccess");
    return {
      type: ProgramActions.FIND_PROGRAM_OFFERING_BY_NAME_SUCCESS,
      payload: codes
    };
  }

  static ADD_PROGRAM_OFFERING = '[Program] Add Program Offering';

  addProgramOffering(program:Program, programOffering: ProgramOffering) {
    return {
      type: ProgramActions.ADD_PROGRAM_OFFERING,
      payload:{program:program, programOffering:programOffering}
    };
  }

  static ADD_PROGRAM_OFFERING_SUCCESS = '[Program] Add Program Offering Success';

  addProgramOfferingSuccess(message) {
    return {
      type: ProgramActions.ADD_PROGRAM_OFFERING_SUCCESS,
      payload:message
    };
  }

  static DELETE_PROGRAM_OFFERING = '[Program] DELETE Program Offering';

  deleteProgramOffering(program:Program, programOffering: ProgramOffering) {
    return {
      type: ProgramActions.DELETE_PROGRAM_OFFERING,
      payload:{program:program, programOffering:programOffering}
    };
  }

  static DELETE_PROGRAM_OFFERING_SUCCESS = '[Program] Delete Program Offering Success';

  deleteProgramOfferingSuccess(program:Program, programOffering: ProgramOffering) {
    return {
      type: ProgramActions.DELETE_PROGRAM_OFFERING_SUCCESS,
      payload:program
    };
  }

  
}
