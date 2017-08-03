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
import { GradeCode } from './../../../../shared/model/common/grade-code.interface';


@Component({
  selector: 'pams-grade-code-list',
  templateUrl: './grade-code.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GradeCodesComponent implements OnChanges {

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'action', label: ''}
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() gradeCodes: GradeCode[];
  @Output() editDialog: EventEmitter<GradeCode> = new EventEmitter<GradeCode>();
  @Output() delete: EventEmitter<GradeCode> = new EventEmitter<GradeCode>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  ngOnChanges(changes: {[ propName: string]: SimpleChange}) {
    if (changes['gradeCodes']){
        this.filteredData = changes['gradeCodes'].currentValue; 
        this.filteredTotal = changes['gradeCodes'].currentValue.length;
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
    let newData: any[] = this.gradeCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
}