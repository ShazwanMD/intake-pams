import {Component, Input, ChangeDetectionStrategy, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs/Rx";
import {Intake} from "../intake.interface";
import {PolicyModuleState} from "../../index";
import {IntakeActions} from "../intake.action";
import {ProgramOffering} from "../program-offering.interface";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'pams-program-offering-select',
  templateUrl: './program-offering-select.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramOfferingSelectComponent implements OnInit {

  @Input() intake: Intake;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  private PROGRAM_OFFERING = "policyModuleState.programOfferings".split(".");
  private programOfferings$: Observable<ProgramOffering>;

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions) {
    this.programOfferings$ = this.store.select(...this.PROGRAM_OFFERING);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramOfferings(this.intake));
  }

  selectChangeEvent(event: ProgramOffering) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }

}
