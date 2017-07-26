import { SubjectCode } from './../../../shared/model/common/subject-code.interface';
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
import {SubjectCodeEditorDialog} from './dialog/subject-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-subject-list.page',
  templateUrl: './subject-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SubjectCodeListPage implements OnInit{
  private SUBJECT_CODES = "setupModuleState.subjectCodes".split(".");
  private subjectCodes$: Observable<SubjectCode[]>;
  private creatorDialogRef: MdDialogRef<SubjectCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''},
  ];

  private subjectCodes: SubjectCode[];
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
    this.subjectCodes$ = this.store.select(...this.SUBJECT_CODES);
    this.subjectCodes$.subscribe(SubjectCodes=>this.subjectCodes = SubjectCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findSubjectCodes());
    this.store.dispatch(this.actions.changeTitle("Subject Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:SubjectCode): void {
    this.showDialog(code);
  }
  delete(code: SubjectCode): void {
    this.store.dispatch(this.actions.removeSubjectCode(code))
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
    let newData: any[] = this.subjectCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:SubjectCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SubjectCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.subjectCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}