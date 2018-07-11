import {Attachment} from '../../../shared/model/application/attachment.interface';
import {Action} from '@ngrx/store';
import {IntakeApplicationActions} from './intake-application.action';

export type AttachmentState = Attachment[];

const initialState: AttachmentState = <Attachment[]>[];

export function attachmentReducer(state = initialState, action: Action): AttachmentState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_ATTACHMENTS_BY_TYPE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
