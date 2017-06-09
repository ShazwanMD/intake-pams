import { PolicyModuleState } from './../../../policy/index';
import { CommonModuleState } from './../../../common/index';
import { FacultyCode } from './../../../common/faculty-codes/faculty-code.interface';
import { ProgramLevel } from './../../../policy/program-levels/program-level.interface';
import { GraduateCenter } from '../../../common/graduate-centers/graduate-center.interface';
import { ProgramCode } from './../../../common/program-codes/program-code.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef, MdSnackBar,} from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";




@Component({
  selector: 'pams-program-code-creator',
  templateUrl: './program-code-creator.dialog.html',
})

export class ProgramCodeCreatorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _programCode: ProgramCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramCodeCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar
  ) {
  }


  set programCode(value: ProgramCode) {
    this._programCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.editorForm = this.formBuilder.group(<ProgramCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
      programLevel: <ProgramLevel>{},
      facultyCode: <FacultyCode>{},
      graduateCenter: <GraduateCenter>{},

    });

     if (this.edit) this.editorForm.patchValue(this._programCode);
  }

  submit(code: ProgramCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open("Confirm to update program code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveProgramCode(code));
    else  this.store.dispatch(this.actions.updateProgramCode(code));
    this.dialog.close();
    });
  }
}
