import {Referee} from './../referee.interface';
import {Component, Input, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {RefereeCreatorDialog} from "./dialog/referee-creator.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";
import { StudyModeOfferingSelectorDialog } from "./dialog/study-mode-offering-selector.dialog";


@Component({
  selector: 'pams-study-center-choice',
  templateUrl: './study-center-choice.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class StudyCenterChoiceComponent implements OnInit {

  @Input() intakeApplication: IntakeApplication;

  private selectorDialogRef: MdDialogRef<StudyModeOfferingSelectorDialog>;

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '100%';
    config.position = {top: '0px'};
    this.selectorDialogRef = this.dialog.open(StudyModeOfferingSelectorDialog, config);
    this.selectorDialogRef.componentInstance.intake = this.intakeApplication.intake;
    this.selectorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.selectorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
}
