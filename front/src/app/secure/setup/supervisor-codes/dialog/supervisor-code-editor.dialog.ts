import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {SupervisorCode} from '../../../../shared/model/common/supervisor-code.interface';

@Component({
  selector: 'pams-supervisor-code-editor',
  templateUrl: './supervisor-code-editor.dialog.html',
})

export class SupervisorCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _supervisorCode: SupervisorCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SupervisorCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set supervisorCode(value: SupervisorCode) {
    this._supervisorCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.editorForm = this.formBuilder.group(<SupervisorCode>{
      id: null,
      code: '',
      name: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._supervisorCode);
  }

  submit(code: SupervisorCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Confirm to update supervisor code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveSupervisorCode(code));
    else  this.store.dispatch(this.actions.updateSupervisorCode(code));
    this.dialog.close();
    });
  }

}
