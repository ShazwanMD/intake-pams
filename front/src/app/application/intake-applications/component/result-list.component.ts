import { SpmResultEditorDialog } from './dialog/spm-result-editor.dialog';
import { BachelorResultEditorDialog } from './dialog/bachelor-result-editor.dialog';
import { ApplicationActions } from './../../application.action';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Result } from './../result.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IntakeApplication} from "../intake-application.interface";


@Component({
  selector: 'pams-result-list',
  templateUrl: './result-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ResultListComponent implements OnInit {

  @Input() results: Result[];
  @Input() intakeApplication: IntakeApplication;

  private selectedRows: Result[];
  private editorBachelorDialogRef: MdDialogRef<BachelorResultEditorDialog>;
  private editorSpmDialogRef: MdDialogRef<SpmResultEditorDialog>;
  private columns: any[] = [
    {name: 'resultType', label: 'Result Type'},
    {name: 'name', label: 'Name'},
    {name: 'field', label: 'Field'},
    {name: 'graduationYear', label: 'Graduation Year'},
    {name: 'resultAlphanumeric', label: 'Result Alphanumeric'},
    {name: 'resultNumeric', label: 'Result Numeric'},
  ];

   constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.results.filter(value => value.selected);
  }

  createBachelor(): void {
    this.showDialog1(null);
  }

  editBachelor(result: Result): void {
    this.showDialog1(result);
  }

  createSpm(): void {
    this.showDialog2(null);
  }

  editSpm(result: Result): void {
    this.showDialog2(result);
  } 

  delete(result: Result): void {
    this.store.dispatch(this.actions.deleteResult(this.intakeApplication, result));
  }

  filter(): void {
  }

  addResult(): void {
     //this.ResultDialog(null);
  }

  selectRow(result: Result): void {
  }

  selectAllRows(results: Result[]): void {
  }

   showDialog1(bachelorResult: Result): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.editorBachelorDialogRef = this.dialog.open(BachelorResultEditorDialog, config);
    this.editorBachelorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    if (bachelorResult) this.editorBachelorDialogRef.componentInstance.bachelorResult = bachelorResult;
    this.editorBachelorDialogRef.afterClosed().subscribe(res => {
      this.selectedRows = [];
    });
  }

    showDialog2(spmResult: Result): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.editorSpmDialogRef = this.dialog.open(SpmResultEditorDialog, config);
    this.editorSpmDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    if (spmResult) this.editorSpmDialogRef.componentInstance.spmResult = spmResult;
    this.editorSpmDialogRef.afterClosed().subscribe(res => {
      this.selectedRows = [];
    });
  } 
}