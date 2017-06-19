import { Result } from './../result.interface';
import {RaceCode} from '../../../common/race-codes/race-code.interface';
import {GenderCode} from '../../../common/gender-codes/gender-code.interface';
import {CountryCode} from '../../../common/country-codes/country-code.interface';
import {StateCode} from '../../../common/state-codes/state-code.interface';
import {EthnicityCode} from '../../../common/ethnicity-codes/ethnicity-code.interface';
import {DisabilityCode} from '../../../common/disability-codes/disability-code.interface';
import {Referee} from '../referee.interface';
import {Employment} from '../employment.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {IntakeApplicationActions} from '../intake-application.action';
import {Observable} from 'rxjs/Observable';
import {IntakeApplication} from '../intake-application.interface';
import {Language} from '../language.interface';
import {NationalityCode} from '../../../common/nationality-codes/nationality-code.interface';
import {MaritalCode} from '../../../common/marital-codes/marital-code.interface';
import {ReligionCode} from '../../../common/religion-codes/religion-code.interface';
import { MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class MgsebIntakeApplicationPage implements OnInit {

  intakeApplication: any;
  dialog: any;

  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  private EMPLOYMENTS: string[] = 'applicationModuleState.employments'.split('.');
  private LANGUAGES: string[] = 'applicationModuleState.languages'.split('.');
  private ATTACHMENTS: string[] = 'applicationModuleState.attachments'.split('.');
  private REFEREES: string[] = 'applicationModuleState.referees'.split('.');
  private RESULTS: string[] = 'applicationModuleState.results'.split('.');

  private intakeApplication$: Observable<IntakeApplication>;
  private employments$: Observable<Employment>;
  private languages$: Observable<Language>;
  private referees$: Observable<Referee>;
  private results$: Observable<Result>;
  private attachments$: Observable<Referee>;
  private applicationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private snackBar: MdSnackBar,
              private store: Store<ApplicationModuleState>) {

    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.employments$ = this.store.select(...this.EMPLOYMENTS);
    this.languages$ = this.store.select(...this.LANGUAGES);
    this.referees$ = this.store.select(...this.REFEREES);
    this.results$ = this.store.select(...this.RESULTS);
    this.attachments$ = this.store.select(...this.ATTACHMENTS);
  }

  ngOnInit(): void {

    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
    });

    this.applicationForm = this.formBuilder.group({
      id: [undefined],
      referenceNo: '',
      researchTitle: '',
      rank: 0,
      merit:0,

      name: '',
      credentialNo: ['', Validators.required],
      birthDate: [undefined, Validators.required],
      passExpDate: [undefined, Validators.required],
      mobile: ['', Validators.required],
      okuNo: '',
      email: '',
      phone: ['', Validators.required],
      fax: [''],
      age: 0,
      mailingAddress1: '',
      mailingAddress2: '',
      mailingAddress3: '',
      mailingPostcode: '',
      officialAddress1:'',
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
      ethnicityCode: <EthnicityCode>{},
      disabilityCode:<DisabilityCode>{},
      religionCode: <ReligionCode>{},
      nationalityCode: <NationalityCode>{},
      mailingStateCode: <StateCode>{},
      mailingCountryCode: <CountryCode>{},
      officialStateCode:<StateCode>{},
      officialCountryCode:<CountryCode>{},
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
      declared:false,

    });
    this.intakeApplication$.subscribe((intakeApplication) => this.applicationForm.patchValue(intakeApplication));
  }

 onTabChange(): void {
    console.log('tab change');
    this.store.dispatch(this.actions.updateIntakeApplication(this.applicationForm.value));
  }
  
 submit(application: IntakeApplication, isValid: boolean): void {
    console.log('submitting application');
    this.store.dispatch(this.actions.submitIntakeApplication(application));
    this.goBack();
  }


  goBack(): void {
    this.router.navigate(['/application/intake-applications/my-intake-application']);
  }
}

