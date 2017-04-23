import {
  Component, Input, EventEmitter, Output, ChangeDetectionStrategy, forwardRef, Provider,
  ElementRef, ViewChild, OnChanges, AfterViewInit
} from '@angular/core';
import {Observable} from "rxjs";
import {ProgramLevel} from "../program-level.interface";
import {ProgramLevelActions} from "../program-level.action";
import {State, Store} from "@ngrx/store";
import {PolicyModuleState} from "../../index";
import {ControlValueAccessor, NG_VALUE_ACCESSOR, FormGroup, FormControl, FormControlName} from "@angular/forms";


export const CUSTOM_VALUE_ACCESSOR: any = {
  provide: NG_VALUE_ACCESSOR,
  useExisting: forwardRef(() => ProgramLevelSelectComponent),
  multi: true
};

const noop = () => {
};


@Component({
  selector: 'pams-program-level-select',
  templateUrl: './program-level-select.component.html',
  providers: [CUSTOM_VALUE_ACCESSOR],
})
export class ProgramLevelSelectComponent implements ControlValueAccessor, AfterViewInit, OnChanges {

  private PROGRAM_LEVELS = "policyModuleState.programLevels".split(".");
  private _value: any;
  private onTouchedCallback: () => void = noop;
  private onChangeCallback: (_: any) => void = noop;
  private propagateChange = (_: any) => { };
  programLevels$: Observable<ProgramLevel[]>;

  @Input() innerFormControl: FormControl = new FormControl();
  @ViewChild('select') selectRef: ElementRef;

  constructor(private store: Store<PolicyModuleState>,
              private actions: ProgramLevelActions) {
    this.programLevels$ = this.store.select(...this.PROGRAM_LEVELS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findProgramLevels());
  }

  ngAfterViewInit() {
    // RESET the custom input form control UI when the form control is RESET
    this.innerFormControl.valueChanges.subscribe(
      () => {
        // check condition if the form control is RESET
        if (this.innerFormControl.value == "" ||
          this.innerFormControl.value == null ||
          this.innerFormControl.value == undefined) {
          this._value = "";
          this.selectRef.nativeElement.value = "";
        }
      }
    );
  }

  ngOnChanges(){
  }

  // event fired when input value is changed .
  // later propagated up to the form control
  // using the custom value accessor interface
  onChange(e:Event, value:any){
    console.log("value: " + value);
    //set changed value
    this._value = value;
    // propagate value into form control using control value accessor interface
    this.propagateChange(this._value);
  }

  onBlur() {
    this.onTouchedCallback();
  }

  //get accessor
  get value(): any {
    return this._value;
  };

  set value(v: any) {
    if (v !== this._value) {
      this._value = v;
      this.onChangeCallback(v);
    }
  }

  writeValue(value: any) {
    if (value !== this._value) {
      this._value = value;
    }
  }

  //From ControlValueAccessor interface
  registerOnChange(fn: any) {
    this.onChangeCallback = fn;
  }

  //From ControlValueAccessor interface
  registerOnTouched(fn: any) {
    this.onTouchedCallback = fn;
  }

}

