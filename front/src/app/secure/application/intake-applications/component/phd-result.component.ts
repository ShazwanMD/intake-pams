import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from '../intake-application.action';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {Result} from '../../../../shared/model/application/result.interface';
import { PhdResultEditorDialog } from '../dialog/phd-result-editor.dialog';

@Component({
  selector: 'pams-phd-result',
  templateUrl: './phd-result.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class PhdResultComponent {

  private editorDialogRef: MdDialogRef<PhdResultEditorDialog>;
  @Input() result: Result;
  @Input() intakeApplication: IntakeApplication;

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
  }

  delete(): void {
    this.store.dispatch(this.actions.deleteResult(this.intakeApplication, this.result));
  }

  editDialog(): void {
    console.log('showDialog');
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(PhdResultEditorDialog, config);
    this.editorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.editorDialogRef.componentInstance.result = this.result;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }
}
