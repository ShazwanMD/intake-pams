import {Action} from '@ngrx/store';
import {CommonActions} from '../common.action';
import {GraduateCenter} from '../../shared/model/common/graduate-center.interface';

export type GraduateCenterListState = GraduateCenter[];

const initialState: GraduateCenterListState = <GraduateCenter[]>[];

export function graduateCenterListReducer(state = initialState, action: Action): GraduateCenterListState {
  switch (action.type) {
    case CommonActions.FIND_GRADUATE_CENTERS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
