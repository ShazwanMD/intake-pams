import {Action} from '@ngrx/store';
import {IntakeActions} from "./intake.action";
import {IntakeTask} from "./intake-task.interface";

export type IntakeTaskState = IntakeTask;

const initialState: IntakeTaskState = <IntakeTaskState>{};

export function intakeTaskReducer(state = initialState, action: Action): IntakeTaskState {
  switch (action.type) {
    case IntakeActions.FIND_INTAKE_TASK_BY_TASK_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
