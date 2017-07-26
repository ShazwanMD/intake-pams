import { SupervisorCode } from './../../../shared/model/common/supervisor-code.interface';
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
import {SupervisorCodeEditorDialog} from './dialog/supervisor-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-supervisor-list.page',
  templateUrl: './supervisor-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SupervisorCodeListPage implements OnInit{
  private SUPERVISOR_CODES = "setupModuleState.supervisorCodes".split(".");
  private supervisorCodes$: Observable<SupervisorCode[]>;
  private creatorDialogRef: MdDialogRef<SupervisorCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'name', label: 'Name'},
    {name: 'action', label: ''}
  ];
    private supervisorCodes: SupervisorCode[];
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;
  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private _dataTableService: TdDataTableService) {
    this.supervisorCodes$ = this.store.select(...this.SUPERVISOR_CODES);
    this.supervisorCodes$.subscribe(SupervisorCodes=>this.supervisorCodes = SupervisorCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findSupervisorCodes());
    this.store.dispatch(this.actions.changeTitle("Supervisor Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:SupervisorCode): void {
    this.showDialog(code);
  }
  delete(code: SupervisorCode): void {
    this.store.dispatch(this.actions.removeSupervisorCode(code))
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
    let newData: any[] = this.supervisorCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:SupervisorCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SupervisorCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.supervisorCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}