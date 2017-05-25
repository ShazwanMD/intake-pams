import { Referee } from './../referee.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";


@Component({
  selector: 'pams-referee-list',
  templateUrl: './referee-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class RefereeListComponent implements OnInit {

  @Input() referees: Referee[];

  private columns: any[] = [
    {name: 'name', label: 'Name'},
    {name: 'officeAddrs', label: 'OfficeAddrs'},
    {name: 'occupation', label: 'Occupation'},
    {name: 'phoneNo', label: 'PhoneNo'},

  ];

  constructor(private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>,) {
  }

  ngOnInit(): void {
  }
}
