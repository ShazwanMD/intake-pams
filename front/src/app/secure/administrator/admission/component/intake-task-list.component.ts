import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {IntakeTask} from '../../../../shared/model/policy/intake-task.interface';

@Component({
  selector: 'pams-intake-task-list',
  templateUrl: './intake-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeTaskListComponent {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'candidateCount', label: 'Candidate Count'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

  @Input() intakeTasks: IntakeTask[];
  @Output() view: EventEmitter<IntakeTask> = new EventEmitter<IntakeTask>();

}
