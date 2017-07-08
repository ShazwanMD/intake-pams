import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {ProgramCode} from '../../shared/model/common/program-code.interface';

@Component({
  selector: 'pams-program-code-list',
  templateUrl: './program-code-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramCodeListComponent {

  @Input() programCodes: ProgramCode[];
  @Output() view = new EventEmitter<ProgramCode>();
}
