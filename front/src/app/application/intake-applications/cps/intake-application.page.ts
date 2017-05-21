import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {EmploymentCreatorDialog} from "./dialog/employment-creator.dialog";
import {IntakeApplication} from "./intake-application.interface";
import {IntakeApplicationActions} from "../intake-application.action";
import {Observable} from "rxjs/Observable";
import {Intake} from "../../../policy/intakes/intake.interface";


@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class CpsIntakeApplicationPage implements OnInit {

  private INTAKE_APPLICATION: string[] = "applicationModuleState.intakeApplication".split(".");
  private INTAKE: string[] = "applicationModuleState.intake".split(".");

  // load both intake and intake application from store
  // for  select component purposes
  private intakeApplication$: Observable<IntakeApplication>;
  private intake$: Observable<Intake>;

  private createForm: FormGroup;
  private creatorDialogRef: MdDialogRef<EmploymentCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.intake$ = this.store.select(...this.INTAKE);
    this.intake$.subscribe(intake => console.log("intake: " + intake.referenceNo));
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      if (null != referenceNo) this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
    });
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EmploymentCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  expandedEvent(): void {

  }

  collapsedEvent(): void {

  }

  next(application: IntakeApplication, isValid: boolean) {
  }
}
