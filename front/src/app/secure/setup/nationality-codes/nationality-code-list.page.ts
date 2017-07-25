import { NationalityCode } from './../../../shared/model/common/nationality-code.interface';
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
import {NationalityCodeCreatorDialog} from './dialog/nationality-code-creator.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';
@Component({
  selector: 'pams-nationality-list.page',
  templateUrl: './nationality-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class NationalityCodeListPage implements OnInit{
  private NATIONALITY_CODES = "setupModuleState.nationalityCodes".split(".");
  private nationalityCodes$: Observable<NationalityCode[]>;
  private creatorDialogRef: MdDialogRef<NationalityCodeCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];
  private nationalityCodes: NationalityCode[];
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
    this.nationalityCodes$ = this.store.select(...this.NATIONALITY_CODES);
    this.nationalityCodes$.subscribe(NationalityCodes=>this.nationalityCodes = NationalityCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findNationalityCodes());
    this.store.dispatch(this.actions.changeTitle("Nationality Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:NationalityCode): void {
    this.showDialog(code);
  }
  delete(code: NationalityCode): void {
    this.store.dispatch(this.actions.removeNationalityCode(code))
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
    let newData: any[] = this.nationalityCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
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