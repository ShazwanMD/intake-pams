import { StudyMode } from './../../../shared/model/common/study-mode.interface';
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
import {StudyModeEditorDialog} from './dialog/study-mode-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-study-list.page',
  templateUrl: './study-mode-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudyModeListPage implements OnInit{
  private STUDY_MODES = "setupModuleState.studyModes".split(".");
  private studyModes$: Observable<StudyMode[]>;
  private creatorDialogRef: MdDialogRef<StudyModeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'prefix', label: 'Prefix'},
    {name: 'action', label: ''}
  ];
  private studyModes: StudyMode[];
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
    this.studyModes$ = this.store.select(...this.STUDY_MODES);
    this.studyModes$.subscribe(StudyModes=>this.studyModes = StudyModes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findStudyModes());
    this.store.dispatch(this.actions.changeTitle("Study Modes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:StudyMode): void {
    this.showDialog(code);
  }
  delete(code: StudyMode): void {
    this.store.dispatch(this.actions.removeStudyMode(code))
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
    let newData: any[] = this.studyModes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:StudyMode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StudyModeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.studyMode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
