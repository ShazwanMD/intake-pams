import {Language} from '../../../../shared/model/application/language.interface';
import {LanguageCode} from '../../../../shared/model/common/language-code.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {IntakeApplicationActions} from '../intake-application.action';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';

@Component({
  selector: 'pams-language-editor',
  templateUrl: './language-editor.dialog.html',
})

export class LanguageEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private _language: Language;
  private editForm: FormGroup;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<LanguageEditorDialog>) {
  }

  set language(value: Language) {
    this._language = value;
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Language>{
      id: null,
      oral: 0,
      written: 0,
      languageCode: <LanguageCode>{},
    });
    if (this.edit) this.editForm.patchValue(this._language);
  }

  submit(language: Language, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateLanguage(this._intakeApplication, language));
    else  this.store.dispatch(this.actions.addLanguage(this._intakeApplication, language));
    this.dialog.close();
  }
}
