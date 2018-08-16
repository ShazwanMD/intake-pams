import { AccountActions } from './../account.action';
import { AccountModuleState } from './../index';
import { MyIntakeApplication } from './../../../shared/model/application/my-intake-application.interface';
import { ReportActions } from './../../../shared/report/report.action';
import { AdmissionActions } from './../../admission/admission.action';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { Employment } from '../../../shared/model/application/employment.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Language } from '../../../shared/model/application/language.interface';
import { Referee } from '../../../shared/model/application/referee.interface';
import { ApplicationModuleState } from '../../application';
import { IntakeApplicationActions } from '../../application/intake-applications/intake-application.action';
import { IntakeActions } from '../../policy/intakes/intake.action';
import { Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';
import { MdSnackBar, MdDialogRef, MdDialogConfig, MdDialog } from '@angular/material';


@Component({
  selector: 'pams-result-candidate',
  templateUrl: './result-candidate.dialog.html',
})

export class ResultCandidateDialog implements OnInit {

  private MY_INTAKE_APPLICATIONS: string[] = 'accountModuleState.myIntakeApplications'.split('.');
  private _myIntakeApplications: MyIntakeApplication;
  private myIntakeApplications$: Observable<MyIntakeApplication[]>;
  private applicationForm: FormGroup;



  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private vcf: ViewContainerRef,
    private admissionActions: AdmissionActions,
    private dialog: MdDialog,
    private editorDialog: MdDialogRef<ResultCandidateDialog>,
    private snackBar: MdSnackBar,
    private store: Store<AccountModuleState>,
    private reportActions: ReportActions,
    private actions: AccountActions) {
    this.myIntakeApplications$ = this.store.select(...this.MY_INTAKE_APPLICATIONS);
  }
  set myIntakeApplications(value: MyIntakeApplication) {
    this._myIntakeApplications = value;
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findMyIntakeApplications());
  }

  accept(accept: MyIntakeApplication) {
     let snackBarRef = this.snackBar.open('Confirm to Accept this Offer?', 'Ok');
    snackBarRef.afterDismissed().subscribe((res) => {
      this.store.dispatch(this.actions.acceptCandidate(accept)); 
    //  this.editorDialog.close();
    });
    let snackBarRef2 = this.snackBar.open('You have Accepted the offer and an offer letter has been created', '',{duration: 3000,});   
    snackBarRef2.afterDismissed().subscribe((res) => {  
    });
    snackBarRef2.onAction().subscribe(() => {   
    });
    
  }

    decline(decline: MyIntakeApplication) {
     let snackBarRef = this.snackBar.open('Confirm to Decline this Offer?', 'Ok');
    snackBarRef.afterDismissed().subscribe((res) => {
      this.store.dispatch(this.actions.declinedCandidate(decline));
      this.editorDialog.close();
    });
    let snackBarRef2 = this.snackBar.open('You have Declined the offer', '',{duration: 3000,});
    snackBarRef.afterDismissed().subscribe((res) => {     
    });
  }

  offerLetter() : void{ 
  }
  
  downloadReport(reportId,parameterReport:MyIntakeApplication): void {
      
      let repParam = reportId+'&reference_no='+ parameterReport.candidate.application.referenceNo;
     
      this.store.dispatch(this.reportActions.downloadReport(repParam));
    }

}