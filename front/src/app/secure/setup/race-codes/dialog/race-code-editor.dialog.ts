import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {RaceCode} from '../../../../shared/model/common/race-code.interface';

@Component({
  selector: 'pams-race-code-creator',
  templateUrl: './race-code-editor.dialog.html',
})

export class RaceCodeEditorDialog implements OnInit {

  private createForm: FormGroup;
  private edit: boolean = false;
  private _raceCode: RaceCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<RaceCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set raceCode(value: RaceCode) {
    this._raceCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<RaceCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
      prefix: '',
    });

  if (this.edit) this.createForm.patchValue(this._raceCode);
 }

  save(code: RaceCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Update race code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
    if (!code.id) this.store.dispatch(this.actions.saveRaceCode(code));
    else  this.store.dispatch(this.actions.updateRaceCode(code));
    this.dialog.close();
  });
 }
}
