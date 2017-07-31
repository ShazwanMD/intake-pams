import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {GraduateCenter} from '../../../../shared/model/common/graduate-center.interface';

@Component({
  selector: 'pams-graduate-center-creator',
  templateUrl: './graduate-center-editor.dialog.html',
})

export class GraduateCenterEditorDialog implements OnInit {

  private createForm: FormGroup;
  private edit: boolean = false;
  private _graduateCenter: GraduateCenter;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GraduateCenterEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set graduateCenter(value: GraduateCenter) {
    this._graduateCenter = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<GraduateCenter>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });

    if (this.edit) this.createForm.patchValue(this._graduateCenter);
  }

  save(code: GraduateCenter, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Update graduate center?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveGraduateCenter(code));
    else  this.store.dispatch(this.actions.updateGraduateCenter(code));
    this.dialog.close();
    });
  }
}
