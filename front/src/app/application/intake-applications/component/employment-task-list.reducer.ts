import {Action} from '@ngrx/store';
import { Employment } from "../employment.interface";
import { IntakeApplicationActions } from "../intake-application.action";

export type EmploymentListState = Employment[];

const initialState: EmploymentListState = <Employment[]>[];

export function employmentListReducer(state = initialState, action: Action): EmploymentListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_EMPLOYMENTS_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
