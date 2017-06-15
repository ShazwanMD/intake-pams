import { DiplomaResultEditorDialog } from './dialog/diploma-result-editor.dialog';
import {DiplomaResult} from '../diploma-result-interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";


@Component({
  selector: 'pams-diploma-result-list',
  templateUrl: './diploma-result-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class DiplomaResultListComponent implements OnInit {

  @Input() diplomaResults: DiplomaResult[];
  @Input() intakeApplication: IntakeApplication;

  private creatorDialogRef: MdDialogRef<DiplomaResultEditorDialog>;
  private columns: any[] = [
    {name: 'name', label: 'Name'},
    {name: 'cgpa', label: 'Cgpa'},
    {name: 'year', label: 'Year'},
    {name: 'resultType', label: 'Result Type'},
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
    this.creatorDialogRef = this.dialog.open(DiplomaResultEditorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
}
