import {Action} from '@ngrx/store';
import {IntakeTask} from "./intake-task.interface";
import {IntakeActions} from "./intake.action";

export type IntakeTaskListState = IntakeTask[];

const initialState: IntakeTaskListState = <IntakeTask[]>[];

export function intakeTaskListReducer(state = initialState, action: Action): IntakeTaskListState {
  switch (action.type) {
    case IntakeActions.FIND_ASSIGNED_INTAKE_TASKS_SUCCESS: {
      return action.payload;
    }
    case IntakeActions.FIND_POOLED_INTAKE_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
