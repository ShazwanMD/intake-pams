
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {PolicyModuleState} from "../../index";

import { IntakeSession } from "../intake-session.interface";
import { IntakeSessionActions } from "../intake-session.action";


@Component({
  selector: 'pams-intake-session-editor',
  templateUrl: './intake-session-editor.dialog.html',
})

export class IntakeSessionEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _intakeSession: IntakeSession;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<IntakeSessionEditorDialog>,
              private store: Store<PolicyModuleState>,
              private actions: IntakeSessionActions) {
  }

  set intakeSession(value: IntakeSession) {
    this._intakeSession = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<IntakeSession>{
      id: null,
      code: '',
      label: '',
      descriptionMs: '',
      descriptionEn: '',
      year: 0,
      current: false,
    });

    if (this.edit) this.editorForm.patchValue(this._intakeSession);
  }

  submit(code: IntakeSession, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveIntakeSession(code));
    else  this.store.dispatch(this.actions.updateIntakeSession(code));
    this.dialog.close();
  }
}
