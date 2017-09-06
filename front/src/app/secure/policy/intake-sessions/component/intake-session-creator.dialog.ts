import { Validators } from '@angular/forms';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {PolicyModuleState} from '../../index';
import {IntakeSessionActions} from '../intake-session.action';
import {IntakeSession} from '../../../../shared/model/policy/intake-session.interface';

@Component({
  selector: 'pams-intake-session-creator',
  templateUrl: './intake-session-creator.dialog.html',
  styleUrls: ['./intake-session-creator.dialog.scss'],
})

export class IntakeSessionCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private actions: IntakeSessionActions,
              private dialog: MdDialogRef<IntakeSessionCreatorDialog>) {

  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      id: [null],
      code: ['',Validators.required],
      label: ['',Validators.required],
      descriptionMs: ['',Validators.required],
      descriptionEn: ['',Validators.required],
      year: [0,Validators.required],
      current: false,
    });
  }

  save(sessions: IntakeSession, isValid: boolean) {
    this.store.dispatch(this.actions.saveIntakeSession(sessions));
    this.dialog.close();
  }
}
