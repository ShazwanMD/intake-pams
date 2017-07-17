import { AuthenticatedUser } from './../../../shared/model/identity/authenticated-user.interface';
import {User} from '../../identity/user.interface';
import {AccountActions} from '../account.action';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AccountModuleState} from '../index';
import { AuthenticationService } from "../../../../services/authentication.service";

@Component({
  selector: 'pams-email-changer',
  templateUrl: './email-changer.dialog.html',
})

export class EmailChangerDialog implements OnInit {

  private emailChangerForm: FormGroup;
  private _user: User;
  private authenticatedUser: AuthenticatedUser;

  constructor(private formBuilder: FormBuilder,
              private dialog: MdDialogRef<EmailChangerDialog>,
              private store: Store<AccountModuleState>,
              private authnService: AuthenticationService,
              private router: Router,
              private actions: AccountActions) {
  }

  set user(value: User) {
    this._user = value;
  }

  ngOnInit(): void {
    this.emailChangerForm = this.formBuilder.group({
      currentEmail: ['', Validators.required],
      newEmail: ['', Validators.required],
    });
  }

    logout(): void {
    this.authnService.logout();
    this.router.navigate(['/login']);
  }

//   submit(change: PasswordChange, valid: boolean) {
//     console.log('submit password change: ', change);
//     this.store.dispatch(this.actions.changeUserPassword(change));
//     this.dialog.close();
//     this.logout();   
// } 
}
