import {Action} from '@ngrx/store';
import {AccountActions} from './account.action';
import {IntakeApplication} from '../../shared/model/application/intake-application.interface';

export type IntakeApplicationListState = IntakeApplication[];

const initialState: IntakeApplicationListState = <IntakeApplication[]>[];

export function intakeApplicationListReducer(state = initialState, action: Action): IntakeApplicationListState {
  switch (action.type) {
    case AccountActions.FIND_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function draftedIntakeApplicationListReducer(state = initialState, action: Action): IntakeApplicationListState {
  switch (action.type) {
    case AccountActions.FIND_DRAFTED_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function submittedIntakeApplicationListReducer(state = initialState, action: Action): IntakeApplicationListState {
  switch (action.type) {
    case AccountActions.FIND_SUBMITTED_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
