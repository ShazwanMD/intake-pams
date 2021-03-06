import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {ResidencyCode} from '../../../../shared/model/common/residency-code.interface';

@Component({
  selector: 'pams-residency-code-editor',
  templateUrl: './residency-code-editor.dialog.html',
})

export class ResidencyCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _residencyCode: ResidencyCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ResidencyCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set residencyCode(value: ResidencyCode) {
    this._residencyCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.editorForm = this.formBuilder.group(<ResidencyCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
     });

    if (this.edit) this.editorForm.patchValue(this._residencyCode);
  }

  submit(code: ResidencyCode, isValid: boolean) {
    if (confirm('Confirm to update residency code?')) {
    if (!code.id) this.store.dispatch(this.actions.saveResidencyCode(code));
    else  this.store.dispatch(this.actions.updateResidencyCode(code));
    this.dialog.close();
    };
  }
}
