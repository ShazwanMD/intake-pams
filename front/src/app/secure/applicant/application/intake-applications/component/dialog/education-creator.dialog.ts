import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../../index';
import {MdDialogRef} from '@angular/material';
import {IntakeApplicationActions} from '../../intake-application.action';
import {Education} from '../../../../../../shared/model/application/education.interface';
@Component({
  selector: 'pams-education-creator',
  templateUrl: './education-creator.dialog.html',
})

export class EducationCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<EducationCreatorDialog>) {
  }

  save(education: Education, isValid: boolean) {
    console.log('education school name : ' + education.schoolName);
    console.log('education course name : ' + education.courseName);
    console.log('education Entry Year : ' + education.entryDate);
    console.log('education Graduation Year : ' + education.graduationDate);
    this.dialog.close();
  }

  ngOnInit(): void {
  }

  expandedEvent(): void {

  }

  collapsedEvent(): void {

  }

}
