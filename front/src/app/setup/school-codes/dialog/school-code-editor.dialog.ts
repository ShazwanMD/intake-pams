import {SchoolCode} from './../../../common/school-codes/school-code.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import { MdDialogRef, MdSnackBar } from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";


@Component({
  selector: 'pams-school-code-editor',
  templateUrl: './school-code-editor.dialog.html',
})

export class SchoolCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _schoolCode: SchoolCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SchoolCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set schoolCode(value: SchoolCode) {
    this._schoolCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<SchoolCode>{
      id: null,
      code: '',
      name: '',
      description: '',
    });

    if (this.edit) this.editorForm.patchValue(this._schoolCode);
  }

  submit(code: SchoolCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open("Confirm to update school code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveSchoolCode(code));
    else  this.store.dispatch(this.actions.updateSchoolCode(code));
    this.dialog.close();
    });
  }
}
