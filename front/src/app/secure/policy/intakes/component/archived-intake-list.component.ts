
import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {MdSnackBar, MdSnackBarRef, SimpleSnackBar} from '@angular/material';
import {Intake} from '../../../../shared/model/policy/intake.interface';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';



@Component({
  selector: 'pams-archived-intake-list',
  templateUrl: './archived-intake-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ArchivedIntakeListComponent {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'projection', label: 'Projection'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
    
  ];

  @Input() intakes: Intake[];
  @Output() view: EventEmitter<Intake> = new EventEmitter<Intake>();

  constructor(private snackBar: MdSnackBar,
              private _dataTableService: TdDataTableService) {
  }

  // constructor(private snackBar: MdSnackBar,
  //             private _dataTableService: TdDataTableService) {
  // }

  viewIntake(intake: Intake): void {
    console.log('Emitting task');
    let snackBarRef: MdSnackBarRef<SimpleSnackBar> = this.snackBar.open('Viewing intake', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(intake);
    });
  }

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 10;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  ngAfterViewInit(): void {
    this.filteredData = this.intakes;
    this.filteredTotal = this.intakes.length;
    this.filter();
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
    let newData: any[] = this.intakes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

}

