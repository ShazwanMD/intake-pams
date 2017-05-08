import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {EmploymentCreatorDialog} from "./dialog/employment-creator.dialog";
import { IntakeApplication } from "./intake-application.interface";


@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class IntakeApplicationPage implements OnInit {

  private createForm: FormGroup;
  private creatorDialogRef: MdDialogRef<EmploymentCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
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

  expandedEvent(): void {

  }

  collapsedEvent(): void {

  }

  next(application: IntakeApplication, isValid: boolean) {
  }
}
