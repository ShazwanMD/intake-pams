import { ProgramCode } from './../../../shared/model/common/program-code.interface';
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
import {ProgramCodeEditorDialog} from './dialog/program-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';
@Component({
  selector: 'pams-program-list.page',
  templateUrl: './program-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramCodeListPage implements OnInit{
  private PROGRAM_CODES = "setupModuleState.programCodes".split(".");
  private programCodes$: Observable<ProgramCode[]>;
  private creatorDialogRef: MdDialogRef<ProgramCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];
  private programCodes: ProgramCode[];
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
    this.programCodes$ = this.store.select(...this.PROGRAM_CODES);
    this.programCodes$.subscribe(ProgramCodes=>this.programCodes = ProgramCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramCodes());
    this.store.dispatch(this.actions.changeTitle("Program Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:ProgramCode): void {
    this.showDialog(code);
  }
  delete(code: ProgramCode): void {
    this.store.dispatch(this.actions.removeProgramCode(code))
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
    let newData: any[] = this.programCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:ProgramCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ProgramCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.programCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
