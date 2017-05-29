import {Action} from '@ngrx/store';
import {LanguageCode} from "./language-code.interface";
import {CommonActions} from "../common.action";

export type LanguageCodeListState = LanguageCode[];

const initialState: LanguageCodeListState = <LanguageCode[]>[];

export function languageCodeListReducer(state = initialState, action: Action): LanguageCodeListState {
  switch (action.type) {
    case CommonActions.FIND_LANGUAGE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
