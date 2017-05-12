import { SupervisorCodeCreatorDialog } from './dialog/supervisor-code-creator.dialog';
import { SupervisorCode } from './../../common/supervisor-codes/supervisor-code.interface';
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
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
  private creatorDialogRef: MdDialogRef<SupervisorCodeCreatorDialog>;
  private supervisorCodes$:Observable<SupervisorCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'name', label: 'Name'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private store: Store<SetupModuleState>){
    this.supervisorCodes$ = this.store.select(...this.SUPERVISOR_CODES);
  }

    showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SupervisorCodeCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res =>{
      
      console.log("close dialog");
      // load something here
    });
  }


  ngOnInit(): void {
    this.store.dispatch(this.actions.findSupervisorCodes())
  }

}