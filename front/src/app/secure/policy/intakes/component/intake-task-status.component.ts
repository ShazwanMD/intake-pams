import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {IntakeTask} from '../../../../shared/model/policy/intake-task.interface';

@Component({
  selector: 'pams-intake-task-status',
  templateUrl: './intake-task-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class IntakeTaskStatusComponent {
  @Input() intakeTask: IntakeTask;
}
