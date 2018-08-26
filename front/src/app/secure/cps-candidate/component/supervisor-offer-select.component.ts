import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import { SupervisorOffering } from './../../../shared/model/policy/supervisor-offering.interface';
import { ApplicationModuleState } from '../../application';
import { IntakeApplicationActions } from "../../application/intake-applications/intake-application.action";
import { Intake } from "../../../shared/model/policy/intake.interface";
import { ProgramCode } from "../../../shared/model/common/program-code.interface";
import { ProgramLevel } from "../../../shared/model/policy/program-level.interface";

@Component({
  selector: 'pams-supervisor-offer-select',
  templateUrl: './supervisor-offer-select.component.html',
  styleUrls: ['./supervisor-offer-select.component.scss'],
})
export class SupervisorOfferingAdmissionSelectComponent implements OnInit {

  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Input() programlevel: ProgramLevel;
  
  //private _intake:Intake;
  
  private SUPERVISOR_OFFERINGS: string[] = 'applicationModuleState.supervisorOfferings'.split('.');
  private supervisorOfferings$: Observable<SupervisorOffering[]>;

  constructor(private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,) {
      this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
  }

  ngOnInit() {
      //console.log("select ada " + this.intake.referenceNo)
      this.store.dispatch(this.actions.findSupervisorOfferingsByProgramLevel(this.programlevel));
  }

  selectChangeEvent(event: SupervisorOffering) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

