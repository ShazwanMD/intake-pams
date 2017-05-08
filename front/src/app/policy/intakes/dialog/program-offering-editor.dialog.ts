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
import {ProgramCode} from "../../../common/program-codes/program-code.interface";
import {ProgramOffering} from "../program-offering.interface";
import {CommonModuleState} from "../../../common/index";
import {CommonActions} from "../../../common/common.action";
import {Observable} from "rxjs";


@Component({
  selector: 'pams-program-offering-editor',
  templateUrl: './program-offering-editor.dialog.html',
})

export class ProgramOfferingEditorDialog implements OnInit {

  private editorForm: FormGroup;
  @Input() intake: Intake;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<ProgramOfferingEditorDialog>) {
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<ProgramOffering>{
      id: null,
      projection: 0,
      interview: true,
      programCode: <ProgramCode>{},
    });
  }

  add(offering: ProgramOffering, isValid: boolean) {
    console.log("add program offering");
    this.store.dispatch(this.actions.addProgramOffering(this.intake, offering));
    this.dialog.close();
  }
}
