import {CountryCode } from './../../common/country-codes/country-code.interface';
import {Component, OnInit,ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {CountryCodeCreatorDialog} from "./dialog/country-code-creator.dialog";
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-country-list-page',
  templateUrl: './country-code-list.page.html',
})
export class CountryCodeListPage implements OnInit {

  private COUNTRY_CODES = "setupModuleState.countryCodes".split(".");
  private countryCodes$:Observable<CountryCode>;
  private creatorDialogRef: MdDialogRef<CountryCodeCreatorDialog>;
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
    this.countryCodes$ = this.store.select(...this.COUNTRY_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findCountryCodes())
    this.store.dispatch(this.actions.changeTitle("Country Codes"))
  }

createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:CountryCode): void {
    this.showDialog(code);
  }

  delete(code: CountryCode): void {
    let snackBarRef = this.snackBar.open("Delete this country code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.removeCountryCode(code))
    });
  }

  filter(): void {
  }

  private showDialog(code:CountryCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(CountryCodeCreatorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.countryCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
