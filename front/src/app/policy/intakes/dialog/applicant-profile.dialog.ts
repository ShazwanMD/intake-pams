import {ReligionCode} from './../../../common/religion-codes/religion-code.interface';
import {MaritalCode} from './../../../common/marital-codes/marital-code.interface';
import {RaceCode} from './../../../common/race-codes/race-code.interface';
import {GenderCode} from './../../../common/gender-codes/gender-code.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef,Input} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {NationalityCode} from "../../../common/nationality-codes/nationality-code.interface";
import { DisabilityCode } from "../../../common/disability-codes/disability-code.interface";
import { EthnicityCode } from "../../../common/ethnicity-codes/ethnicity-code.interface";
import { Observable } from "rxjs/Observable";
import { IntakeApplication } from "../../../application/intake-applications/intake-application.interface";
import { Employment } from "../../../application/intake-applications/employment.interface";
import { Language } from "../../../application/intake-applications/language.interface";
import { Referee } from "../../../application/intake-applications/referee.interface";
import { IntakeApplicationActions } from "../../../application/intake-applications/intake-application.action";
import { ApplicationModuleState } from "../../../application/index";
import { MdSnackBar, MdDialogRef } from "@angular/material";


@Component({
  selector: 'pams-applicant-profile',
  templateUrl: './applicant-profile.dialog.html',
})

export class ApplicantProfileDialog implements OnInit {
    
    //private editorForm: FormGroup;
    @Input() intakeApplication: IntakeApplication;

  private dummyData: any[]=[
   {"subject":"Bahasa Malaysia", "grade":"A+"},
   {"subject":"Bahasa Inggeris", "grade":"B"},
   {"subject":"Geografi", "grade":"C+"},
   {"subject":"Sejarah", "grade":"D+"},
   {"subject":"Matematik", "grade":"A+"},
   {"subject":"Matematik Tambahan", "grade":"A+"},
   {"subject":"Fizik", "grade":"A+"},
   {"subject":"Biologi", "grade":"B+"},
   {"subject":"Kimia", "grade":"B+"},
 ];

  private dummyColumns: any[] = [
    {name: 'subject', label: 'Subject'},
    {name: 'grade', label: 'Grade'},
  ];

  private INTAKE_APPLICATION: string[] = "applicationModuleState.intakeApplication".split(".");
  private EMPLOYMENTS: string[] = "applicationModuleState.employments".split(".");
  private LANGUAGES: string[] = "applicationModuleState.languages".split(".");
  private REFEREES: string[] = "applicationModuleState.referees".split(".");
  private ATTACHMENTS: string[] = "applicationModuleState.attachments".split(".");
  private SPM_RESULTS: string[] = "applicationModuleState.spmResults".split(".");
  private BACHELOR_RESULTS: string[] = "applicationModuleState.bachelorResults".split(".");
  private DIPLOMA_RESULTS: string[] = "applicationModuleState.diplomaResults".split(".");

  private intakeApplication$: Observable<IntakeApplication>;
  private employments$: Observable<Employment>;
  private languages$: Observable<Language>;
  private referees$: Observable<Referee>;
  private attachments$: Observable<Referee>;
  private applicationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<ApplicantProfileDialog>,
              private snackBar: MdSnackBar,
              private store: Store<ApplicationModuleState>) {

    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.employments$ = this.store.select(...this.EMPLOYMENTS);
    this.languages$ = this.store.select(...this.LANGUAGES);
    this.referees$ = this.store.select(...this.REFEREES);
    this.attachments$ = this.store.select(...this.ATTACHMENTS);
  }

  ngOnInit(): void {
      let referenceNo: string = this.intakeApplication.referenceNo;
      this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
  }
  

      
      select(intakeApplication : IntakeApplication) {
      let snackBarRef = this.snackBar.open("Confirm to Select This Applicant?", "Ok");
      snackBarRef.afterDismissed().subscribe(() => {
          this.store.dispatch(this.actions.selectIntakeApplication(intakeApplication));
          this.dialog.afterClosed().subscribe(res => {
              let referenceNo: string = this.intakeApplication.referenceNo;
              this.store.dispatch(this.actions.findIntakeByReferenceNo(intakeApplication.intake.referenceNo));
            });
      });
   }   
  
  reject(intakeApplication : IntakeApplication) {
      let snackBarRef = this.snackBar.open("Confirm to reject This Applicant?", "Ok");
      snackBarRef.afterDismissed().subscribe(() => {
          this.store.dispatch(this.actions.rejectIntakeApplication(intakeApplication));
          this.dialog.afterClosed().subscribe(res => {
              let referenceNo: string = this.intakeApplication.referenceNo;
              this.store.dispatch(this.actions.findIntakeByReferenceNo(intakeApplication.intake.referenceNo));
            });
      });
   }  
  
}
