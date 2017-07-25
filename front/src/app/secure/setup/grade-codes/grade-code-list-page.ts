import { GradeCode } from './../../../shared/model/common/grade-code.interface';
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
import {GradeCodeEditorDialog} from './dialog/grade-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';
@Component({
  selector: 'pams-grade-list.page',
  templateUrl: './grade-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GradeCodeListPage implements OnInit{
  private GRADE_CODES = "setupModuleState.gradeCodes".split(".");
  private gradeCodes$: Observable<GradeCode[]>;
  private creatorDialogRef: MdDialogRef<GradeCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'action', label: ''}
  ];
  private gradeCodes: GradeCode[];
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
    this.gradeCodes$ = this.store.select(...this.GRADE_CODES);
    this.gradeCodes$.subscribe(GradeCodes=>this.gradeCodes = GradeCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findGradeCodes());
    this.store.dispatch(this.actions.changeTitle("Grade Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:GradeCode): void {
    this.showDialog(code);
  }
  delete(code: GradeCode): void {
    this.store.dispatch(this.actions.removeGradeCode(code))
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
    let newData: any[] = this.gradeCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:GradeCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(GradeCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.gradeCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}