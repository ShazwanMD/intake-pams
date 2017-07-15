import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {NationalityCode} from '../../../../shared/model/common/nationality-code.interface';

@Component({
  selector: 'pams-nationality-code-creator',
  templateUrl: './nationality-code-creator.dialog.html',
})

export class NationalityCodeCreatorDialog implements OnInit {

  private creatorForm: FormGroup;
  private edit: boolean = false;
  private _nationalityCode: NationalityCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<NationalityCodeCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set nationalityCode(value: NationalityCode) {
    this._nationalityCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group(<NationalityCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });

    if (this.edit) this.creatorForm.patchValue(this._nationalityCode);
  }

  submit(code: NationalityCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Confirm to update nationality code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      if (!code.id) this.store.dispatch(this.actions.saveNationalityCode(code));
      else  this.store.dispatch(this.actions.updateNationalityCode(code));
      this.dialog.close();
    });
  }
}
