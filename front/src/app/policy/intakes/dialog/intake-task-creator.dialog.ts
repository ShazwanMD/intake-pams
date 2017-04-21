import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Intake} from "../intake.interface";
import {PolicyService} from "../../../../services/policy.service";
import {IntakeSession} from "../intake-session.interface";


@Component({
  selector: 'pams-intake-task-creator',
  templateUrl: './intake-task-creator.dialog.html',
})

export class IntakeTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private policyService: PolicyService,
              private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<IntakeTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Intake>{
      id: null,
      referenceNo: '',
      sourceNo:'',
      intakeNo:'',
      description: '',
      totalPretaxAmount:0,
      totalTaxAmount:0,
      totalAmount:0,
      balanceAmount:0,
      paid:false,
      intakeSession:<IntakeSession>{},
    });

    // todo: componentize
    // this.policyService.findP().subscribe(policys => this.policys = policys);
  }

  save(intake: Intake, isValid: boolean) {
    console.log("intake: " + intake.description);
    this.store.dispatch(this.actions.startIntakeTask(intake));
    this.dialog.close();

    // .subscribe(res => {
    //   let snackBarRef = this._snackBar.open("Intake started", "OK");
    //   snackBarRef.afterDismissed().subscribe(() => {
    //     this.goBack();
    //   });
    // });
  }
}
