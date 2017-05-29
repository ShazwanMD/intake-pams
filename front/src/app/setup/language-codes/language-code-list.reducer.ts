import { LanguageCode } from './../../common/language-codes/language-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from "../setup.action";

export type LanguageCodeListState = LanguageCode[];

const initialState: LanguageCodeListState = <LanguageCode[]>[];

export function languageCodeListReducer(state = initialState, action: Action): LanguageCodeListState {
  switch (action.type) {
    case SetupActions.FIND_LANGUAGE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
