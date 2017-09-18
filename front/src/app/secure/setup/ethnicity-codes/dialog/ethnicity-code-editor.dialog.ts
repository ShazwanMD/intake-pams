import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {EthnicityCode} from '../../../../shared/model/common/ethnicity-code.interface';

@Component({
  selector: 'pams-ethnicity-code-creator',
  templateUrl: './ethnicity-code-editor.dialog.html',
})

export class EthnicityCodeEditorDialog implements OnInit {

  private creatorForm: FormGroup;
  private edit: boolean = false;
  private _ethnicityCode: EthnicityCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<EthnicityCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

set ethnicityCode(value: EthnicityCode) {
    this._ethnicityCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.creatorForm = this.formBuilder.group(<EthnicityCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });

    if (this.edit) this.creatorForm.patchValue(this._ethnicityCode);
  }

  submit(code: EthnicityCode, isValid: boolean) {
    if (confirm('Update ethnicity code?')) {
    if (!code.id) this.store.dispatch(this.actions.saveEthnicityCode(code));
    else  this.store.dispatch(this.actions.updateEthnicityCode(code));
    this.dialog.close();
    };
  }
}
