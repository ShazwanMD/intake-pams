import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import { IntakeApplication } from "../../cps/intake-application.interface";


@Component({
  selector: 'pams-spm-creator',
  templateUrl: './spm-creator.dialog.html',
})

export class SpmCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialogRef<SpmCreatorDialog>) {
  }

  save(employement: IntakeApplication, isValid: boolean) {
    //console.log("employement end date: " + employement.endDate);
    //console.log("employement start date: " + employement.startDate);
    //this.store.dispatch(this.actions.startIntakeTask(intake));
    this.dialog.close();
  }

  ngOnInit(): void {

     this.createForm = this.formBuilder.group(<IntakeApplication>{
    //  id: null,
    //  startDate: null,
    //  endDate: null,
    //  employer:'',
    //  current:false
   });
  }

  expandedEvent(): void {

  }

  collapsedEvent(): void {

  }

  next(application: IntakeApplication, isValid: boolean) {
  }
}
