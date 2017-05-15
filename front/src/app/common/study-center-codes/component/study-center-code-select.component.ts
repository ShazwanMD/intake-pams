// import {Component, Input, OnInit} from '@angular/core';
// import {Observable} from "rxjs";
// import {Store} from "@ngrx/store";
// import {FormControl} from "@angular/forms";
// import {CommonActions} from "../../common.action";
// import {CommonModuleState} from "../../index";



// @Component({
//   selector: 'pams-study-center-code-select',
//   templateUrl: './study-center-code-select.component.html',
// })
// export class StudyCenterCodeSelectComponent implements OnInit {

//   private STUDY_CENTER_CODES = "commonModuleState.studyCenterCodes".split(".");
//   @Input() placeholder: string;
//   @Input() innerFormControl: FormControl;
//   studyCenterCodes$: Observable<StudyCenterCode[]>;

//   constructor(private store: Store<CommonModuleState>,
//               private actions: CommonActions) {
//     this.studyCenterCodes$ = this.store.select(...this.STUDY_CENTER_CODES);
//   }

//   ngOnInit() {
//     this.store.dispatch(this.actions.findProgramCodes());
//   }

//   selectChangeEvent(event: ProgramCode) {
//     this.innerFormControl.setValue(event, {emitEvent: false});
//   }
// }

