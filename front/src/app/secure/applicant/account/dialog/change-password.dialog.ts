import { User } from './../../../../identity/user.interface';
import { AccountActions } from './../account.action';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import { AccountModuleState } from "../index";



@Component({
  selector: 'pams-change-password',
  templateUrl: './change-password.dialog.html',
})

export class ChangePasswordDialog implements OnInit {

  private changePasswordForm: FormGroup;
  private edit: boolean = false;
  private _user: User;
  

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ChangePasswordDialog>,
              private store: Store<AccountModuleState>,
              private actions: AccountActions) {
  }

  set user(value: User) {
    this._user = value;
    this.edit = true;
    
  }

  ngOnInit(): void {

    this.changePasswordForm = this.formBuilder.group(<User>{
      id: null,
      password: '',
      realName: '',
      email: '',
  
    });

    if (this.edit) this.changePasswordForm.patchValue(this._user);
  }

  submit(user: User, isValid: boolean) {
    if (!user.id) this.store.dispatch(this.actions.saveUser(user));
    else  this.store.dispatch(this.actions.updateUser(user));
    this.dialog.close();
  }
}
