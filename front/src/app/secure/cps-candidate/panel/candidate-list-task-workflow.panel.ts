import { FlowState } from '../../../core/flow-state.enum';
import { CandidateTask } from '../../../shared/model/admission/candidate-task.interface';
import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input,
} from '@angular/core';
import {Observable} from 'rxjs';

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
            //componentFactory = this.cfr.resolveComponentFactory(CandidatePreApproveTaskPanel);
            break;
          case FlowState.APPROVED:
            //componentFactory = this.cfr.resolveComponentFactory(CandidateApproveTaskPanel);
            break;
          case FlowState.UPPER_APPROVED:
            //componentFactory = this.cfr.resolveComponentFactory(CandidateOfferTaskPanel);
            break;  
          case FlowState.OFFERED:
           // componentFactory = this.cfr.resolveComponentFactory(CandidateRegisterTaskPanel);
            break;
          default:
            //componentFactory = this.cfr.resolveComponentFactory(CandidatePreApproveTaskPanel);
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
