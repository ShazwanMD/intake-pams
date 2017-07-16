import { PasswordChange } from './../../../shared/model/identity/password-change.interface';
import { User } from '../../identity/user.interface';
import { AccountActions } from '../account.action';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import { AccountModuleState } from "../index";



@Component({
  selector: 'pams-change-password-editor',
  templateUrl: './change-password-editor.dialog.html',
})

export class ChangePasswordEditorDialog implements OnInit {

  private changePasswordForm: FormGroup;
  private edit: boolean = false;
  private _user: User;



  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ChangePasswordEditorDialog>,
              private store: Store<AccountModuleState>,
              private actions: AccountActions) {
  }

  set user(value: User) {
    this._user = value;
    this.edit = true;

  }
  
   ngOnInit(): void {
    this.changePasswordForm = this.formBuilder.group(<PasswordChange>{
     id: null,
      newPassword: '',
      oldPassword: '',
    });

  }

  submit(user: User, change: PasswordChange) {
    this.store.dispatch(this.actions.updateUserPassword(user, change));
    this.dialog.close();
  }
}
