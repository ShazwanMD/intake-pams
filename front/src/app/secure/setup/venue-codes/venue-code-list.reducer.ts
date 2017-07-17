import {VenueCode} from './../../../shared/model/common/venue-code.interface';
import {Action} from '@ngrx/store';
import {SetupActions} from '../setup.action';


export type VenueCodeListState = VenueCode[];

const initialState: VenueCodeListState = <VenueCode[]>[];

export function venueCodeListReducer(state = initialState, action: Action): VenueCodeListState {
  switch (action.type) {
    case SetupActions.FIND_VENUE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
