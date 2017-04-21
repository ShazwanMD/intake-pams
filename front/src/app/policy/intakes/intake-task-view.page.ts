import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef
} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IntakeTask} from "./intake-task.interface";
import {IntakeActions} from "./intake.action";
import {Observable} from "rxjs";
import {PolicyModuleState} from "../index";
import {Store} from "@ngrx/store";


@Component({
  selector: 'pams-intake-task-iew',
  templateUrl: './intake-task-view.page.html',
})
export class IntakeTaskViewPage implements OnInit {

  private intakeTask$: Observable<IntakeTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions) {
    this.intakeTask$ = this.store.select(state => state.intakeTask)
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {taskId: string}) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findIntakeTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}


