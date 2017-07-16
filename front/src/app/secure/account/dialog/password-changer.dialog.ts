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
  selector: 'pams-password-changer',
  templateUrl: './password-changer.dialog.html',
})

export class PasswordChangerDialog implements OnInit {

  private changePasswordForm: FormGroup;
  private _user: User;

  constructor(private formBuilder: FormBuilder,
              private dialog: MdDialogRef<PasswordChangerDialog>,
              private store: Store<AccountModuleState>,
              private actions: AccountActions) {
  }

  set user(value: User) {
    this._user = value;
  }

  ngOnInit(): void {
    this.changePasswordForm = this.formBuilder.group({
      currentPassword: ['', Validators.required],
      newPassword: ['', Validators.required],
      newPasswordAgain: ['', Validators.required],
    });
  }

  submit(change: PasswordChange, valid: boolean): void {
    console.log('submit password change: ', change);
    this.store.dispatch(this.actions.changeUserPassword(change));
    this.dialog.close();
  }
}
