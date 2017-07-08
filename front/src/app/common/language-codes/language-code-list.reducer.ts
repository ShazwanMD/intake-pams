import {Action} from '@ngrx/store';
import {CommonActions} from '../common.action';
import {LanguageCode} from '../../shared/model/common/language-code.interface';

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
