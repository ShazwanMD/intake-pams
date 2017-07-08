import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {RaceCode} from '../../../../shared/model/common/race-code.interface';

export type RaceCodeListState = RaceCode[];

const initialState: RaceCodeListState = <RaceCode[]>[];

export function raceCodeListReducer(state = initialState, action: Action): RaceCodeListState {
  switch (action.type) {
    case SetupActions.FIND_RACE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
