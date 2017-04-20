import {Action} from '@ngrx/store';
import {CentreActions} from "./centre.action";
import {FacultyCode} from "../common/faculty-code.interface";
import {GraduateCentre} from "../common/graduate-centre.interface";

export type GraduateCentreState = GraduateCentre;

const initialState: GraduateCentreState = <GraduateCentre>{};

export function graduateCentreReducer(state = initialState, action: Action): GraduateCentre {
  switch (action.type) {
    case CentreActions.FIND_GRADUATE_CENTRE_BY_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
