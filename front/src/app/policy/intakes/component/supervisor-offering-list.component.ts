import {Component, Input, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {SupervisorOffering} from "../supervisor-offering.interface";
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {MdDialogConfig, MdDialog, MdDialogRef, MdSnackBar} from "@angular/material";
import {SupervisorOfferingEditorDialog} from "../dialog/supervisor-offering-editor.dialog";

@Component({
  selector: 'pams-supervisor-offering-list',
  templateUrl: './supervisor-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SupervisorOfferingListComponent {

  @Input() intake: Intake;
  @Input() supervisorOfferings: SupervisorOffering[];
  private editorDialogRef: MdDialogRef<SupervisorOfferingEditorDialog>;

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  delete(supervisorOffering: SupervisorOffering): void {
    let snackBarRef = this.snackBar.open("Delete this supervisor offering?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.deleteSupervisorOffering(this.intake, supervisorOffering))
    });
  }


  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '80%';
    config.height = '30%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(SupervisorOfferingEditorDialog, config);
    this.editorDialogRef.componentInstance.intake = this.intake;
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("closeDialog");
      this.store.dispatch(this.actions.findStudyModeOfferings(this.intake));
    });
  }
}
