import { LanguageCode } from './../../../shared/model/common/language-code.interface';
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
import {LanguageCodeEditorDialog} from './dialog/language-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';
@Component({
  selector: 'pams-language-list.page',
  templateUrl: './language-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LanguageCodeListPage implements OnInit{
  private LANGUAGE_CODES = "setupModuleState.languageCodes".split(".");
  private languageCodes$: Observable<LanguageCode[]>;
  private creatorDialogRef: MdDialogRef<LanguageCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];
    private languageCodes: LanguageCode[];
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
    this.languageCodes$ = this.store.select(...this.LANGUAGE_CODES);
    this.languageCodes$.subscribe(LanguageCodes=>this.languageCodes = LanguageCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findLanguageCodes());
    this.store.dispatch(this.actions.changeTitle("Language Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:LanguageCode): void {
    this.showDialog(code);
  }
  delete(code: LanguageCode): void {
    this.store.dispatch(this.actions.removeLanguageCode(code))
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
    let newData: any[] = this.languageCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:LanguageCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(LanguageCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.languageCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}