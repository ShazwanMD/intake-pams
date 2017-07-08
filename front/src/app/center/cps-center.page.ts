import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {CenterActions} from './center.action';
import {CenterModuleState} from './index';
import {ProgramCode} from '../shared/model/common/program-code.interface';
import {GraduateCenter} from '../shared/model/common/graduate-center.interface';

@Component({
  selector: 'pams-cps-center-page',
  templateUrl: './cps-center.page.html',
})

export class CpsCenterPage implements OnInit {

  private GRADUATE_CENTER: string[] = 'centerModuleState.graduateCenter'.split('.');
  private PROGRAM_CODES: string[] = 'centerModuleState.programCodes'.split('.');

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
    this.store.dispatch(this.centerActions.findGraduateCenterByCode('CPS'));
    this.graduateCenter$.subscribe((graduateCenter) => {
        if (null != graduateCenter.code) {
          this.store.dispatch(this.centerActions.findProgramCodes(graduateCenter));
        }
      },
    );
  }

  viewProgramCode(programCode: ProgramCode) {
    console.log('programCode: ' + programCode.id);
    this.router.navigate(['/common/program-codes', programCode.id]);
  }

}
