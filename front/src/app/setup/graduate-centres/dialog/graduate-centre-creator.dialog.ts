import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {SetupModuleState} from "../../index";
import {BankCode} from "../../../common/bank-codes/bank-code.interface";
import {SetupActions} from "../../setup.action";
import {GraduateCentre} from "../../../common/graduate-centres/graduate-centre.interface";


@Component({
  selector: 'pams-graduate-centre-creator',
  templateUrl: './graduate-centre-creator.dialog.html',
})

export class GraduateCentreCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GraduateCentreCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions
  ) {
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<GraduateCentre>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });
  }

  save(code: BankCode, isValid: boolean) {
    this.store.dispatch(this.actions.saveGraduateCentre(code));
    this.dialog.close();
  }
}
