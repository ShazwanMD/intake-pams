import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {ProgramActions} from "../program.action";
import {PolicyModuleState} from "../../index";
import {Program} from "../program.interface";
import {IntakeSession} from "../../intake-sessions/intake-session.interface";
import {GraduateCentre} from "../../../common/graduate-centres/graduate-centre.interface";
import {ProgramLevel} from "../../program-levels/program-level.interface";


@Component({
  selector: 'pams-program-offering-creator',
  templateUrl: './program-offering-creator.dialog.html',
 // styleUrls: ['./program-offering-creator.dialog.scss'],
})

export class ProgramOfferingCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private actions: ProgramActions,
              private dialog: MdDialogRef<ProgramOfferingCreatorDialog>) {
  }

  ngOnInit(): void {

  //   this.createForm = this.formBuilder.group(<Program>{
  //     id: null,
  //     code: '',
  //     descriptionMs: '',
  //     descriptionEn: '',
  //   });
     }

  // save(code: Program, isValid: boolean) {
  //   this.store.dispatch(this.actions.saveProgramOffering(code));
  //   this.dialog.close();
  // }


}