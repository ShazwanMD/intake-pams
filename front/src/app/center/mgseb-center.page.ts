import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {ProgramCode} from "../common/program-codes/program-code.interface";
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {CenterActions} from "./center.action";
import {GraduateCenter} from "../common/graduate-centers/graduate-center.interface";
import {CenterModuleState} from "./index";

@Component({
  selector: 'pams-mgseb-center-page',
  templateUrl: './mgseb-center.page.html',
})

export class MgsebCenterPage implements OnInit {

  private GRADUATE_CENTER = "centerModuleState.graduateCenter".split(".");
  private PROGRAM_CODES = "centerModuleState.programCodes".split(".");

  private programCodes$: Observable<ProgramCode[]>;
  private graduateCenter$: Observable<GraduateCenter>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private centerActions: CenterActions,
              private store: Store<CenterModuleState>) {
    this.graduateCenter$ = this.store.select(...this.GRADUATE_CENTER);
    this.programCodes$ = this.store.select(...this.PROGRAM_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.centerActions.findGraduateCenterByCode("MGSEB"));
    this.graduateCenter$.subscribe(graduateCenter => {
        if (null != graduateCenter.code) {
          this.store.dispatch(this.centerActions.findProgramCodes(graduateCenter));
        }
      }
    );
  }

  viewProgramCode(programCode: ProgramCode) {
    console.log("programCode: " + programCode.id);
    this.router.navigate(['/common/program-codes', programCode.id]);
  }



}
