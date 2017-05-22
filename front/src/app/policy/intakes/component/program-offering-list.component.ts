import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {IntakeTask} from "../intake-task.interface";
import {ProgramOffering} from "../program-offering.interface";
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {MdDialogConfig, MdDialog, MdDialogRef} from "@angular/material";
import {ProgramOfferingEditorDialog} from "../dialog/program-offering-editor.dialog";
import {ProgramOfferingListEditorDialog} from "./program-offering-list-editor.dialog";

import { Observable } from "rxjs/Rx";

@Component({
  selector: 'pams-program-offering-list',
  templateUrl: './program-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramOfferingListComponent {
  

  @Input() intake: Intake;
  @Input() programOfferings: ProgramOffering[];

  programOfferings$: Observable<ProgramOffering[]>;

  private editorDialogRef: MdDialogRef<ProgramOfferingEditorDialog>;
  private editorDialogRef2: MdDialogRef<ProgramOfferingListEditorDialog>;
  private INTAKE = "policyModuleState.intake".split(".");
  private PROGRAM_OFFERINGS = "policyModuleState.programOfferings".split(".");
  private intake$:Observable<Intake>;
 

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private vcf: ViewContainerRef,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialog) {
          this.intake$ = this.store.select(...this.INTAKE);
          this.programOfferings$ = this.store.select(...this.PROGRAM_OFFERINGS);

  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramOfferings(this.intake));
  }
  

   createDialog2(): void {
    this.showDialog();
  }

  editDialog2(intake:Intake,id:ProgramOffering): void {
  //  this.showDialog(intake,id);
  }

  delete(intake:Intake, id:ProgramOffering): void {
    this.store.dispatch(this.actions.deleteProgramOffering(intake,id))
  }

  filter(): void {
  }

   showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(ProgramOfferingEditorDialog, config);
    this.editorDialogRef.componentInstance.intake = this.intake;

    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("closeDialog");
      // reload program offerings
      this.store.dispatch(this.actions.findProgramOfferings(this.intake));
    });
  }
  
    showDialog2(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.editorDialogRef2 = this.dialog.open(ProgramOfferingListEditorDialog, config);
   // this.editorDialogRef2.componentInstance.programOffering = (this.intake);

    this.editorDialogRef2.afterClosed().subscribe(res => {
      console.log("closeDialog");
      // reload program offerings
      this.store.dispatch(this.actions.findProgramOfferings(this.intake));
    });
  }

}
