import {Applicant} from '../../identity/applicant.interface';
import {AuthenticatedUser} from '../../../shared/model/identity/authenticated-user.interface';
import {AccountActions} from '../account.action';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AccountModuleState} from '../index';
import {AuthenticationService} from '../../../../services/authentication.service';
import {EmailChange} from '../../../shared/model/identity/email-change.interface';

@Component({
  selector: 'pams-email-changer',
  templateUrl: './email-changer.dialog.html',
})

export class EmailChangerDialog implements OnInit {

  private emailChangerForm: FormGroup;
  private _applicant: Applicant;
  private authenticatedUser: AuthenticatedUser;
  private EMAIL_PATTERN: string = '^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$';

  constructor(private formBuilder: FormBuilder,
              private dialog: MdDialogRef<EmailChangerDialog>,
              private store: Store<AccountModuleState>,
              private authnService: AuthenticationService,
              private router: Router,
              private actions: AccountActions) {
  }

  set applicant(value: Applicant) {
    this._applicant = value;
  }

  ngOnInit(): void {
    this.emailChangerForm = this.formBuilder.group({
      currentEmail: [this._applicant.email, Validators.compose([Validators.required, Validators.pattern(this.EMAIL_PATTERN)])],
      newEmail: ['', Validators.compose([Validators.required, Validators.pattern(this.EMAIL_PATTERN)])],
    });
  }

  logout(): void {
    this.authnService.logout();
    this.router.navigate(['/login']);
  }

  submit(change: EmailChange, valid: boolean) {
    this.store.dispatch(this.actions.changeApplicantEmail(change));
    this.dialog.close();
  }
}
