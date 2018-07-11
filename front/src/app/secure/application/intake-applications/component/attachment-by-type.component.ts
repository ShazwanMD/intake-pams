import { Attachment } from './../../../../shared/model/application/attachment.interface';
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
import { GenderCode } from './../../../../shared/model/common/gender-code.interface';


@Component({
  selector: 'pams-attachment-by-type',
  templateUrl: './attachment-by-type.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AttachmentByTypeComponent implements OnChanges {

  private columns: any[] = [
    {name: 'name', label: 'Name'},
    {name: 'action', label: ''}
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'name';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() attachmentByTypes: Attachment[];
  @Output() editDialog: EventEmitter<GenderCode> = new EventEmitter<GenderCode>();
  @Output() delete: EventEmitter<GenderCode> = new EventEmitter<GenderCode>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  ngOnChanges(changes: {[ propName: string]: SimpleChange}) {
    if (changes['attachmentByTypes']){
        this.filteredData = changes['attachmentByTypes'].currentValue; 
        this.filteredTotal = changes['attachmentByTypes'].currentValue.length;
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
    let newData: any[] = this.attachmentByTypes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
}