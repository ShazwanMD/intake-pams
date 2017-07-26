import { RaceCode } from './../../../shared/model/common/race-code.interface';
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
import {RaceCodeCreatorDialog} from './dialog/race-code-creator.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-race-list.page',
  templateUrl: './race-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class RaceCodeListPage implements OnInit{
  private RACE_CODES = "setupModuleState.raceCodes".split(".");
  private raceCodes$: Observable<RaceCode[]>;
  private creatorDialogRef: MdDialogRef<RaceCodeCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];
  private raceCodes: RaceCode[];
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
    this.raceCodes$ = this.store.select(...this.RACE_CODES);
    this.raceCodes$.subscribe(RaceCodes=>this.raceCodes = RaceCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findRaceCodes());
    this.store.dispatch(this.actions.changeTitle("Race Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:RaceCode): void {
    this.showDialog(code);
  }
  delete(code: RaceCode): void {
    this.store.dispatch(this.actions.removeRaceCode(code))
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
    let newData: any[] = this.raceCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:RaceCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(RaceCodeCreatorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.raceCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}