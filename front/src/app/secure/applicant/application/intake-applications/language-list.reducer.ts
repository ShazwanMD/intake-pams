import {Action} from '@ngrx/store';
import {Language} from './language.interface';
import {IntakeApplicationActions} from './intake-application.action';

export type LanguageListState = Language[];

const initialState: LanguageListState = <Language[]>[];

export function languageListReducer(state = initialState, action: Action): LanguageListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_LANGUAGES_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
