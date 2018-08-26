import { Router, ActivatedRoute } from '@angular/router';
import { MdSnackBar } from '@angular/material';
import { CandidateTask } from '../../../shared/model/admission/candidate-task.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
  } from '@covalent/core';

@Component({
  selector: 'pams-assigned-candidate-list',
  templateUrl: './assigned-candidate-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssignedCandidateListComponent {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'programSelection.programFieldCode.facultyCode.descriptionEn', label: 'Faculty'},
    {name: 'candidateIntake.name', label: 'Name'},
    {name: 'studyMode.studyMode.descriptionEn', label: 'Study Mode'},
    {name: 'programSelection.programFieldCode.fieldCode.descriptionEn', label: 'Field Code'},
    {name: 'intakeSession.descriptionEn', label: 'Intake'},
    {name: 'flowState', label: 'Status'},
    {name: 'candidateIntake.status', label: 'Student Accepted'},
    {name: 'action', label: ''},
  ];

  @Input() candidateTasks: CandidateTask[];
  @Output() view = new EventEmitter<CandidateTask>();

  constructor(private snackBar: MdSnackBar,
    private router: Router,
    private route: ActivatedRoute,
    private _dataTableService: TdDataTableService) {
  }

    viewTask(task: CandidateTask): void {
      console.log('Emitting task');
      if (confirm('Viewing intake?')) {
       this.view.emit(task);
      } else {
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
    this.filteredData = this.candidateTasks;
    this.filteredTotal = this.candidateTasks.length;
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
    let newData: any[] = this.candidateTasks;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

}
