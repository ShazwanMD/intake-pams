import {Action} from '@ngrx/store';
import {Intake} from "../../policy/intakes/intake.interface";
import {IntakeApplicationActions} from "./intake-application.action";
import {IntakeApplication} from "./intake-application.interface";

export type IntakeState = Intake;

const initialState: IntakeState = <IntakeState>{};

export function intakeReducer(state = initialState, action: Action): IntakeState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_INTAKE_BY_REFERENCE_NO_SUCCESS: {
      return action.payload;
    }
    case IntakeApplicationActions.FIND_INTAKE_APPLICATION_BY_REFERENCE_NO_SUCCESS: {
      console.log("FIND_INTAKE_APPLICATION_BY_REFERENCE_NO_SUCCESS " + JSON.stringify(action.payload.intake));
      return action.payload.intake;
    }
    default: {
      return state;
    }
  }
}
