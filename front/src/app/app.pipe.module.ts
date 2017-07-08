import { NgModule }      from '@angular/core';
import {FlowStatePipe} from "./core/flow-state.pipe";
import {BidStatusPipe} from "./secure/applicant/application/intake-applications/bid-status.pipe";

@NgModule({
    imports:        [],
    declarations:   [
        FlowStatePipe,
        BidStatusPipe
    ],
    exports:        [
        FlowStatePipe,
        BidStatusPipe
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
