import { Referee } from './../referee.interface';
import {Employment} from './../employment.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {FormBuilder} from '@angular/forms';
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

  private intakeApplication$: Observable<IntakeApplication>;
  private employments$: Observable<Employment>;
  private referees$: Observable<Referee>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {

    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.employments$ = this.store.select(...this.EMPLOYMENTS);
    this.referees$ = this.store.select(...this.REFEREES);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
    });
  }

  next(application: IntakeApplication, isValid: boolean) {
  }
}
