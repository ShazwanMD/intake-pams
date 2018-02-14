import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar, } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {ProgramFieldCode} from '../../../../shared/model/common/program-field-code.interface';
import {ProgramLevel} from '../../../../shared/model/policy/program-level.interface';
import {FacultyCode} from '../../../../shared/model/common/faculty-code.interface';
import {GraduateCenter} from '../../../../shared/model/common/graduate-center.interface';
import { FieldCode } from "../../../../shared/model/common/field-code.interface";
import { ProgramCode } from "../../../../shared/model/common/program-code.interface";

@Component({
  selector: 'pams-program-field-code-editor',
  templateUrl: './program-field-code-editor.dialog.html',
})

export class ProgramFieldCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _programFieldCode: ProgramFieldCode;
  private _programCode:ProgramCode;
  private _fieldCode:FieldCode;
  private _facultyCode:FacultyCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramFieldCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar, ) {
  }

  set programFieldCode(value: ProgramFieldCode) {
    this._programFieldCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.editorForm = this.formBuilder.group(<ProgramFieldCode>{
      id: null,
      code: '',
      fieldCode: <FieldCode>{},
      programCode: <ProgramCode>{},
      facultyCode: <FacultyCode>{},
    });

    if (this.edit) this.editorForm.patchValue(this._programFieldCode);
  }

  // submit(programFieldCode: ProgramFieldCode, isValid: boolean) {
  //   this._facultyCode = programFieldCode.facultyCode;
  //   this._programCode = programFieldCode.programCode;
  //   this._fieldCode = programFieldCode.fieldCode;
  //   programFieldCode.code = this._programCode.code + '-' + this._fieldCode.code;

  //   console.log( this._programCode.code );
  //   console.log( this._fieldCode.code );
  //   console.log( programFieldCode.code );
  //   console.log( "save click" );

  //   if (confirm('Confirm to update program field code?')) {
  //   if (!programFieldCode.id) this.store.dispatch(this.actions.saveProgramFieldCode(this.programFieldCode));
  //   else  this.store.dispatch(this.actions.updateProgramFieldCode(programFieldCode));
  //   this.dialog.close();
  //   };
  // }
  submit(code: ProgramFieldCode, isValid: boolean) {
    if (confirm('Confirm to update program code?')) {
    if (!code.id) this.store.dispatch(this.actions.saveProgramFieldCode(code));
    else  this.store.dispatch(this.actions.updateProgramFieldCode(code));
    this.dialog.close();
    };
  }
}
