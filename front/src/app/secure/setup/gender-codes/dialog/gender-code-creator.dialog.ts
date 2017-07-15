import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {GenderCode} from '../../../../shared/model/common/gender-code.interface';

@Component({
  selector: 'pams-gender-code-creator',
  templateUrl: './gender-code-creator.dialog.html',
})

export class GenderCodeCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GenderCodeCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
  ) {
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<GenderCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
      prefix: '',

    });
  }

  save(code: GenderCode, isValid: boolean) {
    this.store.dispatch(this.actions.saveGenderCode(code));
  }
}
