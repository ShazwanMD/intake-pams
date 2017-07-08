import {Action} from '@ngrx/store';
import {CenterActions} from './center.action';
import {GraduateCenter} from '../shared/model/common/graduate-center.interface';

export type GraduateCenterState = GraduateCenter;

const initialState: GraduateCenterState = <GraduateCenter>{};

export function graduateCenterReducer(state = initialState, action: Action): GraduateCenter {
  switch (action.type) {
    case CenterActions.FIND_GRADUATE_CENTER_BY_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
