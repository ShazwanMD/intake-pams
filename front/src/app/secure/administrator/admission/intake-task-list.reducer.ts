import {Action} from '@ngrx/store';
import {AdmissionActions} from './admission.action';
import {IntakeTask} from '../../../shared/model/policy/intake-task.interface';

export type IntakeTaskListState = IntakeTask[];

const initialState: IntakeTaskListState = <IntakeTask[]>[];

export function intakeTaskListReducer(state = initialState, action: Action): IntakeTaskListState {
  switch (action.type) {
    case AdmissionActions.FIND_ASSIGNED_INTAKE_TASKS_SUCCESS: {
      return action.payload;
    }
    case AdmissionActions.FIND_POOLED_INTAKE_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
