import {Referee} from './../referee.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {RefereeCreatorDialog} from "./dialog/referee-creator.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";


@Component({
  selector: 'pams-referee-list',
  templateUrl: './referee-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class RefereeListComponent implements OnInit {

  @Input() referees: Referee[];
  @Input() intakeApplication: IntakeApplication;

  private creatorDialogRef: MdDialogRef<RefereeCreatorDialog>;
  private columns: any[] = [
    {name: 'name', label: 'Name'},
    {name: 'officeAddrs', label: 'OfficeAddrs'},
    {name: 'occupation', label: 'Occupation'},
    {name: 'phoneNo', label: 'PhoneNo'},
  ];

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
