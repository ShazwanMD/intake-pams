import { StudyCenterCode } from './../../../common/study-center-codes/study-center-code.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import { MdDialogRef, MdSnackBar } from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";


@Component({
  selector: 'pams-study-center-code-editor',
  templateUrl: './study-center-code-editor.dialog.html',
})

export class StudyCenterCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _studyCenterCode: StudyCenterCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StudyCenterCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set studyCenterCode(value: StudyCenterCode) {
    this._studyCenterCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<StudyCenterCode>{
      id: null,
      code: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._studyCenterCode);
  }

  submit(code: StudyCenterCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open("Confirm to update study center code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveStudyCenterCode(code));
    else  this.store.dispatch(this.actions.updateStudyCenterCode(code));
    this.dialog.close();
    });
  }
}