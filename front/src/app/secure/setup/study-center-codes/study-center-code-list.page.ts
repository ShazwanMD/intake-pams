import { StudyCenterCode } from './../../../shared/model/common/study-center-code.interface';
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
import {StudyCenterCodeEditorDialog} from './dialog/study-center-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-study-center-list-page',
  templateUrl: './study-center-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudyCenterCodeListPage implements OnInit{
  private STUDY_CENTER_CODES = "setupModuleState.studyCenterCodes".split(".");
  private studyCenterCodes$: Observable<StudyCenterCode[]>;
  private creatorDialogRef: MdDialogRef<StudyCenterCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];
  private studyCenterCodes: StudyCenterCode[];
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
    this.studyCenterCodes$ = this.store.select(...this.STUDY_CENTER_CODES);
    this.studyCenterCodes$.subscribe(studyCenterCodes=>this.studyCenterCodes = studyCenterCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findStudyCenterCodes());
    this.store.dispatch(this.actions.changeTitle("StudyCenter Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:StudyCenterCode): void {
    this.showDialog(code);
  }
  delete(code: StudyCenterCode): void {
    this.store.dispatch(this.actions.removeStudyCenterCode(code))
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
    let newData: any[] = this.studyCenterCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:StudyCenterCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StudyCenterCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.studyCenterCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}