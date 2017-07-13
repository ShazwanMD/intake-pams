import {Action} from '@ngrx/store';
import {AdmissionActions} from './admission.action';
import {IntakeTask} from '../../../shared/model/policy/intake-task.interface';

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
