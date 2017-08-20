import { Attachment } from './../../../../shared/model/application/attachment.interface';
import { Result } from '../../../../shared/model/application/result.interface';
import { RaceCode } from '../../../../shared/model/common/race-code.interface';
import { GenderCode } from '../../../../shared/model/common/gender-code.interface';
import { CountryCode } from '../../../../shared/model/common/country-code.interface';
import { StateCode } from '../../../../shared/model/common/state-code.interface';
import { EthnicityCode } from '../../../../shared/model/common/ethnicity-code.interface';
import { DisabilityCode } from '../../../../shared/model/common/disability-code.interface';
import { Referee } from '../../../../shared/model/application/referee.interface';
import { Employment } from '../../../../shared/model/application/employment.interface';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { ApplicationModuleState } from '../../index';
import { IntakeApplicationActions } from '../intake-application.action';
import { Observable } from 'rxjs/Observable';
import { IntakeApplication } from '../../../../shared/model/application/intake-application.interface';
import { Language } from '../../../../shared/model/application/language.interface';
import { NationalityCode } from '../../../../shared/model/common/nationality-code.interface';
import { MaritalCode } from '../../../../shared/model/common/marital-code.interface';
import { ReligionCode } from '../../../../shared/model/common/religion-code.interface';
import { MdSnackBar, MdTabChangeEvent } from '@angular/material';

@Component({
  selector: 'pams-mgseb-intake-application',
  templateUrl: './intake-application.panel.html',
})

export class MgsebIntakeApplicationPanel implements OnInit {

  private TAB_INDEX: string[] = 'applicationModuleState.tabIndex'.split('.');
  private EMPLOYMENTS: string[] = 'applicationModuleState.employments'.split('.');
  private LANGUAGES: string[] = 'applicationModuleState.languages'.split('.');
  private REFEREES: string[] = 'applicationModuleState.referees'.split('.');
  private RESULTS: string[] = 'applicationModuleState.results'.split('.');
  private ATTACHMENTS: string[] = 'applicationModuleState.attachments'.split('.');

  private employments$: Observable<Employment>;
  private languages$: Observable<Language>;
  private referees$: Observable<Referee>;
  private results$: Observable<Result>;
  private attachments$: Observable<Attachment>;
  private applicationForm: FormGroup;
  private tabIndex$: Observable<number>;
  private _intakeApplication: IntakeApplication;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private vcf: ViewContainerRef,
    private snackBar: MdSnackBar,
    private actions: IntakeApplicationActions,
    private store: Store<ApplicationModuleState>) {

    this.attachments$ = this.store.select(...this.ATTACHMENTS);

    this.employments$ = this.store.select(...this.EMPLOYMENTS);
    this.languages$ = this.store.select(...this.LANGUAGES);
    this.referees$ = this.store.select(...this.REFEREES);
    this.results$ = this.store.select(...this.RESULTS);
    this.tabIndex$ = this.store.select(...this.TAB_INDEX);
  }

  get intakeApplication(): IntakeApplication {
    return this._intakeApplication;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.applicationForm = this.formBuilder.group({
      id: [undefined],
      referenceNo: [''],
      researchTitle: [''],
      rank: [0],
      merit: [0],

      name: [''],
      credentialNo: ['', Validators.required],
      birthDate: [undefined, Validators.required],
      passExpDate: [''],
      mobile: ['', Validators.required],
      okuNo: [''],
      email: [''],
      phone: [''],
      fax: [''],
      age: [0],
      mailingAddress1: [''],
      mailingAddress2: [''],
      mailingAddress3: [''],
      mailingPostcode: [''],
      officialAddress1: [''],
      officialAddress2: [''],
      officialAddress3: [''],
      officialPostcode: [''],

      spmResultAttached: [true],
      stpmResultAttached: [true],
      stamResultAttached: [true],
      muetResultAttached: [true],
      diplomaResultAttached: [true],
      bachelorResultAttached: [true],
      toeflResultAttached: [true],
      ieltsResultAttached: [true],
      languageResultAttached: [true],
      processingFeeAttached: [true],
      bankStatementAttached: [true],
      refereeFormAttached: [true],
      researchProposalAttached: [true],
      sponsorLetterAttached: [true],

      genderCode: [<GenderCode>{}],
      maritalCode: [<MaritalCode>{}],
      raceCode: [<RaceCode>{}],
      ethnicityCode: [<EthnicityCode>{}],
      disabilityCode: [<DisabilityCode>{}],
      religionCode: [<ReligionCode>{}],
      nationalityCode: [<NationalityCode>{}],
      mailingStateCode: [<StateCode>{}],
      mailingCountryCode: [<CountryCode>{}],
      officialStateCode: [<StateCode>{}],
      officialCountryCode: [<CountryCode>{}],
      verified: [true],
      sponsored: [true],
      selfSponsored: [true],
      processingReceipt: [true],
      foreignResult: [true],
      educationResult: [true],
      academic: [true],
      financialLetter: [true],
      researchProposal: [true],
      bankStatement: [true],
      refereeForm: [true],
      declared: [true, Validators.requiredTrue],
      copyAddress: [false],
    });
    this.applicationForm.patchValue(this._intakeApplication);
  }

  onTabChange(event: MdTabChangeEvent): void {
    console.log('tab change: ' + event.index);
    this.store.dispatch(this.actions.selectTabIndex(event.index));
    this.store.dispatch(this.actions.updateIntakeApplication(this.applicationForm.value));
  }


  submit(application: IntakeApplication, isValid: boolean) {
    if (confirm('Confirm to Submit this application?')) {
      this.store.dispatch(this.actions.submitIntakeApplication(application));
      this.goBack();
    } else {
      return false;
    }
  }

  // copyAddress(application: IntakeApplication) {
  //   this.store.dispatch(this.actions.updateIntakeApplication(this.applicationForm.value));
  //   let snackBarRef = this.snackBar.open('Confirm to Copy this address?', 'Ok');
  //   snackBarRef.afterDismissed().subscribe(() => {
  //     if (!application.id) this.store.dispatch(this.actions.updateIntakeApplication(application));
  //     else
  //        this.store.dispatch(this.actions.copyAddressApplication(application));  
  //     // this.goBack();
  //   });
  // }

  goBack(): void {
    this.router.navigate(['/secure']);
  }
}

