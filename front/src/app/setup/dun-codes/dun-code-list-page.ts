import {DunCode} from './../../common/dun-codes/dun-code.interface';
import {Component, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {DunCodeEditorDialog} from "./dialog/dun-code-editor.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-dun-list-page',
  templateUrl: './dun-code-list.page.html',
})
export class DunCodeListPage implements OnInit {

  private DUN_CODES = "setupModuleState.dunCodes".split(".");
  private dunCodes$: Observable<DunCode>;
  private creatorDialogRef: MdDialogRef<DunCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.dunCodes$ = this.store.select(...this.DUN_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findDunCodes());
    this.store.dispatch(this.actions.changeTitle("Dun Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:DunCode): void {
    this.showDialog(code);
  }

  delete(code: DunCode): void {
    this.store.dispatch(this.actions.removeDunCode(code))
  }

  filter(): void {
  }

  private showDialog(code:DunCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(DunCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.dunCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
