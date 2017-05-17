import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import { IntakeApplicationPersonal } from "../intake-application-personal.interface";
import { IntakeApplicationActions } from "../../intake-application.action";


@Component({
  selector: 'pams-employment-creator',
  templateUrl: './employment-creator.dialog.html',
})

export class EmploymentCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions : IntakeApplicationActions,
              private dialog: MdDialogRef<EmploymentCreatorDialog>) {
  }

  save(employement: IntakeApplicationPersonal, isValid: boolean) {
    console.log("employement end date: " + employement.endDate);
    console.log("employement start date: " + employement.startDate);
     console.log("employement employer: " + employement.employer);
      console.log("employement designation: " + employement.designation);
    //this.store.dispatch(this.actions.startIntakeTask(intake));
    this.dialog.close();
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<IntakeApplicationPersonal>{
     id: null,
     startDate: null,
     endDate: null,
     employer:'',
     designation:'',
     current:false
   });
  }

  expandedEvent(): void {

  }

  collapsedEvent(): void {

  }

}
