import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {StateCode} from '../../../../../shared/model/common/state-code.interface';

@Component({
  selector: 'pams-state-code-editor',
  templateUrl: './state-code-editor.dialog.html',
})

export class StateCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _stateCode: StateCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StateCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set stateCode(value: StateCode) {
    this._stateCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<StateCode>{
      id: null,
      code: '',
      name: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._stateCode);
  }

  submit(code: StateCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveStateCode(code));
    else  this.store.dispatch(this.actions.updateStateCode(code));
    this.dialog.close();
  }
}
