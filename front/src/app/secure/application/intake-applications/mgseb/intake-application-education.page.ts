import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {ApplicationModuleState} from '../../index';

@Component({
  selector: 'pams-intake-application-education',
  templateUrl: './intake-application-education.page.html',
})

export class IntakeApplicationEducationPage implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>) {
  }

  ngOnInit(): void {
  }

  next(application: IntakeApplication, isValid: boolean) {
  }
}
