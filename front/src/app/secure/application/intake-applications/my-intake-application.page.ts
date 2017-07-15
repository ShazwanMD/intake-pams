import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import {IntakeApplicationActions} from './intake-application.action';
import {ApplicationModuleState} from '../index';
import {IntakeApplication} from '../../../shared/model/application/intake-application.interface';

@Component({
  selector: 'pams-my-intake-application-page',
  templateUrl: './my-intake-application.page.html',
})

export class MyIntakeApplicationPage implements OnInit {

  private INTAKE_APPLICATIONS = 'applicationModuleState.intakeApplications'.split('.');
  private intakeApplications$: Observable<IntakeApplication[]>;

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'intake.referenceNo', label: 'Intake'},
    {name: 'bidStatus', label: 'Status'},
    {name: 'reason', label: 'Reason'},
    {name: 'action', label: ''},
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private intakeApplicationActions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {
    this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
  }

  ngOnInit(): void {
    this.route.params.subscribe(() => {
      this.store.dispatch(this.intakeApplicationActions.findIntakeApplications());
    });
  }
}
