import {Referee} from '../../../../shared/model/application/referee.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {IntakeApplicationActions} from '../intake-application.action';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {RefereeType} from '../../../../shared/model/application/referee-type.enum';

@Component({
  selector: 'pams-referee-editor',
  templateUrl: './referee-editor.dialog.html',
})

export class RefereeEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private editForm: FormGroup;
  private edit: boolean = false;
  private _referee: Referee;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<RefereeEditorDialog>) {
  }

  set referee(value: Referee) {
    this._referee = value;
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Referee>{
      id: null,
      name: '',
      officeAddrs: '',
      occupation: '',
      phoneNo: '',
      refereeType: RefereeType.ACADEMICIAN,
    });
    if (this.edit) this.editForm.patchValue(this._referee);
  }

  submit(referee: Referee, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateReferee(this._intakeApplication, referee));
    else  this.store.dispatch(this.actions.addReferee(this._intakeApplication, referee));
    this.dialog.close();
  }
}
