import { AccountActions } from './../account.action';

import { Component, Input, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { MdDialogRef, MdDialogConfig, MdDialog } from '@angular/material';
import { PasswordChangerDialog } from '../dialog/password-changer.dialog';
import { Store } from '@ngrx/store';
import { AccountModuleState } from '../index';
import { User } from '../../identity/user.interface';
import { EmailChangerDialog } from "../dialog/email-changer.dialog";

@Component({
  selector: 'pams-user',
  templateUrl: './user.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class UserComponent {

 private editorDialogRef: MdDialogRef<PasswordChangerDialog>;
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
    this.editorDialogRef = this.dialog.open(PasswordChangerDialog, config);
    this.editorDialogRef.componentInstance.user = this.user;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

}

