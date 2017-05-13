import {Component, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {GraduateCentre} from "../../common/graduate-centres/graduate-centre.interface";
import {Observable} from "rxjs/Observable";
import {GraduateCentreCreatorDialog} from "./dialog/graduate-centre-creator.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-graduate-centre-list-page',
  templateUrl: './graduate-centre-list.page.html',
})
export class GraduateCentreListPage implements OnInit {

  private GRADUATE_CENTRES = "setupModuleState.graduateCentres".split(".");
  private graduateCentres$: Observable<GraduateCentre>;
  private creatorDialogRef: MdDialogRef<GraduateCentreCreatorDialog>;

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'Description Ms'},
    {name: 'descriptionEn', label: 'Description En'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.graduateCentres$ = this.store.select(...this.GRADUATE_CENTRES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findGraduateCentres())
    this.store.dispatch(this.actions.changeTitle("Graduate Codes"))
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(GraduateCentreCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  filter(filter:string):void {
    console.log("filter");
  }

  deactivate(event): void {
    // this.store.dispatch(this.actions.removeGraduateCentre())
    console.log("event" + event);
  }

}
