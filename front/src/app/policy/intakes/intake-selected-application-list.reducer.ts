import {Action} from '@ngrx/store';
import {IntakeActions} from "./intake.action";
import {IntakeApplication} from "../../application/intake-applications/intake-application.interface";

export type IntakeSelectedApplicationListState = IntakeApplication[];

const initialState: IntakeSelectedApplicationListState = <IntakeApplication[]>[];

export function intakeSelectedApplicationListReducer(state = initialState, action: Action): IntakeSelectedApplicationListState {
  switch (action.type) {
    case IntakeActions.FIND_SELECTED_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
