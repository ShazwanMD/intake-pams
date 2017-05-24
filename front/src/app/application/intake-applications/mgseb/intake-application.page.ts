import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";
import { EducationCreatorDialog } from "../component/dialog/education-creator.dialog";
import { EmploymentCreatorDialog } from "../component/dialog/employment-creator.dialog";
import { IntakeApplicationActions } from "../intake-application.action";
import { Observable } from "rxjs/Observable";
import { Intake } from "../../../policy/intakes/intake.interface";


@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class MgsebIntakeApplicationPage implements OnInit {

  private INTAKE_APPLICATION: string[] = "applicationModuleState.intakeApplication".split(".");
  private INTAKE: string[] = "applicationModuleState.intake".split(".");

  private intakeApplication$: Observable<IntakeApplication>;
  private intake$: Observable<Intake>;
  
  private creatorForm: FormGroup;
  private creatorDialogRef1: MdDialogRef<EducationCreatorDialog>;
  private creatorDialogRef2: MdDialogRef<EmploymentCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialog,
              private actions : IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {
    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.intake$ = this.store.select(...this.INTAKE);
  }

  showDialog1(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef1 = this.dialog.open(EducationCreatorDialog, config);
    this.creatorDialogRef1.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  showDialog2(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef2 = this.dialog.open(EmploymentCreatorDialog, config);
    this.creatorDialogRef2.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
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
