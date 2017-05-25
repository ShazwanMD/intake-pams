import { RefereeCreatorDialog } from './dialog/referee-creator.dialog';
import { Referee } from './../referee.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {IntakeApplication} from "../intake-application.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";



@Component({
  selector: 'pams-referee-tab',
  templateUrl: './referee-tab.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class RefereeTabComponent implements OnInit {

  @Input() intakeApplication: IntakeApplication;
  @Input() referees: Referee[];
  private creatorDialogRef: MdDialogRef<RefereeCreatorDialog>;

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
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(RefereeCreatorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication = this.intakeApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

}
