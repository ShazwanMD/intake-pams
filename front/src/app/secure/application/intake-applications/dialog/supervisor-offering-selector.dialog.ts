import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import { SupervisorOffering } from '../../../../shared/model/policy/supervisor-offering.interface';
import { CommonActions } from '../../../../common/common.action';
import { CommonModuleState } from '../../../../common/index';
import { ProgramLevel } from '../../../../shared/model/policy/program-level.interface';

@Component({
  selector: 'pams-supervisor-offering-selector',
  templateUrl: './supervisor-offering-selector.dialog.html',
})
export class SupervisorOfferingSelectorDialog implements OnInit {

  private SUPERVISOR_OFFERINGS: string[] = 'commonModuleState.supervisorOfferings'.split('.');
  private supervisorOfferings$: Observable<SupervisorOffering[]>;

  @Input() programLevel: ProgramLevel;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findSupervisorOfferingsByProgramLevel(this.programLevel));
  }

  selectChangeEvent(event: SupervisorOffering) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

