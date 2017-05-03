import {Component, Input} from "@angular/core";
import {IntakeSession} from "../../policy/intake-sessions/intake-session.interface";
@Component({
  selector: 'pams-intake-session-list',
  templateUrl: './intake-session-list.component.html',
})

export class IntakeSessionListComponent {

  @Input() intakeSessions: IntakeSession[];


}
