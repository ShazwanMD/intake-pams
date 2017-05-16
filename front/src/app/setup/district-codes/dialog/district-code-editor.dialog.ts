import {DistrictCode} from './../../../common/district-codes/district-code.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";


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
              private actions: SetupActions) {
  }

  set districtCode(value: DistrictCode) {
    this._districtCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<DistrictCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });

    if (this.edit) this.editorForm.patchValue(this._districtCode);
  }

  submit(code: DistrictCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveDistrictCode(code));
    else  this.store.dispatch(this.actions.updateDistrictCode(code));
    this.dialog.close();
  }
}
