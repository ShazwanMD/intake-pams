import {Action} from '@ngrx/store';
import {StudyModeOffering} from "../../policy/intakes/study-mode-offering.interface";
import {IntakeApplicationActions} from "./intake-application.action";

export type IntakeStudyModeOfferingListState = StudyModeOffering[];

const initialState: IntakeStudyModeOfferingListState = <StudyModeOffering[]>[];

export function intakeStudyModeOfferingListReducer(state = initialState, action: Action): IntakeStudyModeOfferingListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_STUDY_MODE_OFFERINGS_BY_INTAKE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
