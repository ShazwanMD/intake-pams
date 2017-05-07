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

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ReligionCodeCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions
  ) {
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<ReligionCode>{
      id: null,
      code: '',
      name: '',
      descriptionMs: '',
      descriptionEn: '',
      prefix: '',
     

    });
  }

  save(code: ReligionCode, isValid: boolean) {
    this.store.dispatch(this.actions.saveReligionCode(code));
  }
}
