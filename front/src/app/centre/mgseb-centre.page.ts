import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {ProgramCode} from "../common/program-code.interface";
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {CentreActions} from "./centre.action";
import {GraduateCentre} from "../common/graduate-centre.interface";
import {CentreModuleState} from "./index";

@Component({
  selector: 'pams-mgseb-centre-page',
  templateUrl: './mgseb-centre.page.html',
})

export class MgsebCentrePage implements OnInit {

  private GRADUATE_CENTRE = "centreModuleState.graduateCentre".split(".");
  private PROGRAM_CODES = "centreModuleState.programCodes".split(".");

  private programCodes$: Observable<ProgramCode[]>;
  private graduateCentre$: Observable<GraduateCentre>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private centreActions: CentreActions,
              private store: Store<CentreModuleState>) {
    this.graduateCentre$ = this.store.select(...this.GRADUATE_CENTRE);
    this.programCodes$ = this.store.select(...this.PROGRAM_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.centreActions.findGraduateCentreByCode("MGSEB"));
    this.graduateCentre$.subscribe(graduateCentre => {
        if (null != graduateCentre.code) {
          this.store.dispatch(this.centreActions.findProgramCodes(graduateCentre));
        }
      }
    );
  }

  viewProgramCode(programCode: ProgramCode) {
    console.log("programCode: " + programCode.id);
    this.router.navigate(['/common/program-codes', programCode.id]);
  }



}
