
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {ProgramOfferingCreatorDialog} from "./dialog/program-offering-creator.dialog";
import {Observable} from "rxjs";
import {Program} from "./program.interface";
import {ProgramOfferingTask} from "./program-offering-task.interface";
import {ProgramActions} from "./program.action";

@Component({
  selector: 'pams-program-offering-center',
  templateUrl: './program-offering-center.page.html',
})

export class ProgramOfferingCenterPage implements OnInit {

  private PROGRAM_OFFERING_TASKS = "policyModuleState.ProgramOfferingTask".split(".");
  private programOfferingTask$: Observable<ProgramOfferingTask[]>;
  private creatorDialogRef: MdDialogRef<ProgramOfferingCreatorDialog>;

constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramActions,
              private vcf : ViewContainerRef,
               private dialog: MdDialog){

              }
     goBack(route: string): void {
    this.router.navigate(['/programs']);
  }

  view(programOffering : ProgramOfferingTask) {
    console.log("programOffering : " + programOffering.taskId);
    this.router.navigate(['/view-task', programOffering.taskId]);
  }


  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ProgramOfferingCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }


  ngOnInit(): void {
   
  
  }
}


