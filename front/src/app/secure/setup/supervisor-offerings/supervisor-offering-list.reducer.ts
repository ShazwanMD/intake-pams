import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SupervisorOffering} from '../../../shared/model/common/supervisor-offering.interface';

export type SupervisorOfferingListState = SupervisorOffering[];

const initialState: SupervisorOfferingListState = <SupervisorOffering[]>[];

export function supervisorOfferingListReducer(state = initialState, action: Action): SupervisorOfferingListState {
  switch (action.type) {
    case SetupActions.FIND_SUPERVISOR_OFFERINGS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
