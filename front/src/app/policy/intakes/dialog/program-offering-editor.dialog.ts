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
import {GraduateCentre} from "../../../common/graduate-centre.interface";
import {ProgramCode} from "../../../common/program-code.interface";
import {ProgramOffering} from "../program-offering.interface";
import {CommonModuleState} from "../../../common/index";
import {CommonActions} from "../../../common/common.action";
import {Observable} from "rxjs";


@Component({
  selector: 'pams-program-offering-editor',
  templateUrl: './program-offering-editor.dialog.html',
})

export class ProgramOfferingEditorDialog implements OnInit {

  private PROGRAM_CODES = "commonModuleState.programCodes".split(".");
  private programCodes$: Observable<ProgramCode[]>;
  private editorForm: FormGroup;
  @Input() intake: Intake;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private commonStore: Store<CommonModuleState>,
              private actions: IntakeActions,
              private commonActions: CommonActions,
              private dialog: MdDialogRef<ProgramOfferingEditorDialog>) {
    this.programCodes$ = this.commonStore.select(...this.PROGRAM_CODES);
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<ProgramOffering>{
      id: null,
      projection: 0,
      interview: true,
      programCode: <ProgramCode>{},
    });

    // retrieve select options
    this.store.dispatch(this.commonActions.findProgramCodes());
  }

  add(offering: ProgramOffering, isValid: boolean) {
    console.log("add program offering");
    this.store.dispatch(this.actions.addProgramOffering(this.intake, offering));
    this.dialog.close();
    // todo(uda): snackbar
  }
}
