import { FlowState } from '../../../core/flow-state.enum';
import { IntakeTask } from '../../../shared/model/policy/intake-task.interface';
import { CandidateApproveTaskPanel } from './candidate-approve-task.panel';
import { CandidateOfferTaskPanel } from './candidate-offer-task.panel';
import { CandidatePreApproveTaskPanel } from './candidate-preapprove-task.panel';
import { CandidateRegisterTaskPanel } from './candidate-register-task.panel';
import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input,
} from '@angular/core';
import {Observable} from 'rxjs';

@Component({
  selector: 'pams-candidate-task-workflow',
  templateUrl: './candidate-task-workflow.panel.html',
})
export class CandidateTaskWorkflowPanel implements OnInit {

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
          case FlowState.SELECTED:
            componentFactory = this.cfr.resolveComponentFactory(CandidatePreApproveTaskPanel);
            break;
          case FlowState.APPROVED:
            componentFactory = this.cfr.resolveComponentFactory(CandidateApproveTaskPanel);
            break;
          case FlowState.UPPER_APPROVED:
            componentFactory = this.cfr.resolveComponentFactory(CandidateOfferTaskPanel);
            break;  
          case FlowState.OFFERED:
            componentFactory = this.cfr.resolveComponentFactory(CandidateRegisterTaskPanel);
            break;
          default:
            componentFactory = this.cfr.resolveComponentFactory(CandidatePreApproveTaskPanel);
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
