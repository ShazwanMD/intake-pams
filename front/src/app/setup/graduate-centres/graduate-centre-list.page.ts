import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {GraduateCentre} from "../../common/graduate-centres/graduate-centre.interface";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'pams-graduate-centre-list-page',
  templateUrl: './graduate-centre-list.page.html',
})
export class GraduateCentreListPage implements OnInit {

  private GRADUATE_CENTRES = "setupModuleState.graduateCentres".split(".");
  private graduateCentres$:Observable<GraduateCentre>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'Description Ms'},
    {name: 'descriptionEn', label: 'Description En'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>){
    this.graduateCentres$ = this.store.select(...this.GRADUATE_CENTRES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findGraduateCentres())
  }

}
