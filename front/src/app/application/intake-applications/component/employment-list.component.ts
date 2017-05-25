import {Employment} from './../employment.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {IntakeApplication} from "../intake-application.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {EmploymentCreatorDialog} from "./dialog/employment-creator.dialog";


@Component({
  selector: 'pams-employment-list',
  templateUrl: './employment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class EmploymentListComponent implements OnInit {

  @Input() employments: Employment[];
  @Input() intakeApplication: IntakeApplication;

  private creatorDialogRef: MdDialogRef<EmploymentCreatorDialog>;
  private columns: any[] = [
    {name: 'employer', label: 'Employer'},
    {name: 'designation', label: 'Designation'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
  ];

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {}

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
    this.creatorDialogRef = this.dialog.open(EmploymentCreatorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication = this.intakeApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

}
