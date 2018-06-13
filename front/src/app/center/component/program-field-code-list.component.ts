import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {ProgramFieldCode} from '../../shared/model/common/program-field-code.interface';

@Component({
  selector: 'pams-program-field-code-list',
  templateUrl: './program-field-code-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramFieldCodeListComponent {

  @Input() programFieldCodes: ProgramFieldCode[];
  @Output() view = new EventEmitter<ProgramFieldCode>();
}
