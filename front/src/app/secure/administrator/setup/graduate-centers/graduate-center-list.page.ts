import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {GraduateCenterCreatorDialog} from './dialog/graduate-center-creator.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {GraduateCenter} from '../../../../shared/model/common/graduate-center.interface';

@Component({
  selector: 'pams-graduate-center-list-page',
  templateUrl: './graduate-center-list.page.html',
})
export class GraduateCenterListPage implements OnInit {

  private GRADUATE_CENTERS: string[] = 'setupModuleState.graduateCenters'.split('.');
  private graduateCenters$: Observable<GraduateCenter>;
  private creatorDialogRef: MdDialogRef<GraduateCenterCreatorDialog>;

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'Description Ms'},
    {name: 'descriptionEn', label: 'Description En'},
    {name: 'action', label: ''},
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.graduateCenters$ = this.store.select(...this.GRADUATE_CENTERS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findGraduateCenters());
    this.store.dispatch(this.actions.changeTitle('Graduate Codes'));
  }

  showDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(GraduateCenterCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  filter(filter: string): void {
    console.log('filter');
  }

  deactivate(event): void {
    // this.store.dispatch(this.actions.removeGraduateCenter())
    console.log('event' + event);
  }

}
