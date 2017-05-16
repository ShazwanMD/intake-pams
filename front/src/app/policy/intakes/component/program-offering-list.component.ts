import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {IntakeTask} from "../intake-task.interface";
import {ProgramOffering} from "../program-offering.interface";
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {MdDialogConfig, MdDialog, MdDialogRef} from "@angular/material";
import {ProgramOfferingEditorDialog} from "../dialog/program-offering-editor.dialog";
import { Observable } from "rxjs/Rx";

@Component({
  selector: 'pams-program-offering-list',
  templateUrl: './program-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramOfferingListComponent {

  @Input() intake: Intake;
  @Input() programOfferings: ProgramOffering[];

  private editorDialogRef: MdDialogRef<ProgramOfferingEditorDialog>;
  private INTAKE = "policyModuleState.intake".split(".");
  private intake$:Observable<Intake>;

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
          this.intake$ = this.store.select(...this.INTAKE);

  }

 

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(ProgramOfferingEditorDialog, config);
    this.editorDialogRef.componentInstance.intake = this.intake;

    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("closeDialog");
      // reload program offerings
      this.store.dispatch(this.actions.findProgramOfferings(this.intake));
    });
  }

}
