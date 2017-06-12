import {Observable} from 'rxjs/Observable';
import {ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {StudyCenterCode} from '../../../common/study-center-codes/study-center-code.interface';
import {Referee} from '../referee.interface';
import {Component, Input, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {RefereeEditorDialog} from "./dialog/referee-editor.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";
import {StudyModeOfferingSelectorDialog} from "./dialog/study-mode-offering-selector.dialog";
import {ProgramOfferingSelectorDialog} from "./dialog/program-offering-selector.dialog";


@Component({
  selector: 'pams-study-center-choice',
  templateUrl: './study-center-choice.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class StudyCenterChoiceComponent implements OnInit {

  @Input() intakeApplication: IntakeApplication;

  private programSelectorDialogRef: MdDialogRef<ProgramOfferingSelectorDialog>;
  private studyModeSelectorDialogRef: MdDialogRef<StudyModeOfferingSelectorDialog>;

  private applicationForm: FormGroup;
  private intakeApplication$: Observable<IntakeApplication>;

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private formBuilder: FormBuilder,
              private dialog: MdDialog) {
  }


  ngOnInit(): void {

    this.applicationForm = this.formBuilder.group(<IntakeApplication>{
      studyCenterCode: <StudyCenterCode>{},

    });
  }

  showProgramSelectionDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '100%';
    config.position = {top: '0px'};
    this.programSelectorDialogRef = this.dialog.open(ProgramOfferingSelectorDialog, config);
    this.programSelectorDialogRef.componentInstance.intake = this.intakeApplication.intake;
    this.programSelectorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.programSelectorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  showStudyModeSelectionDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '100%';
    config.position = {top: '0px'};
    this.studyModeSelectorDialogRef = this.dialog.open(StudyModeOfferingSelectorDialog, config);
    this.studyModeSelectorDialogRef.componentInstance.intake = this.intakeApplication.intake;
    this.studyModeSelectorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.studyModeSelectorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
}
