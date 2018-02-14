import { IntakeApplicationActions } from './../../secure/application/intake-applications/intake-application.action';
import {Action} from '@ngrx/store';
import { SupervisorOffering } from '../../shared/model/common/supervisor-offering.interface';
export type SupervisorOfferingListState = SupervisorOffering[];
const initialState: SupervisorOfferingListState = <SupervisorOffering[]>[];
export function supervisorOfferingListReducer(state = initialState, action: Action): SupervisorOfferingListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_SUPERVISOR_OFFERINGS_BY_PROGRAM_LEVEL_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}