import { SupervisorOffering } from './../../../shared/model/common/supervisor-offering.interface';
import {
  Component,
  Input,
  EventEmitter,
  Output,
  ChangeDetectionStrategy,
  OnInit,
  AfterViewInit,
  ViewContainerRef,
} from '@angular/core';
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import { SupervisorOfferingEditorDialog } from './dialog/supervisor-offering-editor.dialog';

@Component({
  selector: 'pams-supervisor-list.page',
  templateUrl: './supervisor-offering-list.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SupervisorOfferingListPage implements OnInit{
  private SUPERVISOR_OFFERINGS = "setupModuleState.supervisorOfferings".split(".");
  private supervisorOfferings$: Observable<SupervisorOffering[]>;
  private creatorDialogRef: MdDialogRef<SupervisorOfferingEditorDialog>;

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {


    this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
  }
  ngOnInit(): void {
    this.store.dispatch(this.actions.findSupervisorOfferings());
    this.store.dispatch(this.actions.changeTitle("Supervisor Offerings"));
  }
  createDialog(): void {
    this.showDialog(null);
  }
  editDialog(offering:SupervisorOffering): void {
    this.showDialog(offering);
  }
  delete(offering: SupervisorOffering): void {
    this.store.dispatch(this.actions.removeSupervisorOfferings(offering))
  }

  private showDialog(offering:SupervisorOffering): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SupervisorOfferingEditorDialog, config);
    if(offering) this.creatorDialogRef.componentInstance.supervisorOffering = offering; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
