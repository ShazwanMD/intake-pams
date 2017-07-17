import { VenueCode } from './../../../../shared/model/common/venue-code.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';


@Component({
  selector: 'pams-venue-code-editor',
  templateUrl: './venue-code-editor.dialog.html',
})

export class VenueCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _venueCode: VenueCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<VenueCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set venueCode(value: VenueCode) {
    this._venueCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<VenueCode>{
      id: null,
      code: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._venueCode);
  }

  submit(code: VenueCode, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Confirm to update venue code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      if (!code.id) this.store.dispatch(this.actions.saveVenueCode(code));
      else  this.store.dispatch(this.actions.updateVenueCode(code));
      this.dialog.close();
    });
  }
}
