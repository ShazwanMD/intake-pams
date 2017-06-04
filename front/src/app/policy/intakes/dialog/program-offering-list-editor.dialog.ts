import { Component, ViewContainerRef, OnInit, AfterViewInit, ChangeDetectionStrategy } from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import { MdDialogRef, MdSnackBar } from "@angular/material";
import {Observable} from "rxjs/Observable";
import {PolicyModuleState} from "../../index";
import { IntakeActions } from "../intake.action";
import { Intake } from "../intake.interface";
import { ProgramOffering } from "../program-offering.interface";
import { ProgramCode } from "../../../common/program-codes/program-code.interface";

@Component({
  selector: 'pams-program-offering-list-editor',
  templateUrl: './program-offering-list-editor.dialog.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProgramOfferingListEditorDialog {
//implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _programOffering: ProgramOffering;
  private _intake: Intake;
  private intake$:Observable<Intake>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramOfferingListEditorDialog>,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private snackBar: MdSnackBar) {
  }

  set programOffering(programOffering) {
    console.log("programOffering.id :" + programOffering.programCode.id);
    this._programOffering = programOffering;
    this.edit = true;
  }

  set intake(intake: Intake) {
    this._intake = intake;
    this.edit = true;

  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<ProgramOffering>{
      id:null,
      projection:0,
      interview:true,
      generalCriteria:'',
      specificCriteria:'',
      programCode: <ProgramCode>{},
    });
    console.log("this._programOffering :"+this._programOffering.programCode);
    console.log("this._intake :"+this._intake.id);
    if (this.edit) this.editorForm.patchValue(this._programOffering);
  }

  submit(programOffering: ProgramOffering, isValid: boolean) {
    if (programOffering.id)this.store.dispatch(this.actions.updateProgramOffering(this._intake, programOffering));
    this.dialog.close();
  }
}