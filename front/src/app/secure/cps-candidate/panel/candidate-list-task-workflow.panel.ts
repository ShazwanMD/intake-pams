import { FlowState } from '../../../core/flow-state.enum';
import { CandidateTask } from '../../../shared/model/admission/candidate-task.interface';
import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input,
} from '@angular/core';
import {Observable} from 'rxjs';
import { CandidateDraftTaskPanel } from "./candidate-draft-task.panel";
import { CandidateVerifyTaskPanel } from "./candidate-verify-task.panel";
import { CandidatePublishTaskPanel } from "./candidate-publish-task.panel.";

@Component({
  selector: 'pams-candidate-list-task-workflow',
  templateUrl: './candidate-list-task-workflow.panel.html',
})
export class CandidateListTaskWorkflowPanel implements OnInit {

  private componentRef: ComponentRef<any>;

  @ViewChild('taskPanel', {read: ViewContainerRef}) taskPanel: ViewContainerRef;
  @Input() candidateTaskObservable: Observable<CandidateTask>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.candidateTaskObservable.subscribe((task) => {
      if (task.flowState) {

        console.log('task flowState: ' + task.flowState);
        if (this.componentRef) {
          this.componentRef.destroy();
        }
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(CandidateDraftTaskPanel);
            break;
          case FlowState.VERIFIED:
            componentFactory = this.cfr.resolveComponentFactory(CandidateVerifyTaskPanel);
            break;
          case FlowState.PUBLISHED:
            componentFactory = this.cfr.resolveComponentFactory(CandidatePublishTaskPanel);
            break;  
          case FlowState.OFFERED:
           // componentFactory = this.cfr.resolveComponentFactory(CandidateRegisterTaskPanel);
            break;
          default:
            //componentFactory = this.cfr.resolveComponentFactory(CandidatePreApproveTaskPanel);
            break;
        }
        this.componentRef = this.taskPanel.createComponent(componentFactory);
        this.componentRef.instance.candidateTask = task;
      }
    });
  }

  ngOnDestroy() {
    if (this.componentRef) {
      this.componentRef.destroy();
    }
  }
}
