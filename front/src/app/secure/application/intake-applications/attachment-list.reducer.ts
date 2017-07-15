import {Attachment} from '../../../shared/model/application/attachment.interface';
import {Action} from '@ngrx/store';
import {IntakeApplicationActions} from './intake-application.action';

export type AttachmentListState = Attachment[];

const initialState: AttachmentListState = <Attachment[]>[];

export function attachmentListReducer(state = initialState, action: Action): AttachmentListState {
  switch (action.type) {
    case IntakeApplicationActions.FIND_ATTACHMENTS_BY_INTAKE_APPLICATION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
