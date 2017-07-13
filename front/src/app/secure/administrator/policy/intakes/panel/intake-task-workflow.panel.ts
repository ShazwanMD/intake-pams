import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input,
} from '@angular/core';
import {Observable} from 'rxjs';
import {FlowState} from '../../../../../core/flow-state.enum';
import {IntakeDraftTaskPanel} from './intake-draft-task.panel';
import {IntakeVerifyTaskPanel} from './intake-verify-task.panel';
import {IntakePublishTaskPanel} from './intake-publish-task.panel';
import {IntakeEvaluateTaskPanel} from './intake-evaluate-task.panel';
import {IntakeTask} from '../../../../../shared/model/policy/intake-task.interface';

@Component({
  selector: 'pams-intake-task-workflow',
  templateUrl: './intake-task-workflow.panel.html',
})
export class IntakeTaskWorkflowPanel implements OnInit {

  private componentRef: ComponentRef<any>;

  @ViewChild('taskPanel', {read: ViewContainerRef}) taskPanel: ViewContainerRef;
  @Input() intakeTaskObservable: Observable<IntakeTask>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.intakeTaskObservable.subscribe((task) => {
      if (task.flowState) {

        console.log('task flowState: ' + task.flowState);
        if (this.componentRef) {
          this.componentRef.destroy();
        }
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(IntakeDraftTaskPanel);
            break;
          case FlowState.VERIFIED:
            componentFactory = this.cfr.resolveComponentFactory(IntakeVerifyTaskPanel);
            break;
          case FlowState.PUBLISHED:
            componentFactory = this.cfr.resolveComponentFactory(IntakePublishTaskPanel);
            break;
          case FlowState.EVALUATED:
            componentFactory = this.cfr.resolveComponentFactory(IntakeEvaluateTaskPanel);
            break;
          default:
            componentFactory = this.cfr.resolveComponentFactory(IntakeDraftTaskPanel);
            break;
        }
        this.componentRef = this.taskPanel.createComponent(componentFactory);
        this.componentRef.instance.intakeTask = task;
      }
    });
  }

  ngOnDestroy() {
    if (this.componentRef) {
      this.componentRef.destroy();
    }
  }
}
