import {ReligionCode} from './../../../common/religion-codes/religion-code.interface';
import {MaritalCode} from './../../../common/marital-codes/marital-code.interface';
import {RaceCode} from './../../../common/race-codes/race-code.interface';
import {GenderCode} from './../../../common/gender-codes/gender-code.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
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
import { Address } from "../../../application/intake-applications/address.interface";
import { SpmResult } from "../../../application/intake-applications/spm-result.interface";
import { BachelorResult } from "../../../application/intake-applications/bachelor-result-interface";
import { DiplomaResult } from "../../../application/intake-applications/diploma-result-interface";
import { IntakeApplicationActions } from "../../../application/intake-applications/intake-application.action";
import { ApplicationModuleState } from "../../../application/index";


@Component({
  selector: 'pams-applicant-profile',
  templateUrl: './applicant-profile.dialog.html',
})

export class ApplicantProfileDialog implements OnInit {

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
  private ADDRESSES: string[] = "applicationModuleState.addresses".split(".");
  private SPM_RESULTS: string[] = "applicationModuleState.spmResults".split(".");
  private BACHELOR_RESULTS: string[] = "applicationModuleState.bachelorResults".split(".");
  private DIPLOMA_RESULTS: string[] = "applicationModuleState.diplomaResults".split(".");

  private intakeApplication$: Observable<IntakeApplication>;
  private employments$: Observable<Employment>;
  private languages$: Observable<Language>;
  private referees$: Observable<Referee>;
  private attachments$: Observable<Referee>;
  private addresses$: Observable<Address>;
  private spmResults$: Observable<SpmResult>;
  private bachelorResults$: Observable<BachelorResult>;
  private diplomaResults$: Observable<DiplomaResult>;
  private applicationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {

    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.employments$ = this.store.select(...this.EMPLOYMENTS);
    this.languages$ = this.store.select(...this.LANGUAGES);
    this.referees$ = this.store.select(...this.REFEREES);
    this.attachments$ = this.store.select(...this.ATTACHMENTS);
    this.addresses$ = this.store.select(...this.ADDRESSES);
    this.spmResults$ = this.store.select(...this.SPM_RESULTS);
    this.bachelorResults$ = this.store.select(...this.BACHELOR_RESULTS);
    this.diplomaResults$ = this.store.select(...this.DIPLOMA_RESULTS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
    });

    this.applicationForm = this.formBuilder.group(<IntakeApplication>{
      id: null,
      referenceNo: '',
      researchTitle: '',
      rank: 0,
      merit: 0,
      name: '',
      credentialNo: '',
      birthDate: null,
      mobile: '',
      okuNo: '',
      email: '',
      phone: '',
      fax: '',
      age: 0,
      passExpDate: null,

      genderCode: <GenderCode>{},
      maritalCode: <MaritalCode>{},
      disabilityCode: <DisabilityCode>{},
      ethnicityCode: <EthnicityCode>{},
      raceCode: <RaceCode>{},
      religionCode: <ReligionCode>{},
      nationalityCode: <NationalityCode>{},
      verified: false,
      sponsored: false,
      selfSponsored: false,
      spmResultAttached: false,

      processingReceipt:false,
      foreignResult:false,
      educationResult:false,
      academic:false,
      financialLetter:false,
      researchProposal:false,
      bankStatement:false,
      refereeForm:false,
     
    });
    this.intakeApplication$.subscribe(intakeApplication => this.applicationForm.patchValue(intakeApplication));
  }
}
