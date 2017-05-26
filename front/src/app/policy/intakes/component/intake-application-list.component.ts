import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";

import {ActivatedRoute} from "@angular/router";
import {IntakeApplication} from "../../../application/intake-applications/intake-application.interface";

@Component({
  selector: 'pams-intake-application-list',
  templateUrl: './intake-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeApplicationListComponent {

  @Input() intake: Intake;
  @Input() intakeApplications: IntakeApplication;

  constructor(private store: Store<PolicyModuleState>,
              private route: ActivatedRoute,
              private actions: IntakeActions) {
  }

  ngOnInit(): void {
  }

  filter(): void {
  }
}
