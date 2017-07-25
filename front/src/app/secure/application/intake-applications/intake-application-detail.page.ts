import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {IntakeApplicationActions} from './intake-application.action';
import {ApplicationModuleState} from '../index';
import {IntakeApplication} from '../../../shared/model/application/intake-application.interface';

@Component({
  selector: 'pams-intake-application-detail',
  templateUrl: './intake-application-detail.page.html',
})
export class IntakeApplicationDetailPage implements OnInit {

  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  private intakeApplication$: Observable<IntakeApplication>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions) {
    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      console.log('intake application by refno: ' + referenceNo);
      if (referenceNo) {
        this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/secure/']);
  }
}

