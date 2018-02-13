import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {FieldCode} from '../../../../shared/model/common/field-code.interface';
import {FacultyCode} from '../../../../shared/model/common/faculty-code.interface';

@Component({
  selector: 'pams-field-code-creator',
  templateUrl: './field-code-editor.dialog.html',
})

export class FieldCodeEditorDialog implements OnInit {

  private creatorForm: FormGroup;
  private edit: boolean = false;
  private _fieldCode: FieldCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<FieldCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set fieldCode(value: FieldCode) {
    this._fieldCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.creatorForm = this.formBuilder.group(<FieldCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });

    if (this.edit) this.creatorForm.patchValue(this._fieldCode);
  }

  submit(code: FieldCode, isValid: boolean) {
    if (confirm('Confirm to update Field code?')){
    if (!code.id) this.store.dispatch(this.actions.saveFieldCode(code));
    else  this.store.dispatch(this.actions.updateFieldCode(code));
    this.dialog.close();
    };
  }
}
