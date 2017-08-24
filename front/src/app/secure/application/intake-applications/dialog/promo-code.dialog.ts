import { IntakeApplication } from './../../../../shared/model/application/intake-application.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {IntakeApplicationActions} from '../intake-application.action';
import {Employment} from '../../../../shared/model/application/employment.interface';
import {EmploymentType} from '../../../../shared/model/application/employment-type.enum';
import { Observable } from "rxjs/Rx";

@Component({
  selector: 'pams-employment-editor',
  templateUrl: './employment-editor.dialog.html',
})

export class PromoCodeDialog implements OnInit {
  private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');
  
  private intakeApplications$: Observable<IntakeApplication[]>;
    
  private _intakeApplication: IntakeApplication;
  private promoCodeForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<PromoCodeDialog>) {
  }


  set intakeApplications(value: IntakeApplication) {
    this._intakeApplication= value;
  }

  ngOnInit(): void {
    this.promoCodeForm = this.formBuilder.group({
      promoCode:'',
    });
  }

//   submit(change: PasswordChange, valid: boolean) {
//     let snackBarRef = this.snackBar.open('Confirm to change your password?', 'Ok');
//      snackBarRef.afterDismissed().subscribe(() => {
//        if(!change.newPassword)this.store.dispatch(this.actions.saveUser(change));
//      this.store.dispatch(this.actions.changeUserPassword(change));
//      this.dialog.close();
     
//  });
 }

  
