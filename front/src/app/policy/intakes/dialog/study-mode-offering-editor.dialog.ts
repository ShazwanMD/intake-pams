import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import { MdDialogRef, MdSnackBar } from "@angular/material";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Intake} from "../intake.interface";
import {StudyModeOffering} from "../study-mode-offering.interface";
import {StudyMode} from "../../../common/study-modes/study-mode.interface";


@Component({
  selector: 'pams-study-mode-offering-editor',
  templateUrl: './study-mode-offering-editor.dialog.html',
})

export class StudyModeOfferingEditorDialog implements OnInit {

  private editorForm: FormGroup;
  @Input() intake: Intake;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<StudyModeOfferingEditorDialog>,
              private snackBar: MdSnackBar) {
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<StudyModeOffering>{
      id: null,
      studyMode: <StudyMode>{},
    });
  }

  add(offering: StudyModeOffering, isValid: boolean) {
    console.log("add studyMode offering");
    this.store.dispatch(this.actions.addStudyModeOffering(this.intake, offering));
    this.dialog.close();
  }
}
