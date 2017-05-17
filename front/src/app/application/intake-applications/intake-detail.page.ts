import {Component, OnInit, ViewContainerRef, Input} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {ApplicationModuleState} from "../index";
import {Intake} from "../../policy/intakes/intake.interface";
import {IntakeApplicationActions} from "./intake-application.action";

@Component({
  selector: 'pams-intake-detail',
  templateUrl: './intake-detail.page.html',
})

export class IntakeDetailPage implements OnInit {

  private INTAKE = "applicationModuleState.intake".split(".");
  private intake$: Observable<Intake>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {
    this.intake$ = this.store.select(...this.INTAKE);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
        console.log("referenceNo :"+referenceNo);
      if (null != referenceNo)this.store.dispatch(this.actions.findIntakeByReferenceNo(referenceNo));
    });
  }

  apply(intake: Intake) {
       this.intake$.subscribe(intake => this.store.dispatch(this.actions.applyIntake(intake)));
  }
}
