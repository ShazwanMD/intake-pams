import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {IntakeApplication} from "../../intake-application.interface";


@Component({
  selector: 'pams-intake-application',
  templateUrl: './working-experience-creator.dialog.html',
})

export class IntakeApplicationWorkingExperience implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>) {
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
