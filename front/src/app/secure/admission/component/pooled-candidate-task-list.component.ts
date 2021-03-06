import { Router, ActivatedRoute } from '@angular/router';
import { MdSnackBar } from '@angular/material';
import { IntakeTask } from '../../../shared/model/policy/intake-task.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
  } from '@covalent/core';

@Component({
  selector: 'pams-pooled-candidate-task-list',
  templateUrl: './pooled-candidate-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PooledCandidateTaskListComponent {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'projection', label: 'Projection'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

  @Input() intakeTasks: IntakeTask[];
  @Output() claim = new EventEmitter<IntakeTask>();

  constructor(private snackBar: MdSnackBar,
    private router: Router,
    private route: ActivatedRoute,
    private _dataTableService: TdDataTableService) {
}

claimTask(task: IntakeTask): void {
  console.log('Emitting task');
  if (confirm('Claim intake task?')) {
    this.claim.emit(task);
    window.location.reload();
  }
   else {
  }
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
    this.filteredData = this.intakeTasks;
    this.filteredTotal = this.intakeTasks.length;
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
    let newData: any[] = this.intakeTasks;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

}
