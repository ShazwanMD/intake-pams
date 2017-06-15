import { MaritalCodeEditorDialog } from './dialog/marital-code-editor.dialog';
import { MaritalCode } from './../../common/marital-codes/marital-code.interface';

import {Component, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from "@angular/material";


@Component({
  selector: 'pams-marital-list-page',
  templateUrl: './marital-code-list.page.html',
})
export class MaritalCodeListPage implements OnInit {

  private MARITAL_CODES = "setupModuleState.maritalCodes".split(".");
  private maritalCodes$: Observable<MaritalCode>;
  private creatorDialogRef: MdDialogRef<MaritalCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
 // {name: 'name', label: 'Name'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.maritalCodes$ = this.store.select(...this.MARITAL_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findMaritalCodes());
    this.store.dispatch(this.actions.changeTitle("Marital Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:MaritalCode): void {
    this.showDialog(code);
  }

  delete(code: MaritalCode): void {
    let snackBarRef = this.snackBar.open("Delete this marital code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.removeMaritalCode(code))
    });
  }

  filter(): void {
  }

  private showDialog(code:MaritalCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(MaritalCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.maritalCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
