import { ReligionCode } from "./../../common/religion-codes/religion-code.interface";
import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'pams-religion-list-page',
  templateUrl: './religion-code-list.page.html',
})
export class ReligionCodeListPage implements OnInit {

  private RELIGION_CODES = "setupModuleState.religionCodes".split(".");
  private religionCodes$:Observable<ReligionCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>){
    this.religionCodes$ = this.store.select(...this.RELIGION_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findReligionCodes())
  }

}
