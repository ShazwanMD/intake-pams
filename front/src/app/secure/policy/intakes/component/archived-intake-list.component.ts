import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {MdSnackBar, MdSnackBarRef, SimpleSnackBar} from '@angular/material';
import {Intake} from '../../../../shared/model/policy/intake.interface';

@Component({
  selector: 'pams-archived-intake-list',
  templateUrl: './archived-intake-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ArchivedIntakeListComponent {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'projection', label: 'Projection'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
  ];

  @Input() intakes: Intake[];
  @Output() view: EventEmitter<Intake> = new EventEmitter<Intake>();

  constructor(private snackBar: MdSnackBar) {
  }

  viewIntake(intake: Intake): void {
    console.log('Emitting task');
    let snackBarRef: MdSnackBarRef<SimpleSnackBar> = this.snackBar.open('Viewing intake', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(intake);
    });
  }
}
