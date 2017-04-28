import {Action} from '@ngrx/store';
import {Intake} from "../../policy/intakes/intake.interface";
import {IntakeApplicationActions} from "./intake-application.action";

export type IntakeState = Intake;

const initialState: IntakeState = <IntakeState>{};

export function intakeReducer(state = initialState, action: Action): IntakeState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_INTAKES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
