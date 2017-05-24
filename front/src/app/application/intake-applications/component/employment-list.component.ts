import {Employment} from './../employment.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";


@Component({
  selector: 'pams-employment-list',
  templateUrl: './employment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})


export class EmploymentListComponent implements OnInit {
  @Input() employments: Employment[];

  private EMPLOYMENTS = "applicationModuleState.employments".split(".");

  private employments$: Observable<Employment>;
  private columns: any[] = [
    {name: 'employer', label: 'Employer'},
    {name: 'designation', label: 'Designation'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
  ];

  constructor(private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>,) {
    this.employments$ = this.store.select(...this.EMPLOYMENTS);
  }

  ngOnInit(): void {
    this.employments$.subscribe(application => this.store.dispatch(this.actions.findEmploymentsByIntakeApplication(application)));
  }

}
