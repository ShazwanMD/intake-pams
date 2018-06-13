import { SupervisorOffering } from './../../../../shared/model/common/supervisor-offering.interface';
import {
  Component, 
  Input, 
  EventEmitter, 
  Output, 
  ChangeDetectionStrategy, 
  AfterViewInit, 
  OnChanges, 
  SimpleChange
} from '@angular/core';
import {
TdDataTableSortingOrder,
TdDataTableService,
ITdDataTableSortChangeEvent,
IPageChangeEvent
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
selector: 'pams-supervisor-offering-list',
templateUrl: './supervisor-offering.html',
changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SupervisorOfferingsComponent implements OnChanges {

private columns: any[] = [
  {name: 'supervisorCode.code', label: 'StaffNo'},
  {name: 'supervisorCode.name', label: 'Name'},
  {name: 'action', label: ''}
];

filteredData: any[];
filteredTotal: number;
searchTerm: string = '';
fromRow: number = 1;
currentPage: number = 1;
pageSize: number = 5;
sortBy: string = 'supervisorCode.code';
sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

@Input() supervisorOfferings: SupervisorOffering[];
@Output() editDialog: EventEmitter<SupervisorOffering> = new EventEmitter<SupervisorOffering>();
@Output() delete: EventEmitter<SupervisorOffering> = new EventEmitter<SupervisorOffering>();

constructor(private _dataTableService: TdDataTableService,
            private snackBar: MdSnackBar) {
}

ngOnChanges(changes: {[ propName: string]: SimpleChange}) {
  if (changes['supervisorOfferings']){
      this.filteredData = changes['supervisorOfferings'].currentValue; 
      this.filteredTotal = changes['supervisorOfferings'].currentValue.length;
      this.filter();
    }
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
  let newData: any[] = this.supervisorOfferings;
  newData = this._dataTableService.filterData(newData, this.searchTerm, true);
  this.filteredTotal = newData.length;
  newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
  newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
  this.filteredData = newData;
}
}