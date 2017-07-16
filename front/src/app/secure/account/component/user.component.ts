import { AccountActions } from './../account.action';
import { Applicant } from '../../identity/applicant.interface';
import { Observable } from 'rxjs/Observable';

import { Component, Input, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { MdDialogRef, MdDialogConfig, MdDialog } from "@angular/material";
import { ChangePasswordEditorDialog } from "../dialog/change-password-editor.dialog";
import { Store } from "@ngrx/store";
import { AccountModuleState } from "../index";
import { User } from "../../identity/user.interface";


@Component({
  selector: 'pams-user',
  templateUrl: './user.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class UserComponent {


 private editorDialogRef: MdDialogRef<ChangePasswordEditorDialog>;
 @Input() user: User;

  constructor(private actions: AccountActions,
              private vcf: ViewContainerRef,
              private store: Store<AccountModuleState>,
              private dialog: MdDialog) {
  }
 

  editDialog(): void {
    console.log('editDialog');
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(ChangePasswordEditorDialog, config);
    this.editorDialogRef.componentInstance.user = this.user;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }
}


