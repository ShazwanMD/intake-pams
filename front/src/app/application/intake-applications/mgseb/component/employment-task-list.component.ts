import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import { Employment } from "../../employment.interface";

@Component({
  selector: 'pams-employment-task-list',
  templateUrl: './employment-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EmploymentTaskListComponent {

  @Input() Employment: Employment[];
  @Output() view = new EventEmitter<Employment>();

  private columns: any[] = [
    {name: 'employer', label: 'Employer'},
    {name: 'designation', label: 'Designation'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''}
  ];
}
