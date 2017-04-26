import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {IntakeTask} from "../../policy/intakes/intake-task.interface";

@Component({
  selector: 'pams-intake-task-list',
  templateUrl: './intake-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeTaskListComponent {

  @Input() intakeTasks: IntakeTask[];
  @Output() view = new EventEmitter<IntakeTask>();

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'candidateCount', label: 'Candidate Count'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''}
  ];
}
