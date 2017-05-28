import { SpmResult } from './../spm-result.interface';
import { Address } from './../address.interface';
import {Referee} from './../referee.interface';
import {Employment} from './../employment.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {IntakeApplicationActions} from "../intake-application.action";
import {Observable} from "rxjs/Observable";
import {IntakeApplication} from "../intake-application.interface";



@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class CpsIntakeApplicationPage implements OnInit {

  private INTAKE_APPLICATION: string[] = "applicationModuleState.intakeApplication".split(".");
  private EMPLOYMENTS = "applicationModuleState.employments".split(".");
  private REFEREES = "applicationModuleState.referees".split(".");
  private ADDRESSES = "applicationModuleState.addresses".split(".");
  private SPM_RESULTS = "applicationModuleState.spmResults".split(".");


  private intakeApplication$: Observable<IntakeApplication>;
  private employments$: Observable<Employment>;
  private referees$: Observable<Referee>;
  private addresses$: Observable<Address>;
  private spmResults$: Observable<SpmResult>;
  private applicationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {

    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.employments$ = this.store.select(...this.EMPLOYMENTS);
    this.referees$ = this.store.select(...this.REFEREES);
    this.addresses$ = this.store.select(...this.ADDRESSES);
    this.spmResults$ = this.store.select(...this.SPM_RESULTS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
    });

    this.applicationForm = this.formBuilder.group(<IntakeApplication>{
      id: null,
      referenceNo: '',
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
      verified: false,
      sponsored: false,
      selfSponsored: false,
    });
    this.intakeApplication$.subscribe(intakeApplication => this.applicationForm.patchValue(intakeApplication));
  }

  onTabChange(): void {
    console.log("tab change");
    this.store.dispatch(this.actions.updateIntakeApplication(this.applicationForm.value));
  }
}
