import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {IntakeTask} from "../intake-task.interface";
import {StudyModeOffering} from "../study-mode-offering.interface";
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";
import { MdDialogConfig, MdDialog, MdDialogRef, MdSnackBar } from "@angular/material";
import {StudyModeOfferingEditorDialog} from "../dialog/study-mode-offering-editor.dialog";

@Component({
  selector: 'pams-study-mode-offering-list',
  templateUrl: './study-mode-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudyModeOfferingListComponent {

  @Input() intake: Intake;
  @Input() studyModeOfferings: StudyModeOffering[];
  private editorDialogRef: MdDialogRef<StudyModeOfferingEditorDialog>;

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }
  
  delete(studyModeOffering: StudyModeOffering): void {
    let snackBarRef = this.snackBar.open("Confirm to delete this studymode offering?", "Yes");
    snackBarRef.afterDismissed().subscribe(() => {
    console.log("delete program offering :"+studyModeOffering.id);
    this.store.dispatch(this.actions.deleteStudyModeOffering(this.intake, studyModeOffering))
    });
  }

  showDialog(): void {
    let snackBarRef = this.snackBar.open("Add new study mode offering?", "Yes");
    snackBarRef.afterDismissed().subscribe(() => {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(StudyModeOfferingEditorDialog, config);
    this.editorDialogRef.componentInstance.intake = this.intake;

    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("closeDialog");
      // reload studyMode offerings
      this.store.dispatch(this.actions.findStudyModeOfferings(this.intake));
    });
    });
  }

}
