import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {SupervisorCode} from '../../../shared/model/common/supervisor-code.interface';

@Component({
  selector: 'pams-supervisor-code-select',
  templateUrl: './supervisor-code-select.component.html',
  styleUrls: ['./supervisor-code-select.scss'],
})
export class SupervisorCodeSelectComponent implements OnInit {

  private SUPERVISOR_CODES: string[] = 'commonModuleState.supervisorCodes'.split('.');
  private supervisorCodes$: Observable<SupervisorCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.supervisorCodes$ = this.store.select(...this.SUPERVISOR_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findSupervisorCodes());
  }

  selectChangeEvent(event: SupervisorCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
