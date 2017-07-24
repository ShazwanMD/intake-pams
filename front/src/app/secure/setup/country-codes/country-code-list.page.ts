import { CountryCode } from './../../../shared/model/common/country-code.interface';
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
import {CountryCodeCreatorDialog} from './dialog/country-code-creator.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-country-list.page',
  templateUrl: './country-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CountryCodeListPage implements OnInit{
  private COUNTRY_CODES = "setupModuleState.countryCodes".split(".");
  private countryCodes$: Observable<CountryCode[]>;
  private creatorDialogRef: MdDialogRef<CountryCodeCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];
    private countryCodes: CountryCode[];
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 10;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;
  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private _dataTableService: TdDataTableService) {
    this.countryCodes$ = this.store.select(...this.COUNTRY_CODES);
    this.countryCodes$.subscribe(CountryCodes=>this.countryCodes = CountryCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findCountryCodes());
    this.store.dispatch(this.actions.changeTitle("Country Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:CountryCode): void {
    this.showDialog(code);
  }
  delete(code: CountryCode): void {
    this.store.dispatch(this.actions.removeCountryCode(code))
  }
  sort(sortEvent: ITdDataTableSortChangeEvent): void {
    this.sortBy = sortEvent.name;
    this.sortOrder = sortEvent.order;
    this.filter();
  }
   search(searchTerm: string): void {
    this.searchTerm = searchTerm;
    this.filter();
  }
    page(pagingEvent: IPageChangeEvent): void {
    this.fromRow = pagingEvent.fromRow;
    this.currentPage = pagingEvent.page;
    this.pageSize = pagingEvent.pageSize;
    this.filter();
  }
  filter(): void {
    console.log('filter');
    let newData: any[] = this.countryCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
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