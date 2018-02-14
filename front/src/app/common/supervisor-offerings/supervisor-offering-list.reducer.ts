import {Action} from '@ngrx/store';
import {CommonActions} from '../common.action';
import { SupervisorOffering } from '../../shared/model/common/supervisor-offering.interface';

export type SupervisorOfferingListState = SupervisorOffering[];

const initialState: SupervisorOfferingListState = <SupervisorOffering[]>[];

export function supervisorOfferingListReducer(state = initialState, action: Action): SupervisorOfferingListState {
  switch (action.type) {
    case CommonActions.FIND_SUPERVISOR_OFFERINGS:{
      return action.payload;
    }
    case CommonActions.FIND_SUPERVISOR_OFFERINGS_BY_PROGRAM_LEVEL_SUCCESS: {
        return action.payload;
      }
    default: {
      return state;
    }
  }
}
