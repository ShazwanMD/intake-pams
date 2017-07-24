import { IntakeTask } from '../../../shared/model/policy/intake-task.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-candidate-task-status',
  templateUrl: './candidate-task-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class CandidateTaskStatusComponent {
  @Input() intakeTask: IntakeTask;
}
