import { Pipe, PipeTransform } from '@angular/core';
import { FlowState } from "./flow-state.enum";

@Pipe({ name: 'flowStatePipe' })
export class FlowStatePipe implements PipeTransform {

  transform(value: FlowState): any {
    if (!value) {
      return value;
    }
    switch (FlowState[value.toString()]) {
      case FlowState.DRAFTED: {
        return 'New';
      }
      case FlowState.VERIFIED: {
        return 'Verify';
      }
      case FlowState.PUBLISHED: {
        return 'Publish';
      }
      case FlowState.EVALUATED: {
        return 'Evaluate';
      }
      case FlowState.COMPLETED: {
        return 'Final';
      }
      case FlowState.SELECTED: {
        return 'Select';
      }
      case FlowState.APPROVED: {
        return 'Recommend';
      }
      case FlowState.UPPER_APPROVED: {
        return 'Endorse';
      }
      case FlowState.OFFERED: {
        return 'Offer';
      }

      case FlowState.REGISTERED: {
        return 'Register';
      }

      default: {
        return value;
      }
    }
  }
}