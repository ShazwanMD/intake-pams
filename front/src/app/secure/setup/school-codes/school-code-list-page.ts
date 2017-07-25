import { SchoolCode } from './../../../shared/model/common/school-code.interface';
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
import {SchoolCodeEditorDialog} from './dialog/school-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-school-list.page',
  templateUrl: './school-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SchoolCodeListPage implements OnInit{
  private SCHOOL_CODES = "setupModuleState.schoolCodes".split(".");
  private schoolCodes$: Observable<SchoolCode[]>;
  private creatorDialogRef: MdDialogRef<SchoolCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];
    private schoolCodes: SchoolCode[];
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
    this.schoolCodes$ = this.store.select(...this.SCHOOL_CODES);
    this.schoolCodes$.subscribe(SchoolCodes=>this.schoolCodes = SchoolCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findSchoolCodes());
    this.store.dispatch(this.actions.changeTitle("School Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:SchoolCode): void {
    this.showDialog(code);
  }
  delete(code: SchoolCode): void {
    this.store.dispatch(this.actions.removeSchoolCode(code))
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
    let newData: any[] = this.schoolCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:SchoolCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SchoolCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.schoolCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}