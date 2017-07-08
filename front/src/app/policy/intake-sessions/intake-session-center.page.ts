import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IntakeSessionActions} from './intake-session.action';
import {MdDialogConfig, MdDialogRef, MdDialog} from '@angular/material';
import {Observable} from 'rxjs/Observable';
import {PolicyModuleState} from '../index';
import {Store} from '@ngrx/store';
import {IntakeSessionCreatorDialog} from './component/intake-session-creator.dialog';
import {IntakeSession} from '../../shared/model/policy/intake-session.interface';

@Component({
  selector: 'pams-intake-session-center',
  templateUrl: './intake-session-center.page.html',
})

export class IntakeSessionCenterPage implements OnInit {

  private INTAKE_SESSIONS: string[] = 'policyModuleState.intakeSessions'.split('.');
  private intakeSessions$: Observable<IntakeSession[]>;
  private creatorDialogRef: MdDialogRef<IntakeSessionCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: IntakeSessionActions,
              private store: Store<PolicyModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.intakeSessions$ = this.store.select(...this.INTAKE_SESSIONS);
  }

  goBack(route: string): void {
    this.router.navigate(['/intake-sessions']);
  }

  showDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(IntakeSessionCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  filter(): void {
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findIntakeSessions());
  }
}
