import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {IntakeApplication} from "../../../secure/applicant/application/intake-applications/intake-application.interface";
import {IntakeApplicationActions} from "../../../secure/applicant/application/intake-applications/intake-application.action";
import {ApplicationModuleState} from "../../../secure/applicant/application/index";
import {MdSnackBar, MdDialogRef, MdDialogConfig} from "@angular/material";


@Component({
  selector: 'pams-applicant-profile-reject',
  templateUrl: './applicant-profile-reject.dialog.html',
})

export class ApplicantProfileRejectDialog implements OnInit {

  private rejectForm: FormGroup;
  private _intakeApplication: IntakeApplication;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<ApplicantProfileRejectDialog>,
              private snackBar: MdSnackBar,
              private store: Store<ApplicationModuleState>) {
  }

  set intakeApplication(intakeApplication: IntakeApplication) {
    console.log("intakeApplication.id :" + intakeApplication.id);
    this._intakeApplication = intakeApplication;
  }


  ngOnInit(): void {
    this.rejectForm = this.formBuilder.group(<IntakeApplication>{
      id: null,
      reason: '',
      referenceNo: '',
    });

    this.rejectForm.patchValue(this._intakeApplication);
  }

  submit(intakeApplication: IntakeApplication) {
    let snackBarRef = this.snackBar.open("Confirm to Reject This Applicant?", "Ok");

    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.rejectIntakeApplication(intakeApplication));
      this.dialog.close();
    });
  }

}
