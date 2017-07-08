import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IntakeActions} from './intake.action';
import {Observable} from 'rxjs';
import {PolicyModuleState} from '../index';
import {Store} from '@ngrx/store';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';

@Component({
  selector: 'pams-intake-task-detail',
  templateUrl: './intake-task-detail.page.html',
})
export class IntakeTaskDetailPage implements OnInit {

  private INTAKE_TASK: string[] = 'policyModuleState.intakeTask'.split('.');
  private intakeTask$: Observable<IntakeTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions) {
    this.intakeTask$ = this.store.select(...this.INTAKE_TASK);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findIntakeTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}

