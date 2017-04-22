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
import {IntakeSession} from "../../intake-sessions/intake-session.interface";
import {GraduateCentre} from "../../../common/graduate-centre.interface";
import {Observable} from "rxjs";
import {CommonActions} from "../../../common/common.action";
import {CommonModuleState} from "../../../common/index";
import {IntakeSessionActions} from "../../intake-sessions/intake-session.action";
import {ProgramLevel} from "../../program-levels/program-level.interface";
import {ProgramLevelActions} from "../../program-levels/program-level.action";


@Component({
  selector: 'pams-intake-task-creator',
  templateUrl: './intake-task-creator.dialog.html',
})

export class IntakeTaskCreatorDialog implements OnInit {

  private GRADUATE_CENTRES = "commonModuleState.graduateCentres".split(".");
  private INTAKE_SESSIONS = "policyModuleState.intakeSessions".split(".");
  private PROGRAM_LEVELS = "policyModuleState.programLevels".split(".");
  private graduateCentres$: Observable<GraduateCentre[]>;
  private intakeSessions$: Observable<IntakeSession[]>;
  private programLevels$: Observable<ProgramLevel[]>;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private commonStore: Store<CommonModuleState>,
              private actions: IntakeActions,
              private intakeSessionActions: IntakeSessionActions,
              private programLevelActions: ProgramLevelActions,
              private commonActions: CommonActions,
              private dialog: MdDialogRef<IntakeTaskCreatorDialog>) {
    this.graduateCentres$ = this.commonStore.select(...this.GRADUATE_CENTRES);
    this.intakeSessions$ = this.store.select(...this.INTAKE_SESSIONS);
    this.programLevels$ = this.store.select(...this.PROGRAM_LEVELS);
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Intake>{
      id: null,
      referenceNo: '',
      sourceNo: '',
      intakeNo: '',
      description: '',
      projection: 0,
      startDate: null,
      endDate: null,
      programLevel: <ProgramLevel>{},
      intakeSession: <IntakeSession>{},
      graduateCentre: <GraduateCentre>{}
    });

    // retrieve select options
    this.store.dispatch(this.commonActions.findGraduateCentres());
    this.store.dispatch(this.intakeSessionActions.findIntakeSessions());
    this.store.dispatch(this.programLevelActions.findProgramLevels());
  }

  save(intake: Intake, isValid: boolean) {
    console.log("intake: " + intake.description);
    this.store.dispatch(this.actions.startIntakeTask(intake));
    this.dialog.close();
  }
}
