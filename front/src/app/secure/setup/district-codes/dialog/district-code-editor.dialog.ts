import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {DistrictCode} from '../../../../shared/model/common/district-code.interface';

@Component({
  selector: 'pams-district-code-editor',
  templateUrl: './district-code-editor.dialog.html',
})

export class DistrictCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _districtCode: DistrictCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<DistrictCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set districtCode(value: DistrictCode) {
    this._districtCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<DistrictCode>{
      id: null,
      code: '',
      description: '',
     });

    if (this.edit) this.editorForm.patchValue(this._districtCode);
  }

  submit(code: DistrictCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Confirm to update district code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveDistrictCode(code));
    else  this.store.dispatch(this.actions.updateDistrictCode(code));
    this.dialog.close();
    });
  }
}
