import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {ProgramCode} from "../common/program-code.interface";
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {CentreActions} from "./centre.action";
import {GraduateCentre} from "../common/graduate-centre.interface";
import {CentreModuleState} from "./index";

@Component({
  selector: 'pams-cps-centre-page',
  templateUrl: './cps-centre.page.html',
})

export class CpsCentrePage implements OnInit {

  private programCodes$: Observable<ProgramCode[]>;
  private graduateCentre$: Observable<GraduateCentre>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private centreActions: CentreActions,
              private store: Store<CentreModuleState>) {
    this.graduateCentre$ = this.store.select(state => state.graduateCentre);
    this.programCodes$ = this.store.select(state => state.programCodes);
  }

  ngOnInit(): void {
    this.store.dispatch(this.centreActions.findGraduateCentreByCode("CPS"))
    this.graduateCentre$.subscribe(graduateCentre => {
        if (null != graduateCentre.code) {
          this.store.dispatch(this.centreActions.findProgramCodes(graduateCentre));
        }
      }
    );
  }
}
