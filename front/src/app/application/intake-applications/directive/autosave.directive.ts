import {Directive, Input, Self, AfterViewInit, HostListener} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {FormGroup} from "@angular/forms";
import {ApplicationModuleState} from "../../index";
import {Store} from "@ngrx/store";

export const DEFAULT_AUTOSAVE_DEBOUNCE: number = 3000;

@Directive({
  selector: '[pams-autosave]',
})
export class AutosaveDirective implements AfterViewInit {
  @Input() saveWhenInvalid: boolean;
  @HostListener('keyup') keyupListener = this.resetDebounce;

  timer: any;

  constructor(@Self() private form: FormGroup,
              private intakeApplicationActions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>) {
  }

  ngAfterViewInit(): void {
    this.form.statusChanges.subscribe(this.setDebounce);
  }

  ngOnDestroy(): void {
    if (this.timer) {
      clearTimeout(this.timer);
    }
  }

  setDebounce = (): void => {
    if (this.canAutosave()) {
      if (!this.timer && this.form.dirty && (this.saveWhenInvalid || this.form.valid)) {
        this.timer = setTimeout(this.autosave, DEFAULT_AUTOSAVE_DEBOUNCE)
      }
    }
  }

  resetDebounce(): void {
    if (this.timer && this.canAutosave()) {
      clearTimeout(this.timer);
      this.timer = null;
      this.setDebounce();
    }
  }

  autosave = (): void => {
    if (this.canAutosave()) {
      this.store.dispatch(this.intakeApplicationActions.updateIntakeApplication(this.form.value));
      // const waitOn = this.submitAndWait();
      // if (waitOn) {
      //   this.autosaveAction.waitOn(waitOn).subscribe();
      // }
      clearTimeout(this.timer);
    }
  }

  private canAutosave(): boolean {
    return this.form.dirty && (this.saveWhenInvalid || this.form.valid);
  }
}


// note
// autosave = (): void => {
//   if (this.canAutosave()) {
//     const waitOn = this.submitAndWait();
//     if (waitOn) {
//       this.autosaveAction.waitOn(waitOn).subscribe();
//     }
//     clearTimeout(this.timer);
//   }
// }
//
// submitAndWait(): IWaitValue<any> {
//   if (this.saveWhenInvalid) {
//   return this.form.saveForm();
// } else {
//   return this.form.submitAndWait();
// }
// }
