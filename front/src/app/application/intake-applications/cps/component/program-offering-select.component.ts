import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Store} from "@ngrx/store";
import {MdDialogConfig, MdDialog, MdDialogRef} from "@angular/material";
import { Observable } from "rxjs/Rx";
import {Intake} from "../../../../policy/intakes/intake.interface";
import {PolicyModuleState} from "../../../../policy/index";
import { IntakeActions } from "../../../../policy/intakes/intake.action";
import { ProgramOffering } from "../../../../policy/intakes/program-offering.interface";

@Component({
  selector: 'pams-program-offering-select',
  templateUrl: './program-offering-select.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramOfferingSelectComponent {

 // @Input() intake: Intake;
  //@Input() programOfferings: ProgramOffering[];

  @Input() placeholder: string;
  private PROGRAM_OFFERING = "policyModuleState.programOfferings".split(".");
  private programOfferings$:Observable<ProgramOffering>

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
          this.programOfferings$ = this.store.select(...this.PROGRAM_OFFERING);
  }

  ngOnInit() {
      this.programOfferings$.take(1).subscribe(intake => this.store.dispatch(this.actions.findProgramOfferings(intake)));
    }

}
