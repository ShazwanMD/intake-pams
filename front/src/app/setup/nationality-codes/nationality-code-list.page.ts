import { NationalityCode } from './../../common/nationality-codes/nationality-code.interface';
import {Component, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {NationalityCodeCreatorDialog} from "./dialog/nationality-code-creator.dialog";
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-nationality-list-page',
  templateUrl: './nationality-code-list.page.html',
})
export class NationalityCodeListPage implements OnInit {

  private NATIONALITY_CODES = "setupModuleState.nationalityCodes".split(".");
  private nationalityCodes$: Observable<NationalityCode>;
  private creatorDialogRef: MdDialogRef<NationalityCodeCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.nationalityCodes$ = this.store.select(...this.NATIONALITY_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findNationalityCodes());
    this.store.dispatch(this.actions.changeTitle("Nationality Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:NationalityCode): void {
    this.showDialog(code);
  }

  delete(code: NationalityCode): void {
    let snackBarRef = this.snackBar.open("Delete this nationality code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.removeNationalityCode(code))
    });
  }

  filter(): void {
  }

  private showDialog(code:NationalityCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(NationalityCodeCreatorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.nationalityCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
