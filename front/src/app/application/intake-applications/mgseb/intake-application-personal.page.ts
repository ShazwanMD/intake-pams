import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {IntakeApplication} from "../intake-application.interface";
import {ApplicationModuleState} from "../../index";
import {IntakeApplicationPersonal} from "./intake-application-personal.interface";
import { EmploymentCreatorDialog } from "./dialog/employment-creator.dialog";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import { EducationCreatorDialog } from "./dialog/education-creator.dialog";


@Component({
  selector: 'pams-intake-application-personal',
  templateUrl: './intake-application-personal.page.html',
})

export class IntakeApplicationPersonalPage implements OnInit {

  private createForm: FormGroup;
  private creatorDialogRef: MdDialogRef<EmploymentCreatorDialog>;
  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialog,
              private store: Store<ApplicationModuleState>) {
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

  ngOnInit(): void {
    
  }

  next(application:IntakeApplication , isValid: boolean) {
  }
}
