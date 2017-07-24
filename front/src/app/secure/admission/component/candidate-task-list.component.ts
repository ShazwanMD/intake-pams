import { IntakeTask } from '../../../shared/model/policy/intake-task.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-candidate-task-list',
  templateUrl: './candidate-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CandidateTaskListComponent {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'projection', label: 'Projection'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

  @Input() intakeTasks: IntakeTask[];
  @Output() view = new EventEmitter<IntakeTask>();

}
