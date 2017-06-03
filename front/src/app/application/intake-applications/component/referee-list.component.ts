import { Referee } from './../referee.interface';
import { RefereeEditorDialog } from './dialog/referee-editor.dialog';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {IntakeApplication} from "../intake-application.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";




@Component({
  selector: 'pams-referee-list',
  templateUrl: './referee-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class RefereeListComponent implements OnInit {

  
  @Input() referees: Referee[];
  @Input() intakeApplication: IntakeApplication;

  private selectedRows: Referee[];
  private editorDialogRef: MdDialogRef<RefereeEditorDialog>;
  private columns: any[] = [
    {name: 'name', label: 'Name'},
    {name: 'officeAddrs', label: 'OfficeAddrs'},
    {name: 'occupation', label: 'Occupation'},
    {name: 'phoneNo', label: 'PhoneNo'},
  ];

 constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {}

  ngOnInit(): void {
    this.selectedRows = this.referees.filter(value => value.selected);
  }

  create(): void {
     this.showDialog(null);
  }

  edit(referee: Referee): void {
     this.showDialog(referee);
  }

  delete(referee:Referee): void {
    this.store.dispatch(this.actions.deleteReferee(this.intakeApplication, referee));
  }

  filter(): void {
  }

  selectRow(referee: Referee): void {
  }

  selectAllRows(referees: Referee[]): void {
  }

  showDialog(referee: Referee): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.editorDialogRef = this.dialog.open(RefereeEditorDialog, config);
    this.editorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    if (referee) this.editorDialogRef.componentInstance.referee = referee;
    this.editorDialogRef.afterClosed().subscribe(res => {
        this.selectedRows = [];
    });
  }
}