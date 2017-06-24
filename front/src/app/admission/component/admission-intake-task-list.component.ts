import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {IntakeTask} from '../../policy/intakes/intake-task.interface';

@Component({
  selector: 'pams-admission-intake-task-list',
  templateUrl: './admission-intake-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionIntakeTaskListComponent {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'candidateCount', label: 'Candidate Count'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

  @Input() intakeTasks: IntakeTask[];
  @Output() view = new EventEmitter<IntakeTask>();

}
