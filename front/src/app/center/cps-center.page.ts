import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {CenterActions} from './center.action';
import {CenterModuleState} from './index';
import {ProgramCode} from '../shared/model/common/program-code.interface';
import {GraduateCenter} from '../shared/model/common/graduate-center.interface';
import { ProgramFieldCode } from '../shared/model/common/program-field-code.interface';

@Component({
  selector: 'pams-cps-center-page',
  templateUrl: './cps-center.page.html',
})

export class CpsCenterPage implements OnInit {

  private GRADUATE_CENTER: string[] = 'centerModuleState.graduateCenter'.split('.');
  private PROGRAM_FIELD_CODES: string[] = 'centerModuleState.programFieldCodes'.split('.');

  private programFieldCodes$: Observable<ProgramFieldCode[]>;
  private graduateCenter$: Observable<GraduateCenter>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private centerActions: CenterActions,
              private store: Store<CenterModuleState>) {
    this.graduateCenter$ = this.store.select(...this.GRADUATE_CENTER);
    this.programFieldCodes$ = this.store.select(...this.PROGRAM_FIELD_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.centerActions.findGraduateCenterByCode('CPS'));
    this.graduateCenter$.subscribe((graduateCenter) => {
        if (null != graduateCenter.code) {
          this.store.dispatch(this.centerActions.findProgramFieldCodes(graduateCenter));
        }
      },
    );
  }

  viewProgramFieldCode(programFieldCode: ProgramFieldCode) {
    console.log('programFieldCode: ' + programFieldCode.code);
    this.router.navigate(['/common/program-codes', programFieldCode.code]);
  }

}
