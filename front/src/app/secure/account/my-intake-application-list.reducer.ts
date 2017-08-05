import { MyIntakeApplication } from './../../shared/model/application/my-intake-application.interface';
import {Action} from '@ngrx/store';
import {AccountActions} from './account.action';

export type MyIntakeApplicationListState = MyIntakeApplication[];

const initialState: MyIntakeApplicationListState = <MyIntakeApplication[]>[];

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