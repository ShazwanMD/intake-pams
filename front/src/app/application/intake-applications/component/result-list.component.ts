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
  //private editorDialogRef: MdDialogRef<ResultEditorDialog>;
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

  /*create(): void {
    this.showDialog(null);
  }*/

  /*edit(result: Result): void {
    this.showDialog(result);
  }*/

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

  /*showDialog(result: Result): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.editorDialogRef = this.dialog.open(ResultEditorDialog, config);
    this.editorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    if (result) this.editorDialogRef.componentInstance.result = result;
    this.editorDialogRef.afterClosed().subscribe(res => {
      this.selectedRows = [];
    });
  }*/
}