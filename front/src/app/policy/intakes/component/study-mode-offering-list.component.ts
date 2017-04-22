import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {IntakeTask} from "../intake-task.interface";
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {StudyModeOffering} from "../study-mode-offering.interface";

@Component({
  selector: 'pams-study-mode-offering-list',
  templateUrl: './study-mode-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudyModeOfferingListComponent {

  @Input() intake: Intake;
  @Input() studyModeOfferings: StudyModeOffering[];

  constructor(private store: Store<PolicyModuleState>,
              private actions: IntakeActions,) {
  }

  add(studyModeOffering: StudyModeOffering) {
    this.store.dispatch(this.actions.addStudyModeOffering(this.intake, studyModeOffering));
  }

  delete(studyModeOffering: StudyModeOffering) {
    this.store.dispatch(this.actions.deleteStudyModeOffering(this.intake, studyModeOffering));
  }

}
