import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SupervisorCode} from '../../../../shared/model/common/supervisor-code.interface';

export type SupervisorCodeListState = SupervisorCode[];

const initialState: SupervisorCodeListState = <SupervisorCode[]>[];

export function supervisorCodeListReducer(state = initialState, action: Action): SupervisorCodeListState {
  switch (action.type) {
    case SetupActions.FIND_SUPERVISOR_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
