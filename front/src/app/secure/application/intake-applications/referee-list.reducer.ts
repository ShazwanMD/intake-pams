import {Referee} from '../../../shared/model/application/referee.interface';
import {Action} from '@ngrx/store';
import {IntakeApplicationActions} from './intake-application.action';

export type RefereeListState = Referee[];

const initialState: RefereeListState = <Referee[]>[];

export function refereeListReducer(state = initialState, action: Action): RefereeListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_REFEREES_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
