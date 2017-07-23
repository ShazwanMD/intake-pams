import {Result} from '../../../../shared/model/application/result.interface';
import {ReligionCode} from '../../../../shared/model/common/religion-code.interface';
import {MaritalCode} from '../../../../shared/model/common/marital-code.interface';
import {RaceCode} from '../../../../shared/model/common/race-code.interface';
import {GenderCode} from '../../../../shared/model/common/gender-code.interface';
import {Referee} from '../../../../shared/model/application/referee.interface';
import {Employment} from '../../../../shared/model/application/employment.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {IntakeApplicationActions} from '../intake-application.action';
import {Observable} from 'rxjs/Observable';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {Language} from '../../../../shared/model/application/language.interface';
import {NationalityCode} from '../../../../shared/model/common/nationality-code.interface';
import {DisabilityCode} from '../../../../shared/model/common/disability-code.interface';
import {EthnicityCode} from '../../../../shared/model/common/ethnicity-code.interface';
import {CountryCode} from '../../../../shared/model/common/country-code.interface';
import {StateCode} from '../../../../shared/model/common/state-code.interface';

@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.panel.html',
})

export class CpsIntakeApplicationPanel implements OnInit {

  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  private EMPLOYMENTS: string[] = 'applicationModuleState.employments'.split('.');
  private LANGUAGES: string[] = 'applicationModuleState.languages'.split('.');
  private REFEREES: string[] = 'applicationModuleState.referees'.split('.');
  private RESULTS: string[] = 'applicationModuleState.results'.split('.');
  private ATTACHMENTS: string[] = 'applicationModuleState.attachments'.split('.');

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
      id:  [undefined],
      referenceNo:  [''],
      researchTitle: [''],
      rank: [0],
      merit: [0],
      name: [''],
      credentialNo: ['', Validators.required],
      birthDate:[undefined, Validators.required],
      mobile: ['', Validators.required],
      okuNo:[''],
      email: [''],
      phone: [''],
      fax:  [''],
      age: [0],
      passExpDate: [''],
      mailingAddress1: [''],
      mailingAddress2: [''],
      mailingAddress3: [''],
      mailingPostcode:[''],
      officialAddress1: [''],
      officialAddress2: [''],
      officialAddress3: [''],
      officialPostcode: [''],


      genderCode: [<GenderCode>{}],
      maritalCode:[<MaritalCode>{}],
      disabilityCode: [<DisabilityCode>{}],
      ethnicityCode: [<EthnicityCode>{}],
      raceCode: [<RaceCode>{}],
      religionCode:  [<ReligionCode>{}],
      nationalityCode:  [<NationalityCode>{}],
      mailingStateCode:  [<StateCode>{}],
      mailingCountryCode: [<CountryCode>{}],
      officialStateCode: [<StateCode>{}],
      officialCountryCode: [<CountryCode>{}],
      verified: [true],
      sponsored: [true],
      selfSponsored: [true],
      paid: [true],

      spmResultAttached: [true],
      stpmResultAttached: [true],
      diplomaResultAttached: [true],
      bachelorResultAttached: [true],
      toeflResultAttached: [true],
      ieltsResultAttached: [true],
      languageResultAttached:[true],
      processingFeeAttached: [true],
      bankStatementAttached: [true],
      refereeFormAttached: [true],
      researchProposalAttached:[true],
      sponsorLetterAttached:[true],

      processingReceipt: [true],
      foreignResult: [true],
      educationResult: [true],
      academic: [true],
      financialLetter:[true],
      researchProposal: [true],
      bankStatement: [true],
      refereeForm:[true],
      declared: [true, Validators.requiredTrue],

    });
    this.intakeApplication$.subscribe((intakeApplication) => this.applicationForm.patchValue(intakeApplication));
  }

  onTabChange(): void {
    console.log('tab change');
    this.store.dispatch(this.actions.updateIntakeApplication(this.applicationForm.value));
  }


   submit(application: IntakeApplication, isValid: boolean){
    if (confirm('Confirm to Submit this application?')) {
           this.store.dispatch(this.actions.submitIntakeApplication(application));
           this.goBack();
       } else {
           return false;
       }
    }
  
  copyAddress(application: IntakeApplication){
  if (confirm('Confirm to Copy this address?')) {
           this.store.dispatch(this.actions.copyAddressApplication(application));
           this.goBack();
       } else {
           return false;
       }
  }


  // submit(application: IntakeApplication, isValid: boolean): void {
  //   console.log('submitting application');
  //   this.store.dispatch(this.actions.submitIntakeApplication(application));
  //   this.goBack();
  // }

  goBack(): void {
    this.router.navigate(['/application/intake-applications/my-intake-application']);
  }

  // saverange(): void {
  //  // console.log(this.applicationForm);
  //   console.log(this.applicationForm.controls['merit'].value,this.applicationForm.controls['year'].value);
  //   this.applicationForm.controls['merit'].setValue(this.applicationForm.controls['year'].value*0.05);
  // }
}