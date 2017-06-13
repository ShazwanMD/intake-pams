import { CountryCode } from './../../../common/country-codes/country-code.interface';
import { StateCode } from './../../../common/state-codes/state-code.interface';
import {EthnicityCode} from '../../../common/ethnicity-codes/ethnicity-code.interface';
import {DisabilityCode} from '../../../common/disability-codes/disability-code.interface';
import {DiplomaResult} from '../diploma-result-interface';
import {BachelorResult} from '../bachelor-result-interface';
import {SpmResult} from '../spm-result.interface';
import {Referee} from '../referee.interface';
import {Employment} from '../employment.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {IntakeApplicationActions} from "../intake-application.action";
import {Observable} from "rxjs/Observable";
import {IntakeApplication} from "../intake-application.interface";
import {Language} from "../language.interface";
import {NationalityCode} from "../../../common/nationality-codes/nationality-code.interface";
import {GenderCode} from "../../../common/gender-codes/gender-code.interface";
import {MaritalCode} from "../../../common/marital-codes/marital-code.interface";
import {RaceCode} from "../../../common/race-codes/race-code.interface";
import {ReligionCode} from "../../../common/religion-codes/religion-code.interface";
import {MdDialogRef, MdDialogConfig} from "@angular/material";


@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class MgsebIntakeApplicationPage implements OnInit {
  intakeApplication: any;
  dialog: any;

  private dummyData: any[] = [
    {"subject": "Bahasa Malaysia", "grade": "A+"},
    {"subject": "Bahasa Inggeris", "grade": "B"},
    {"subject": "Geografi", "grade": "C+"},
    {"subject": "Sejarah", "grade": "D+"},
    {"subject": "Matematik", "grade": "A+"},
    {"subject": "Matematik Tambahan", "grade": "A+"},
    {"subject": "Fizik", "grade": "A+"},
    {"subject": "Biologi", "grade": "B+"},
    {"subject": "Kimia", "grade": "B+"},
  ];

  private dummyColumns: any[] = [
    {name: 'subject', label: 'Subject'},
    {name: 'grade', label: 'Grade'},
  ];

  private INTAKE_APPLICATION: string[] = "applicationModuleState.intakeApplication".split(".");
  private EMPLOYMENTS: string[] = "applicationModuleState.employments".split(".");
  private LANGUAGES: string[] = "applicationModuleState.languages".split(".");
  private ATTACHMENTS: string[] = "applicationModuleState.attachments".split(".");
  private REFEREES: string[] = "applicationModuleState.referees".split(".");
  private SPM_RESULTS: string[] = "applicationModuleState.spmResults".split(".");
  private BACHELOR_RESULTS: string[] = "applicationModuleState.bachelorResults".split(".");
  private DIPLOMA_RESULTS: string[] = "applicationModuleState.diplomaResults".split(".");


  private intakeApplication$: Observable<IntakeApplication>;
  private employments$: Observable<Employment>;
  private languages$: Observable<Language>;
  private referees$: Observable<Referee>;
  private attachments$: Observable<Referee>;
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
    this.spmResults$ = this.store.select(...this.SPM_RESULTS);
    this.bachelorResults$ = this.store.select(...this.BACHELOR_RESULTS);
    this.diplomaResults$ = this.store.select(...this.DIPLOMA_RESULTS);
    this.attachments$ = this.store.select(...this.ATTACHMENTS);
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
      passExpDate: null,
      mobile: '',
      okuNo: '',
      email: '',
      phone: '',
      fax: '',
      age: 0,
      mailingAddress1: '',
      mailingAddress2: '',
      mailingAddress3: '',
      mailingPostcode: '',
      officialAddress1: '',
      officialAddress2: '',
      officialAddress3: '',
      officialPostcode: '',      

      spmResultAttached: false,
      stpmResultAttached: false,
      diplomaResultAttached: false,
      bachelorResultAttached: false,
      toeflResultAttached: false,
      ieltsResultAttached: false,
      languageResultAttached: false,
      processingFeeAttached: false,
      bankStatementAttached: false,
      refereeFormAttached: false,
      researchProposalAttached: false,
      sponsorLetterAttached: false,

      genderCode: <GenderCode>{},
      maritalCode: <MaritalCode>{},
      raceCode: <RaceCode>{},
      disabilityCode: <DisabilityCode>{},
      ethnicityCode: <EthnicityCode>{},
      religionCode: <ReligionCode>{},
      nationalityCode: <NationalityCode>{},
      mailingStateCode: <StateCode>{},
      mailingCountryCode: <CountryCode>{},
      officialStateCode: <StateCode>{},
      officialCountryCode: <CountryCode>{},
      verified: false,
      sponsored: false,
      selfSponsored: false,
      processingReceipt: false,
      foreignResult: false,
      educationResult: false,
      academic: false,
      financialLetter: false,
      researchProposal: false,
      bankStatement: false,
      refereeForm: false,

    });
    this.intakeApplication$.subscribe(intakeApplication => this.applicationForm.patchValue(intakeApplication));
  }

  onTabChange(): void {
    console.log("tab change");
    this.store.dispatch(this.actions.updateIntakeApplication(this.applicationForm.value));
  }

  submit(application: IntakeApplication, isValid: boolean) {
    console.log("submitting application");
    this.store.dispatch(this.actions.submitIntakeApplication(application));
    this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/application/intake-applications/my-intake-application']);
  }
}


