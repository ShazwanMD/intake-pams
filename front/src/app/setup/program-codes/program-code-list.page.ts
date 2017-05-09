import { MdDialog } from '@angular/material';

import { ProgramCodeCreatorDialog } from './dialog/program-code-creator.dialog';

import { ProgramCode } from './../../common/program-codes/program-code.interface';

import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";






@Component({
  selector: 'pams-program-list-page',
  templateUrl: './program-code-list.page.html',
})
export class ProgramCodeListPage implements OnInit {

  private PROGRAM_CODES = "setupModuleState.programCodes".split(".");
  private programCodes$:Observable<ProgramCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private dialog: MdDialog){
    this.programCodes$ = this.store.select(...this.PROGRAM_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramCodes())
  }

}