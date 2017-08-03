import {Action} from '@ngrx/store';
import {AccountActions} from './account.action';
import {IntakeApplication} from '../../shared/model/application/intake-application.interface';

export type MyIntakeApplicationListState = IntakeApplication[];

const initialState: MyIntakeApplicationListState = <IntakeApplication[]>[];

export function myIntakeApplicationListReducer(state = initialState, action: Action): MyIntakeApplicationListState {
  switch (action.type) {
    case AccountActions.FIND_MY_INTAKE_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}