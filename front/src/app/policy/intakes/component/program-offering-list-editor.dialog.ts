import { Component, ViewContainerRef, OnInit, AfterViewInit, ChangeDetectionStrategy } from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {PolicyModuleState} from "../../index";
import { ProgramOffering } from "../program-offering.interface";
import { IntakeActions } from "../intake.action";
import { Intake } from "../intake.interface";
import {Observable} from "rxjs/Observable";
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
              private actions: IntakeActions) {
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
      interview:false,
      generalCriteria:'',
      specificCriteria:'',   
      programCode: <ProgramCode>{},
    });
    console.log("this._programOffering :"+this._programOffering.programCode);
    if (this.edit) this.editorForm.patchValue(this._programOffering);
  }

  submit(intake :Intake,id: ProgramOffering, isValid: boolean) {
    // if (!intake.id) intake =>this.store.dispatch(this.actions.addProgramOffering(intake,id));
    // else  
    this.store.dispatch(this.actions.updateProgramOffering(this._intake, id));
    this.dialog.close();
  }
}