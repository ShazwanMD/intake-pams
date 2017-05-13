import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IntakeSessionActions} from "./intake-session.action";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {Observable} from "rxjs/Observable";
import {IntakeSession} from "./intake-session.interface";
import {PolicyModuleState} from "../index";
import {Store} from "@ngrx/store";

@Component({
  selector: 'pams-intake-session-center',
  templateUrl: './intake-session-center.page.html',
})

export class IntakeSessionCenterPage implements OnInit {

  private INTAKE_SESSIONS = "policyModuleState.intakeSessions".split(".");
  private intakeSessions$: Observable<IntakeSession[]>;
  // private creatorDialogRef: MdDialogRef<IntakeSessionTaskCreatorDialog>;

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

  filter():void {

  }


  ngOnInit(): void {
    this.store.dispatch(this.actions.findIntakeSessions());
  }
}

