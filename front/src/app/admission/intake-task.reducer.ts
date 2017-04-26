import {Action} from '@ngrx/store';
import {IntakeTask} from "../policy/intakes/intake-task.interface";
import {AdmissionActions} from "./admission.action";

export type IntakeTaskState = IntakeTask;

const initialState: IntakeTaskState = <IntakeTaskState>{};

export function intakeTaskReducer(state = initialState, action: Action): IntakeTaskState {
  switch (action.type) {
    case AdmissionActions.FIND_INTAKE_TASK_BY_TASK_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
