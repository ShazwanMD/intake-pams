import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {PolicyModuleState} from "../../index";
import { ProgramOffering } from "../program-offering.interface";
import { IntakeActions } from "../intake.action";
import { Intake } from "../intake.interface";


@Component({
  selector: 'pams-program-offering-list-editor',
  templateUrl: './program-offering-list-editor.dialog.html',
})

export class ProgramOfferingListEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _programOffering: ProgramOffering;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramOfferingListEditorDialog>,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions) {
  }

  set programOffering(value: ProgramOffering) {
    this._programOffering = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<ProgramOffering>{
      projection:0,
      interview:false,
      generalCriteria:'',
      specificCriteria:'',   
    });

    if (this.edit) this.editorForm.patchValue(this._programOffering);
  }

  submit(intake:Intake, id: ProgramOffering, isValid: boolean) {
    if (!intake.id) intake =>this.store.dispatch(this.actions.addProgramOffering(intake,id));
    else  this.store.dispatch(this.actions.updateProgramOffering(intake,id));
    this.dialog.close();
  }
}