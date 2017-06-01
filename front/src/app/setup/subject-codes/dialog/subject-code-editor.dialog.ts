import {SubjectCode} from './../../../common/subject-codes/subject-code.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";


@Component({
  selector: 'pams-subject-code-editor',
  templateUrl: './subject-code-editor.dialog.html',
})

export class SubjectCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _subjectCode: SubjectCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SubjectCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set subjectCode(value: SubjectCode) {
    this._subjectCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<SubjectCode>{
      id: null,
      code: '',
      // name: '',
      description: '',
    });

    if (this.edit) this.editorForm.patchValue(this._subjectCode);
  }

  submit(code: SubjectCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveSubjectCode(code));
    else  this.store.dispatch(this.actions.updateSubjectCode(code));
    this.dialog.close();
  }
}
