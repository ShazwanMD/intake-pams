import { Observable } from 'rxjs';
import { IntakeSession } from './../intake-session.interface';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';

import { IntakeSessionActions } from "../intake-session.action";
import { Store } from "@ngrx/store";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";
import { PolicyModuleState } from "../../index";
import { IntakeSessionEditorDialog } from "./intake-session-editor.dialog";

@Component({
  selector: 'pams-intake-session-list',
  templateUrl: './intake-session-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeSessionListComponent {

  @Input() intakeSessions: IntakeSession[];
  @Output() view = new EventEmitter<IntakeSession>();

  private INTAKE_SESSION = "policyModuleState.intakeSession".split(".");
  private intakeSession$:Observable<IntakeSession>;
  private creatorDialogRef: MdDialogRef<IntakeSessionEditorDialog>;
  
  
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'Description (MS)'},
    {name: 'descriptionEn', label: 'Description (EN)'},
    {name: 'year', label: 'Year'},
    {name: 'current', label: 'Current'},    
    {name: 'id', label: 'id'},
    {name: 'action', label: ''}
  ];

    constructor(private actions: IntakeSessionActions,
              private store: Store<PolicyModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.intakeSession$ = this.store.select(...this.INTAKE_SESSION);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findIntakeSessions());
    
  }

   createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:IntakeSession): void {
    this.showDialog(code);
  }

  delete(id: IntakeSession): void {
    this.store.dispatch(this.actions.removeIntakeSession(id))
  }

  filter(): void {
  }

  private showDialog(code:IntakeSession): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(IntakeSessionEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.intakeSession = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
