import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input, AfterViewInit
} from '@angular/core';
import {Observable} from "rxjs";
import {IntakeTask} from "../intake-task.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {IntakeRegisterTaskPanel} from "./intake-register-task.panel";
import {IntakeDraftTaskPanel} from "./intake-draft-task.panel";


@Component({
  selector: 'pams-intake-task-workflow',
  templateUrl: './intake-task-workflow.panel.html',
})
export class IntakeTaskWorkflowPanel implements OnInit {

  @ViewChild('taskPanel', {read: ViewContainerRef})
  private taskPanel: ViewContainerRef;
  private componentRef: ComponentRef<any>;
  @Input() intakeTaskObservable: Observable<IntakeTask>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.intakeTaskObservable.subscribe(task => {
      if (task.flowState) {

        console.log("task flowState: " + task.flowState);
        if (this.componentRef) this.componentRef.destroy();
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(IntakeDraftTaskPanel);
            break;
          case FlowState.REGISTERED:
            componentFactory = this.cfr.resolveComponentFactory(IntakeRegisterTaskPanel);
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
