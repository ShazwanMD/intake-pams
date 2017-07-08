import {Component, Input, ChangeDetectionStrategy, OnInit, OnChanges, SimpleChange} from '@angular/core';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Rx';
import {FormControl} from '@angular/forms';
import {IntakeApplication} from '../intake-application.interface';
import {ProgramOffering} from '../../../../../policy/intakes/program-offering.interface';
import {ApplicationModuleState} from '../../index';
import {IntakeApplicationActions} from '../intake-application.action';

@Component({
  selector: 'pams-intake-program-offering-select',
  templateUrl: './intake-program-offering-select.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeProgramOfferingSelectComponent implements OnChanges {

  @Input() intakeApplication: IntakeApplication;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  private PROGRAM_OFFERING = 'applicationModuleState.programOfferings'.split('.');
  private programOfferings$: Observable<ProgramOffering>;

  constructor(private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions) {
    this.programOfferings$ = this.store.select(...this.PROGRAM_OFFERING);
  }

  ngOnChanges(changes: { [propertyName: string]: SimpleChange }) {
    if (changes['intakeApplication'] && this.intakeApplication.referenceNo) {
      console.log('intake app: ' + this.intakeApplication.referenceNo);
      this.store.dispatch(this.actions.findProgramOfferingsByIntake(this.intakeApplication));
    }
  }

  selectChangeEvent(event: ProgramOffering) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
