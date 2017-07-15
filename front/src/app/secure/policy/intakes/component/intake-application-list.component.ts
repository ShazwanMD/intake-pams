import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';

import {ActivatedRoute} from '@angular/router';
import {Intake} from '../../../../shared/model/policy/intake.interface';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {PolicyModuleState} from '../../index';
import {IntakeActions} from '../intake.action';

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
