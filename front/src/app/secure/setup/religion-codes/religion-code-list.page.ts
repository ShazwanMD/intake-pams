import { ReligionCode } from './../../../shared/model/common/religion-code.interface';
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
import {ReligionCodeCreatorDialog} from './dialog/religion-code-creator.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-religion-list.page',
  templateUrl: './religion-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ReligionCodeListPage implements OnInit{
  private RELIGION_CODES = "setupModuleState.religionCodes".split(".");
  private religionCodes$: Observable<ReligionCode[]>;
  private creatorDialogRef: MdDialogRef<ReligionCodeCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];
  private religionCodes: ReligionCode[];
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
    this.religionCodes$ = this.store.select(...this.RELIGION_CODES);
    this.religionCodes$.subscribe(ReligionCodes=>this.religionCodes = ReligionCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findReligionCodes());
    this.store.dispatch(this.actions.changeTitle("Religion Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:ReligionCode): void {
    this.showDialog(code);
  }
  delete(code: ReligionCode): void {
    this.store.dispatch(this.actions.removeReligionCode(code))
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
    let newData: any[] = this.religionCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:ReligionCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ReligionCodeCreatorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.religionCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}