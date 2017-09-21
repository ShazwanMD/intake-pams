import { AttachmentCreatorDialog } from './../dialog/attachment-creator.dialog';
import { Attachment } from './../../../../shared/model/application/attachment.interface';

import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from '../intake-application.action';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-attachment-list',
  templateUrl: './attachment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AttachmentListComponent implements OnInit {

  @Input() attachments: Attachment[];
  @Input() intakeApplication: IntakeApplication;

  private selectedRows: Attachment[];
  private creatorDialogRef: MdDialogRef<AttachmentCreatorDialog>;
  private columns: any[] = [
    {name: 'name', label: 'Name'},
    {name: 'size', label: 'Size'},
    {name: 'attachmentType', label: 'Attachment Type'},
  ];

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.attachments.filter((value) => value.selected);
  }

  create(): void {
    this.showDialog(null);
  }

  edit(attachment: Attachment): void {
    this.showDialog(attachment);
  }

  delete(): void {
    console.log('length: ' + this.selectedRows.length);
    for (let i: number = 0; i < this.selectedRows.length; i++) {
      this.store.dispatch(this.actions.deleteAttachment(this.intakeApplication, this.selectedRows[i]));
    }
    this.selectedRows = [];
  }

  filter(): void {
  }
  
  selectRow(attachment: Attachment): void {

  }   

  selectAllRows(attachment: Attachment[]): void {
  }

  showDialog(attachment: Attachment): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.creatorDialogRef = this.dialog.open(AttachmentCreatorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    if (attachment) this.creatorDialogRef.componentInstance.attachment = attachment;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      this.selectedRows = [];
    });
  }
}
