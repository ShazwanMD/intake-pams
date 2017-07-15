import {Action} from '@ngrx/store';
import {IntakeActions} from './intake.action';
import {StudyModeOffering} from '../../../shared/model/policy/study-mode-offering.interface';

export type StudyModeOfferingListState = StudyModeOffering[];

const initialState: StudyModeOfferingListState = <StudyModeOffering[]>[];

export function studyModeOfferingListReducer(state = initialState, action: Action): StudyModeOfferingListState {
  switch (action.type) {
    case IntakeActions.FIND_STUDY_MODE_OFFERINGS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
