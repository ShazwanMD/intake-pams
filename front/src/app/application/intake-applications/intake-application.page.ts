import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IntakeApplicationActions} from "./intake-applications/intake-application.action";
import {ApplicationModuleState} from "./index";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs/Observable";
import {Intake} from "../policy/intakes/intake.interface";
import { IntakeApplication } from "./intake-applications/intake-application.interface";

@Component({
 // selector: 'pams-application-page',
 // templateUrl: './application.page.html',
})

export class IntakeApplicationPage implements OnInit {

  private INTAKES = "applicationModuleState.intakes".split(".");
  private intakes$: Observable<Intake[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private intakeApplicationActions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {
    this.intakes$ = this.store.select(...this.INTAKES);
  }

  ngOnInit(): void {
    this.route.params.subscribe(() => {
     // this.store.dispatch(this.intakeApplicationActions.findIntake()); // find PUBLISHED intakes
        this.router.navigate(['application/intake-applications/cps']);
    });
  }

  apply(intake: Intake): void {
      
    console.log("apply");
      this.router.navigate(['application/intake-applications/',intake.referenceNo]);
  }
}
