import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IntakeApplicationActions} from './intake-applications/intake-application.action';
import {ApplicationModuleState} from './index';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import {Intake} from '../../../policy/intakes/intake.interface';

@Component({
  selector: 'pams-application-page',
  templateUrl: './application.page.html',
})

export class ApplicationPage implements OnInit {

  private INTAKES = 'applicationModuleState.intakes'.split('.');
  private intakes$: Observable<Intake[]>;

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'action', label: ''},
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private intakeApplicationActions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {
    this.intakes$ = this.store.select(...this.INTAKES);
  }

  ngOnInit(): void {
    this.route.params.subscribe(() => {
      this.store.dispatch(this.intakeApplicationActions.findPublishedIntakes());
    });
  }
}
