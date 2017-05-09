import { SupervisorCode } from './../../common/supervisor-codes/supervisor-code.interface';
import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'pams-supervisor-list-page',
  templateUrl: './supervisor-code-list.page.html',
})
export class SupervisorCodeListPage implements OnInit {

  private SUPERVISOR_CODES = "setupModuleState.supervisorCodes".split(".");
  private supervisorCodes$:Observable<SupervisorCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'name', label: 'Name'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>){
    this.supervisorCodes$ = this.store.select(...this.SUPERVISOR_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findSupervisorCodes())
  }

}