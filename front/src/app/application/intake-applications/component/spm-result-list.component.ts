import { SpmResultEditorDialog } from './dialog/spm-result-editor.dialog';
import {SpmResult} from '../spm-result.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";


@Component({
  selector: 'pams-spm-result-list',
  templateUrl: './spm-result-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class SpmResultListComponent implements OnInit {

  @Input() spmResults: SpmResult[];
  @Input() intakeApplication: IntakeApplication;

  private selectedRows: SpmResult[];
  private creatorDialogRef: MdDialogRef<SpmResultEditorDialog>;
  private columns: any[] = [
    {name: 'subjectCode.description', label: 'Subject Name'},
    {name: 'grade', label: 'Grade'},
    {name: 'year', label: 'Year'},
    // {name: 'aggregate', label: 'Aggregate'},
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
    this.creatorDialogRef = this.dialog.open(SpmResultEditorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
}
