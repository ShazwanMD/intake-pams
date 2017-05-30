import { LanguageCode } from './../../../common/language-codes/language-code.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import { MdDialogRef, MdSnackBar } from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";

@Component({
  selector: 'pams-language-code-editor',
  templateUrl: './language-code-editor.dialog.html',
})

export class LanguageCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _languageCode: LanguageCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<LanguageCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set languageCode(value: LanguageCode) {
    this._languageCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<LanguageCode>{
      id: null,
      code: '',
      name: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._languageCode);
  }

  submit(code: LanguageCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open("Confirm to update language code?", "Yes");
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveLanguageCode(code));
    else  this.store.dispatch(this.actions.updateLanguageCode(code));
    this.dialog.close();
    });
  }
}
