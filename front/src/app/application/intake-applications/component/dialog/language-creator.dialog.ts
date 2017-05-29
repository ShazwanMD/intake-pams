import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";
import {Language} from "../../language.interface";
import {LanguageCode} from "../../../../common/language-codes/language-code.interface";


@Component({
  selector: 'pams-language-creator',
  templateUrl: './language-creator.dialog.html',
})

export class LanguageCreatorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<LanguageCreatorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Language>{
      id: null,
      oral: 0,
      written: 0,
      languageCode: <LanguageCode>{},
    });
  }

  save(language: Language, isValid: boolean) {
    this.store.dispatch(this.actions.addLanguage(this._intakeApplication, language));
    this.dialog.close();
  }
}
