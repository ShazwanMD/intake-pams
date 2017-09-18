import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {DisabilityCode} from '../../../../shared/model/common/disability-code.interface';

@Component({
  selector: 'pams-disability-code-editor',
  templateUrl: './disability-code-editor.dialog.html',
})

export class DisabilityCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _disabilityCode: DisabilityCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<DisabilityCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set disabilityCode(value: DisabilityCode) {
    this._disabilityCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<DisabilityCode>{
      id: null,
      code: '',
      name: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._disabilityCode);
  }

  submit(code: DisabilityCode, isValid: boolean) {
    if (confirm('Confirm to update disability code?')){
    if (!code.id) this.store.dispatch(this.actions.saveDisabilityCode(code));
    else  this.store.dispatch(this.actions.updateDisabilityCode(code));
    this.dialog.close();
    };
  }
}
