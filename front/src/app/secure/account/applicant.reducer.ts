import { Applicant } from '../administrator/identity/applicant.interface';
import {Action} from '@ngrx/store';
import {Intake} from '../../shared/model/policy/intake.interface';
import {AccountActions} from './account.action';

export type ApplicantState = Applicant;

const initialState: ApplicantState = <Applicant>{};

export function applicantReducer(state = initialState, action: Action): ApplicantState {
  switch (action.type) {
    case AccountActions.FIND_APPLICANT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
