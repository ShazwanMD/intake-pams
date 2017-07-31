import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {GenderCode} from '../../../../shared/model/common/gender-code.interface';

@Component({
  selector: 'pams-gender-code-creator',
  templateUrl: './gender-code-editor.dialog.html',
})

export class GenderCodeEditorDialog implements OnInit {

  private createForm: FormGroup;
  private edit: boolean = false;
  private _genderCode: GenderCode;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GenderCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set genderCode(value: GenderCode) {
    this._genderCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<GenderCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });

    if (this.edit) this.createForm.patchValue(this._genderCode);
  }

  save(code: GenderCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Update race code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveRaceCode(code));
    else  this.store.dispatch(this.actions.updateRaceCode(code));
    this.dialog.close();
    });
  }
}
