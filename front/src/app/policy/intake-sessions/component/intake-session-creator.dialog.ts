import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {PolicyModuleState} from "../../index";
import {IntakeSession} from "../../intake-sessions/intake-session.interface";
import {GraduateCentre} from "../../../common/graduate-centres/graduate-centre.interface";
import {ProgramLevel} from "../../program-levels/program-level.interface";
import {IntakeSessionActions} from "../intake-session.action";


@Component({
  selector: 'pams-intake-session-creator',
  templateUrl: './intake-session-creator.dialog.html',
})

export class IntakeSessionCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private actions: IntakeSessionActions,
              private dialog: MdDialogRef<IntakeSessionCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<IntakeSession>{
      id: null,
      code: '',
      label: '',
      descriptionMs: '',
      descriptionEn: '',
      year: 0,
      current: false,
    });
  }

  save(intake: IntakeSession, isValid: boolean) {
    // todo(samiya): add method, effect, action
    // this.store.dispatch(this.actions.saveIntakeSession(intake));
    this.dialog.close();
  }
}
