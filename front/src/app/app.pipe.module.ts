import { CandidateFlowStatePipe } from './core/candidate-flow-state.pipe';
import {NgModule}      from '@angular/core';
import {FlowStatePipe} from './core/flow-state.pipe';
import {BidStatusPipe} from './secure/application/intake-applications/bid-status.pipe';

@NgModule({
  imports: [],
  declarations: [
    FlowStatePipe,
    BidStatusPipe,
    CandidateFlowStatePipe,
  ],
  exports: [
    FlowStatePipe,
    BidStatusPipe,
    CandidateFlowStatePipe,
  ],
})

export class PipeModule {

  static forRoot() {
    return {
      ngModule: PipeModule,
      providers: [],
    };
  }
}
