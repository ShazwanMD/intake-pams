import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {IntakeSessionActions} from '../intake-session.action';
import {PolicyModuleState} from '../../index';
import {IntakeSession} from "../../../../../shared/model/policy/intake-session.interface";

@Component({
  selector: 'pams-intake-session-select',
  templateUrl: './intake-session-select.component.html',
  styleUrls: ['./intake-session-select.scss'],
})
export class IntakeSessionSelectComponent implements OnInit {

  private INTAKE_SESSIONS = 'policyModuleState.intakeSessions'.split('.');
  private intakeSessions$: Observable<IntakeSession[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeSessionActions) {
    this.intakeSessions$ = this.store.select(...this.INTAKE_SESSIONS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findIntakeSessions());
  }

  selectChangeEvent(event: IntakeSession) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

