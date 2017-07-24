import { Observable } from 'rxjs/Observable';
import { IntakeApplicationActions } from './intake-application.action';
import { ApplicationModuleState } from './../index';
import { Store } from '@ngrx/store';
import { Intake } from './../../../shared/model/policy/intake.interface';
import { MgsebIntakeApplicationPanel } from './mgseb/intake-application.panel';
import { CpsIntakeApplicationPanel } from './cps/intake-application.panel';
import { IntakeApplication } from './../../../shared/model/application/intake-application.interface';
import {
  Component, OnInit, OnDestroy, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentFactory, ComponentRef, Input,
} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'pams-intake-application-detail',
  templateUrl: './intake-application-detail.page.html',
})
export class IntakeApplicationDetailPage implements OnInit {
  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  private componentRef: ComponentRef<any>;
  private intakeApplication$: Observable<IntakeApplication>;
  
  @ViewChild('intakeApplicationFormPanel', { read: ViewContainerRef }) intakeApplicationFormPanel: ViewContainerRef;
  constructor(private viewContainerRef: ViewContainerRef,
    private actions: IntakeApplicationActions,
    private cfr: ComponentFactoryResolver,
    private store: Store<ApplicationModuleState>,
    private route: ActivatedRoute,
    private router: Router) {
  }
  ngOnInit(): void {

    let componentFactory: ComponentFactory<any>;
    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.intakeApplication$.subscribe((intakeApplication) => {
      console.log('test IA detail 1',  intakeApplication);
      if (intakeApplication) {
          if (intakeApplication.intake.graduateCenter.code === 'CPS') {
        componentFactory = this.cfr.resolveComponentFactory(CpsIntakeApplicationPanel);
        console.log('test IA detail 2');
          }
      } else if (intakeApplication) {
          if (intakeApplication.intake.graduateCenter.code === 'MGSEB') {
        componentFactory = this.cfr.resolveComponentFactory(MgsebIntakeApplicationPanel);
        console.log('test IA detail 3');
          }
      }
      // handle null factory
      if (componentFactory) {
        this.componentRef = this.intakeApplicationFormPanel.createComponent(componentFactory);
        console.log('test IA detail 4');
      } else {
        this.router.navigate(['/intakes']);
        console.log('test IA detail 5');
      }
    });
  }
}
