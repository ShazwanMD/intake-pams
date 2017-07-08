import {Action} from '@ngrx/store';
import {Intake} from '../../../../policy/intakes/intake.interface';
import {IntakeApplicationActions} from './intake-application.action';

export type IntakeListState = Intake[];

const initialState: IntakeListState = <Intake[]>[];

export function intakeListReducer(state = initialState, action: Action): IntakeListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_INTAKES_SUCCESS: {
      return action.payload;
    }
    case IntakeApplicationActions.FIND_PUBLISHED_INTAKES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
