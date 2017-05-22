import {Component, Input, ChangeDetectionStrategy, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs/Rx";
import {FormControl} from "@angular/forms";
import {IntakeApplication} from "../intake-application.interface";
import {ProgramOffering} from "../../../policy/intakes/program-offering.interface";
import {ApplicationModuleState} from "../../index";
import {IntakeApplicationActions} from "../intake-application.action";

@Component({
  selector: 'pams-intake-program-offering-select',
  templateUrl: './intake-program-offering-select.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeProgramOfferingSelectComponent implements OnInit {

  @Input() intakeApplication: IntakeApplication;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  private PROGRAM_OFFERING = "applicationModuleState.programOfferings".split(".");
  private programOfferings$: Observable<ProgramOffering>;

  constructor(private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions) {
    this.programOfferings$ = this.store.select(...this.PROGRAM_OFFERING);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramOfferingsByIntakeApplication(this.intakeApplication));
  }

  selectChangeEvent(event: ProgramOffering) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }

}
