import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IntakeSessionActions} from "./intake-session.action";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";

@Component({
  selector: 'pams-intake-session-center',
  templateUrl: './intake-session-center.page.html',
})

export class IntakeSessionCenterPage implements OnInit {

  // private creatorDialogRef: MdDialogRef<IntakeSessionTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: IntakeSessionActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  goBack(route: string): void {
    this.router.navigate(['/intake-sessions']);
  }

  ngOnInit(): void {
  }
}

