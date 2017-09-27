import { Intake } from './../../../../shared/model/policy/intake.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';


@Component({
  selector: 'pams-intake-status',
  templateUrl: './intake-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class IntakeStatusComponent {
  @Input() intake: Intake;
}
