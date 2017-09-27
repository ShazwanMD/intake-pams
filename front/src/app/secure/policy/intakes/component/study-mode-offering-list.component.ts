import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {IntakeActions} from '../intake.action';
import {PolicyModuleState} from '../../index';
import {Store} from '@ngrx/store';
import { MdDialogConfig, MdDialog, MdDialogRef, MdSnackBar } from '@angular/material';
import {StudyModeOfferingEditorDialog} from '../dialog/study-mode-offering-editor.dialog';
import {Intake} from '../../../../shared/model/policy/intake.interface';
import {StudyModeOffering} from '../../../../shared/model/policy/study-mode-offering.interface';

@Component({
  selector: 'pams-study-mode-offering-list',
  templateUrl: './study-mode-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudyModeOfferingListComponent {

  private editorDialogRef: MdDialogRef<StudyModeOfferingEditorDialog>;
  @Input() intake: Intake;
  @Input() studyModeOfferings: StudyModeOffering[];

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  delete(studyModeOffering: StudyModeOffering): void {
    if (confirm('Confirm to delete this studymode offering?')) {
    // let snackBarRef = this.snackBar.open('Confirm to delete this studymode offering?', 'Ok');
    // snackBarRef.afterDismissed().subscribe(() => {
    console.log('delete program offering :' + studyModeOffering.id);
    this.store.dispatch(this.actions.deleteStudyModeOffering(this.intake, studyModeOffering));
    };
  }

  showDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(StudyModeOfferingEditorDialog, config);
    this.editorDialogRef.componentInstance.intake = this.intake;

    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('closeDialog');
      // reload studyMode offerings
      this.store.dispatch(this.actions.findStudyModeOfferings(this.intake));
    });
  }

}
