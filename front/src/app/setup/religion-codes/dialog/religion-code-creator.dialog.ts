import { ReligionCode } from './../../../common/religion-codes/religion-code.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";


@Component({
  selector: 'pams-religion-code-creator',
  templateUrl: './religion-code-creator.dialog.html',
})

export class ReligionCodeCreatorDialog implements OnInit {

  private creatorForm: FormGroup;
  private edit: boolean = false;
  private _religionCode: ReligionCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ReligionCodeCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

set religionCode(value: ReligionCode) {
    this._religionCode = value;
    this.edit = true;
  }

  ngOnInit(): void {

    this.creatorForm = this.formBuilder.group(<ReligionCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });

if (this.edit) this.creatorForm.patchValue(this._religionCode);
}

   submit(code: ReligionCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveReligionCode(code));
    else  this.store.dispatch(this.actions.updateReligionCode(code));
    this.dialog.close();
  }
}