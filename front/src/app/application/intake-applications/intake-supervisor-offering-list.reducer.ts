import {Action} from '@ngrx/store';
import {SupervisorOffering} from "../../policy/intakes/supervisor-offering.interface";
import {IntakeApplicationActions} from "./intake-application.action";

export type IntakeSupervisorOfferingListState = SupervisorOffering[];

const initialState: IntakeSupervisorOfferingListState = <SupervisorOffering[]>[];

export function intakeSupervisorOfferingListReducer(state = initialState, action: Action): IntakeSupervisorOfferingListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_STUDY_MODE_OFFERINGS_BY_INTAKE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
