import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {DunCode} from '../../../../shared/model/common/dun-code.interface';

@Component({
  selector: 'pams-dun-code-editor',
  templateUrl: './dun-code-editor.dialog.html',
})

export class DunCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _dunCode: DunCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<DunCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set dunCode(value: DunCode) {
    this._dunCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<DunCode>{
      id: null,
      code: '',
      description: '',
    });

    if (this.edit) this.editorForm.patchValue(this._dunCode);
  }

  submit(code: DunCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Confirm to update dun code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      if (!code.id) this.store.dispatch(this.actions.saveDunCode(code));
      else  this.store.dispatch(this.actions.updateDunCode(code));
      this.dialog.close();
    });
  }
}
