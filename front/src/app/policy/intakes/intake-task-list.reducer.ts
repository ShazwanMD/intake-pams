import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';

export type IntakeTaskListState = IntakeTask[];

const initialState: IntakeTaskListState = <IntakeTask[]>[];

export function assignedIntakeTaskListReducer(state = initialState, action: Action): IntakeTaskListState {
  switch (action.type) {
    case IntakeActions.FIND_ASSIGNED_INTAKE_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
export function pooledIntakeTaskListReducer(state = initialState, action: Action): IntakeTaskListState {
  switch (action.type) {
    case IntakeActions.FIND_POOLED_INTAKE_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
