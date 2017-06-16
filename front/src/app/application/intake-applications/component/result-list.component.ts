import { StpmResultEditorDialog } from './dialog/stpm-result-editor.dialog';
import { DiplomaResultEditorDialog } from './dialog/diploma-result-editor.dialog';
import { SpmResultEditorDialog } from './dialog/spm-result-editor.dialog';
import { BachelorResultEditorDialog } from './dialog/bachelor-result-editor.dialog';
import { ApplicationActions } from './../../application.action';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Result } from './../result.interface';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef } from '@angular/core';
import { IntakeApplicationActions } from "../intake-application.action";
import { Store } from "@ngrx/store";
import { ApplicationModuleState } from "../../index";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";
import { IntakeApplication } from "../intake-application.interface";


@Component({
  selector: 'pams-result-list',
  templateUrl: './result-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ResultListComponent implements OnInit {

  @Input() results: Result;
  @Input() intakeApplication: IntakeApplication;


  private creatorBachelorDialogRef: MdDialogRef<BachelorResultEditorDialog>;
  private creatorDiplomaDialogRef: MdDialogRef<DiplomaResultEditorDialog>;
  private creatorStpmDialogRef: MdDialogRef<StpmResultEditorDialog>;
  private creatorSpmDialogRef: MdDialogRef<SpmResultEditorDialog>;
  private columns: any[] = [
    { name: 'resultType', label: 'Result Type' },
    { name: 'name', label: 'Name' },
    { name: 'field', label: 'Field' },
    { name: 'graduationYear', label: 'Graduation Year' },
    { name: 'resultAlphanumeric', label: 'Result Alphanumeric' },
    { name: 'resultNumeric', label: 'Result Numeric' },
  ];

  constructor(private actions: IntakeApplicationActions,
    private vcf: ViewContainerRef,
    private store: Store<ApplicationModuleState>,
    private dialog: MdDialog) {
  }

  ngOnInit(): void {
  }

  createBachelor(): void {
    this.showDialog1(null);
  }

  createSpm(): void {
    this.showDialog2(null);
  }

  createDiploma(): void {
    this.showDialog3(null);
  }

  createStpm(): void {
    this.showDialog4(null);
  }

  filter(): void {
  }

  showDialog1(bachelorResult: Result): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = { top: '65px' };
    this.creatorBachelorDialogRef = this.dialog.open(BachelorResultEditorDialog, config);
    this.creatorBachelorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.creatorBachelorDialogRef.afterClosed().subscribe(res => {
    });
  }

  showDialog2(spmResult: Result): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = { top: '65px' };
    this.creatorSpmDialogRef = this.dialog.open(SpmResultEditorDialog, config);
    this.creatorSpmDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.creatorSpmDialogRef.afterClosed().subscribe(res => {
    });
  }

  showDialog3(diplomaResult: Result): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = { top: '65px' };
    this.creatorDiplomaDialogRef = this.dialog.open(DiplomaResultEditorDialog, config);
    this.creatorDiplomaDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.creatorDiplomaDialogRef.afterClosed().subscribe(res => {
    });
  }

  showDialog4(stpmResult: Result): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = { top: '65px' };
    this.creatorStpmDialogRef = this.dialog.open(StpmResultEditorDialog, config);
    this.creatorStpmDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.creatorStpmDialogRef.afterClosed().subscribe(res => {
    });
  }

}
