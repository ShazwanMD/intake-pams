import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {SupervisorOffering} from '../../../shared/model/policy/supervisor-offering.interface';

export type SupervisorOfferingListState = SupervisorOffering[];

const initialState: SupervisorOfferingListState = <SupervisorOffering[]>[];

export function supervisorOfferingListReducer(state = initialState, action: Action): SupervisorOfferingListState {
  switch (action.type) {
    case IntakeActions.FIND_SUPERVISOR_OFFERINGS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
