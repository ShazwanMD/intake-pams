import {MdDialog} from '@angular/material';
import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {RaceCode} from '../../../shared/model/common/race-code.interface';

@Component({
  selector: 'pams-race-list-page',
  templateUrl: './race-code-list.page.html',
})
export class RaceCodeListPage implements OnInit {

  private RACE_CODES = 'setupModuleState.raceCodes'.split('.');
  private raceCodes$: Observable<RaceCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''},
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private dialog: MdDialog) {
    this.raceCodes$ = this.store.select(...this.RACE_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findRaceCodes());
    this.store.dispatch(this.actions.changeTitle('Race Codes'));
  }

  filter(): void {
  }
}
