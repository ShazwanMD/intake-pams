import {FieldCode} from '../../../shared/model/common/field-code.interface';
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
import {FieldCodeEditorDialog} from './dialog/field-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-field-list-page',
  templateUrl: './field-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FieldCodeListPage implements OnInit {

  private FIELD_CODES = "setupModuleState.fieldCodes".split(".");
  private fieldCodes$: Observable<FieldCode[]>;
  private creatorDialogRef: MdDialogRef<FieldCodeEditorDialog>;

  //private fieldCodes: FieldCode[];
  // filteredData: any[];
  // filteredTotal: number;
  // searchTerm: string = '';
  // fromRow: number = 1;
  // currentPage: number = 1;
  // pageSize: number = 10;
  // sortBy: string = 'code';
  // sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;
  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private _dataTableService: TdDataTableService) {
    this.fieldCodes$ = this.store.select(...this.FIELD_CODES);
    // this.fieldCodes$.subscribe(FieldCodes=>this.fieldCodes = FieldCodes)
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findFieldCodes());
    this.store.dispatch(this.actions.changeTitle('Field Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: FieldCode): void {
    this.showDialog(code);
  }

  delete(code: FieldCode): void {
    this.store.dispatch(this.actions.removeFieldCode(code))
  }

  // sort(sortEvent: ITdDataTableSortChangeEvent): void {
  //   this.sortBy = sortEvent.name;
  //   this.sortOrder = sortEvent.order;
  //   this.filter();
  // }

  //  search(searchTerm: string): void {
  //   this.searchTerm = searchTerm;
  //   this.filter();

  // }

  //   page(pagingEvent: IPageChangeEvent): void {
  //   this.fromRow = pagingEvent.fromRow;
  //   this.currentPage = pagingEvent.page;
  //   this.pageSize = pagingEvent.pageSize;
  //   this.filter();

  // }

  // filter(): void {
  //   console.log('filter');
  //   let newData: any[] = this.fieldCodes;
  //   newData = this._dataTableService.filterData(newData, this.searchTerm, true);
  //   this.filteredTotal = newData.length;
  //   newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
  //   newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
  //   this.filteredData = newData;
  // }

  private showDialog(code: FieldCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(FieldCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.fieldCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
