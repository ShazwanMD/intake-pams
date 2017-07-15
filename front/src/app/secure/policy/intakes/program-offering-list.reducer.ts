import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {ProgramOffering} from '../../../shared/model/policy/program-offering.interface';

export type ProgramOfferingListState = ProgramOffering[];

const initialState: ProgramOfferingListState = <ProgramOffering[]>[];

export function programOfferingListReducer(state = initialState, action: Action): ProgramOfferingListState {
  switch (action.type) {
    case IntakeActions.FIND_PROGRAM_OFFERINGS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
