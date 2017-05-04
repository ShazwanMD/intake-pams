import { WorkingExperienceCreatorDialog } from './dialog/working-experience-creator.dialog';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {IntakeApplication} from "../intake-application.interface";
import {ApplicationModuleState} from "../../index";
import { IntakeApplicationPersonal } from "./intake-application.interface";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";


@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class IntakeApplicationPage implements OnInit {


  private createForm: FormGroup;
  private creatorDialogRef: MdDialogRef<WorkingExperienceCreatorDialog>;

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
    this.creatorDialogRef = this.dialog.open(WorkingExperienceCreatorDialog, config);
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
  
  next(application:IntakeApplication , isValid: boolean) {
  }
}
