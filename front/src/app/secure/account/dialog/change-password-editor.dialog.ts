import {PasswordChange} from '../../../shared/model/identity/password-change.interface';
import {User} from '../../identity/user.interface';
import {AccountActions} from '../account.action';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AccountModuleState} from '../index';

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
    this.changePasswordForm = this.formBuilder.group({
      user: [undefined],
      currentPassword: ['', Validators.required],
      newPassword: ['', Validators.required],
    });

    this.changePasswordForm.patchValue(this._user);
  }

  submit(change: PasswordChange, valid: boolean): void {
    console.log('submit password change: ', change.user);
    this.store.dispatch(this.actions.updateUserPassword(change));
    this.dialog.close();
  }
}
