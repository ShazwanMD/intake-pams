
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {BankCode} from '../../../../shared/model/common/bank-code.interface';

@Component({
  selector: 'pams-bank-code-creator',
  templateUrl: './bank-code-creator.dialog.html',
})

export class BankCodeCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<BankCodeCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
  ) {
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<BankCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });
  }

  save(code: BankCode, isValid: boolean) {
    this.store.dispatch(this.actions.saveBankCode(code));
    this.dialog.close();
  }
}
