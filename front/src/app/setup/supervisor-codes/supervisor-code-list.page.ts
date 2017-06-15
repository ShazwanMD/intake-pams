import { SupervisorCodeEditorDialog } from './dialog/supervisor-code-editor.dialog';
import { SupervisorCode } from './../../common/supervisor-codes/supervisor-code.interface';
import {Component, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-supervisor-list-page',
  templateUrl: './supervisor-code-list.page.html',
})
export class SupervisorCodeListPage implements OnInit {

  private SUPERVISOR_CODES = "setupModuleState.supervisorCodes".split(".");
  private supervisorCodes$: Observable<SupervisorCode>;
  private creatorDialogRef: MdDialogRef<SupervisorCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
  //  {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'name', label: 'Name'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.supervisorCodes$ = this.store.select(...this.SUPERVISOR_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findSupervisorCodes());
    this.store.dispatch(this.actions.changeTitle("Supervisor Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:SupervisorCode): void {
    this.showDialog(code);
  }

  delete(code: SupervisorCode): void {
    let snackBarRef = this.snackBar.open("Delete this supervisor code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.removeSupervisorCode(code))
    });
  }

  filter(): void {
  }

  private showDialog(code:SupervisorCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SupervisorCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.supervisorCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
