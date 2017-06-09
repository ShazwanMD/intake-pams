import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {GraduateCenter} from "../graduate-center.interface";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import {CommonModuleState} from "../../index";


@Component({
  selector: 'pams-graduate-center-select',
  templateUrl: './graduate-center-select.component.html',
  styleUrls: ['./graduate-center-select.scss'],
})
export class GraduateCenterSelectComponent implements OnInit {

  private GRADUATE_CENTERS = "commonModuleState.graduateCenters".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  graduateCenters$: Observable<GraduateCenter[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.graduateCenters$ = this.store.select(...this.GRADUATE_CENTERS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findGraduateCenters());
  }

  selectChangeEvent(event: GraduateCenter) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

