import {SupervisorOfferingSelectorDialog} from './dialog/supervisor-offering-selector.dialog';
import {Referee} from '../referee.interface';
import {Component, Input, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {RefereeEditorDialog} from "./dialog/referee-editor.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";
import {ProgramOfferingSelectorDialog} from "./dialog/program-offering-selector.dialog";
import {StudyModeOfferingSelectorDialog} from "./dialog/study-mode-offering-selector.dialog";


@Component({
  selector: 'pams-program-choice',
  templateUrl: './program-choice.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProgramChoiceComponent implements OnInit {

  @Input() intakeApplication: IntakeApplication;

  private programSelectorDialogRef: MdDialogRef<ProgramOfferingSelectorDialog>;
  private studyModeSelectorDialogRef: MdDialogRef<StudyModeOfferingSelectorDialog>;
  private supervisorSelectorDialogRef: MdDialogRef<SupervisorOfferingSelectorDialog>;

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
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

  showSupervisorSelectionDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '100%';
    config.position = {top: '0px'};
    this.supervisorSelectorDialogRef = this.dialog.open(SupervisorOfferingSelectorDialog, config);
    this.supervisorSelectorDialogRef.componentInstance.intake = this.intakeApplication.intake;
    this.supervisorSelectorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.supervisorSelectorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

}
