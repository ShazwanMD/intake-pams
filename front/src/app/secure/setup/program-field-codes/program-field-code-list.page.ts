import { ProgramFieldCode } from './../../../shared/model/common/program-field-code.interface';
import {
  Component,
  Input,
  EventEmitter,
  Output,
  ChangeDetectionStrategy,
  OnInit,
  AfterViewInit,
  ViewContainerRef,
} from '@angular/core';
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ProgramFieldCodeEditorDialog} from './dialog/program-field-code-editor.dialog';

@Component({
  selector: 'pams-program-field-list.page',
  templateUrl: './program-field-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramFieldCodeListPage implements OnInit{
  private PROGRAM_FIELD_CODES = "setupModuleState.programFieldCodes".split(".");
  private programFieldCodes$: Observable<ProgramFieldCode[]>;
  private creatorDialogRef: MdDialogRef<ProgramFieldCodeEditorDialog>;

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {


    this.programFieldCodes$ = this.store.select(...this.PROGRAM_FIELD_CODES);
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramFieldCodes());
    this.store.dispatch(this.actions.changeTitle("Program Field Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:ProgramFieldCode): void {
    this.showDialog(code);
  }
  delete(code: ProgramFieldCode): void {
    this.store.dispatch(this.actions.removeProgramFieldCode(code))
  }

  private showDialog(code:ProgramFieldCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ProgramFieldCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.programFieldCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
