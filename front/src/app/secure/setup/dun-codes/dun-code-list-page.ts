// import {Component, OnInit, ViewContainerRef} from '@angular/core';
// import {Store} from '@ngrx/store';
// import {SetupActions} from '../setup.action';
// import {SetupModuleState} from '../index';
// import {Observable} from 'rxjs/Observable';
// import {DunCodeEditorDialog} from './dialog/dun-code-editor.dialog';
// import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
// import {DunCode} from '../../../shared/model/common/dun-code.interface';

// @Component({
//   selector: 'pams-dun-list-page',
//   templateUrl: './dun-code-list.page.html',
// })
// export class DunCodeListPage implements OnInit {

//   private DUN_CODES: string[] = 'setupModuleState.dunCodes'.split('.');
//   private dunCodes$: Observable<DunCode>;
//   private creatorDialogRef: MdDialogRef<DunCodeEditorDialog>;
//   private columns: any[] = [
//     {name: 'code', label: 'Code'},
//     {name: 'description', label: 'Description'},
//     {name: 'action', label: ''},
//   ];

//   constructor(private actions: SetupActions,
//               private store: Store<SetupModuleState>,
//               private vcf: ViewContainerRef,
//               private dialog: MdDialog,
//               private snackBar: MdSnackBar) {
//     this.dunCodes$ = this.store.select(...this.DUN_CODES);
//   }

//   ngOnInit(): void {
//     this.store.dispatch(this.actions.findDunCodes());
//     this.store.dispatch(this.actions.changeTitle('Dun Codes'));
//   }

//   createDialog(): void {
//     this.showDialog(null);
//   }

//   editDialog(code: DunCode): void {
//     this.showDialog(code);
//   }

//   delete(code: DunCode): void {
//     let snackBarRef = this.snackBar.open('Delete this dun code?', 'Ok');
//     snackBarRef.afterDismissed().subscribe(() => {
//     this.store.dispatch(this.actions.removeDunCode(code));
//     });
//   }

//   filter(): void {
//   }

//   private showDialog(code: DunCode): void {
//     console.log('create');
//     let config = new MdDialogConfig();
//     config.viewContainerRef = this.vcf;
//     config.role = 'dialog';
//     config.width = '70%';
//     config.height = '65%';
//     config.position = {top: '0px'};
//     this.creatorDialogRef = this.dialog.open(DunCodeEditorDialog, config);
//     if (code) this.creatorDialogRef.componentInstance.dunCode = code; // set
//     this.creatorDialogRef.afterClosed().subscribe((res) => {
//       console.log('close dialog');
//     });
//   }

// }

import { DunCode } from './../../../shared/model/common/dun-code.interface';
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
import {DunCodeEditorDialog} from './dialog/dun-code-editor.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-dun-list.page',
  templateUrl: './dun-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class DunCodeListPage implements OnInit{
  private DUN_CODES = "setupModuleState.dunCodes".split(".");
  private dunCodes$: Observable<DunCode[]>;
  private creatorDialogRef: MdDialogRef<DunCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];
    private dunCodes: DunCode[];
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
    this.dunCodes$ = this.store.select(...this.DUN_CODES);
    this.dunCodes$.subscribe(DunCodes=>this.dunCodes = DunCodes)
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findDunCodes());
    this.store.dispatch(this.actions.changeTitle("Dun Codes"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(code:DunCode): void {
    this.showDialog(code);
  }
  delete(code: DunCode): void {
    this.store.dispatch(this.actions.removeDunCode(code))
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
    let newData: any[] = this.dunCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  private showDialog(code:DunCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(DunCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.dunCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}