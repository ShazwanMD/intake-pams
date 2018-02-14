import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {ProgramLevel} from '../../../shared/model/policy/program-level.interface';
import { SupervisorOffering } from '../../../shared/model/policy/supervisor-offering.interface';

@Component({
  selector: 'pams-supervisor-offering-select',
  templateUrl: './supervisor-offering-select.component.html',
  styleUrls: ['./supervisor-offering-select.scss'],
})
export class SupervisorOfferingSelectComponent implements OnInit {

  private SUPERVISOR_OFFERINGS: string[] = 'commonModuleState.supervisorOfferings'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Input() supervisorOffering: SupervisorOffering;
   @Input() programLevel: ProgramLevel;
  supervisorOfferings$: Observable<SupervisorOffering[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findSupervisorOfferingsByProgramLevel(this.programLevel.code));
  }

  // ngOnInit() {
  //   this.store.dispatch(this.actions.findSupervisorOfferingsByProgramLevel(this.supervisorOffering.programLevel));
  // }

  selectChangeEvent(event: SupervisorOffering) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
