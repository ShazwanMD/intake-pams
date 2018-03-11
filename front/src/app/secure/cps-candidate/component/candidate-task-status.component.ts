import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import { Candidate } from "../../../shared/model/admission/candidate.interface";

@Component({
  selector: 'pams-candidate-task-status',
  templateUrl: './candidate-task-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class CandidateTaskStatusComponent {
  @Input() candidate: Candidate;
}
