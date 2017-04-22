import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {IntakeTask} from "../intake-task.interface";
import {SupervisorOffering} from "../supervisor-offering.interface";
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";

@Component({
  selector: 'pams-supervisor-offering-list',
  templateUrl: './supervisor-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SupervisorOfferingListComponent {

  @Input() intake: Intake;
  @Input() supervisorOfferings: SupervisorOffering[];

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,) {
  }

  add(supervisorOffering: SupervisorOffering) {
    this.store.dispatch(this.actions.addSupervisorOffering(this.intake, supervisorOffering));
  }

  delete(supervisorOffering: SupervisorOffering) {
    this.store.dispatch(this.actions.deleteSupervisorOffering(this.intake, supervisorOffering));
  }
}
