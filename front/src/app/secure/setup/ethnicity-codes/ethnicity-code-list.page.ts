import { EthnicityCode } from './../../../shared/model/common/ethnicity-code.interface';
import {
  Component,
  Input,
  EventEmitter,
  Output,
  ChangeDetectionStrategy,
  OnInit,
  ViewContainerRef,
} from '@angular/core';
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {EthnicityCodeCreatorDialog} from './dialog/ethnicity-code-creator.dialog';
import {
  TdDataTableService,
  TdDataTableSortingOrder,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-ethnicity-list-page',
  templateUrl: './ethnicity-code-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EthnicityCodeListPage implements OnInit {

  private ETHNICITY_CODES: string[] = 'setupModuleState.ethnicityCodes'.split('.');
  private ethnicityCodes$: Observable<EthnicityCode[]>;
  private creatorDialogRef: MdDialogRef<EthnicityCodeCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''},
  ];

  private ethnicityCodes: EthnicityCode[];
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
              //private snackBar: MdSnackBar)
    this.ethnicityCodes$ = this.store.select(...this.ETHNICITY_CODES);
    this.ethnicityCodes$.subscribe(EthnicityCodes=>this.ethnicityCodes = EthnicityCodes)
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findEthnicityCodes());
    this.store.dispatch(this.actions.changeTitle('Ethnicity Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: EthnicityCode): void {
    this.showDialog(code);
  }

  delete(code: EthnicityCode): void {
     this.store.dispatch(this.actions.removeEthnicityCode(code))
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
    let newData: any[] = this.ethnicityCodes;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  private showDialog(code: EthnicityCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EthnicityCodeCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.ethnicityCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
