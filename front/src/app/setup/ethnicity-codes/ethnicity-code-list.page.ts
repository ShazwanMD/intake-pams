import { EthnicityCode } from './../../common/ethnicity-codes/ethnicity-code.interface';
import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'pams-ethnicity-list-page',
  templateUrl: './ethnicity-code-list.page.html',
})
export class EthnicityCodeListPage implements OnInit {

  private ETHNICITY_CODES = "setupModuleState.ethnicityCodes".split(".");
  private ethnicityCodes$:Observable<EthnicityCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>){
    this.ethnicityCodes$ = this.store.select(...this.ETHNICITY_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findEthnicityCodes())
  }

}