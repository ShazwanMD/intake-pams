import { NationalityCode } from './../../../common/nationality-codes/nationality-code.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";


@Component({
  selector: 'pams-nationality-code-creator',
  templateUrl: './nationality-code-creator.dialog.html',
})

export class NationalityCodeCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<NationalityCodeCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions
  ) {
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<NationalityCode>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
      prefix: '',
     

    });
  }

  save(code: NationalityCode, isValid: boolean) {
    this.store.dispatch(this.actions.saveNationalityCode(code));
  }
}