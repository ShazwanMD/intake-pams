import {FacultyCodeCreatorDialog} from './dialog/faculty-code-creator.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {FacultyCode} from '../../../shared/model/common/faculty-code.interface';

@Component({
  selector: 'pams-faculty-list-page',
  templateUrl: './faculty-code-list.page.html',
})
export class FacultyCodeListPage implements OnInit {

  private FACULTY_CODES: string[] = 'setupModuleState.facultyCodes'.split('.');
  private facultyCodes$: Observable<FacultyCode>;
  private creatorDialogRef: MdDialogRef<FacultyCodeCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''},
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.facultyCodes$ = this.store.select(...this.FACULTY_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findFacultyCodes());
    this.store.dispatch(this.actions.changeTitle('Faculty Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: FacultyCode): void {
    this.showDialog(code);
  }

  delete(code: FacultyCode): void {
    let snackBarRef = this.snackBar.open('Delete this faculty code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeFacultyCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: FacultyCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(FacultyCodeCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.facultyCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
