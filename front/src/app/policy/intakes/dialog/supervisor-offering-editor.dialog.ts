  import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Intake} from "../intake.interface";
import {PolicyService} from "../../../../services/policy.service";
import {IntakeSession} from "../../intake-sessions/intake-session.interface";
import {GraduateCentre} from "../../../common/graduate-centres/graduate-centre.interface";
//import {ProgramCode} from "../../../common/program-codes/program-code.interface";
//import {ProgramOffering} from "../program-offering.interface";
import {CommonModuleState} from "../../../common/index";
import {CommonActions} from "../../../common/common.action";
import {Observable} from "rxjs";
import { SupervisorOffering } from "../supervisor-offering.interface";
import { SupervisorCode } from "../../../common/supervisor-codes/supervisor-code.interface";


@Component({
  selector: 'pams-supervisor-offering-editor',
  templateUrl: './supervisor-offering-editor.dialog.html',
})

export class SupervisorOfferingEditorDialog implements OnInit {

  private editorForm: FormGroup;
  @Input() intake: Intake;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<SupervisorOfferingEditorDialog>) {
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<SupervisorOffering>{
      id: null,
      projection: 0,
      supervisorCode: <SupervisorCode>{},
    });
  }

  add(supervisor: SupervisorOffering, isValid: boolean) {
    console.log("add supervisor offering");
    this.store.dispatch(this.actions.addSupervisorOffering(this.intake, supervisor));
    this.dialog.close();
  }
}
