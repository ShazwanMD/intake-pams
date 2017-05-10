import { NationalityCode } from './../../common/nationality-codes/nationality-code.interface';
import { MdDialog } from '@angular/material';
import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";



@Component({
  selector: 'pams-nationality-list-page',
  templateUrl: './nationality-code-list.page.html',
})
export class NationalityCodeListPage implements OnInit {

  private NATIONALITY_CODES = "setupModuleState.nationalityCodes".split(".");
  private nationalityCodes$:Observable<NationalityCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private dialog: MdDialog){
    this.nationalityCodes$ = this.store.select(...this.NATIONALITY_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findNationalityCodes())
  }

}