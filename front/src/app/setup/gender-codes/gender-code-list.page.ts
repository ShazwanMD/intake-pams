import { GenderCode } from './../../common/gender-codes/gender-code.interface';
import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";




@Component({
  selector: 'pams-gender-list-page',
  templateUrl: './gender-code-list.page.html',
})
export class GenderCodeListPage implements OnInit {

  private GENDER_CODES = "setupModuleState.genderCodes".split(".");
  private genderCodes$:Observable<GenderCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>){
    this.genderCodes$ = this.store.select(...this.GENDER_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findGenderCodes())
    this.store.dispatch(this.actions.changeTitle("Gender Codes"))
  }

}
