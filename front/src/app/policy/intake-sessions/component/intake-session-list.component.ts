import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {IntakeSession} from "../intake-session.interface";

@Component({
  selector: 'pams-intake-session-list',
  templateUrl: './intake-session-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeSessionListComponent {

  @Input() intakeSessions: IntakeSession[];
  @Output() view = new EventEmitter<IntakeSession>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'Description (MS)'},
    {name: 'descriptionEn', label: 'Description (EN)'},
    {name: 'year', label: 'Year'},
    {name: 'current', label: 'Current'},
    {name: 'action', label: ''}
  ];
}
