import { MaritalCode } from './../../common/marital-codes/marital-code.interface';
import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'pams-marital-list-page',
  templateUrl: './marital-code-list.page.html',
})
export class MaritalCodeListPage implements OnInit {

  private MARITAL_CODES = "setupModuleState.maritalCodes".split(".");
  private maritalCodes$:Observable<MaritalCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>){
    this.maritalCodes$ = this.store.select(...this.MARITAL_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findMaritalCodes())
    this.store.dispatch(this.actions.changeTitle("Marital Codes"))
  }

  filter():void {}
}
