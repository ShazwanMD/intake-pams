import { ParliamentCode } from './../../../shared/model/common/parliament-code.interface';
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
import {ParliamentCodeEditorDialog} from './dialog/parliament-code-editor.dialog';

@Component({
  selector: 'pams-parliament-list.page',
  templateUrl: './parliament-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ParliamentCodeListPage implements OnInit{
  private PARLIAMENT_CODES = "setupModuleState.parliamentCodes".split(".");
  private parliamentCodes$: Observable<ParliamentCode[]>;
  private creatorDialogRef: MdDialogRef<ParliamentCodeEditorDialog>;

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {


    this.parliamentCodes$ = this.store.select(...this.PARLIAMENT_CODES);
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findParliamentCodes());
    this.store.dispatch(this.actions.changeTitle("Parliament Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:ParliamentCode): void {
    this.showDialog(code);
  }
  delete(code: ParliamentCode): void {
    this.store.dispatch(this.actions.removeParliamentCode(code))
  }

  private showDialog(code:ParliamentCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ParliamentCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.parliamentCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
