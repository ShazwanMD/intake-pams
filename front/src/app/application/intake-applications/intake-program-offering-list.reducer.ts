import {Action} from '@ngrx/store';
import {ProgramOffering} from "../../policy/intakes/program-offering.interface";
import {IntakeApplicationActions} from "./intake-application.action";

export type IntakeProgramOfferingListState = ProgramOffering[];

const initialState: IntakeProgramOfferingListState = <ProgramOffering[]>[];

export function intakeProgramOfferingListReducer(state = initialState, action: Action): IntakeProgramOfferingListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_PROGRAM_OFFERINGS_BY_INTAKE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
